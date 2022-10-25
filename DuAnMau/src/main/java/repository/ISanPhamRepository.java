package repository;

import domainmodel.SanPham;
import java.util.List;

/**
 *
 * @author trant
 */
public interface ISanPhamRepository {

    List<SanPham> getAllSanPham();

    String insertSanPham(String ma, String ten);

    void updateSanPham(SanPham sp, String ma, String ten);

    SanPham getSanPhamFromMa(String maSp);
}
