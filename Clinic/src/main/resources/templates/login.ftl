<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Вход</title>
    <link href="/static/css/styles.css" rel="stylesheet">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<#if error??>
<div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Login!
    </div>
    <form method="post" action="/login">
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit" value="Login">
    </form>
    <form method="get" action="/signUp">
        <input type="submit" value="Еще не зарегестрирован">
    </form>
</div>
</body>
</html>
