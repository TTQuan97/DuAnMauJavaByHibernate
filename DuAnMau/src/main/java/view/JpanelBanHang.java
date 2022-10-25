package view;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.implement.ChiTietSpService;
import service.implement.DongSpService;
import service.implement.HoaDonChiTietService;
import service.implement.HoaDonService;
import service.IHoaDonService;
import service.IChiTietSpService;
import service.IDongSpService;
import service.IMauSacService;
import service.INsxService;
import service.ISanPhamService;
import service.implement.MauSacService;
import service.implement.NsxService;
import service.implement.SanPhamService;
import service.IHoaDonChiTietService;
import viewmodel.ChiTietSpViewModel;
import viewmodel.DongSpViewModel;
import viewmodel.GioHangViewModel;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.NsxViewModel;
import viewmodel.SanPhamViewModel;

public class JpanelBanHang extends javax.swing.JPanel {

    private DefaultTableModel modelTableSanPhamChiTiet;
    private DefaultTableModel modelTableHoaDon;
    private DefaultTableModel modelTableGioHang;
    private DefaultTableModel modelTableHoaDonChiTiet;
    private final IChiTietSpService chiTietSpService;
    private final IMauSacService mauSacService;
    private final INsxService nsxService;
    private final IDongSpService dongSpService;
    private final ISanPhamService sanPhamService;
    private final IHoaDonService hoaDonService;
    private final IHoaDonChiTietService hoaDonChiTietService;
    private DefaultComboBoxModel<SanPhamViewModel> comboSanPham;
    private DefaultComboBoxModel<MauSacViewModel> comboMauSac;
    private DefaultComboBoxModel<NsxViewModel> comboNsx;
    private DefaultComboBoxModel<DongSpViewModel> comboDongSp;

    public JpanelBanHang() {
        initComponents();
        setDefaultTable();
        hoaDonService = new HoaDonService();
        chiTietSpService = new ChiTietSpService();
        mauSacService = new MauSacService();
        nsxService = new NsxService();
        dongSpService = new DongSpService();
        sanPhamService = new SanPhamService();
        hoaDonChiTietService = new HoaDonChiTietService();
        showDataChiTietSp(chiTietSpService.getAllChiTietSp());
        ShowDataHoaDon(hoaDonService.getAllHoaDon());
        setDefaultCombobox();
        btnThanhToan.setEnabled(false);
        txtTienKhachDua.setEnabled(false);

    }

    public final void setDefaultCombobox() {
        comboSanPham = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sanPhamService.getAllSanPham().toArray());
        comboMauSac = (DefaultComboBoxModel) new DefaultComboBoxModel<>(mauSacService.getAllMauSac().toArray());
        comboNsx = (DefaultComboBoxModel) new DefaultComboBoxModel<>(nsxService.getAllNsx().toArray());
        comboDongSp = (DefaultComboBoxModel) new DefaultComboBoxModel<>(dongSpService.getAllDongSp().toArray());
        cbbSanPham.setModel((DefaultComboBoxModel) comboSanPham);
        cbbDongSp.setModel((DefaultComboBoxModel) comboDongSp);
        cbbMauSac.setModel((DefaultComboBoxModel) comboMauSac);
        cbbNsx.setModel((DefaultComboBoxModel) comboNsx);

    }

    private void setDefaultTable() {
        modelTableSanPhamChiTiet = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelTableHoaDon = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelTableGioHang = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        modelTableHoaDonChiTiet = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        String headerChiTiet[] = {"Id", "Mã Sp", "Tên Sp", "Nhà sản xuất", "Dòng Sp",
            "Màu sắc", "Năm Bảo hành", "Số lượng tồn", "Giá nhập", "Giá Bán", "Mô tả"};
        String headerHoaDon[] = {"Mã HĐ", "Ngày tạo", "Trạng thái"};
        String headerGioHang[] = {"IdSp", "Mã Sp", "Tên Sp", "Số lượng", "Đơn giá", "Thành tiền"};
        String headerChiTietHd[] = {"Tên Sp", "Số lượng", "Đơn giá"};
        modelTableSanPhamChiTiet.setColumnIdentifiers(headerChiTiet);
        modelTableHoaDon.setColumnIdentifiers(headerHoaDon);
        modelTableGioHang.setColumnIdentifiers(headerGioHang);
        modelTableHoaDonChiTiet.setColumnIdentifiers(headerChiTietHd);
        //set model for table
        tblChiTietHD.setModel(modelTableHoaDonChiTiet);
        tblSanPhamBan.setModel(modelTableSanPhamChiTiet);
        tblHoaDon.setModel(modelTableHoaDon);
        tblQuanLiChiTietSp.setModel(modelTableSanPhamChiTiet);
        tblGioHang.setModel(modelTableGioHang);
        //not allowed edit column
        tblChiTietHD.getTableHeader().setReorderingAllowed(false);
        tblQuanLiChiTietSp.getTableHeader().setReorderingAllowed(false);
        tblGioHang.getTableHeader().setReorderingAllowed(false);
        tblHoaDon.getTableHeader().setReorderingAllowed(false);
        tblSanPhamBan.getTableHeader().setReorderingAllowed(false);
        //hide column Id on table
        tblSanPhamBan.getColumnModel().getColumn(0).setMinWidth(0);
        tblSanPhamBan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblGioHang.getColumnModel().getColumn(0).setMinWidth(0);
        tblGioHang.getColumnModel().getColumn(0).setMaxWidth(0);
        tblQuanLiChiTietSp.getColumnModel().getColumn(0).setMinWidth(0);
        tblQuanLiChiTietSp.getColumnModel().getColumn(0).setMaxWidth(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tbpBanHang = new javax.swing.JTabbedPane();
        tabSanPham = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btnThemChiTietSp = new javax.swing.JButton();
        txtNamBH = new javax.swing.JTextField();
        txtSLTon = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        btnSuaChiTietSp = new javax.swing.JButton();
        btnXoaChiTietSp = new javax.swing.JButton();
        btnMoiChiTietSp = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblQuanLiChiTietSp = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbbNsx = new javax.swing.JComboBox<>();
        cbbDongSp = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbSanPham = new javax.swing.JComboBox<>();
        txtTenSp = new javax.swing.JLabel();
        tabHoaDon = new javax.swing.JPanel();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        pnlGioHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        pnlSanPhamHoaDon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamBan = new javax.swing.JTable();
        txtSearchSP = new javax.swing.JTextField();
        pnlHoaDonChiTiet = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtTienKhachDua = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaHoaDon = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblChiTietHD = new javax.swing.JTable();
        pnlDanhSachHoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tbpBanHang.setBackground(new java.awt.Color(255, 255, 255));
        tbpBanHang.setBorder(null);
        tbpBanHang.setOpaque(true);

        tabSanPham.setBackground(new java.awt.Color(255, 255, 255));
        tabSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Mã Sản Phẩm");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tên Sản Phẩm");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Năm Bảo Hành");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Số Lượng Tồn");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Giá Nhập");

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Giá Bán");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane4.setViewportView(txtMoTa);

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Mô Tả");

        btnThemChiTietSp.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnThemChiTietSp.setText("Thêm");
        btnThemChiTietSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemChiTietSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTietSpActionPerformed(evt);
            }
        });

        btnSuaChiTietSp.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnSuaChiTietSp.setText("Sửa");
        btnSuaChiTietSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaChiTietSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChiTietSpActionPerformed(evt);
            }
        });

        btnXoaChiTietSp.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnXoaChiTietSp.setText("Xóa");
        btnXoaChiTietSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaChiTietSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChiTietSpActionPerformed(evt);
            }
        });

        btnMoiChiTietSp.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnMoiChiTietSp.setText("Mới");
        btnMoiChiTietSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiChiTietSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiChiTietSpActionPerformed(evt);
            }
        });

        tblQuanLiChiTietSp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblQuanLiChiTietSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLiChiTietSpMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblQuanLiChiTietSp);

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Màu sắc");

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Dòng Sản phẩm");

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Nhà sản xuất");

        cbbNsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNsx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbNsxMouseEntered(evt);
            }
        });

        cbbDongSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDongSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbDongSpMouseEntered(evt);
            }
        });

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbMauSacMouseEntered(evt);
            }
        });

        cbbSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSanPhamActionPerformed(evt);
            }
        });

        txtTenSp.setForeground(new java.awt.Color(102, 102, 102));
        txtTenSp.setText("-");

        javax.swing.GroupLayout tabSanPhamLayout = new javax.swing.GroupLayout(tabSanPham);
        tabSanPham.setLayout(tabSanPhamLayout);
        tabSanPhamLayout.setHorizontalGroup(
            tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSanPhamLayout.createSequentialGroup()
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7))
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel16))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel10))
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel11))
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel12))
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel13))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtGiaBan)
                    .addComponent(txtGiaNhap)
                    .addComponent(txtSLTon)
                    .addComponent(txtNamBH)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.Alignment.LEADING, 0, 76, Short.MAX_VALUE)
                            .addComponent(cbbDongSp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbNsx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnThemChiTietSp)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaChiTietSp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaChiTietSp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoiChiTietSp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabSanPhamLayout.setVerticalGroup(
            tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSanPhamLayout.createSequentialGroup()
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSp))
                        .addGap(19, 19, 19)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbbNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbbDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel13))
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(43, 43, 43)
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaChiTietSp)
                    .addComponent(btnSuaChiTietSp)
                    .addComponent(btnMoiChiTietSp)
                    .addComponent(btnThemChiTietSp)))
        );

        tbpBanHang.addTab("Quản lí Sản Phẩm", tabSanPham);

        tabHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rdoChoThanhToan);
        rdoChoThanhToan.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rdoChoThanhToan.setForeground(new java.awt.Color(102, 102, 102));
        rdoChoThanhToan.setText("Chờ thanh toán");
        rdoChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rdoTatCa.setForeground(new java.awt.Color(102, 102, 102));
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rdoDaThanhToan.setForeground(new java.awt.Color(102, 102, 102));
        rdoDaThanhToan.setText("Đã thanh toán");
        rdoDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaThanhToanActionPerformed(evt);
            }
        });

        pnlGioHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlGioHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout pnlGioHangLayout = new javax.swing.GroupLayout(pnlGioHang);
        pnlGioHang.setLayout(pnlGioHangLayout);
        pnlGioHangLayout.setHorizontalGroup(
            pnlGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGioHangLayout.setVerticalGroup(
            pnlGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGioHangLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSanPhamHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnlSanPhamHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tblSanPhamBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanPhamBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamBanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPhamBan);

        txtSearchSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamHoaDonLayout = new javax.swing.GroupLayout(pnlSanPhamHoaDon);
        pnlSanPhamHoaDon.setLayout(pnlSanPhamHoaDonLayout);
        pnlSanPhamHoaDonLayout.setHorizontalGroup(
            pnlSanPhamHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(pnlSanPhamHoaDonLayout.createSequentialGroup()
                .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSanPhamHoaDonLayout.setVerticalGroup(
            pnlSanPhamHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamHoaDonLayout.createSequentialGroup()
                .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHoaDonChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pnlHoaDonChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn"));

        jLabel1.setText("Mã hóa đơn :");

        jLabel2.setText("Ngày tạo :");

        jLabel4.setText("Tổng tiền :");

        jLabel5.setText("Tiền khách đưa :");

        jLabel6.setText("Tiền thừa :");

        btnThanhToan.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 204, 102));
        jSeparator1.setOpaque(true);

        lblMaHoaDon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblMaHoaDon.setText("-");

        lblNgayTao.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblNgayTao.setText("-");

        lblTongTien.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblTongTien.setText("-");

        lblTienThua.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblTienThua.setText("-");

        tblChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblChiTietHD);

        javax.swing.GroupLayout pnlHoaDonChiTietLayout = new javax.swing.GroupLayout(pnlHoaDonChiTiet);
        pnlHoaDonChiTiet.setLayout(pnlHoaDonChiTietLayout);
        pnlHoaDonChiTietLayout.setHorizontalGroup(
            pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonChiTietLayout.createSequentialGroup()
                        .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                                .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonChiTietLayout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addGap(63, 63, 63)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlHoaDonChiTietLayout.setVerticalGroup(
            pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                        .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblMaHoaDon))
                        .addGap(18, 18, 18)
                        .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblNgayTao))
                        .addGap(34, 34, 34)
                        .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblTongTien))
                        .addGap(44, 44, 44)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblTienThua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlDanhSachHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnlDanhSachHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        tblHoaDon.setBorder(null);
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout pnlDanhSachHoaDonLayout = new javax.swing.GroupLayout(pnlDanhSachHoaDon);
        pnlDanhSachHoaDon.setLayout(pnlDanhSachHoaDonLayout);
        pnlDanhSachHoaDonLayout.setHorizontalGroup(
            pnlDanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDanhSachHoaDonLayout.setVerticalGroup(
            pnlDanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTaoHoaDon.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabHoaDonLayout = new javax.swing.GroupLayout(tabHoaDon);
        tabHoaDon.setLayout(tabHoaDonLayout);
        tabHoaDonLayout.setHorizontalGroup(
            tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHoaDonLayout.createSequentialGroup()
                .addGroup(tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlSanPhamHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabHoaDonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabHoaDonLayout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(tabHoaDonLayout.createSequentialGroup()
                                    .addComponent(rdoChoThanhToan)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoTatCa)
                                    .addGap(34, 34, 34)
                                    .addComponent(rdoDaThanhToan)
                                    .addGap(51, 51, 51))
                                .addComponent(pnlDanhSachHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnlGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlHoaDonChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabHoaDonLayout.setVerticalGroup(
            tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabHoaDonLayout.createSequentialGroup()
                        .addGroup(tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoChoThanhToan)
                            .addGroup(tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoTatCa)
                                .addComponent(rdoDaThanhToan)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDanhSachHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btnTaoHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlHoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tbpBanHang.addTab("Hóa Đơn", tabHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpBanHang)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public final void showDataChiTietSp(List<ChiTietSpViewModel> list) {
        modelTableSanPhamChiTiet.setRowCount(0);
        for (ChiTietSpViewModel chiTietView : list) {
            modelTableSanPhamChiTiet.addRow(chiTietView.getDataChiTietSpView());
        }
    }

    private void showDataGioHang(GioHangViewModel gioHang) {
        modelTableGioHang.addRow(gioHang.getDataGioHangView());
    }

    private void ShowDataHoaDon(List<HoaDonViewModel> list) {
        modelTableHoaDon.setRowCount(0);
        if (rdoTatCa.isSelected()) {
            for (HoaDonViewModel hoaDon : list) {
                modelTableHoaDon.addRow(hoaDon.getHoaDonForView());
            }
        } else if (rdoChoThanhToan.isSelected()) {
            for (HoaDonViewModel hoaDon : list) {
                if (hoaDon.getTrangThai() == null) {
                    modelTableHoaDon.addRow(hoaDon.getHoaDonForView());
                }
            }
        } else if (rdoDaThanhToan.isSelected()) {
            for (HoaDonViewModel hoaDon : list) {

                if (hoaDon.getTrangThai() != null && hoaDon.getTrangThai() == 1) {
                    modelTableHoaDon.addRow(hoaDon.getHoaDonForView());
                }
            }
        }
    }

    private void ShowDataHoaDonChiTiet(List<HoaDonChiTietViewModel> list) {
        int row = tblHoaDon.getSelectedRow();
        modelTableHoaDonChiTiet.setRowCount(0);
        int soLuong = 0;
        double donGia = 0;
        double tongTien = 0;
        for (HoaDonChiTietViewModel hoaDonChiTiet : list) {
            soLuong = hoaDonChiTiet.getSoLuong();
            donGia = Double.parseDouble(hoaDonChiTiet.getDonGia().toString());
            tongTien += (soLuong * donGia);
            modelTableHoaDonChiTiet.addRow(hoaDonChiTiet.getDataHoaDonChiTietView());
        }
        lblMaHoaDon.setText(tblHoaDon.getValueAt(row, 0).toString());
        lblNgayTao.setText(tblHoaDon.getValueAt(row, 1).toString());
        BigDecimal tongChiPhi = new BigDecimal(tongTien);
        lblTongTien.setText(tongChiPhi.toString());
    }

    private boolean checkNumber(String num) {
        Pattern regexInt = Pattern.compile("^[0-9]+$");
        Pattern regexDouble = Pattern.compile("^[0-9]+(\\.)[0-9]+$");
        if (!regexInt.matcher(num).find() && !regexDouble.matcher(num).find()) {
            JOptionPane.showMessageDialog(this, "Số không hợp lệ", "Number Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean checkEmpty() {
        if (txtNamBH.getText().isBlank() || txtSLTon.getText().isBlank()
                || txtGiaBan.getText().isBlank() || txtGiaNhap.getText().isBlank()
                || txtMoTa.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        }
        return true;
    }
    private void btnThemChiTietSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietSpActionPerformed
        if (checkEmpty() && checkNumber(txtNamBH.getText()) && checkNumber(txtSLTon.getText())
                && checkNumber(txtGiaNhap.getText()) && checkNumber(txtGiaBan.getText())) {
            SanPhamViewModel spView = (SanPhamViewModel) comboSanPham.getSelectedItem();
            DongSpViewModel dongView = (DongSpViewModel) comboDongSp.getSelectedItem();
            MauSacViewModel mauSacView = (MauSacViewModel) comboMauSac.getSelectedItem();
            NsxViewModel nsxView = (NsxViewModel) comboNsx.getSelectedItem();
            chiTietSpService.addChiTietSanPham(spView, dongView, mauSacView, nsxView,
                    Integer.parseInt(txtNamBH.getText()), Integer.parseInt(txtSLTon.getText()),
                    new BigDecimal(txtGiaNhap.getText()), new BigDecimal(txtGiaBan.getText()), txtMoTa.getText());
            JOptionPane.showMessageDialog(this, "Thêm thông tin thành công");
            showDataChiTietSp(chiTietSpService.getAllChiTietSp());
        }

    }//GEN-LAST:event_btnThemChiTietSpActionPerformed

    private void btnMoiChiTietSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiChiTietSpActionPerformed
        cbbSanPham.setSelectedIndex(0);
        cbbNsx.setSelectedIndex(0);
        cbbDongSp.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        txtTenSp.setText("");
        txtNamBH.setText("");
        txtSLTon.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtMoTa.setText("");
    }//GEN-LAST:event_btnMoiChiTietSpActionPerformed

    private void btnXoaChiTietSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChiTietSpActionPerformed
        int row = tblQuanLiChiTietSp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
        } else {
            chiTietSpService.deleteChiTietSp(tblQuanLiChiTietSp.getValueAt(row, 0).toString());
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            showDataChiTietSp(chiTietSpService.getAllChiTietSp());
            btnMoiChiTietSpActionPerformed(evt);

        }

    }//GEN-LAST:event_btnXoaChiTietSpActionPerformed

    private void btnSuaChiTietSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChiTietSpActionPerformed
        int row = tblQuanLiChiTietSp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa");
        } else {
            SanPhamViewModel spView = (SanPhamViewModel) comboSanPham.getSelectedItem();
            DongSpViewModel dongView = (DongSpViewModel) comboDongSp.getSelectedItem();
            MauSacViewModel mauSacView = (MauSacViewModel) comboMauSac.getSelectedItem();
            NsxViewModel nsxView = (NsxViewModel) comboNsx.getSelectedItem();
            chiTietSpService.updateChiTietSp(tblQuanLiChiTietSp.getValueAt(row, 0).toString(),
                    spView, dongView, mauSacView, nsxView,
                    Integer.parseInt(txtNamBH.getText()),
                    Integer.parseInt(txtSLTon.getText()),
                    new BigDecimal(txtGiaNhap.getText()),
                    new BigDecimal(txtGiaBan.getText()),
                    txtMoTa.getText());
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            showDataChiTietSp(chiTietSpService.getAllChiTietSp());
            btnMoiChiTietSpActionPerformed(evt);
        }

    }//GEN-LAST:event_btnSuaChiTietSpActionPerformed


    private void tblQuanLiChiTietSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLiChiTietSpMouseClicked
        int row = tblQuanLiChiTietSp.getSelectedRow();
        for (int i = 0; i < cbbSanPham.getItemCount(); i++) {
            if (tblQuanLiChiTietSp.getValueAt(row, 1).toString().equals(comboSanPham.getElementAt(i).getMa())) {
                cbbSanPham.setSelectedIndex(i);
                break;
            }
        }
        if (tblQuanLiChiTietSp.getValueAt(row, 3).toString().equalsIgnoreCase("(chưa có thông tin)")) {
            cbbNsx.setEnabled(false);
        } else {
            cbbNsx.setEnabled(true);
            for (int i = 0; i < cbbNsx.getItemCount(); i++) {
                if (tblQuanLiChiTietSp.getValueAt(row, 3).toString().equals(comboNsx.getElementAt(i).getTen())) {
                    cbbNsx.setSelectedIndex(i);
                    break;
                }
            }
        }
        if (tblQuanLiChiTietSp.getValueAt(row, 4).toString().equalsIgnoreCase("(chưa có thông tin)")) {
            cbbDongSp.setEnabled(false);
        } else {
            cbbDongSp.setEnabled(true);
            for (int i = 0; i < cbbDongSp.getItemCount(); i++) {
                if (tblQuanLiChiTietSp.getValueAt(row, 4).toString().equals(comboDongSp.getElementAt(i).getTen())) {
                    cbbDongSp.setSelectedIndex(i);
                    break;
                }
            }
        }

        if (tblQuanLiChiTietSp.getValueAt(row, 5).toString().equalsIgnoreCase("(chưa có thông tin)")) {
            cbbMauSac.setEnabled(false);
        } else {
            cbbMauSac.setEnabled(true);
            for (int i = 0; i < cbbMauSac.getItemCount(); i++) {
                if (tblQuanLiChiTietSp.getValueAt(row, 5).toString().equals(comboMauSac.getElementAt(i).getTen())) {
                    cbbMauSac.setSelectedIndex(i);
                    break;
                }
            }
        }

        txtTenSp.setText(tblQuanLiChiTietSp.getValueAt(row, 2).toString());
        txtNamBH.setText(tblQuanLiChiTietSp.getValueAt(row, 6).toString());
        txtSLTon.setText(tblQuanLiChiTietSp.getValueAt(row, 7).toString());
        txtGiaNhap.setText(tblQuanLiChiTietSp.getValueAt(row, 8).toString());
        txtGiaBan.setText(tblQuanLiChiTietSp.getValueAt(row, 9).toString());
        txtMoTa.setText(tblQuanLiChiTietSp.getValueAt(row, 10).toString());

    }//GEN-LAST:event_tblQuanLiChiTietSpMouseClicked

    private void txtSearchSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSPKeyReleased
        if (txtSearchSP.getText().isEmpty()) {
            showDataChiTietSp(chiTietSpService.getAllChiTietSp());
        } else {
            List<ChiTietSpViewModel> listSearch = chiTietSpService.searchChiTietSanPham(txtSearchSP.getText());
            showDataChiTietSp(listSearch);
        }


    }//GEN-LAST:event_txtSearchSPKeyReleased

    private void cbbSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSanPhamActionPerformed
        SanPhamViewModel spView = (SanPhamViewModel) comboSanPham.getSelectedItem();
        txtTenSp.setText(spView.getTen());

    }//GEN-LAST:event_cbbSanPhamActionPerformed

    private void cbbNsxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNsxMouseEntered
        cbbNsx.setEnabled(true);
    }//GEN-LAST:event_cbbNsxMouseEntered

    private void cbbDongSpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbDongSpMouseEntered
        cbbDongSp.setEnabled(true);
    }//GEN-LAST:event_cbbDongSpMouseEntered

    private void cbbMauSacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMauSacMouseEntered
        cbbMauSac.setEnabled(true);
    }//GEN-LAST:event_cbbMauSacMouseEntered

    private int getSoLuongTonSp(int row) {
        return Integer.parseInt(tblSanPhamBan.getValueAt(row, 7).toString());
    }

    private void updateSoluongTon(JTable table, int rowChiTietSp) {
        int soLuong = getSoLuongTonSp(rowChiTietSp);
        if (table == tblSanPhamBan) {
            soLuong--;
        } else {
            soLuong++;
        }
        modelTableSanPhamChiTiet.setValueAt(soLuong, rowChiTietSp, 7);

    }

    private int getSoluongSpInGioHang(int row) {
        return Integer.parseInt(tblGioHang.getValueAt(row, 3).toString());
    }

    private void updateSpInGioHang(JTable tableClick, int rowGiohang) {
        int soluong = getSoluongSpInGioHang(rowGiohang);
        BigDecimal donGia = new BigDecimal(modelTableGioHang.getValueAt(rowGiohang, 4).toString());
        BigDecimal thanhTien = new BigDecimal(modelTableGioHang.getValueAt(rowGiohang, 5).toString());
        if (tableClick == tblSanPhamBan) {
            soluong++;
        } else {
            soluong--;
        }
        thanhTien = donGia.multiply(new BigDecimal(soluong));
        modelTableGioHang.setValueAt(soluong, rowGiohang, 3);
        modelTableGioHang.setValueAt(thanhTien, rowGiohang, 5);
    }

    private Integer positionOfSpInSanPhamBan(String idSp) {
        Integer rowPosition = null;
        for (int i = 0; i < modelTableSanPhamChiTiet.getRowCount(); i++) {
            if (idSp.equals(modelTableSanPhamChiTiet.getValueAt(i, 0).toString())) {
                return rowPosition = i;
            }
        }
        return rowPosition;
    }

    private Integer positionOfSpInGioHang(String idSp) {
        Integer rowPosition = null;
        for (int i = 0; i < modelTableGioHang.getRowCount(); i++) {
            if (idSp.equals(modelTableGioHang.getValueAt(i, 0).toString())) {
                return rowPosition = i;
            }
        }
        return rowPosition;
    }

    private void tblSanPhamBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamBanMouseClicked
        int row = tblSanPhamBan.getSelectedRow();
        int soLuongTon = getSoLuongTonSp(row);
        if (soLuongTon > 0) {
            GioHangViewModel gioHang = new GioHangViewModel();
            gioHang.setIdSp(tblQuanLiChiTietSp.getValueAt(row, 0).toString());
            gioHang.setMaSp(tblSanPhamBan.getValueAt(row, 1).toString());
            gioHang.setTenSp(tblSanPhamBan.getValueAt(row, 2).toString());
            gioHang.setSoLuong(1);
            gioHang.setDonGia(new BigDecimal(tblSanPhamBan.getValueAt(row, 9).toString()));
            gioHang.setThanhTien(gioHang.tinhTongTien());
            Integer position = positionOfSpInGioHang(gioHang.getIdSp());
            if (position != null) {
                updateSpInGioHang(tblSanPhamBan, position);
                updateSoluongTon(tblSanPhamBan, row);

            } else {
                showDataGioHang(gioHang);
                updateSoluongTon(tblSanPhamBan, row);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã hết ");
        }

    }//GEN-LAST:event_tblSanPhamBanMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int row = tblGioHang.getSelectedRow();
        int position = positionOfSpInSanPhamBan(tblGioHang.getValueAt(row, 0).toString());
        updateSpInGioHang(tblGioHang, row);
        updateSoluongTon(tblGioHang, position);
        if (getSoluongSpInGioHang(row) <= 0) {
            modelTableGioHang.removeRow(row);
        }

    }//GEN-LAST:event_tblGioHangMouseClicked

    private String autoGenMaHoaDon() {
        String firstWord = "HD";
        int lastnumber = 0;
        String maHD = null;
        List<Integer> list = new ArrayList<>();
        if (tblHoaDon.getRowCount() > 0) {
            for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
                maHD = tblHoaDon.getValueAt(i, 0).toString();
                list.add(Integer.parseInt(maHD.substring(2)));
            }
            list.sort((o1, o2) -> {
                return o1.compareTo(o2);
            });
            lastnumber = (int) list.get(list.size() - 1);
            lastnumber++;
        }
        return maHD = firstWord + String.valueOf(lastnumber);
    }

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        if (tblGioHang.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Giỏ hàng trống");
        } else {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
            dateFormat.format(date);
            String maHD = autoGenMaHoaDon();
            hoaDonService.insertHoaDon(maHD, date, null);
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                ChiTietSpViewModel chiTietSPView = new ChiTietSpViewModel();
                HoaDonViewModel hoaDonView = new HoaDonViewModel();
                hoaDonView.setMaHD(maHD);
                chiTietSPView.setId(tblGioHang.getValueAt(i, 0).toString());
                int soLuongMua = Integer.parseInt(tblGioHang.getValueAt(i, 3).toString());
                BigDecimal donGia = new BigDecimal(tblGioHang.getValueAt(i, 4).toString());
                hoaDonChiTietService.insertHoaDonChiTiet(soLuongMua, donGia, chiTietSPView, hoaDonView);
                int soLuongTon = getSoLuongTonSp(positionOfSpInSanPhamBan(chiTietSPView.getId()));
                chiTietSpService.updateSoluongTon(chiTietSPView.getId(), soLuongTon);
            }

            ShowDataHoaDon(hoaDonService.getAllHoaDon());
            showDataChiTietSp(chiTietSpService.getAllChiTietSp());
            modelTableGioHang.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");

        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed


    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        List<HoaDonChiTietViewModel> hoaDonChiTiet = hoaDonChiTietService.getHoaDonChiTietByMaHd(
                tblHoaDon.getValueAt(row, 0).toString());
        ShowDataHoaDonChiTiet(hoaDonChiTiet);
        if (tblHoaDon.getValueAt(row, 2).toString().equalsIgnoreCase("Chưa thanh toán")) {
            btnThanhToan.setEnabled(true);
            btnThanhToan.setText("Thanh toán");
            txtTienKhachDua.setEnabled(true);
        } else {
            btnThanhToan.setEnabled(false);
            btnThanhToan.setText("Đã thanh toán");
            txtTienKhachDua.setEnabled(false);

        }


    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = tblHoaDon.getSelectedRow();
        if (txtTienKhachDua.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa");
        } else {
            if (Double.parseDouble(txtTienKhachDua.getText()) >= Double.parseDouble(lblTongTien.getText())) {
                hoaDonService.updateTrangThai(tblHoaDon.getValueAt(row, 0).toString(), 1);
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                ShowDataHoaDon(hoaDonService.getAllHoaDon());
                tblHoaDon.clearSelection();
                btnThanhToan.setEnabled(false);
                btnThanhToan.setText("Đã thanh toán");
                txtTienKhachDua.setText("");
                txtTienKhachDua.setEnabled(false);
                lblTienThua.setText("-");
            } else {
                JOptionPane.showMessageDialog(this, "Số tiền không đủ để thanh toán");
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void rdoChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoThanhToanActionPerformed
        ShowDataHoaDon(hoaDonService.getAllHoaDon());
    }//GEN-LAST:event_rdoChoThanhToanActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        ShowDataHoaDon(hoaDonService.getAllHoaDon());
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed
        ShowDataHoaDon(hoaDonService.getAllHoaDon());
    }//GEN-LAST:event_rdoDaThanhToanActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        if (!txtTienKhachDua.getText().isBlank()) {
            if (checkNumber(txtTienKhachDua.getText())) {
                double tienThua = Double.parseDouble(txtTienKhachDua.getText()) - Double.parseDouble(lblTongTien.getText());
                lblTienThua.setText(new BigDecimal(tienThua).toString());
            } else {
                txtTienKhachDua.setText("");
                lblTienThua.setText("-");
            }

        } else {
            lblTienThua.setText("-");
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoiChiTietSp;
    private javax.swing.JButton btnSuaChiTietSp;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemChiTietSp;
    private javax.swing.JButton btnXoaChiTietSp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDongSp;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNsx;
    private javax.swing.JComboBox<String> cbbSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlDanhSachHoaDon;
    private javax.swing.JPanel pnlGioHang;
    private javax.swing.JPanel pnlHoaDonChiTiet;
    private javax.swing.JPanel pnlSanPhamHoaDon;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JPanel tabHoaDon;
    private javax.swing.JPanel tabSanPham;
    private javax.swing.JTable tblChiTietHD;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblQuanLiChiTietSp;
    private javax.swing.JTable tblSanPhamBan;
    private javax.swing.JTabbedPane tbpBanHang;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtSLTon;
    private javax.swing.JTextField txtSearchSP;
    private javax.swing.JLabel txtTenSp;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
