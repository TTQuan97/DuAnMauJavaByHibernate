/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GeneratedValue(generator = "autoGen")
    @GenericGenerator(name = "autoGen", strategy = "guid")
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "HoaDonChiTiet",
            joinColumns = {
                @JoinColumn(name = "IdHoaDon")},
            inverseJoinColumns = {
                @JoinColumn(name = "IdChiTietSP")}
    )
    private Set<ChiTietSP> chiTietSP;

    @OneToMany(mappedBy = "hoaDonKey", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HoaDonChiTiet> hoaDonChiTiet;

    public HoaDon() {
    }

    public HoaDon(String id, String ma, Date ngayTao, Integer tinhTrang, Set<ChiTietSP> chiTietSP, Set<HoaDonChiTiet> hoaDonChiTiet) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
        this.chiTietSP = chiTietSP;
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Set<ChiTietSP> getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(Set<ChiTietSP> chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public Set<HoaDonChiTiet> getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(Set<HoaDonChiTiet> hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

}
