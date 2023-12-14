/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.model;

/**
 *
 * @author HP
 */
public class StockModel {
    private String idb, nama, jumlah, pemasok;
    // private String nim, nama, alamat, noHp;

    //ID
    public String getIdb() {
        return idb;
    }

    public void setIdb(String idb) {
        this.idb = idb;
    }
    
    //Nama Barang
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    //Jumlah Barang
    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    //Pemasok
    public String getPemasok() {
        return pemasok;
    }

    public void setPemasok (String pemasok) {
        this.pemasok = pemasok;
    }    
}
