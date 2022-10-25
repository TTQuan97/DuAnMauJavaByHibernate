/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.SanPham;
import java.util.ArrayList;
import java.util.List;
import repository.ISanPhamRepository;
import repository.implement.SanPhamRepository;
import service.ISanPhamService;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author trant
 */
public class SanPhamService implements ISanPhamService {

    private ISanPhamRepository sanPhamRepo;

    public SanPhamService() {
        sanPhamRepo = new SanPhamRepository();
    }

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        var listViewSp = sanPhamRepo.getAllSanPham();
        List<SanPhamViewModel> listView = new ArrayList<>();
        for (SanPham sp : listViewSp) {
            listView.add(new SanPhamViewModel(sp.getMa(), sp.getTen()));
        }
        return listView;

    }

    @Override
    public String insertSanPham(String ma, String ten) {
        return sanPhamRepo.insertSanPham(ma, ten);
    }

    @Override
    public void updateSanPham(SanPhamViewModel spView, String ma, String ten) {
        SanPham sp = sanPhamRepo.getSanPhamFromMa(spView.getMa());
        sanPhamRepo.updateSanPham(sp, ma, ten);
    }

    @Override
    public String getIdFromMa(String maSp) {
        String id = null;
        if (sanPhamRepo.getSanPhamFromMa(maSp) == null) {
            return id;
        } else {
            return id = sanPhamRepo.getSanPhamFromMa(maSp).getId();
        }

    }

}
