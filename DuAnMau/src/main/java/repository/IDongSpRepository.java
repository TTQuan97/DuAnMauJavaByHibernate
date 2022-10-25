/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.DongSP;
import java.util.List;

/**
 *
 * @author trant
 */
public interface IDongSpRepository {

    List<DongSP> getAllDongSp();

    String insertDong(String maDong, String tenDong);

    void updateDong(DongSP dong, String ma, String ten);

    void deleteDongSp(String maDong);

    public DongSP getDongSpFromMa(String maDong);

}
