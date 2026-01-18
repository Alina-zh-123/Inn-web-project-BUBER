<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Home</title></head>
<body>

<h1>Welcome, ${sessionScope.client.username}!</h1>

<form action="/your-app-name/controller" method="post">
    <input type="hidden" name="command" value="sign_out">
    <button type="submit">Sign Out</button>
</form>

</body>
</html>
