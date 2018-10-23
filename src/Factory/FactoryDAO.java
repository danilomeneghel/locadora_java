package Factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import Dao.AluguelDAO;
import Dao.ClienteDAO;
import Dao.FilmeDAO;

/**
 *
 * @author Danilo
 */
public class FactoryDAO {

    public static IClienteDAO getClienteDAO() throws FileNotFoundException, IOException {
        return new ClienteDAO();
    }

    public static IFilmeDAO getFilmeDAO() throws FileNotFoundException, IOException {
        return new FilmeDAO();
    }

    public static IAluguelDAO getAluguelDAO() throws FileNotFoundException, IOException {
        return new AluguelDAO();
    }
}
