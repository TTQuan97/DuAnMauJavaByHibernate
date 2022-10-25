/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import java.util.Date;
import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author trant
 */
public interface IHoaDonService {

    List<HoaDonViewModel> getAllHoaDon();

    String insertHoaDon(String maHD, Date ngayTao, Integer tinhTrang);

    void updateTrangThai(String maHd, Integer trangThai);

    HoaDon getHoaDonByMa(String maHd);
}
