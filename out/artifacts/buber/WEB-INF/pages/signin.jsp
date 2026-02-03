<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<h1>Sign in</h1>
<head>
    <title>Sign in</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="SIGN_IN">

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Enter</button>
</form>

<hr>
<p>Don't have an account yet?</p>
<form action="pages/signup.jsp" method="get">
    <button type="submit">Sign up</button>
</form>
</body>
</html>