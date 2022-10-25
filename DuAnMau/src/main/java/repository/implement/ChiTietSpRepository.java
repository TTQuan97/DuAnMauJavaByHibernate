/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.implement;

import repository.IChiTietSpRepository;
import domainmodel.ChiTietSP;
import domainmodel.DongSP;
import domainmodel.HoaDonChiTiet;
import domainmodel.MauSac;
import domainmodel.Nsx;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class ChiTietSpRepository implements IChiTietSpRepository {

    @Override
    public List<ChiTietSP> getAllChiTietSp() {
        List<ChiTietSP> listChiTietSp = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            listChiTietSp = session.createQuery("from ChiTietSP").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listChiTietSp;

    }

    @Override
    public String addChiTietSanPham(SanPham sp, DongSP dongSp,
            MauSac mauSac, Nsx nsx, Integer namBH, Integer soLuongTon,
            BigDecimal giaNhap, BigDecimal giaBan, String moTa) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiTietSP chiTietSp = new ChiTietSP();
            chiTietSp.setSanPham(sp);
            chiTietSp.setDongSp(dongSp);
            chiTietSp.setMauSac(mauSac);
            chiTietSp.setNsx(nsx);
            chiTietSp.setNamBH(namBH);
            chiTietSp.setSoLuongTon(soLuongTon);
            chiTietSp.setGiaNhap(giaNhap);
            chiTietSp.setGiaBan(giaBan);
            chiTietSp.setMoTa(moTa);
            session.save(chiTietSp);
            trans.commit();
            session.close();
        }
        return id;
    }

    @Override
    public void updateChiTietSp(String idChiTiet, SanPham sp, DongSP dongSp,
            MauSac mauSac, Nsx nsx, Integer namBH, Integer soLuongTon,
            BigDecimal giaNhap, BigDecimal giaBan, String moTa) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiTietSP chiTietSp = session.get(ChiTietSP.class, idChiTiet);
            chiTietSp.setSanPham(sp);
            chiTietSp.setDongSp(dongSp);
            chiTietSp.setMauSac(mauSac);
            chiTietSp.setNsx(nsx);
            chiTietSp.setNamBH(namBH);
            chiTietSp.setSoLuongTon(soLuongTon);
            chiTietSp.setGiaNhap(giaNhap);
            chiTietSp.setGiaBan(giaBan);
            chiTietSp.setMoTa(moTa);
            session.update(chiTietSp);
            trans.commit();
            session.close();
        }
    }

    @Override
    public void deleteChiTietSp(String idChiTiet) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiTietSP chiTietSp = session.get(ChiTietSP.class, idChiTiet);
            Set<HoaDonChiTiet> hoaDonChiTiet = chiTietSp.getHoaDonChiTiet();
            hoaDonChiTiet.clear();
            session.remove(chiTietSp);
            trans.commit();
            session.close();
        }
    }

    @Override
    public List<ChiTietSP> searchChiTietSanPham(String tenSp) {
        Transaction trans = null;
        List<ChiTietSP> listChiTiet = new ArrayList<>();
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM SanPham WHERE ten like :tenSanPham");
            query.setParameter("tenSanPham", "%" + tenSp + "%");
            List<SanPham> listSearch = query.list();
            for (SanPham sanPham : listSearch) {
                for (ChiTietSP chiTietSP : sanPham.getChiTietSP()) {
                    listChiTiet.add(chiTietSP);
                }
            }
            trans.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Lỗi ko thể tìm kiếm");
        }
        return listChiTiet;

    }

    @Override

    public ChiTietSP getChiTietSpById(String id) {
        ChiTietSP chiTietSp = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            chiTietSp = session.get(ChiTietSP.class, id);
            trans.commit();
            session.close();
        }
        return chiTietSp;

    }

    @Override
    public void updateSoluongTon(String idChiTiet, Integer soLuongTon) {
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiTietSP chiTietSP = getChiTietSpById(idChiTiet);
            chiTietSP.setSoLuongTon(soLuongTon);
            session.update(chiTietSP);
            trans.commit();
            session.close();
        }
    }

}
