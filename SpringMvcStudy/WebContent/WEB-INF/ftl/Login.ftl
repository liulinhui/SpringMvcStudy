<!DOCTYPE HTML>
<html>
<head>
<title>登陆页面</title>
<link rel="stylesheet" type="text/css" href="resource/css/main.css"/>
</head>
<body>

<div id="global">
<form commandName="product" action="login" method="post">
    <fieldset>
        <legend>用户信息</legend>
        <p>
            <label for="name">用户名: </label>
            <input id="name" path="name" name="name"/>
        </p>
        <p>
            <label for="password">密码: </label>
            <input id="password" path="password" name="password"/>
        </p>

        <p id="buttons">
            <input id="reset" type="reset" value="重置">
            <input id="submit" type="submit" value="登陆">
        </p>
    </fieldset>
</form>
</div>
</body>
</html>
