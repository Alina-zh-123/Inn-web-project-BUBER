<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zhilyuk.task4.entity.Car" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Make order</title>
</head>
<body>
<h1>Make order</h1>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="MAKE_ORDER">

    <%
        ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
        if (cars != null) {
            for (Car car : cars) {
    %>
    <label>
        <input type="radio" name="carId" value="<%= car.getId() %>">
        <%= car.toString() %>
    </label>
    <br>
    <%
            }
        }
    %>
    <br>
    <button type="submit">Enter</button>
</form>

</body>
</html>
