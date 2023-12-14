/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stock.view;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import static groovy.inspect.Inspector.print;
import java.awt.Desktop;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JFrame;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import stock.controller.MahasiswaController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import stock.dao.imp.MahasiswaDAOImp;
import stock.koneksi.KoneksiDatabase;
import stock.model.Mahasiswa;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HP
 */
public class FrameMahasiswa extends javax.swing.JFrame {

    private String jasperPrint;
//    public Statement st;
//    public ResultSet rs;
//    Connection cn = mahasiswa.koneksi.KoneksiDatabase.koneksi();
    /**
     * Creates new form MainGUI
     */
    public void updateTabel(List<Mahasiswa> data) {
        DefaultTableModel model = (DefaultTableModel) Tabel_Data.getModel();
        model.setRowCount(0); // Mengosongkan tabel

        for (Mahasiswa mhs : data) {
            Object[] row = {mhs.getNim(), mhs.getNoHp(), mhs.getNama(), mhs.getAlamat()};
            model.addRow(row);
        }
    }

    //DefaultTableModel model; //Default Tabel (1A)
    //Buat Objek Kelas Controller
    MahasiswaController mhsController;
    

    public FrameMahasiswa() {
        initComponents();
        
        initTableListener();
        
        // Menonaktifkan resize
        setResizable(false);

        // Menetapkan ukuran frame
        setSize(1000, 510);

        // Menetapkan operasi default ketika tombol close diklik
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("TELEPON");
        model.addColumn("NAMA");
        model.addColumn("ALAMAT");
        Tabel_Data.setModel(model);
    }
  
    
    private void initTableListener() {
    Tabel_Data.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = Tabel_Data.getSelectedRow();
                if (selectedRow != -1) {
                    // Baris dipilih, isi kolom input dengan data dari baris tersebut
                    String nim = Tabel_Data.getValueAt(selectedRow, 0).toString();
                    String noHp = Tabel_Data.getValueAt(selectedRow, 1).toString();
                    String nama = Tabel_Data.getValueAt(selectedRow, 2).toString();
                    String alamat = Tabel_Data.getValueAt(selectedRow, 3).toString();

                    nimTextField.setText(nim);
                    NoHpTextField.setText(noHp);
                    namaTextField.setText(nama);
                    alamatTextField.setText(alamat);
                }
            }
        }
    });
    
    
}

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nimTextField = new javax.swing.JTextField();
        NoHpTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        alamatTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_Data = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        CariTextField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1000, 500));

        titlePanel.setBackground(new java.awt.Color(51, 51, 51));
        titlePanel.setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA = JUMLAH BARANG");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ALAMAT = PEMASOK");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIM = ID BARANG");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NO. TELP = NAMA BARANG");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TANGGAL MASUK (NEW)");

        jTextField1.setText("jTextField1");

        btn_tambah.setText("INSERT");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_hapus.setText("DELETE");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_reset.setText("RESET");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_cetak.setText("PRINT");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pencarian Berdasarkan Nama:");

        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        Tabel_Data.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Tabel_Data);

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(btn_cari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nimTextField)
                            .addComponent(NoHpTextField)
                            .addComponent(namaTextField)
                            .addComponent(alamatTextField)
                            .addComponent(jTextField1)))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CariTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(titlePanelLayout.createSequentialGroup()
                                .addComponent(btn_tambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(btn_cetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NoHpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(alamatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_update)
                            .addComponent(btn_hapus)
                            .addComponent(btn_reset))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cetak)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(690, 690, 690)
                .addComponent(btn_cari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1016, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        if (mhsController == null) {
            try {
                // Jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FrameMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Ambil teks dari kolom pencarian
        String namaCari = CariTextField.getText();

        // Lakukan pencarian berdasarkan nama
        mhsController.cariNama(namaCari);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        Document document = new Document();
        try {
            // Mendapatkan waktu saat ini untuk digunakan sebagai nama file PDF
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = sdf.format(new Date());

            // Nama file PDF
            String pdfFileName = "Data_Mahasiswa_" + timestamp + ".pdf";

            // Lokasi penyimpanan file PDF
            String pdfFilePath = System.getProperty("user.home") + File.separator + pdfFileName;

            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));

            document.open();

            // Judul PDF
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Paragraph title = new Paragraph("DATA MAHASISWA", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n")); // Baris kosong

            // Tabel PDF
            PdfPTable pdfTable = new PdfPTable(Tabel_Data.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Header
            Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.BLACK);
            for (int i = 0; i < Tabel_Data.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(Tabel_Data.getColumnName(i), fontHeader));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Data
            Font fontData = FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.BLACK);
            for (int i = 0; i < Tabel_Data.getRowCount(); i++) {
                for (int j = 0; j < Tabel_Data.getColumnCount(); j++) {
                    PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(Tabel_Data.getValueAt(i, j)), fontData));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);

            // Menutup dokumen dan menampilkan file PDF
            document.close();
            Desktop.getDesktop().open(new File(pdfFilePath));

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        if (mhsController == null) {
            try {
                // jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FrameMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mhsController.reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        if (mhsController == null) {
            try {
                // jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FrameMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mhsController.delete();
    }//GEN-LAST:event_btn_hapusActionPerformed

    //MEMPERBARUHI
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (mhsController == null) {
            try {
                // jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FrameMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mhsController.update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed

    }//GEN-LAST:event_btn_tambahActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

       
   
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrameMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrameMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrameMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrameMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrameMahasiswa().setVisible(true);
//            }
//        });
//    }

    public JTextField getCariTextField() {
        return CariTextField;
    }

    public void setCariTextField(JTextField CariTextField) {
        this.CariTextField = CariTextField;
    }

    public JTextField getNoHpTextField() {
        return NoHpTextField;
    }

    public void setNoHpTextField(JTextField NoHpTextField) {
        this.NoHpTextField = NoHpTextField;
    }

    public JTextField getAlamatTextField() {
        return alamatTextField;
    }

    public void setAlamatTextField(JTextField alamatTextField) {
        this.alamatTextField = alamatTextField;
    }

    public JTextField getNamaTextField() {
        return namaTextField;
    }

    public void setNamaTextField(JTextField namaTextField) {
        this.namaTextField = namaTextField;
    }

    public JTextField getNimTextField() {
        return nimTextField;
    }

    public void setNimTextField(JTextField nimTextField) {
        this.nimTextField = nimTextField;
    }

    public JTable getTabel_Data() {
        return Tabel_Data;
    }

    public void setTabel_Data(JTable Tabel_Data) {
        this.Tabel_Data = Tabel_Data;
    }

    public JButton getCETAK() {
        return btn_cetak;
    }

    public void setCETAK(JButton CETAK) {
        this.btn_cetak = CETAK;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CariTextField;
    private javax.swing.JTextField NoHpTextField;
    private javax.swing.JTable Tabel_Data;
    private javax.swing.JTextField alamatTextField;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JTextField nimTextField;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

  


}
