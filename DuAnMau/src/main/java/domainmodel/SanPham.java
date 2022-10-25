/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(generator = "autoGen")
    @GenericGenerator(name = "autoGen", strategy = "guid")
    @Column(name = "Id")
    private String id;
    @Column(name = "Ma", unique = true)
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietSP> chiTietSP;

    public SanPham() {
    }

    public SanPham(String id, String ma, String ten, List<ChiTietSP> chiTietSP) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.chiTietSP = chiTietSP;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<ChiTietSP> getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(List<ChiTietSP> chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

}
