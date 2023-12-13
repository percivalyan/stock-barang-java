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
import stock.model.Barang;
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
    final String insert = "INSERT INTO tb_barang (idbarang, jumlahbarang, namabarang, pemasok) VALUES (?,?,?,?);";

//    public StockDAOImp(Connection koneksi) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public void insert(Barang mhs) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO tb_barang (idbarang, jumlahbarang, namabarang, pemasok) VALUES (?, ?, ?, ?)");
            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.setString(3, mhs.getAlamat());
            ps.setString(4, mhs.getNoHp());
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
public void update(Barang mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("UPDATE tb_barang SET pemasok=?, jumlahbarang=?, databarang=? WHERE idbarang=?");
        ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.setString(3, mhs.getAlamat());
            ps.setString(4, mhs.getNoHp());
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
public void delete(Barang mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("DELETE FROM tb_barang WHERE idbarang=?");
        ps.setString(1, mhs.getNim());
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
public List<Barang> getAll() {
    List<Barang> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM tb_barang");
        rs = ps.executeQuery();

        while (rs.next()) {
            Barang mhs = new Barang();
            mhs.setNim(rs.getString("idbarang"));
             mhs.setAlamat(rs.getString("namabarang"));
            mhs.setNama(rs.getString("pemasok"));
            mhs.setNoHp(rs.getString("jumlahbarang"));
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
public List<Barang> getCariNama(String nama) {
    List<Barang> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM tb_barang WHERE namabarang LIKE ?");
        ps.setString(1, "%" + nama + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            Barang mhs = new Barang();
             mhs.setNim(rs.getString("idbarang"));
            mhs.setNama(rs.getString("jumlahbarang"));
            mhs.setAlamat(rs.getString("namabarang"));
            mhs.setNoHp(rs.getString("pemasok"));
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