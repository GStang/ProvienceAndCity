import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgs on 17-8-23.
 */
@WebServlet(name = "CityServlet", value = "/CityServlet")
public class CityServlet extends HttpServlet {

//    private StringBuffer buffer = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("province");
        CityDao dao = new CityDao();
        List<String> citysname;
        List<CityBean> citys = new ArrayList<CityBean>();
        citysname = dao.getCity(s);
        for (String city :
                citysname) {
            citys.add(new CityBean(city));
        }
        Gson gson = new Gson();
        String json = gson.toJson(citys);
        resp.getWriter().print(json);
    }
}
