/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.DongSpViewModel;

/**
 *
 * @author trant
 */
public interface IDongSpService {

    List<DongSpViewModel> getAllDongSp();

    String insertDong(String maDong, String tenDong);

    void updateDong(DongSpViewModel dongView, String ma, String ten);

    void deleteDongSp(String maDong);

    String getIdFromMa(String maDong);
}
