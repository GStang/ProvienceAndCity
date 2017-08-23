import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgs on 17-8-23.
 */
public class CityDao {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/city";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String passwor = "123456";

    private Connection conn = null;

    {
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, passwor);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    PreparedStatement pstate;

    public Connection getConn() {

        return conn;
    }

    public List<String> getCity(String provicename) {
        try {
            pstate = conn.prepareStatement("SELECT c.name from citys c left join provice p on p.name=? where" +
                    " c.provice = p.name");
            pstate.setString(1, provicename);
            ResultSet set = pstate.executeQuery();
            ArrayList<String> citys = new ArrayList<String>();
            while (set.next()) {
                citys.add(set.getString(1));
            }
            return citys;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
