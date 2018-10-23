package Factory;

import java.sql.SQLException;
import Bean.Cliente;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface IClienteDAO {

    public void save(Cliente obj) throws SQLException, ClassNotFoundException;

    public Boolean delete(Cliente obj) throws Exception;

    public List<Cliente> load() throws SQLException, ClassNotFoundException;

}
