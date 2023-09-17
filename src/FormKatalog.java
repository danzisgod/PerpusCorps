
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.adempiere.legacy.apache.ecs.xhtml.table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Danuar Anardha
 */
public class FormKatalog extends javax.swing.JFrame {

    Connection koneksiDB = Koneksi.getConnection();

    /**
     * Creates new form FormKatalog
     */
    public FormKatalog() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent de) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent de) {
                warn();
            }

            public void warn() {
                try {
                    ResultSet hasil = koneksiDB.createStatement().executeQuery("select * from buku where judul like '%" + jTextField1.getText() + "%' or pengarang like '%" + jTextField1.getText() + "%' or penerbit like '%" + jTextField1.getText() + "%' or id_buku like '%" + jTextField1.getText() + "%'");
                    DefaultTableModel model = (DefaultTableModel) TBLKatalog.getModel();
                    model.setRowCount(0);
                    while (hasil.next()) {
                        model.addRow(new String[]{hasil.getString(1), hasil.getString(2), hasil.getString(3), hasil.getString(4), hasil.getString(5), hasil.getString(6), hasil.getString(7), hasil.getString(8), hasil.getString(9), hasil.getString(10)});
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormPetugas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        kondisiAwal();
        setDefaultCloseOperation(FormKatalog.DISPOSE_ON_CLOSE);
        setResizable(false);
        jTextField2.setEnabled(false);
        setTitle("PerpusCorps - Katalog");
    }

    private void kondisiAwal() {
        try {
            jTextField1.setText("");
            jTextField2.setText("");
            ImageIcon icon = new ImageIcon();
            jLabel1.setIcon(icon);
            ResultSet hasil = koneksiDB.createStatement().executeQuery("select * from buku");
            DefaultTableModel model = (DefaultTableModel) TBLKatalog.getModel();
            model.setRowCount(0);
            while (hasil.next()) {
                model.addRow(new String[]{hasil.getString(1), hasil.getString(2), hasil.getString(3), hasil.getString(4), hasil.getString(5), hasil.getString(6), hasil.getString(7), hasil.getString(8), hasil.getString(9), hasil.getString(10)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormKatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLKatalog = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cover Buku"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TBLKatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Buku", "Judul", "Pengarang", "Penerbit", "Kategori", "Tahun", "Stok", "Harga", "Gambar", "Tanggal Masuk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLKatalog.setAutoResizeMode(0);
        TBLKatalog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLKatalogMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLKatalog);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lokasi Cover"));
        jPanel3.setPreferredSize(new java.awt.Dimension(94, 51));

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Urutkan"));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Judul", "Pengarang", "Penerbit", "Kategori", "Tahun", "Stok", "Harga", "Tanggal Masuk" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton5.setText("Urutkan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, 0, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBLKatalogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLKatalogMouseClicked
        try {
            int row = TBLKatalog.getSelectedRow();
            String to = TBLKatalog.getModel().getValueAt(row, 0).toString();
            ResultSet hasil = koneksiDB.createStatement().executeQuery("select * from buku where id_buku ='" + to + "'");
            if (hasil.next()) {
                String id = hasil.getString(1);
                String gambar = hasil.getString(9);
                jTextField2.setText(gambar);
                ImageIcon icon = new ImageIcon(jTextField2.getText());
                Image image = icon.getImage();
                Image imgScale = image.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                jLabel1.setIcon(scaledIcon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TBLKatalogMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jComboBox2.getSelectedItem().toString().equals("ID") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 0, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("ID") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 0, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Judul") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 1, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Judul") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 1, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Pengarang") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 2, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Pengarang") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 2, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Penerbit") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 3, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Penerbit") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 3, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Kategori") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 4, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Kategori") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 4, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Tahun") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 5, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Tahun") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 5, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Stok") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 6, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Stok") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 6, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Harga") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 7, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Harga") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 7, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Tanggal Masuk") && jComboBox3.getSelectedItem().toString().equals("Ascending")) {
            QuickSortAsc.quickSortAsc(TBLKatalog, 9, 0, TBLKatalog.getRowCount() - 1);
        } else if (jComboBox2.getSelectedItem().toString().equals("Tanggal Masuk") && jComboBox3.getSelectedItem().toString().equals("Descending")) {
            QuickSortDesc.quickSortAsc(TBLKatalog, 9, 0, TBLKatalog.getRowCount() - 1);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormKatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKatalog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBLKatalog;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}