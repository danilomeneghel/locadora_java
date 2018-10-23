package Dao;

import Bean.Filme;
import Factory.IFilmeDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class FilmeDAO extends GenericDAO implements IFilmeDAO {

    private String SQL_SELECT = "SELECT * FROM filme "
            + "WHERE id=?";

    private String SQL_SELECT2 = "SELECT * FROM filme";

    private String SQL_DELETE = "DELETE FROM filme "
            + "WHERE id=?";

    private String SQL_INSERT = "INSERT INTO filme (id, titulo, valor) "
            + "VALUES(FILME_SEQ.NEXTVAL,?,?)";

    private String SQL_UPDATE = "UPDATE filme SET titulo=? , valor=? "
            + "WHERE id=?";

    public FilmeDAO() throws FileNotFoundException, IOException {
        super.TABLE = "filme";
    }

    public List<Filme> load() throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT2);

        //executa a consulta
        ResultSet rs = ps.executeQuery();

        List<Filme> listFil = new ArrayList<Filme>();

        while (rs.next()) {
            Filme fil = new Filme();

            fil.setId(rs.getInt("id"));
            fil.setTitulo(rs.getString("titulo"));
            fil.setValor(rs.getString("valor"));

            System.out.println(fil.getTitulo());
            listFil.add(fil);
        }

        return listFil;
    }

    public Boolean delete(Filme obj) throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_DELETE);

        ps.setInt(1, obj.getId());

        //executa a consulta
        ResultSet rs = ps.executeQuery();

        return true;
    }

    public void save(Filme obj) throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();

        PreparedStatement ps;

        if (obj.getId() == 0) {
            ps = conn.prepareStatement(SQL_INSERT, 1);

            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getValor());

            ps.executeUpdate();

            obj.setId(getLastId());

        } else {
            ps = conn.prepareStatement(SQL_UPDATE);

            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getValor());
            ps.setInt(3, obj.getId());

            ps.executeUpdate();
        }
    }

    public Filme load(Filme obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
