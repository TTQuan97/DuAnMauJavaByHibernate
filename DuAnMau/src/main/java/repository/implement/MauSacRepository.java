/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.implement;

import repository.IMauSacRepository;
import domainmodel.ChiTietSP;
import domainmodel.MauSac;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class MauSacRepository implements IMauSacRepository {

    @Override
    public List<MauSac> getAllMauSac() {
        List<MauSac> list = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM MauSac").list();
            trans.commit();
            session.close();
        }
        return list;
    }

    @Override
    public String insertMauSac(String maMau, String tenMau) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            MauSac mauSac = new MauSac();
            mauSac.setMa(maMau);
            mauSac.setTen(tenMau);
            id = (String) session.save(mauSac);
            trans.commit();
            session.close();
        }
        return id;
    }

    @Override
    public void updateMauSac(MauSac mauSac, String ma, String ten) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            mauSac.setMa(ma);
            mauSac.setTen(ten);
            session.update(mauSac);
            trans.commit();
            session.close();
        }
    }

    @Override
    public void deleteMauSac(String maMau) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            MauSac mauSac = session.get(MauSac.class, getMauSacFromMa(maMau).getId());
            for (ChiTietSP chiTiet : mauSac.getListChiTiet()) {
                chiTiet.setMauSac(null);
                session.update(chiTiet);
            }
            session.remove(mauSac);
            trans.commit();
            session.close();
        }
    }

    @Override
    public MauSac getMauSacFromMa(String maMau) {
        MauSac mauSac = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM MauSac Where ma=:ma");
            query.setParameter("ma", maMau);
            List<MauSac> list = query.getResultList();
            if (list.size() > 0) {
                mauSac = list.get(0);
            }
            trans.commit();
            session.close();
        }
        return mauSac;

    }

}
