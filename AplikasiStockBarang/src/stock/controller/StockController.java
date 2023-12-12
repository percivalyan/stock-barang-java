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
import stock.model.Barang;

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
    Barang mhs = new Barang();
    mhs.setNim(frame.getNimTextField().getText());
    mhs.setNama(frame.getNamaTextField().getText());
    mhs.setAlamat(frame.getAlamatTextField().getText());
    mhs.setNoHp(frame.getNoHpTextField().getText());

    daoMahasiswaImpl.insert(mhs);
    }   
    
    //MEMPERBARUHI
public void update() {
        Barang mhs = new Barang();
        mhs.setNim(frame.getNimTextField().getText());
        mhs.setNama(frame.getNamaTextField().getText());
        mhs.setAlamat(frame.getAlamatTextField().getText());
        mhs.setNoHp(frame.getNoHpTextField().getText());

        daoMahasiswaImpl.update(mhs);

        // Setelah update, refresh tampilan tabel
        refreshTable();
    }

//MENGHAPUS
public void delete() {
        Barang mhs = new Barang();
        mhs.setNim(frame.getNimTextField().getText());

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
    List<Barang> mahasiswaList = daoMahasiswaImpl.getAll();

    // Mendapatkan model tabel dari frame
    DefaultTableModel model = (DefaultTableModel) frame.getTabel_Data().getModel();

    // Membersihkan data yang ada di tabel
    model.setRowCount(0);

    // Memasukkan data baru ke dalam tabel
    for (Barang mhs : mahasiswaList) {
        Object[] rowData = {mhs.getNim(), mhs.getNoHp(), mhs.getNama(), mhs.getAlamat()};
        model.addRow(rowData);
    }
}

private void refreshTable() {
        // Ambil data terbaru dari database
        List<Barang> mahasiswaList = daoMahasiswaImpl.getAll();

        // Update model tabel di frame
        DefaultTableModel model = (DefaultTableModel) frame.getTabel_Data().getModel();
        model.setRowCount(0); // Kosongkan tabel

        // Isi tabel dengan data terbaru
        for (Barang mhs : mahasiswaList) {
            Object[] rowData = {mhs.getNim(), mhs.getNoHp(), mhs.getNama(), mhs.getAlamat()};
            model.addRow(rowData);
        }
    }

public List<Barang> getMahasiswaList() {
        // Mengambil data dari database
        return daoMahasiswaImpl.getAll();
    }

// Tambahkan metode cariNama
    public void cariNama(String nama) {
        // Panggil metode di DAO untuk mendapatkan hasil pencarian
        List<Barang> hasilPencarian = daoMahasiswaImpl.getCariNama(nama);

        // Update tabel dengan hasil pencarian
        frame.updateTabel(hasilPencarian);
    }


}
