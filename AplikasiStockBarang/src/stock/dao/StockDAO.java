/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package stock.dao;

import java.util.List;
import stock.model.Barang;
//import mahasiswa.view.MahasiswaView;
/**
 *
 * @author HP
 */
public interface StockDAO {
    //Fungsi untuk melakukan proses CRUD pada database
    public void insert(Barang mhs);
    
    public void update(Barang mhs);
    
    public void delete(Barang mhs);
    
    public List<Barang> getAll();
    
    public List<Barang> getCariNama(String nama);
}
