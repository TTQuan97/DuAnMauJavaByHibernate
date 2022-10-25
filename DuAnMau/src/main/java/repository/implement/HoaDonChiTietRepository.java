package repository.implement;

import domainmodel.ChiTietSP;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IHoaDonChiTietRepository;
import utility.HibernateUtility;

/**
 *
 * @author trant
 */
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public void insertHoaDonChiTiet(Integer soLuong, BigDecimal donGia, ChiTietSP chiTietSp, HoaDon hoaDon) {
        String id = null;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setSoLuong(soLuong);
            hdct.setDonGia(donGia);
            hdct.setChiTietSpKey(chiTietSp);
            hdct.setHoaDonKey(hoaDon);
            session.save(hdct);
            trans.commit();
            session.close();
        }

    }

    public Set<HoaDonChiTiet> getHoaDonChiTietByHoaDon(HoaDon hoaDon) {
        Set<HoaDonChiTiet> sethdCt;
        try ( Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            HoaDon hd = session.get(HoaDon.class, hoaDon.getId());
            sethdCt = hd.getHoaDonChiTiet();
            trans.commit();
            session.close();
        }
        return sethdCt;
    }

}
