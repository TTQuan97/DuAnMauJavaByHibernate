package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author trant
 */
public class HoaDonChiTietViewModel {

    private String tenSp;
    private Integer soLuong;
    private BigDecimal donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String tenSp, Integer soLuong, BigDecimal donGia) {
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public Object[] getDataHoaDonChiTietView() {
        return new Object[]{tenSp, soLuong, donGia};
    }

}
