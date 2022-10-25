/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.ChiTietSP;
import domainmodel.DongSP;
import domainmodel.MauSac;
import domainmodel.Nsx;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repository.implement.ChiTietSpRepository;
import repository.implement.DongSpRepository;
import repository.implement.MauSacRepository;
import repository.implement.NsxRepository;
import repository.implement.SanPhamRepository;
import repository.IChiTietSpRepository;
import repository.IDongSpRepository;
import repository.IMauSacRepository;
import repository.INsxRepository;
import repository.ISanPhamRepository;
import service.IChiTietSpService;
import viewmodel.ChiTietSpViewModel;
import viewmodel.DongSpViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.NsxViewModel;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author trant
 */
public class ChiTietSpService implements IChiTietSpService {

    private IChiTietSpRepository ChiTietSpRepository;
    private IMauSacRepository mauSacRepo;
    private IDongSpRepository dongSpRepo;
    private INsxRepository nsxRepo;
    private ISanPhamRepository sanPhamRepo;

    public ChiTietSpService() {
        ChiTietSpRepository = new ChiTietSpRepository();
        mauSacRepo = new MauSacRepository();
        dongSpRepo = new DongSpRepository();
        nsxRepo = new NsxRepository();
        sanPhamRepo = new SanPhamRepository();
    }

    @Override
    public List<ChiTietSpViewModel> getAllChiTietSp() {
        var chiTiet = ChiTietSpRepository.getAllChiTietSp();
        List<ChiTietSpViewModel> listView = new ArrayList<>();
        for (ChiTietSP ct : chiTiet) {
            ChiTietSpViewModel chiTietView = new ChiTietSpViewModel();
            chiTietView.setId(ct.getId());
            chiTietView.setMaSanPham(ct.getSanPham().getMa());
            chiTietView.setTenSanPham(ct.getSanPham().getTen());
            if (ct.getNsx() != null) {
                chiTietView.setTenNsx(ct.getNsx().getTen());
            } else {
                chiTietView.setTenNsx("(chưa có thông tin)");
            }
            if (ct.getDongSp() != null) {
                chiTietView.setTenDongSanPham(ct.getDongSp().getTen());
            } else {
                chiTietView.setTenDongSanPham("(chưa có thông tin)");
            }
            if (ct.getMauSac() != null) {
                chiTietView.setTenMauSac(ct.getMauSac().getTen());
            } else {
                chiTietView.setTenMauSac("(chưa có thông tin)");
            }
            chiTietView.setNamBH(ct.getNamBH());
            chiTietView.setSoLuongTon(ct.getSoLuongTon());
            chiTietView.setGiaNhap(ct.getGiaNhap());
            chiTietView.setGiaBan(ct.getGiaBan());
            chiTietView.setMoTa(ct.getMoTa());
            listView.add(chiTietView);
        }
        return listView;
    }

    @Override
    public String addChiTietSanPham(SanPhamViewModel sp, DongSpViewModel dongSp,
            MauSacViewModel mauSac, NsxViewModel nsx, Integer namBH, Integer soLuongTon,
            BigDecimal giaNhap, BigDecimal giaBan, String moTa) {
        SanPham product = sanPhamRepo.getSanPhamFromMa(sp.getMa());
        MauSac color = mauSacRepo.getMauSacFromMa(mauSac.getMa());
        DongSP type = dongSpRepo.getDongSpFromMa(dongSp.getMa());
        Nsx mnf = nsxRepo.getNsxFromMa(nsx.getMa());
        return ChiTietSpRepository.addChiTietSanPham(product, type, color, mnf, namBH,
                soLuongTon, giaNhap, giaBan, moTa);
    }

    @Override
    public void updateChiTietSp(String idChiTiet, SanPhamViewModel spView,
            DongSpViewModel dongSpView, MauSacViewModel mauSacView,
            NsxViewModel nsxView, Integer namBH, Integer soLuongTon, BigDecimal giaNhap,
            BigDecimal giaBan, String moTa) {
        SanPham sp = sanPhamRepo.getSanPhamFromMa(spView.getMa());
        DongSP dong = dongSpRepo.getDongSpFromMa(dongSpView.getMa());
        Nsx nsx = nsxRepo.getNsxFromMa(nsxView.getMa());
        MauSac mauSac = mauSacRepo.getMauSacFromMa(mauSacView.getMa());
        ChiTietSpRepository.updateChiTietSp(idChiTiet, sp, dong, mauSac, nsx, namBH,
                soLuongTon, giaNhap, giaBan, moTa);
    }

    @Override
    public void deleteChiTietSp(String idChiTiet) {
        ChiTietSpRepository.deleteChiTietSp(idChiTiet);
    }

    @Override
    public List<ChiTietSpViewModel> searchChiTietSanPham(String tenSp) {
        var chiTiet = ChiTietSpRepository.searchChiTietSanPham(tenSp);
        List<ChiTietSpViewModel> listSearchView = new ArrayList<>();
        for (ChiTietSP ct : chiTiet) {
            ChiTietSpViewModel chiTietView = new ChiTietSpViewModel();
            chiTietView.setId(ct.getId());
            chiTietView.setMaSanPham(ct.getSanPham().getMa());
            chiTietView.setTenSanPham(ct.getSanPham().getTen());
            if (ct.getNsx() != null) {
                chiTietView.setTenNsx(ct.getNsx().getTen());
            }
            if (ct.getDongSp() != null) {
                chiTietView.setTenDongSanPham(ct.getDongSp().getTen());
            }
            if (ct.getMauSac() != null) {
                chiTietView.setTenMauSac(ct.getMauSac().getTen());
            }
            chiTietView.setNamBH(ct.getNamBH());
            chiTietView.setSoLuongTon(ct.getSoLuongTon());
            chiTietView.setGiaNhap(ct.getGiaNhap());
            chiTietView.setGiaBan(ct.getGiaBan());
            chiTietView.setMoTa(ct.getMoTa());
            listSearchView.add(chiTietView);
        }
        return listSearchView;
    }

    @Override
    public void updateSoluongTon(String idChiTiet, Integer soLuongTon) {
        ChiTietSpRepository.updateSoluongTon(idChiTiet, soLuongTon);
    }

}
