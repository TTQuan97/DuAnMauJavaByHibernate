/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.HoaDon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.implement.HoaDonRepository;
import repository.IHoaDonRepository;
import service.IHoaDonService;
import viewmodel.HoaDonViewModel;

public class HoaDonService implements IHoaDonService {

    private final IHoaDonRepository hoaDonRepo;

    public HoaDonService() {
        hoaDonRepo = new HoaDonRepository();
    }

    @Override
    public List<HoaDonViewModel> getAllHoaDon() {
        List<HoaDonViewModel> listView = new ArrayList<>();
        var listHoaDon = hoaDonRepo.getAllHoaDon();
        for (HoaDon hoaDon : listHoaDon) {
            listView.add(new HoaDonViewModel(hoaDon.getMa(), hoaDon.getNgayTao(), hoaDon.getTinhTrang()));
        }
        return listView;
    }

    @Override
    public String insertHoaDon(String maHD, Date ngayTao, Integer tinhTrang) {
        return hoaDonRepo.insertHoaDon(maHD, ngayTao, tinhTrang);
    }

    @Override
    public void updateTrangThai(String maHd, Integer trangThai) {
        hoaDonRepo.updateTrangThai(maHd, trangThai);
    }

    @Override
    public HoaDon getHoaDonByMa(String maHd) {
        return hoaDonRepo.getHoaDonByMa(maHd);
    }

}
