package view;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import service.implement.ChiTietSpService;
import service.IChiTietSpService;

public final class FormMenu extends javax.swing.JFrame implements Runnable {

    JpanelBanHang _banHang;
    JpanelThongTinSp _thongTinSP;

    public FormMenu() {
        initComponents();
        setGraphicOfFrame();
        run();
        //create  object jpanel
        _banHang = new JpanelBanHang();
        _thongTinSP = new JpanelThongTinSp();

        //add jpanel from difference class to jpanel of FormMenu
        pnlRight.add(_banHang);
        pnlRight.add(_thongTinSP);

        //default hide panel
        _banHang.setVisible(false);
        _thongTinSP.setVisible(false);
        this.setResizable(false);

    }

    //set graphic of FormMenu
    private void setGraphicOfFrame() {
        lblBanHang.setIcon(new ImageIcon("image\\analysis.png"));
        lblThongTinSp.setIcon(new ImageIcon("image\\information.png"));
        lblThongTinSp.setSize(130, 80);
        lblBanHang.setSize(130, 80);
        lblDongHo.setIcon(new ImageIcon("image\\clock.png"));
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
    }

    //set up clock at menu
    private void setClock() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
        Date date = new Date();
        lblDongHo.setText(dateFormat.format(date));
    }

    @Override
    public void run() {
        new Thread(() -> {
            while (true) {
                try {
                    setClock();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        lblBanHang = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        lblThongTinSp = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUÂN ĐẸP TRAI");
        setSize(new java.awt.Dimension(1200, 700));

        pnlLeft.setBackground(new java.awt.Color(13, 124, 147));

        lblBanHang.setBackground(new java.awt.Color(255, 153, 0));
        lblBanHang.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblBanHang.setForeground(new java.awt.Color(255, 255, 255));
        lblBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanHang.setText("BÁN HÀNG");
        lblBanHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBanHang.setOpaque(true);
        lblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBanHangMouseExited(evt);
            }
        });

        lblDongHo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblDongHo.setText("jLabel1");

        lblThongTinSp.setBackground(new java.awt.Color(255, 153, 0));
        lblThongTinSp.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblThongTinSp.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTinSp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTinSp.setText("THÔNG TIN SP");
        lblThongTinSp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblThongTinSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThongTinSp.setOpaque(true);
        lblThongTinSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongTinSpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThongTinSpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThongTinSpMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblThongTinSp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTinSp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pnlRight.setBackground(new java.awt.Color(255, 255, 255));
        pnlRight.setLayout(new javax.swing.OverlayLayout(pnlRight));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void refeshDataJpanelBanHang() {
        IChiTietSpService chiTietSpService = new ChiTietSpService();
        _banHang.showDataChiTietSp(chiTietSpService.getAllChiTietSp());
        _banHang.setDefaultCombobox();

    }
    private void lblBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseEntered
        lblBanHang.setForeground(Color.BLUE);
        lblBanHang.setBackground(Color.YELLOW);
    }//GEN-LAST:event_lblBanHangMouseEntered

    private void lblBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseExited
        lblBanHang.setForeground(Color.WHITE);
        lblBanHang.setBackground(Color.ORANGE);


    }//GEN-LAST:event_lblBanHangMouseExited

    private void lblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseClicked
        _banHang.setVisible(true);
        _thongTinSP.setVisible(false);

        lblBanHang.setBorder(new LineBorder(Color.RED));
        lblThongTinSp.setBorder(null);
        refeshDataJpanelBanHang();

    }//GEN-LAST:event_lblBanHangMouseClicked

    private void lblThongTinSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinSpMouseClicked
        _thongTinSP.setVisible(true);
        _banHang.setVisible(false);

        lblThongTinSp.setBorder(new LineBorder(Color.RED));
        lblBanHang.setBorder(null);
    }//GEN-LAST:event_lblThongTinSpMouseClicked

    private void lblThongTinSpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinSpMouseEntered
        lblThongTinSp.setForeground(Color.BLUE);
        lblThongTinSp.setBackground(Color.YELLOW);
    }//GEN-LAST:event_lblThongTinSpMouseEntered

    private void lblThongTinSpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinSpMouseExited
        lblThongTinSp.setForeground(Color.WHITE);
        lblThongTinSp.setBackground(Color.ORANGE);
    }//GEN-LAST:event_lblThongTinSpMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblThongTinSp;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    // End of variables declaration//GEN-END:variables
}
