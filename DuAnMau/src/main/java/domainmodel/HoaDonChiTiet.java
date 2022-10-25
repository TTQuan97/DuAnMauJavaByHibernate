/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HoaDonChiTiet")
@IdClass(HoaDonSanPhamId.class)
public class HoaDonChiTiet implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDonKey;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSpKey;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    public HoaDonChiTiet() {

    }

    public HoaDonChiTiet(HoaDon hoaDonKey, ChiTietSP chiTietSpKey, Integer soLuong, BigDecimal donGia) {
        this.hoaDonKey = hoaDonKey;
        this.chiTietSpKey = chiTietSpKey;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getHoaDonKey() {
        return hoaDonKey;
    }

    public void setHoaDonKey(HoaDon hoaDonKey) {
        this.hoaDonKey = hoaDonKey;
    }

    public ChiTietSP getChiTietSpKey() {
        return chiTietSpKey;
    }

    public void setChiTietSpKey(ChiTietSP chiTietSpKey) {
        this.chiTietSpKey = chiTietSpKey;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

}
