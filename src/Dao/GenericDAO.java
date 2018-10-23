package Dao;

import Conexao.Banco;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Danilo
 */
public class GenericDAO {

    protected String TABLE;

    private Banco db;

    public GenericDAO() throws FileNotFoundException, IOException {
        this.db = new Banco();
    }

    public Banco getDb() {
        return db;
    }

    public void setDb(Banco db) {
        this.db = db;
    }

    public int getLastId() throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT " + TABLE + "_SEQ.nextVal AS proximo FROM DUAL");

        //executa a consulta
        ResultSet rs = ps.executeQuery();

        rs.next();

        return rs.getInt("proximo") - 1;
    }

}
