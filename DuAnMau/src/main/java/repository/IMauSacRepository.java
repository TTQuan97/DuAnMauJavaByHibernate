/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.MauSac;
import java.util.List;

/**
 *
 * @author trant
 */
public interface IMauSacRepository {

    List<MauSac> getAllMauSac();

    String insertMauSac(String maMau, String tenMau);

    void updateMauSac(MauSac mauSac, String ma, String ten);

    void deleteMauSac(String maMau);

    MauSac getMauSacFromMa(String maMau);
}
