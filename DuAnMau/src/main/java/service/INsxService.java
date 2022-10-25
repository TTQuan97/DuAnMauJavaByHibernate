/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.NsxViewModel;

/**
 *
 * @author trant
 */
public interface INsxService {

    public List<NsxViewModel> getAllNsx();

    String insertNsx(String maNsx, String tenNsx);

    void updateNsx(NsxViewModel nsxView, String ma, String ten);

    public void deleteNsx(String maNsx);

    public String getIdFromMa(String maNsx);

}
