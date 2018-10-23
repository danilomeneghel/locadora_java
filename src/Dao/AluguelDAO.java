package Dao;

import Bean.Aluguel;
import Factory.IAluguelDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class AluguelDAO extends GenericDAO implements IAluguelDAO {

    private String SQL_SELECT = "SELECT * FROM aluguel "
            + "WHERE id=?";

    private String SQL_SELECT2 = "SELECT * FROM aluguel";

    private String SQL_DELETE = "DELETE FROM aluguel "
            + "WHERE id=?";

    private String SQL_INSERT = "INSERT INTO aluguel (id, filme, cliente, data) "
            + "VALUES(ALU_SEQ.NEXTVAL, ?, ?, ?)";

    private String SQL_UPDATE = "UPDATE aluguel SET filme=? , cliente=?, data=? "
            + "WHERE id=?";

    public AluguelDAO() throws FileNotFoundException, IOException {
        super.TABLE = "aluguel";
    }

    public List<Aluguel> load() throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT2);

        //executa a consulta
        ResultSet rs = ps.executeQuery();

        List<Aluguel> listAlu = new ArrayList<Aluguel>();

        while (rs.next()) {
            Aluguel alu = new Aluguel();

            alu.setId(rs.getInt("id"));
            alu.setFilme(rs.getString("filme"));
            alu.setCliente(rs.getString("cliente"));
            alu.setData(rs.getString("data"));

            System.out.println(alu.getFilme());
            listAlu.add(alu);
        }

        return listAlu;
    }

    public Boolean delete(Aluguel obj) throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_DELETE);

        ps.setInt(1, obj.getId());

        //executa a consulta
        ResultSet rs = ps.executeQuery();

        return true;
    }

    public void save(Aluguel obj) throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();

        PreparedStatement ps;

        if (obj.getId() == 0) {
            ps = conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getFilme());
            ps.setString(2, obj.getCliente());
            ps.setString(3, obj.getData());

            ps.executeUpdate();

            obj.setId(getLastId());

        } else {
            ps = conn.prepareStatement(SQL_UPDATE);

            ps.setString(1, obj.getFilme());
            ps.setString(2, obj.getCliente());
            ps.setString(3, obj.getData());
            ps.setInt(4, obj.getId());

            ps.executeUpdate();

        }
    }

    public Aluguel load(Aluguel obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
