<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        tr:nth-child(even) { background-color: #f2f2f2; }
    </style>
</head>
<body>
<div style="text-align:center"><h2>Список пользователей</h2></a> </div>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>

    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>
                <a href="edit?id=${user.id}">Редактировать</a>

                <form action="delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<div style="text-align:center"> <a href="add" style="display:inline-block">Добавить нового пользователя</a> </div>
</body>
</html>