/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Nsx;
import java.util.List;

/**
 *
 * @author trant
 */
public interface INsxRepository {

    List<Nsx> getAllNsx();

    String insertNsx(String maNsx, String tenNsx);

    void updateNsx(Nsx nsx, String ma, String ten);

    void deleteNsx(String maNsx);

    Nsx getNsxFromMa(String maNsx);

}
