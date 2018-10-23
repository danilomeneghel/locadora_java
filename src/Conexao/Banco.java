package Conexao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class Banco {

    private String strConexao;
    private String strDriver;

    private final String DIRECTORY = "C:/temp/";

    public Banco() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(DIRECTORY + "db.config");
        BufferedReader br = new BufferedReader(fr);

        String user, pass, host, driver;

        try {

            user = br.readLine();
            pass = br.readLine();
            host = br.readLine();
            driver = br.readLine();

        } finally {
            br.close();
            fr.close();
        }

        setStrConexao("jdbc:oracle:thin:" + user + "/" + pass + "@" + host + "/XE");
        setStrDriver(driver);
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(getStrDriver());
        return DriverManager.getConnection(getStrConexao());
    }

    public String getStrConexao() {
        return strConexao;
    }

    public void setStrConexao(String strConexao) {
        this.strConexao = strConexao;
    }

    public String getStrDriver() {
        return strDriver;
    }

    public void setStrDriver(String strDriver) {
        this.strDriver = strDriver;
    }

}
