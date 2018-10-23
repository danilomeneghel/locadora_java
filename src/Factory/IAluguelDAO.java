package Factory;

import java.sql.SQLException;
import Bean.Aluguel;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface IAluguelDAO {

    public void save(Aluguel obj) throws SQLException, ClassNotFoundException;

    public Boolean delete(Aluguel obj) throws SQLException, ClassNotFoundException;

    public List<Aluguel> load() throws SQLException, ClassNotFoundException;
}
