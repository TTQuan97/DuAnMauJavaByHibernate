package domainmodel;

import java.io.Serializable;
import java.util.Objects;

public class HoaDonSanPhamId implements Serializable {

    private HoaDon hoaDonKey;
    private ChiTietSP chiTietSpKey;

    public HoaDonSanPhamId() {
    }

    public HoaDonSanPhamId(HoaDon hoaDonKey, ChiTietSP chiTietSpKey) {
        this.hoaDonKey = hoaDonKey;
        this.chiTietSpKey = chiTietSpKey;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.hoaDonKey);
        hash = 23 * hash + Objects.hashCode(this.chiTietSpKey);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDonSanPhamId other = (HoaDonSanPhamId) obj;
        if (!Objects.equals(this.hoaDonKey, other.hoaDonKey)) {
            return false;
        }
        return Objects.equals(this.chiTietSpKey, other.chiTietSpKey);
    }

}
