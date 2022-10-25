/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.Nsx;
import java.util.ArrayList;
import java.util.List;
import repository.INsxRepository;
import repository.implement.NsxRepository;
import service.INsxService;
import viewmodel.NsxViewModel;

/**
 *
 * @author trant
 */
public class NsxService implements INsxService {

    INsxRepository nsxRepo;

    public NsxService() {
        nsxRepo = new NsxRepository();
    }

    @Override
    public List<NsxViewModel> getAllNsx() {
        var allNsx = nsxRepo.getAllNsx();
        List<NsxViewModel> listView = new ArrayList<>();
        for (Nsx nsx : allNsx) {
            listView.add(new NsxViewModel(nsx.getMa(), nsx.getTen()));
        }
        return listView;
    }

    @Override
    public String insertNsx(String maNsx, String tenNsx) {
        return nsxRepo.insertNsx(maNsx, tenNsx);
    }

    @Override
    public void updateNsx(NsxViewModel nsxView, String ma, String ten) {
        Nsx nsx = nsxRepo.getNsxFromMa(nsxView.getMa());
        nsxRepo.updateNsx(nsx, ma, ten);
    }

    @Override
    public void deleteNsx(String maNsx) {
        nsxRepo.deleteNsx(maNsx);
    }

    @Override
    public String getIdFromMa(String maNsx) {
        String id = null;
        if (nsxRepo.getNsxFromMa(maNsx) == null) {
            return id;
        } else {
            return id = nsxRepo.getNsxFromMa(maNsx).getId();
        }
    }

}
