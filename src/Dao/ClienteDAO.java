package Dao;

import Bean.Cliente;
import Factory.IClienteDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class ClienteDAO extends GenericDAO implements IClienteDAO {

    private String SQL_SELECT = "SELECT * FROM cliente "
            + "WHERE codcliente=?";

    private String SQL_SELECT2 = "SELECT * FROM cliente";

    private String SQL_DELETE = "DELETE FROM cliente "
            + "WHERE codcliente=?";

    private String SQL_INSERT = "INSERT INTO cliente (codcliente, nome, email, telefone) "
            + "VALUES(CLIENTE_SEQ.NEXTVAL,?,?,?)";

    private String SQL_UPDATE = "UPDATE cliente SET nome=?, email=?, telefone=? "
            + "WHERE codcliente=?";

    public ClienteDAO() throws FileNotFoundException, IOException {
        super.TABLE = "cliente";
    }

    public List<Cliente> load() throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT2);

        //executa a consulta
        ResultSet rs = ps.executeQuery();

        List<Cliente> listCli = new ArrayList<Cliente>();

        while (rs.next()) {
            Cliente cli = new Cliente();

            cli.setCodigo(rs.getInt("codcliente"));
            cli.setNome(rs.getString("nome"));
            cli.setEmail(rs.getString("email"));
            cli.setTelefone(rs.getString("telefone"));

            System.out.println(cli.getNome());
            listCli.add(cli);
        }

        return listCli;
    }

    public Boolean delete(Cliente obj) throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_DELETE);

        ps.setInt(1, obj.getCodigo());

        //executa a consulta
        ResultSet rs = ps.executeQuery();
        
        return true;
    }

    public void save(Cliente obj) throws SQLException, ClassNotFoundException {
        Connection conn = getDb().getConnection();

        PreparedStatement ps;

        if (obj.getCodigo() == 0) {
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getTelefone());

            ps.executeUpdate();

            obj.setCodigo(getLastId());
            JOptionPane.showMessageDialog(null, "Registro cadastrado com sucesso!");
        } else {
            ps = conn.prepareStatement(SQL_UPDATE);

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getTelefone());
            ps.setInt(4, obj.getCodigo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente '" + obj.getNome() + "' foi alterado com sucesso!");

        }
    }

    public Cliente load(Cliente obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
