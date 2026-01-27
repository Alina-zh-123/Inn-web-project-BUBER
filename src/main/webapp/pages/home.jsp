<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Home</title></head>
<body>

<h1>Welcome, ${sessionScope.client.username}!</h1>
<form action="/buber/makeorder" method="post">
    <label for="destination">Destination</label>
    <input type="text" id="destination" name="destination">
    <input type="text" name="command" value="MAKE_REQUEST">
    <button type="submit">Make request for order</button>
</form>
<form action="/buber/controller" method="post">
    <input type="hidden" name="command" value="SIGN_OUT">
    <button type="submit">Sign Out</button>
</form>

</body>
</html>
