package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import service.implement.DongSpService;
import service.IDongSpService;
import service.IMauSacService;
import service.INsxService;
import service.ISanPhamService;
import service.implement.MauSacService;
import service.implement.NsxService;
import service.implement.SanPhamService;
import viewmodel.DongSpViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.NsxViewModel;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author trant
 */
public class JpanelThongTinSp extends javax.swing.JPanel {

    private DefaultTableModel modelMauSac;
    private DefaultTableModel modelNsx;
    private DefaultTableModel modelDongSp;
    private DefaultTableModel modelSanPham;
    private final IMauSacService mauSacService;
    private final INsxService nsxService;
    private final IDongSpService dongSpService;
    private final ISanPhamService sanPhamService;

    public JpanelThongTinSp() {
        initComponents();
        setDefaultTable();
        mauSacService = new MauSacService();
        dongSpService = new DongSpService();
        nsxService = new NsxService();
        sanPhamService = new SanPhamService();
        showDataDongSp(dongSpService.getAllDongSp());
        showDataMauSac(mauSacService.getAllMauSac());
        showDataNsx(nsxService.getAllNsx());
        showDataSanPham(sanPhamService.getAllSanPham());

    }

    private void setDefaultTable() {
        modelMauSac = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int ColumnIndex) {
                return false;
            }

        };
        modelNsx = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int ColumnIndex) {
                return false;
            }
        };
        modelDongSp = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int ColumnIndex) {
                return false;
            }
        };
        modelSanPham = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int ColumnIndex) {
                return false;
            }
        };

        String headerSanPham[] = {"M?? S???n ph???m", "T??n s???n ph???m"};
        String headerMauSac[] = {"M?? m??u", "T??n m??u"};
        String headerNsx[] = {"M?? nsx", "T??n Nsx"};
        String headerDongSp[] = {"M?? D??ng sp", "T??n D??ng Sp"};
        modelSanPham.setColumnIdentifiers(headerSanPham);
        modelMauSac.setColumnIdentifiers(headerMauSac);
        modelNsx.setColumnIdentifiers(headerNsx);
        modelDongSp.setColumnIdentifiers(headerDongSp);
        tblSanPham.setModel(modelSanPham);
        tblDongSp.setModel(modelDongSp);
        tblNsx.setModel(modelNsx);
        tblMauSac.setModel(modelMauSac);
        tblDongSp.getTableHeader().setReorderingAllowed(false);
        tblMauSac.getTableHeader().setReorderingAllowed(false);
        tblNsx.getTableHeader().setReorderingAllowed(false);
        tblSanPham.getTableHeader().setReorderingAllowed(false);
    }

    private void showDataMauSac(List<MauSacViewModel> list) {
        modelMauSac.setRowCount(0);
        for (MauSacViewModel mauSacViewModel : list) {
            modelMauSac.addRow(mauSacViewModel.getDataViewMauSac());
        }
    }

    private void showDataDongSp(List<DongSpViewModel> list) {
        modelDongSp.setRowCount(0);
        for (DongSpViewModel dongSpViewModel : list) {
            modelDongSp.addRow(dongSpViewModel.getDataViewDongSp());
        }
    }

    private void showDataNsx(List<NsxViewModel> list) {
        modelNsx.setRowCount(0);
        for (NsxViewModel nsxViewModel : list) {
            modelNsx.addRow(nsxViewModel.getDataViewNsx());
        }
    }

    private void showDataSanPham(List<SanPhamViewModel> list) {
        modelSanPham.setRowCount(0);
        for (SanPhamViewModel sanPhamViewModel : list) {
            modelSanPham.addRow(sanPhamViewModel.getDataViewSp());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpThuocTinh = new javax.swing.JTabbedPane();
        pblMauSac = new javax.swing.JPanel();
        btnThemMau = new javax.swing.JButton();
        btnSuaMau = new javax.swing.JButton();
        btnXoaMau = new javax.swing.JButton();
        btnMoiMau = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaMau = new javax.swing.JTextField();
        txtTenMau = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        pblNsx = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNsx = new javax.swing.JTextField();
        txtTenNsx = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNsx = new javax.swing.JTable();
        btnThemNsx = new javax.swing.JButton();
        btnSuaNsx = new javax.swing.JButton();
        btnXoaNsx = new javax.swing.JButton();
        btnMoiNsx = new javax.swing.JButton();
        pnlDongSp = new javax.swing.JPanel();
        pblNsx1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaDong = new javax.swing.JTextField();
        txtTenDong = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDongSp = new javax.swing.JTable();
        btnThemDong = new javax.swing.JButton();
        btnSuaDong = new javax.swing.JButton();
        btnXoaDong = new javax.swing.JButton();
        btnMoiDong = new javax.swing.JButton();
        pnlSanPham = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        txtMaSp = new javax.swing.JTextField();
        btnThemSp = new javax.swing.JButton();
        btnSuaSp = new javax.swing.JButton();
        btnMoiSp = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        tbpThuocTinh.setBackground(new java.awt.Color(255, 255, 255));
        tbpThuocTinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbpThuocTinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbpThuocTinh.setOpaque(true);

        pblMauSac.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMau.setText("Th??m");
        btnThemMau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauActionPerformed(evt);
            }
        });

        btnSuaMau.setText("S???a");
        btnSuaMau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauActionPerformed(evt);
            }
        });

        btnXoaMau.setText("X??a");
        btnXoaMau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauActionPerformed(evt);
            }
        });

        btnMoiMau.setText("M???i");
        btnMoiMau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiMauActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("M?? m??u");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("T??n M??u");

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
    );
    tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblMauSacMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tblMauSac);

    javax.swing.GroupLayout pblMauSacLayout = new javax.swing.GroupLayout(pblMauSac);
    pblMauSac.setLayout(pblMauSacLayout);
    pblMauSacLayout.setHorizontalGroup(
        pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pblMauSacLayout.createSequentialGroup()
            .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pblMauSacLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(btnThemMau))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pblMauSacLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))))
            .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pblMauSacLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaMau, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(txtTenMau)))
                .addGroup(pblMauSacLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(btnSuaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(btnXoaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btnMoiMau, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(60, 60, 60)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(31, Short.MAX_VALUE))
    );
    pblMauSacLayout.setVerticalGroup(
        pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pblMauSacLayout.createSequentialGroup()
            .addGap(57, 57, 57)
            .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pblMauSacLayout.createSequentialGroup()
                    .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(129, 129, 129)
                    .addGroup(pblMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemMau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoiMau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(30, Short.MAX_VALUE))
    );

    tbpThuocTinh.addTab("M??u S???c", pblMauSac);

    pblNsx.setBackground(new java.awt.Color(255, 255, 255));

    jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(102, 102, 102));
    jLabel3.setText("M?? Nsx");

    jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(102, 102, 102));
    jLabel4.setText("T??n Nsx");

    tblNsx.setModel(new javax.swing.table.DefaultTableModel(
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
    tblNsx.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblNsxMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tblNsx);

    btnThemNsx.setText("Th??m");
    btnThemNsx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnThemNsx.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnThemNsxActionPerformed(evt);
        }
    });

    btnSuaNsx.setText("S???a");
    btnSuaNsx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSuaNsx.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSuaNsxActionPerformed(evt);
        }
    });

    btnXoaNsx.setText("X??a");
    btnXoaNsx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnXoaNsx.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnXoaNsxActionPerformed(evt);
        }
    });

    btnMoiNsx.setText("M???i");
    btnMoiNsx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMoiNsx.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMoiNsxActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pblNsxLayout = new javax.swing.GroupLayout(pblNsx);
    pblNsx.setLayout(pblNsxLayout);
    pblNsxLayout.setHorizontalGroup(
        pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pblNsxLayout.createSequentialGroup()
            .addGap(94, 94, 94)
            .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3)
                .addComponent(jLabel4)
                .addComponent(btnThemNsx))
            .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pblNsxLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaNsx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(txtTenNsx, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(pblNsxLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(btnSuaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(btnXoaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnMoiNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(28, 28, 28)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(27, Short.MAX_VALUE))
    );
    pblNsxLayout.setVerticalGroup(
        pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pblNsxLayout.createSequentialGroup()
            .addGap(48, 48, 48)
            .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pblNsxLayout.createSequentialGroup()
                    .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(txtMaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtTenNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(152, 152, 152)
                    .addGroup(pblNsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoiNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(29, Short.MAX_VALUE))
    );

    tbpThuocTinh.addTab("Nh?? S???n xu???t", pblNsx);

    pblNsx1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(102, 102, 102));
    jLabel5.setText("M?? d??ng Sp");

    jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(102, 102, 102));
    jLabel6.setText("T??n d??ng Sp");

    tblDongSp.setModel(new javax.swing.table.DefaultTableModel(
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
    tblDongSp.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblDongSpMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(tblDongSp);

    btnThemDong.setText("Th??m");
    btnThemDong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnThemDong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnThemDongActionPerformed(evt);
        }
    });

    btnSuaDong.setText("S???a");
    btnSuaDong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSuaDong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSuaDongActionPerformed(evt);
        }
    });

    btnXoaDong.setText("X??a");
    btnXoaDong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnXoaDong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnXoaDongActionPerformed(evt);
        }
    });

    btnMoiDong.setText("M???i");
    btnMoiDong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMoiDong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMoiDongActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pblNsx1Layout = new javax.swing.GroupLayout(pblNsx1);
    pblNsx1.setLayout(pblNsx1Layout);
    pblNsx1Layout.setHorizontalGroup(
        pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pblNsx1Layout.createSequentialGroup()
            .addGap(83, 83, 83)
            .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(pblNsx1Layout.createSequentialGroup()
                    .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaDong, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addComponent(txtTenDong)))
                .addGroup(pblNsx1Layout.createSequentialGroup()
                    .addComponent(btnThemDong)
                    .addGap(29, 29, 29)
                    .addComponent(btnSuaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(btnXoaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                    .addComponent(btnMoiDong, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33))
    );
    pblNsx1Layout.setVerticalGroup(
        pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pblNsx1Layout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pblNsx1Layout.createSequentialGroup()
                    .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(txtMaDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTenDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(122, 122, 122)
                    .addGroup(pblNsx1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemDong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoiDong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(35, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pnlDongSpLayout = new javax.swing.GroupLayout(pnlDongSp);
    pnlDongSp.setLayout(pnlDongSpLayout);
    pnlDongSpLayout.setHorizontalGroup(
        pnlDongSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 906, Short.MAX_VALUE)
        .addGroup(pnlDongSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pblNsx1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnlDongSpLayout.setVerticalGroup(
        pnlDongSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 652, Short.MAX_VALUE)
        .addGroup(pnlDongSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pblNsx1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tbpThuocTinh.addTab("D??ng s???n ph???m", pnlDongSp);

    pnlSanPham.setBackground(new java.awt.Color(255, 255, 255));

    jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(102, 102, 102));
    jLabel7.setText("M?? s???n ph???m");

    jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(102, 102, 102));
    jLabel8.setText("T??n s???n ph???m");

    btnThemSp.setText("Th??m");
    btnThemSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnThemSp.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnThemSpActionPerformed(evt);
        }
    });

    btnSuaSp.setText("S???a");
    btnSuaSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSuaSp.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSuaSpActionPerformed(evt);
        }
    });

    btnMoiSp.setText("M???i");
    btnMoiSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMoiSp.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMoiSpActionPerformed(evt);
        }
    });

    tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
    tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblSanPhamMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(tblSanPham);

    javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
    pnlSanPham.setLayout(pnlSanPhamLayout);
    pnlSanPhamLayout.setHorizontalGroup(
        pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlSanPhamLayout.createSequentialGroup()
            .addGap(83, 83, 83)
            .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSanPhamLayout.createSequentialGroup()
                    .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaSp, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addComponent(txtTenSp)))
                .addGroup(pnlSanPhamLayout.createSequentialGroup()
                    .addComponent(btnThemSp)
                    .addGap(29, 29, 29)
                    .addComponent(btnSuaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btnMoiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33))
    );
    pnlSanPhamLayout.setVerticalGroup(
        pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlSanPhamLayout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSanPhamLayout.createSequentialGroup()
                    .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(122, 122, 122)
                    .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(35, Short.MAX_VALUE))
    );

    tbpThuocTinh.addTab("S???n ph???m", pnlSanPham);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tbpThuocTinh)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tbpThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkFormEmpty(JTextField ma, JTextField ten) {
        if (ma.getText().isBlank() || ten.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Kh??ng ???????c tr???ng");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkExisted(Object obj, String ma) {
        if (obj == MauSacViewModel.class) {
            if (mauSacService.getIdFromMa(ma) == null) {
                return false;
            } else {
                return true;
            }
        } else if (obj == DongSpViewModel.class) {
            if (dongSpService.getIdFromMa(ma) == null) {
                return false;
            } else {
                return true;
            }
        } else if (obj == SanPhamViewModel.class) {
            if (sanPhamService.getIdFromMa(ma) == null) {
                return false;
            } else {
                return true;
            }
        } else {
            if (nsxService.getIdFromMa(ma) == null) {
                return false;
            } else {
                return true;
            }
        }

    }

    private void fillDataFromTableToForm(JTable table, int row, JTextField ma, JTextField ten) {
        ma.setText(table.getValueAt(row, 0).toString());
        ten.setText(table.getValueAt(row, 1).toString());
    }

    private void clearForm(JTable table, JTextField ma, JTextField ten) {
        ma.setText("");
        ten.setText("");
        table.clearSelection();
    }
    private void btnThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauActionPerformed
        if (checkFormEmpty(txtMaMau, txtTenMau)) {
            if (!checkExisted(MauSacViewModel.class, txtMaMau.getText())) {
                mauSacService.insertMauSac(txtMaMau.getText(), txtTenMau.getText());
                JOptionPane.showMessageDialog(this, "Th??m m??u th??nh c??ng");
                showDataMauSac(mauSacService.getAllMauSac());
            } else {
                JOptionPane.showMessageDialog(this, "M??u s???c ???? t???n t???i");
            }
        }
    }//GEN-LAST:event_btnThemMauActionPerformed

    private void btnSuaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauActionPerformed
        int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            if (checkFormEmpty(txtMaMau, txtTenMau)) {
                if (txtMaMau.getText().equals(tblMauSac.getValueAt(row, 0).toString())) {
                    MauSacViewModel mauView = new MauSacViewModel();
                    mauView.setMa(tblMauSac.getValueAt(row, 0).toString());
                    mauSacService.updateMauSac(mauView,
                            txtMaMau.getText(), txtTenMau.getText());
                    JOptionPane.showMessageDialog(this, "S???a m??u th??nh c??ng");
                    showDataMauSac(mauSacService.getAllMauSac());
                    btnMoiMauActionPerformed(evt);

                } else {
                    if (checkExisted(MauSacViewModel.class, txtMaMau.getText())) {
                        JOptionPane.showMessageDialog(this, "M??u s???c ???? t???n t???i");
                    } else {
                        MauSacViewModel mauView = new MauSacViewModel();
                        mauView.setMa(tblMauSac.getValueAt(row, 0).toString());
                        mauSacService.updateMauSac(mauView,
                                txtMaMau.getText(), txtTenMau.getText());
                        JOptionPane.showMessageDialog(this, "S???a m??u th??nh c??ng");
                        showDataMauSac(mauSacService.getAllMauSac());
                        btnMoiMauActionPerformed(evt);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaMauActionPerformed

    private void btnXoaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauActionPerformed
        int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            mauSacService.deleteMauSac(txtMaMau.getText());
            JOptionPane.showMessageDialog(this, "X??a m??u th??nh c??ng");
            showDataMauSac(mauSacService.getAllMauSac());
            btnMoiMauActionPerformed(evt);
        }
    }//GEN-LAST:event_btnXoaMauActionPerformed

    private void btnMoiMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiMauActionPerformed
        clearForm(tblMauSac, txtMaMau, txtTenMau);
    }//GEN-LAST:event_btnMoiMauActionPerformed

    private void btnThemNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNsxActionPerformed
        if (checkFormEmpty(txtMaNsx, txtTenNsx)) {
            if (!checkExisted(NsxViewModel.class, txtMaNsx.getText())) {
                nsxService.insertNsx(txtMaNsx.getText(), txtTenNsx.getText());
                JOptionPane.showMessageDialog(this, "Th??m Nsx th??nh c??ng");
                showDataNsx(nsxService.getAllNsx());
            } else {
                JOptionPane.showMessageDialog(this, "Nsx ???? t???n t???i");
            }
        }
    }//GEN-LAST:event_btnThemNsxActionPerformed

    private void btnSuaNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNsxActionPerformed
        int row = tblNsx.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            if (checkFormEmpty(txtMaNsx, txtTenNsx)) {
                if (txtMaNsx.getText().equals(tblNsx.getValueAt(row, 0).toString())) {
                    NsxViewModel nsxView = new NsxViewModel();
                    nsxView.setMa(tblNsx.getValueAt(row, 0).toString());
                    nsxService.updateNsx(nsxView, txtMaNsx.getText(), txtTenNsx.getText());
                    JOptionPane.showMessageDialog(this, "S???a Nsx th??nh c??ng");
                    showDataNsx(nsxService.getAllNsx());
                    btnMoiNsxActionPerformed(evt);

                } else {
                    if (checkExisted(NsxViewModel.class, txtMaNsx.getText())) {
                        JOptionPane.showMessageDialog(this, "Nsx ???? t???n t???i");
                    } else {
                        NsxViewModel nsxView = new NsxViewModel();
                        nsxView.setMa(tblNsx.getValueAt(row, 0).toString());
                        nsxService.updateNsx(nsxView,
                                txtMaNsx.getText(), txtTenNsx.getText());
                        JOptionPane.showMessageDialog(this, "S???a Nsx th??nh c??ng");
                        showDataNsx(nsxService.getAllNsx());
                        btnMoiNsxActionPerformed(evt);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaNsxActionPerformed

    private void btnXoaNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNsxActionPerformed
        int row = tblNsx.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            nsxService.deleteNsx(tblNsx.getValueAt(row, 0).toString());
            JOptionPane.showMessageDialog(this, "X??a Nsx th??nh c??ng");
            showDataNsx(nsxService.getAllNsx());
            btnMoiNsxActionPerformed(evt);
        }
    }//GEN-LAST:event_btnXoaNsxActionPerformed

    private void btnMoiNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiNsxActionPerformed
        clearForm(tblNsx, txtMaNsx, txtTenNsx);
    }//GEN-LAST:event_btnMoiNsxActionPerformed

    private void btnThemDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDongActionPerformed
        if (checkFormEmpty(txtMaDong, txtTenDong)) {
            if (!checkExisted(DongSpViewModel.class, txtMaDong.getText())) {
                dongSpService.insertDong(txtMaDong.getText(), txtTenDong.getText());
                JOptionPane.showMessageDialog(this, "Th??m D??ng Sp th??nh c??ng");
                showDataDongSp(dongSpService.getAllDongSp());
            } else {
                JOptionPane.showMessageDialog(this, "D??ng sp ???? t???n t???i");
            }
        }
    }//GEN-LAST:event_btnThemDongActionPerformed

    private void btnSuaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDongActionPerformed
        int row = tblDongSp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            if (checkFormEmpty(txtMaDong, txtTenDong)) {
                if (txtMaDong.getText().equals(tblDongSp.getValueAt(row, 0).toString())) {
                    DongSpViewModel dongView = new DongSpViewModel();
                    dongView.setMa(tblDongSp.getValueAt(row, 0).toString());
                    dongSpService.updateDong(dongView, txtMaDong.getText(), txtTenDong.getText());
                    JOptionPane.showMessageDialog(this, "S???a D??ng sp th??nh c??ng");
                    showDataDongSp(dongSpService.getAllDongSp());
                    btnMoiDongActionPerformed(evt);

                } else {
                    if (checkExisted(DongSpViewModel.class, txtMaDong.getText())) {
                        JOptionPane.showMessageDialog(this, "D??ng sp ???? t???n t???i");
                    } else {
                        DongSpViewModel dongView = new DongSpViewModel();
                        dongView.setMa(tblDongSp.getValueAt(row, 0).toString());
                        dongSpService.updateDong(dongView, txtMaDong.getText(), txtTenDong.getText());
                        JOptionPane.showMessageDialog(this, "S???a D??ng sp th??nh c??ng");
                        showDataDongSp(dongSpService.getAllDongSp());
                        btnMoiDongActionPerformed(evt);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaDongActionPerformed

    private void btnXoaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDongActionPerformed
        int row = tblDongSp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            dongSpService.deleteDongSp(tblDongSp.getValueAt(row, 0).toString());
            JOptionPane.showMessageDialog(this, "X??a D??ng Sp th??nh c??ng");
            showDataDongSp(dongSpService.getAllDongSp());
            btnMoiDongActionPerformed(evt);
        }
    }//GEN-LAST:event_btnXoaDongActionPerformed

    private void btnMoiDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDongActionPerformed
        clearForm(tblDongSp, txtMaDong, txtTenDong);
    }//GEN-LAST:event_btnMoiDongActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        int row = tblMauSac.getSelectedRow();
        fillDataFromTableToForm(tblMauSac, row, txtMaMau, txtTenMau);
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void tblNsxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNsxMouseClicked
        int row = tblNsx.getSelectedRow();
        fillDataFromTableToForm(tblNsx, row, txtMaNsx, txtTenNsx);
    }//GEN-LAST:event_tblNsxMouseClicked

    private void tblDongSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongSpMouseClicked
        int row = tblDongSp.getSelectedRow();
        fillDataFromTableToForm(tblDongSp, row, txtMaDong, txtTenDong);
    }//GEN-LAST:event_tblDongSpMouseClicked

    private void btnThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpActionPerformed
        if (checkFormEmpty(txtMaSp, txtTenSp)) {
            if (!checkExisted(SanPhamViewModel.class, txtMaSp.getText())) {
                sanPhamService.insertSanPham(txtMaSp.getText(), txtTenSp.getText());
                JOptionPane.showMessageDialog(this, "Th??m S???n Ph???m th??nh c??ng");
                showDataSanPham(sanPhamService.getAllSanPham());
            } else {
                JOptionPane.showMessageDialog(this, "S???n ph???m ???? t???n t???i");
            }
        }
    }//GEN-LAST:event_btnThemSpActionPerformed


    private void btnSuaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSpActionPerformed
        int row = tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng click v??o B???ng");
        } else {
            if (checkFormEmpty(txtMaSp, txtTenSp)) {
                if (txtMaSp.getText().equals(tblSanPham.getValueAt(row, 0).toString())) {
                    SanPhamViewModel spView = new SanPhamViewModel();
                    spView.setMa(tblSanPham.getValueAt(row, 0).toString());
                    sanPhamService.updateSanPham(spView, txtMaSp.getText(), txtTenSp.getText());
                    JOptionPane.showMessageDialog(this, "S???a s???n ph???m th??nh c??ng");
                    showDataSanPham(sanPhamService.getAllSanPham());
                    btnMoiDongActionPerformed(evt);

                } else {
                    if (checkExisted(SanPhamViewModel.class, txtMaSp.getText())) {
                        JOptionPane.showMessageDialog(this, "S???n ph???m ???? t???n t???i");
                    } else {
                        SanPhamViewModel spView = new SanPhamViewModel();
                        spView.setMa(tblSanPham.getValueAt(row, 0).toString());
                        sanPhamService.updateSanPham(spView, txtMaSp.getText(), txtTenSp.getText());
                        JOptionPane.showMessageDialog(this, "S???a s???n ph???m th??nh c??ng");
                        showDataSanPham(sanPhamService.getAllSanPham());
                        btnMoiDongActionPerformed(evt);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaSpActionPerformed

    private void btnMoiSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiSpActionPerformed
        clearForm(tblSanPham, txtMaSp, txtTenSp);
    }//GEN-LAST:event_btnMoiSpActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = tblSanPham.getSelectedRow();
        fillDataFromTableToForm(tblSanPham, row, txtMaSp, txtTenSp);
    }//GEN-LAST:event_tblSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoiDong;
    private javax.swing.JButton btnMoiMau;
    private javax.swing.JButton btnMoiNsx;
    private javax.swing.JButton btnMoiSp;
    private javax.swing.JButton btnSuaDong;
    private javax.swing.JButton btnSuaMau;
    private javax.swing.JButton btnSuaNsx;
    private javax.swing.JButton btnSuaSp;
    private javax.swing.JButton btnThemDong;
    private javax.swing.JButton btnThemMau;
    private javax.swing.JButton btnThemNsx;
    private javax.swing.JButton btnThemSp;
    private javax.swing.JButton btnXoaDong;
    private javax.swing.JButton btnXoaMau;
    private javax.swing.JButton btnXoaNsx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pblMauSac;
    private javax.swing.JPanel pblNsx;
    private javax.swing.JPanel pblNsx1;
    private javax.swing.JPanel pnlDongSp;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JTable tblDongSp;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblNsx;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTabbedPane tbpThuocTinh;
    private javax.swing.JTextField txtMaDong;
    private javax.swing.JTextField txtMaMau;
    private javax.swing.JTextField txtMaNsx;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtTenDong;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTenNsx;
    private javax.swing.JTextField txtTenSp;
    // End of variables declaration//GEN-END:variables

}
