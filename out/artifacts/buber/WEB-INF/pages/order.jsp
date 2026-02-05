<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h2>Order information:</h2>
<head>
    <title>Order</title>
</head>
<body>
<label>Client: ${sessionScope.client.getUsername()}</label><br>
<label>Car: ${sessionScope.car.toString()}</label><br>
</body>

<br>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="DECLINE_ORDER">
    <button type="submit">Decline order</button>
</form>
</html>