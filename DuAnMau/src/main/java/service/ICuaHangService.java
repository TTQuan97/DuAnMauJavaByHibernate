/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.CuaHangViewModel;

/**
 *
 * @author trant
 */
public interface ICuaHangService {

    List<CuaHangViewModel> getAllCuaHang();

    String insertCuaHang(CuaHangViewModel cuaHang);

    void deleteCuaHangbyId(String id);

    void updateCuaHang(CuaHangViewModel cuaHang);

    CuaHangViewModel getCuaHangByMa(String ma);

    List<CuaHangViewModel> getCuahangByDiaChi(String diaChi);

}
