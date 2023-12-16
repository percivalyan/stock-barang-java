/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.dao.imp;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stock.koneksi.KoneksiDatabase;
import stock.model.StockModel;
import stock.view.FrameStock;
import stock.dao.StockDAO;
//import mahasiswa.view.MahasiswaView;

/**
 *
 * @author HP
 */
public class StockDAOImp implements StockDAO {
    //Buat Var  Koneksi
    Connection connection;
    
    public StockDAOImp() throws SQLException{
        KoneksiDatabase koneksi = new KoneksiDatabase();
        connection = koneksi.koneksi();
    }
    final String insert = "INSERT INTO barangmasuk (idbarang, namabarang, jumlahbarang, pemasok) VALUES (?,?,?,?);";

//    public StockDAOImp(Connection koneksi) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public void insert(StockModel mhs) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO barangmasuk (idbarang, namabarang, jumlahbarang, pemasok) VALUES (?, ?, ?, ?)");
            ps.setString(1, mhs.getIdb());
            ps.setString(2, mhs.getNama());
            ps.setString(3, mhs.getJumlah());
            ps.setString(4, mhs.getPemasok());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


   // Di dalam class StockDAOImp
@Override
public void update(StockModel mhs) {
    PreparedStatement ps = null;
    try {
         ps = connection.prepareStatement("UPDATE barangmasuk SET namabarang=?, jumlahbarang=?, pemasok=? WHERE idbarang=?");
        ps.setString(1, mhs.getIdb());
        ps.setString(2, mhs.getNama());
        ps.setString(3, mhs.getJumlah());
        ps.setString(4, mhs.getPemasok());
        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

@Override
public void delete(StockModel mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("DELETE FROM barangmasuk WHERE idbarang=?");
        ps.setString(1, mhs.getIdb());
        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

// Implementasi metode getAll dan getCariNama sesuai kebutuhan
@Override
public List<StockModel> getAll() {
    List<StockModel> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM barangmasuk");
        rs = ps.executeQuery();

        while (rs.next()) {
            StockModel mhs = new StockModel();
            mhs.setIdb(rs.getString("idbarang"));
            mhs.setJumlah(rs.getString("jumlahbarang"));
            mhs.setPemasok(rs.getString("pemasok"));
            mhs.setNama(rs.getString("namabarang"));
            mahasiswaList.add(mhs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return mahasiswaList;
}

@Override
public List<StockModel> getCariNama(String nama) {
    List<StockModel> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM tb_mahasiswa WHERE nama LIKE ?");
        ps.setString(1, "%" + nama + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            StockModel mhs = new StockModel();
            mhs.setIdb(rs.getString("idbarang"));
            mhs.setJumlah(rs.getString("jumlahbarang"));
            mhs.setPemasok(rs.getString("pemasok"));
            mhs.setNama(rs.getString("namabarang"));
            mahasiswaList.add(mhs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return mahasiswaList;
}

}