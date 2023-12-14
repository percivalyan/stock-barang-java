/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import stock.dao.imp.StockDAOImp;
import stock.view.FrameStock;
import stock.model.StockModel;

/**
 *
 * @author HP
 */
public class StockController {
    FrameStock frame = new FrameStock();
    StockDAOImp daoMahasiswaImpl;
    private final StockController mhsController;
    
    //Buat Controller
    public StockController(FrameStock frame) throws SQLException {
        //Inisialisasi
        this.frame = frame;
        this.mhsController = this; // Tambahkan inisialisasi ini
        daoMahasiswaImpl = new StockDAOImp();
    }
    
    //Insert Data User
    public void insert() {
    StockModel mhs = new StockModel();
    mhs.setIdb(frame.getNimTextField().getText());
    mhs.setJumlah(frame.getNamaTextField().getText());
    mhs.setPemasok(frame.getAlamatTextField().getText());
    mhs.setNama(frame.getNoHpTextField().getText());

    daoMahasiswaImpl.insert(mhs);
    }   
    
    //MEMPERBARUHI
public void update() {
        StockModel mhs = new StockModel();
        mhs.setIdb(frame.getNimTextField().getText());
        mhs.setJumlah(frame.getNamaTextField().getText());
        mhs.setPemasok(frame.getAlamatTextField().getText());
        mhs.setNama(frame.getNoHpTextField().getText());

        daoMahasiswaImpl.update(mhs);

        // Setelah update, refresh tampilan tabel
        refreshTable();
    }

//MENGHAPUS
public void delete() {
        StockModel mhs = new StockModel();
        mhs.setIdb(frame.getNimTextField().getText());

        daoMahasiswaImpl.delete(mhs);

        // Setelah delete, refresh tampilan tabel
        refreshTable();
    }

//RESET
public void reset() {
    frame.getNimTextField().setText("");
    frame.getNoHpTextField().setText("");
    frame.getNamaTextField().setText("");
    frame.getAlamatTextField().setText("");
}

public void tampilkanData() {
    // Mengambil data dari database
    List<StockModel> mahasiswaList = daoMahasiswaImpl.getAll();

    // Mendapatkan model tabel dari frame
    DefaultTableModel model = (DefaultTableModel) frame.getTabel_Data().getModel();

    // Membersihkan data yang ada di tabel
    model.setRowCount(0);

    // Memasukkan data baru ke dalam tabel
    for (StockModel mhs : mahasiswaList) {
        Object[] rowData = {mhs.getIdb(), mhs.getNama(), mhs.getJumlah(), mhs.getPemasok()};
        model.addRow(rowData);
    }
}

private void refreshTable() {
        // Ambil data terbaru dari database
        List<StockModel> mahasiswaList = daoMahasiswaImpl.getAll();

        // Update model tabel di frame
        DefaultTableModel model = (DefaultTableModel) frame.getTabel_Data().getModel();
        model.setRowCount(0); // Kosongkan tabel

        // Isi tabel dengan data terbaru
        for (StockModel mhs : mahasiswaList) {
            Object[] rowData = {mhs.getIdb(), mhs.getNama(), mhs.getJumlah(), mhs.getPemasok()};
            model.addRow(rowData);
        }
    }

public List<StockModel> getMahasiswaList() {
        // Mengambil data dari database
        return daoMahasiswaImpl.getAll();
    }

// Tambahkan metode cariNama
    public void cariNama(String nama) {
        // Panggil metode di DAO untuk mendapatkan hasil pencarian
        List<StockModel> hasilPencarian = daoMahasiswaImpl.getCariNama(nama);

        // Update tabel dengan hasil pencarian
        frame.updateTabel(hasilPencarian);
    }


}
