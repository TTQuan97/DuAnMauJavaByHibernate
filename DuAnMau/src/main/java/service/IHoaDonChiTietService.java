package service;

import java.math.BigDecimal;
import java.util.List;
import viewmodel.ChiTietSpViewModel;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author trant
 */
public interface IHoaDonChiTietService {

    List<HoaDonChiTietViewModel> getHoaDonChiTietByMaHd(String maHd);

    void insertHoaDonChiTiet(Integer soLuong, BigDecimal donGia, ChiTietSpViewModel SpView, HoaDonViewModel hoaDonView);

}
