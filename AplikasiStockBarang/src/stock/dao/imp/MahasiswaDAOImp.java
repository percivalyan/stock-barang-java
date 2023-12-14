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

import stock.dao.MahasiswaDAO;
import stock.koneksi.KoneksiDatabase;
import stock.model.Mahasiswa;
import stock.view.FrameMahasiswa;
//import mahasiswa.view.MahasiswaView;


/**
 *
 * @author HP
 */
public class MahasiswaDAOImp implements MahasiswaDAO {
    //Buat Var  Koneksi
    Connection connection;
    
    public MahasiswaDAOImp() throws SQLException{
        KoneksiDatabase koneksi = new KoneksiDatabase();
        connection = koneksi.koneksi();
    }
    final String insert = "INSERT INTO tb_mahasiswa (nim, nama, alamat, hp) VALUES (?,?,?,?);";

//    public MahasiswaDAOImp(Connection koneksi) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public void insert(Mahasiswa mhs) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO tb_mahasiswa (nim, nama, alamat, hp) VALUES (?, ?, ?, ?)");
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


   // Di dalam class MahasiswaDAOImp
@Override
public void update(Mahasiswa mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("UPDATE tb_mahasiswa SET nama=?, alamat=?, hp=? WHERE nim=?");
        ps.setString(1, mhs.getNama());
        ps.setString(2, mhs.getAlamat());
        ps.setString(3, mhs.getNoHp());
        ps.setString(4, mhs.getNim());
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
public void delete(Mahasiswa mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("DELETE FROM tb_mahasiswa WHERE nim=?");
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
public List<Mahasiswa> getAll() {
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM tb_mahasiswa");
        rs = ps.executeQuery();

        while (rs.next()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(rs.getString("nim"));
            mhs.setNama(rs.getString("nama"));
            mhs.setAlamat(rs.getString("alamat"));
            mhs.setNoHp(rs.getString("hp"));
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
public List<Mahasiswa> getCariNama(String nama) {
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM tb_mahasiswa WHERE nama LIKE ?");
        ps.setString(1, "%" + nama + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(rs.getString("nim"));
            mhs.setNama(rs.getString("nama"));
            mhs.setAlamat(rs.getString("alamat"));
            mhs.setNoHp(rs.getString("hp"));
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