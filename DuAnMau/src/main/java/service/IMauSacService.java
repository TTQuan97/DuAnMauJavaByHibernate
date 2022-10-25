/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.MauSacViewModel;

/**
 *
 * @author trant
 */
public interface IMauSacService {

    List<MauSacViewModel> getAllMauSac();

    void insertMauSac(String maMau, String tenMau);

    void updateMauSac(MauSacViewModel mauView, String ma, String ten);

    void deleteMauSac(String maMau);

    String getIdFromMa(String maMau);
}
