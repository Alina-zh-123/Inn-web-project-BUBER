<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Welcome, ${sessionScope.client.username}!</h1>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="MAKE_REQUEST_FOR_ORDER">

    <label>     Your location:</label><br>
    <label>${sessionScope.client.getLatitude()}, ${sessionScope.client.getLongitude()}</label><br>
    <br>
    <button type="submit">Find cars nearby</button>
</form>
<hr>
<form action="pages/signin.jsp" method="get">
    <button type="submit">Sign out</button>
</form>
</body>
</html>
