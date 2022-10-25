/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.implement;

import domainmodel.ChiTietSP;
import domainmodel.DongSP;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IDongSpRepository;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class DongSpRepository implements IDongSpRepository {

    @Override
    public List<DongSP> getAllDongSp() {
        List<DongSP> list = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM DongSP").list();
            trans.commit();
            session.close();
        }
        return list;
    }

    @Override
    public String insertDong(String maDong, String tenDong) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            DongSP dongsp = new DongSP();
            dongsp.setMa(maDong);
            dongsp.setTen(tenDong);
            id = (String) session.save(dongsp);
            trans.commit();
            session.close();
        }
        return id;
    }

    @Override
    public void updateDong(DongSP dong, String ma, String ten) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            dong.setMa(ma);
            dong.setTen(ten);
            session.update(dong);
            trans.commit();
            session.close();
        }
    }

    @Override
    public void deleteDongSp(String maDong) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            DongSP dong = session.get(DongSP.class, getDongSpFromMa(maDong).getId());
            for (ChiTietSP chiTiet : dong.getListChiTiet()) {
                chiTiet.setDongSp(null);
                session.update(chiTiet);
            }
            session.remove(dong);
            trans.commit();
            session.close();
        }
    }

    @Override
    public DongSP getDongSpFromMa(String maDong) {
        DongSP dongSp = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM DongSP Where ma=:ma");
            query.setParameter("ma", maDong);
            List<DongSP> list = query.getResultList();
            if (list.size() > 0) {
                dongSp = list.get(0);
            }
            trans.commit();
            session.close();
        }
        return dongSp;
    }
}
