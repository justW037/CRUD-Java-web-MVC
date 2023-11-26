
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="p-4">
<div class="nav">
    <a href="/add" class="btn btn-success">Thêm</a>
    <form class="form-inline" action="search">
        <input class="form-control mr-sm-2" name="searchKeyword" id="search" type="search" placeholder="Tìm kiếm">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
    </form>
</div>
<h1>Danh sách</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Sửa</th>
        <th>Xoá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><form action="updatedUser">
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit" class="btn btn-primary">Sửa</button>
                </form></td>
            <td><form action="deleteUser" method="post">
                <input type="hidden" name="userId" value="${user.id}">
                <button type="submit" class="btn btn-danger">Xoá</button>
                </form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>

</html>
<style>
    .nav {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
    }
    .form-inline {
        display: flex;
        flex-direction: row;
    }
    #search {
        width: 300px;
    }
</style>