<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление пользователя</title>
</head>
<body>
<div style="text-align:center">

<form action="add" method="post">
  Name: <input type="text" name="name" required><br><br>
  Email: <input type="email" name="email" required><br><br>
  Address: <input type="text" name="address"><br><br>
  <input type="submit" value="Добавить пользователя">
</form>
</div>
<br>
<div style="text-align:center"> <a href="${pageContext.request.contextPath}/" style="display:inline-block">Назад к списку пользователей</a> </div>
</body>
</html>