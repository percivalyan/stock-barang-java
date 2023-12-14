/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package stock.dao;

import java.util.List;
import stock.model.StockModel;
//import mahasiswa.view.MahasiswaView;
/**
 *
 * @author HP
 */
public interface StockDAO {
    //Fungsi untuk melakukan proses CRUD pada database
    public void insert(StockModel mhs);
    
    public void update(StockModel mhs);
    
    public void delete(StockModel mhs);
    
    public List<StockModel> getAll();
    
    public List<StockModel> getCariNama(String nama);
}
