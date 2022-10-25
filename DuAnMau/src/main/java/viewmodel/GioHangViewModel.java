package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author trant
 */
public class GioHangViewModel {

    private String idSp;
    private String maSp;
    private String tenSp;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;

    public GioHangViewModel() {
    }

    public GioHangViewModel(String idSp, String maSp, String tenSp, Integer soLuong, BigDecimal donGia, BigDecimal thanhTien) {
        this.idSp = idSp;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public BigDecimal tinhTongTien() {

        return donGia.multiply(new BigDecimal(soLuong));
    }

    public Object[] getDataGioHangView() {
        return new Object[]{idSp, maSp, tenSp, soLuong, donGia, thanhTien};
    }

}
