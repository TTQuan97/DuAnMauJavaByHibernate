/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author trant
 */
public interface ISanPhamService {

    List<SanPhamViewModel> getAllSanPham();

    String insertSanPham(String ma, String ten);

    void updateSanPham(SanPhamViewModel spView, String ma, String ten);

    String getIdFromMa(String maSp);

}
