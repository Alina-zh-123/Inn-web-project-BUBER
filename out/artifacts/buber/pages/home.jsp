<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Home</title></head>
<body>

<h1>Welcome, ${sessionScope.client.username}!</h1>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="SIGN_OUT">
    <button type="submit">Sign Out</button>
</form>

</body>
</html>
