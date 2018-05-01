<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Личный кабинет</title>
    <link href="/static/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="form-style-2-heading">${user.firstName}</div>
<div class="form-style-2-heading">${user.lastName}</div>
<div class="form-style-2-heading">${user.role}</div>




<td><form method="post" action="/delete/${user.login}">
    <input type="submit" value="Открепиться от этой поликлиники">
</form></td>

<form method="get" action="/users">
    <input type="submit" value="Список пользователей(только для администраторов)">
</form>



<a href="/logout">Выход</a>
</body>
</html>