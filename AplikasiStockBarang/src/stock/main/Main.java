package stock.main;

import stock.koneksi.KoneksiDatabase;
import stock.view.FrameStock;
import java.sql.Connection;
import java.sql.SQLException;
import stock.controller.StockController;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        FrameStock frameMahasiswa = new FrameStock();
        frameMahasiswa.setVisible(true);

        StockController mhsController = new StockController(frameMahasiswa);
        mhsController.tampilkanData();
    }
}
