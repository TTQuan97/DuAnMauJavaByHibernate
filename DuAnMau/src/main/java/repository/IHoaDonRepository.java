/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiTietSP;
import domainmodel.HoaDon;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author trant
 */
public interface IHoaDonRepository {

    List<HoaDon> getAllHoaDon();

    String insertHoaDon(String maHD, Date ngayTao, Integer tinhTrang);

    void updateTrangThai(String maHd, Integer trangThai);

    HoaDon getHoaDonByMa(String maHd);

    Set<ChiTietSP> getChiTietSpByHoaDon(HoaDon hoaDon);
}
