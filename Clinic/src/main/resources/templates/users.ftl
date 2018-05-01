<html>
<head>
    <title>Зарегестрированные пользователи</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>



<div class="form-style-2">
    <form method="post" action="/users/pacient">
        <input type="submit" value="Найти всех пациентов">
    </form>

    <form method="post" action="/users/admin">
        <input type="submit" value="Найти всех Врачей">
    </form>

    <form method="get" action="/users">
        <input type="submit" value="Показать всех пользователей">
    </form>
    <div class="form-style-2-heading">
        Зарегестрированы
    </div>
    <table>
        <tr>
            <th>Имя</th>

            <th>Фамилия</th>

            <th>Состояние аккаунта</th>

            <th>Здоровье</th>

            <th>Паспортные данные</th>

            <th>Права</th>

        </tr>
    <#list usersFromServer as user>
        <tr>
            <td>${user.firstName} </td>
            <td>${user.lastName}</td>
            <td>${user.state}</td>
            <td>${user.statusHealth}</td>
            <td>${user.passportData}</td>
            <td>${user.role}</td>
            <td><form method="post" action="/users/sick/${user.login}">
                <input type="submit" value="Болен">
            </form></td>

            <td><form method="post" action="/users/health/${user.login}">
                <input type="submit" value="Здоров">
            </form></td>
        </tr>
    </#list>
    </table>
    <form method="get" action="/">
        <input type="submit" value="Личный кабинет">
    </form>
</div>
</body>
</html>
