<%--
  Created by IntelliJ IDEA.
  User: tgs
  Date: 17-8-23
  Time: 上午10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市联动</title>
    <script type="application/javascript">
        function change() {
            var select = document.getElementById("province-select");
            var city = document.getElementById("city-select");
            var xmlHttp = getXMLHTTPRequest();
            while (city.hasChildNodes()){
                city.removeChild(city.childNodes[0]);
            }
            if (xmlHttp == -1) {
                alert("暂时不支持您的浏览器");
                var errorshow = document.getElementById("error");
                errorshow.innerHTML = "暂时不支持您的浏览器";
            }
            if (select.selectedIndex == 1) {
                xmlHttp.open("GET", "/CityServlet?province=sichuan", true);
            } else if (select.selectedIndex == 2) {
                xmlHttp.open("GET", "/CityServlet?province=guangdong", true);
            } else if (select.selectedIndex == 3) {
                xmlHttp.open("GET", "/CityServlet?province=hebei", true);
            } else
                xmlHttp.open("GET", "/CityServlet?province=sichuan", true);
            xmlHttp.send(null);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    var responsejson = xmlHttp.responseText;
                    var array = JSON.parse(responsejson);
                    for (var i = 0; i < array.length; i++) {
                        var option = new Option;
                        option.innerHTML = array[i].cityName;
                        city.appendChild(option);
                    }
                    var option = new Option;
                    option.innerHTML = array[0].cityName;
                }
            }
        }

    </script>
    <script type="application/javascript">
        function getXMLHTTPRequest() {
            try {
                return new XMLHttpRequest();
            } catch (e) {
                return -1;
            }

        }
    </script>
</head>
<body>

<select id="province-select" name="省" onchange="change()">
    <option value="0">请选择省</option>
    <option value="1">四川</option>
    <option value="2">广东</option>
    <option value="3">河北</option>
</select>
<select id="city-select" name="市">
    <option value="0">请选择市</option>
</select>
<h5 id="error"></h5>
<h5 id="success"></h5>
</body>
</html>
