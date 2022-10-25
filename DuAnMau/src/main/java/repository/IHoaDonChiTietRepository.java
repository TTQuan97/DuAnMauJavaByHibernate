/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.ChiTietSP;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author trant
 */
public interface IHoaDonChiTietRepository {

    void insertHoaDonChiTiet(Integer soLuong, BigDecimal donGia, ChiTietSP chiTietSp,
            HoaDon hoaDon);

    Set<HoaDonChiTiet> getHoaDonChiTietByHoaDon(HoaDon hoaDon);

}
