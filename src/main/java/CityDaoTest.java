import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tgs on 17-8-23.
 */
public class CityDaoTest {

    CityDao dao = new CityDao();


    @Test
    public void Test() {
        List<String> citys = dao.getCity("sichuan");
//        System.out.println(s);
        for (String city : citys) {
            System.out.println(city);
        }
    }
}
