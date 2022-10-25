/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.implement;

import repository.ISanPhamRepository;
import java.util.List;
import domainmodel.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class SanPhamRepository implements ISanPhamRepository {

    @Override
    public List<SanPham> getAllSanPham() {
        List<SanPham> listSp = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            listSp = session.createQuery("from SanPham").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listSp;
    }

    @Override
    public String insertSanPham(String ma, String ten) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            SanPham sp = new SanPham();
            sp.setMa(ma);
            sp.setTen(ten);
            id = (String) session.save(sp);
            trans.commit();
            session.close();
        }
        return id;
    }

    @Override
    public void updateSanPham(SanPham sp, String ma, String ten) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            sp.setMa(ma);
            sp.setTen(ten);
            session.update(sp);
            trans.commit();
            session.close();
        }
    }

    @Override
    public SanPham getSanPhamFromMa(String maSp) {
        SanPham sp = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM SanPham Where ma=:maSp");
            query.setParameter("maSp", maSp);
            List<SanPham> list = query.getResultList();
            if (list.size() > 0) {
                sp = list.get(0);
            }
            trans.commit();
            session.close();
        }
        return sp;

    }

}
