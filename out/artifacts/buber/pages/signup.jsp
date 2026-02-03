<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<h2>Sign up</h2>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="SIGN_UP">

    <label>Username:</label><br>
    <input type="text" name="username" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Enter</button>
</form>

</body>
</html>