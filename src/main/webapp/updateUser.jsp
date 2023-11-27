
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="p-4">
    <a href="getalluser" class="btn btn-success">Quay lại</a>
    <h1 >Sửa người dùng</h1>
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="username">Tên người dùng</label>
            <input type="text" name="username" class="form-control w-25 mb-3" id="username" placeholder="Nhập tên" value="${user.username}" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" name="email" class="form-control w-25 mb-3" id="email" placeholder="Nhập email" value="${user.email}" required>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
