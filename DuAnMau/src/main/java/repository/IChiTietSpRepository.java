/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiTietSP;
import domainmodel.DongSP;
import domainmodel.MauSac;
import domainmodel.Nsx;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author trant
 */
public interface IChiTietSpRepository {

    List<ChiTietSP> getAllChiTietSp();

    String addChiTietSanPham(SanPham sp, DongSP dongSp,
            MauSac mauSac, Nsx nsx, Integer namBH, Integer soLuongTon,
            BigDecimal giaNhap, BigDecimal giaBan, String moTa);

    void updateChiTietSp(String idChiTiet, SanPham sp, DongSP dongSp,
            MauSac mauSac, Nsx nsx, Integer namBH, Integer soLuongTon,
            BigDecimal giaNhap, BigDecimal giaBan, String moTa);

    void updateSoluongTon(String idChiTiet, Integer soLuongTon);

    void deleteChiTietSp(String idChiTiet);

    List<ChiTietSP> searchChiTietSanPham(String tenSp);

    ChiTietSP getChiTietSpById(String id);
}
