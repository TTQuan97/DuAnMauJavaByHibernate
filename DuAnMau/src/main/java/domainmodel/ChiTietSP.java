/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "ChiTietSP")

public class ChiTietSP implements Serializable {

    @Id
    @GeneratedValue(generator = "autoGen")
    @GenericGenerator(name = "autoGen", strategy = "guid")
    @Column(name = "Id")
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP", nullable = true)
    private SanPham sanPham;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx", nullable = true)
    private Nsx nsx;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac", nullable = true)
    private MauSac mauSac;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP", nullable = true)
    private DongSP dongSp;
    @Column(name = "NamBH")
    private Integer namBH;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "HoaDonChiTiet",
            joinColumns = {
                @JoinColumn(name = "IdChiTietSP")},
            inverseJoinColumns = {
                @JoinColumn(name = "IdHoaDon")}
    )
    private Set<HoaDon> hoaDon;

    @OneToMany(mappedBy = "chiTietSpKey", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HoaDonChiTiet> hoaDonChiTiet;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham sanPham, Nsx nsx, MauSac mauSac, DongSP dongSp, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Set<HoaDon> hoaDon, Set<HoaDonChiTiet> hoaDonChiTiet) {
        this.id = id;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSp = dongSp;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hoaDon = hoaDon;
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Nsx getNsx() {
        return nsx;
    }

    public void setNsx(Nsx nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSp() {
        return dongSp;
    }

    public void setDongSp(DongSP dongSp) {
        this.dongSp = dongSp;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Set<HoaDon> getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(Set<HoaDon> hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Set<HoaDonChiTiet> getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(Set<HoaDonChiTiet> hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

}
