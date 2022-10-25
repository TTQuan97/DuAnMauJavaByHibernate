/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.implement;

import domainmodel.ChiTietSP;
import domainmodel.HoaDon;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IHoaDonRepository;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> list;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM HoaDon").list();
            trans.commit();
            session.close();
        }
        return list;
    }

    @Override
    public String insertHoaDon(String maHD, Date ngayTao, Integer tinhTrang) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            HoaDon hd = new HoaDon();
            hd.setMa(maHD);
            hd.setNgayTao(ngayTao);
            hd.setTinhTrang(tinhTrang);
            id = (String) session.save(hd);
            trans.commit();
            session.close();
        }
        return id;
    }

    @Override
    public void updateTrangThai(String maHd, Integer trangThai) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            HoaDon hd = getHoaDonByMa(maHd);
            hd.setTinhTrang(trangThai);
            session.update(hd);
            trans.commit();
            session.close();
        }

    }

    @Override
    public HoaDon getHoaDonByMa(String maHd) {
        HoaDon hd = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM HoaDon WHERE ma=:mahd");
            query.setParameter("mahd", maHd);
            hd = (HoaDon) query.uniqueResult();
            trans.commit();
            session.close();
        }
        return hd;
    }

    public Set<ChiTietSP> getChiTietSpByHoaDon(HoaDon hoaDon) {
        Set<ChiTietSP> chiTietSP = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            chiTietSP = hoaDon.getChiTietSP();
            trans.commit();
            session.close();
        }
        return chiTietSP;
    }

}
