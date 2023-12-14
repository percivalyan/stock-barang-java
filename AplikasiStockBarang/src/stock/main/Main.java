package stock.main;

import stock.koneksi.KoneksiDatabase;
import stock.view.FrameMahasiswa;
import java.sql.Connection;
import java.sql.SQLException;
import stock.controller.MahasiswaController;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        FrameMahasiswa frameMahasiswa = new FrameMahasiswa();
        frameMahasiswa.setVisible(true);

        MahasiswaController mhsController = new MahasiswaController(frameMahasiswa);
        mhsController.tampilkanData();
    }
}
