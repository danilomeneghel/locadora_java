package Factory;

import java.sql.SQLException;
import Bean.Filme;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface IFilmeDAO {

    public void save(Filme obj) throws SQLException, ClassNotFoundException;

    public Boolean delete(Filme obj) throws SQLException, ClassNotFoundException;

    public List<Filme> load() throws SQLException, ClassNotFoundException;
}
