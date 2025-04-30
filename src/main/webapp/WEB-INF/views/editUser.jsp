<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Редактировать данные пользователя</title>
</head>
<body>
<div style="text-align:center">
<form action="update" method="post">
  <input type="hidden" name="id" value="${user.id}"><br><br>
  Name: <input type="text" name="name" value="${user.name}" required><br><br>
  Address: <input type="text" name="address" value="${user.address}"><br><br>
  Email: <input type="email" name="email" value="${user.email}"><br><br>
  <input type="submit" value="Обновить">
</form>
</div>
<br>
<div style="text-align:center"> <a href="${pageContext.request.contextPath}/" style="display:inline-block">Назад к списку пользователей</a> </div>
</body>
</html>