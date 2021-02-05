
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
Авторизация
<br>
<form method="post", action="/reg">
    <input name="login", type="text", placeholder="login"><br>
    <input name="pass", type="password", placeholder="password"><br>
    <button>Submit</button>
</form>

<a href="/mainPage">На главную</a><br>
</body>
</html>
