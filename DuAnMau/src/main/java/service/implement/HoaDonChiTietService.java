/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.ChiTietSP;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repository.implement.ChiTietSpRepository;
import repository.implement.HoaDonChiTietRepository;
import repository.implement.HoaDonRepository;
import repository.IChiTietSpRepository;
import repository.IHoaDonChiTietRepository;
import repository.IHoaDonRepository;
import service.IHoaDonChiTietService;
import viewmodel.ChiTietSpViewModel;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author trant
 */
public class HoaDonChiTietService implements IHoaDonChiTietService {

    private final IHoaDonRepository hoaDonRepo;
    private final IHoaDonChiTietRepository hoaDonChiTietRepo;
    private final IChiTietSpRepository chiTietSpRepo;

    public HoaDonChiTietService() {
        hoaDonRepo = new HoaDonRepository();
        hoaDonChiTietRepo = new HoaDonChiTietRepository();
        chiTietSpRepo = new ChiTietSpRepository();
    }

    @Override
    public List<HoaDonChiTietViewModel> getHoaDonChiTietByMaHd(String maHd) {
        List<HoaDonChiTietViewModel> listView = new ArrayList<>();
        var ChiTietHd = hoaDonChiTietRepo.getHoaDonChiTietByHoaDon(hoaDonRepo.getHoaDonByMa(maHd));
        for (HoaDonChiTiet hoaDonct : ChiTietHd) {
            HoaDonChiTietViewModel chiTietHd = new HoaDonChiTietViewModel();
            chiTietHd.setDonGia(hoaDonct.getDonGia());
            chiTietHd.setSoLuong(hoaDonct.getSoLuong());
            chiTietHd.setTenSp(hoaDonct.getChiTietSpKey().getSanPham().getTen());
            listView.add(chiTietHd);
        }
        return listView;
    }

    @Override
    public void insertHoaDonChiTiet(Integer soLuong, BigDecimal donGia, ChiTietSpViewModel SpView, HoaDonViewModel hoaDonView) {
        ChiTietSP chiTietSP = chiTietSpRepo.getChiTietSpById(SpView.getId());
        HoaDon hoaDon = hoaDonRepo.getHoaDonByMa(hoaDonView.getMaHD());
        hoaDonChiTietRepo.insertHoaDonChiTiet(soLuong, donGia, chiTietSP, hoaDon);
    }

}
