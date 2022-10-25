/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.MauSac;
import java.util.ArrayList;
import java.util.List;
import repository.IMauSacRepository;
import repository.implement.MauSacRepository;
import service.IMauSacService;
import viewmodel.MauSacViewModel;

/**
 *
 * @author trant
 */
public class MauSacService implements IMauSacService {

    IMauSacRepository mauSacRepo;

    public MauSacService() {
        mauSacRepo = new MauSacRepository();
    }

    @Override
    public List<MauSacViewModel> getAllMauSac() {
        var allmauSac = mauSacRepo.getAllMauSac();
        List<MauSacViewModel> listView = new ArrayList<>();
        for (MauSac mauSac : allmauSac) {
            listView.add(new MauSacViewModel(mauSac.getMa(), mauSac.getTen()));
        }
        return listView;
    }

    @Override
    public void insertMauSac(String maMau, String tenMau) {
        mauSacRepo.insertMauSac(maMau, tenMau);
    }

    @Override
    public void updateMauSac(MauSacViewModel mauView, String ma, String ten) {
        MauSac mauSac = mauSacRepo.getMauSacFromMa(mauView.getMa());
        mauSacRepo.updateMauSac(mauSac, ma, ten);
    }

    @Override
    public void deleteMauSac(String maMau) {
        mauSacRepo.deleteMauSac(maMau);
    }

    @Override
    public String getIdFromMa(String maMau) {
        String id = null;
        if (mauSacRepo.getMauSacFromMa(maMau) == null) {
            return id;
        } else {
            return id = mauSacRepo.getMauSacFromMa(maMau).getId();
        }
    }

}
