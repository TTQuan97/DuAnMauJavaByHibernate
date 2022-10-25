/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author trant
 */
public class HoaDonViewModel {

    private String maHD;
    private Date ngayTao;
    private Integer TrangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maHD, Date ngayTao, Integer TrangThai) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.TrangThai = TrangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Integer TrangThai) {
        this.TrangThai = TrangThai;
    }

    private String convertTrangthai() {
        if (TrangThai == null) {
            return "Chưa thanh toán";
        } else if (TrangThai == 1) {
            return "Đã thanh toán";
        } else {
            return "Đã hủy";
        }
    }

    public Object[] getHoaDonForView() {
        return new Object[]{maHD, new SimpleDateFormat("dd-MM-yyyy").format(ngayTao), convertTrangthai()};
    }

}
