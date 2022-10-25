/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.File;
import domainmodel.ChiTietSP;

import domainmodel.DongSP;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.HoaDonSanPhamId;
import domainmodel.MauSac;
import domainmodel.Nsx;
import domainmodel.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author trant
 */
public class HibernateUtility {

    private static SessionFactory factory;

    static {
        Configuration config = new Configuration();
        config.configure(new File("resources\\hibernate.cfg.xml"));
        config.addAnnotatedClass(ChiTietSP.class);
        config.addAnnotatedClass(DongSP.class);
        config.addAnnotatedClass(HoaDonChiTiet.class);
        config.addAnnotatedClass(HoaDon.class);
        config.addAnnotatedClass(MauSac.class);
        config.addAnnotatedClass(Nsx.class);
        config.addAnnotatedClass(SanPham.class);
        config.addAnnotatedClass(HoaDonSanPhamId.class);
        factory = config.buildSessionFactory();

    }

    public static SessionFactory getFactory() {
        return factory;
    }

}
