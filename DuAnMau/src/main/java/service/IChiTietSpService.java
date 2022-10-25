/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import viewmodel.ChiTietSpViewModel;
import viewmodel.DongSpViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.NsxViewModel;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author trant
 */
public interface IChiTietSpService {

    List<ChiTietSpViewModel> getAllChiTietSp();

    String addChiTietSanPham(SanPhamViewModel sp, DongSpViewModel dongSp, MauSacViewModel mauSac, NsxViewModel nsx,
            Integer namBH, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, String moTa);

    void updateChiTietSp(String idChiTiet, SanPhamViewModel spView, DongSpViewModel dongSpView, MauSacViewModel mauSacView,
            NsxViewModel nsxView, Integer namBH, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, String moTa);

    void deleteChiTietSp(String idChiTiet);

    List<ChiTietSpViewModel> searchChiTietSanPham(String tenSp);

    void updateSoluongTon(String idChiTiet, Integer soLuongTon);
}
