/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.implement;

import repository.INsxRepository;
import domainmodel.ChiTietSP;
import domainmodel.Nsx;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class NsxRepository implements INsxRepository {

    @Override
    public List<Nsx> getAllNsx() {
        List<Nsx> list = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM Nsx").list();
            trans.commit();
            session.close();
        }
        return list;
    }

    @Override
    public String insertNsx(String maNsx, String tenNsx) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Nsx nsx = new Nsx();
            nsx.setMa(maNsx);
            nsx.setTen(tenNsx);
            id = (String) session.save(nsx);
            trans.commit();
            session.close();
        }
        return id;

    }

    @Override
    public void updateNsx(Nsx nsx, String ma, String ten) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            nsx.setMa(ma);
            nsx.setTen(ten);
            session.update(nsx);
            trans.commit();
            session.close();
        }
    }

    @Override
    public void deleteNsx(String ma) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Nsx nsx = session.get(Nsx.class, getNsxFromMa(ma).getId());
            for (ChiTietSP chiTiet : nsx.getListChiTiet()) {
                chiTiet.setNsx(null);
                session.update(chiTiet);
            }
            session.remove(nsx);
            trans.commit();
            session.close();
        }
    }

    @Override
    public Nsx getNsxFromMa(String maNsx) {
        Nsx nsx = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM Nsx Where ma=:ma");
            query.setParameter("ma", maNsx);
            List<Nsx> list = query.getResultList();
            if (list.size() > 0) {
                nsx = list.get(0);
            }

            trans.commit();
            session.close();
        }
        return nsx;
    }
}
