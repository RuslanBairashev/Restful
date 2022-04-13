<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of users</title>
    <style>
        body {
            font: 11pt Arial, Helvetica, sans-serif; /* Рубленый шрифт текста */
            margin: 0; /* Отступы на странице */
        }
        h1 {
            font-size: 36px; /* Размер шрифта */
            margin: 0; /* Отступы на странице */
        }
        h2 {
            margin-top: 0; /* Убираем отступ сверху */
        }
        #container {
            width: 1000px; /* Ширина слоя */
            margin: 0 auto; /* Выравнивание по центру */
        }
        #sidebar { /* Левая колонка */
            float: left; /* Обтекание справа */
            width: 300px; /* Ширина колонки */
            padding: 5px; /* Поля вокруг текста */
        }
        #content { /* Правая колонка */
            margin: 10px 5px 20px 310px; /* Значения отступов */
            padding: 5px; /* Поля вокруг текста */
        }
        #footer { /* Нижний блок */
            width: 1000px; /* Ширина слоя */
        }
    </style>
</head>
<body>
<h1>List of users</h1>
<table width="1000" border="1" cellpadding="4" cellspacing="0">
    <thead bgcolor="#C0C0C0">
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>login</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <#list users as usr>
        <tr >
            <td width="25%" align="center">${usr.firstName}</td>
            <td width="25%" align="center">${usr.lastName}</td>
            <td width="25%" align="center">${usr.login}</td>
            <td width="25%" align="center">${usr.usrRole.getName()}</td>
        </tr>
    </#list>
    </tbody>
</table>
<br/>
<form method="post">
    <input type="text" name="firstName" placeholder="Enter firstname">
    <input type="text" name="lastName" placeholder="Enter lastname">
    <input type="text" name="login" placeholder="Enter login">
    <input type="text" name="password" placeholder="Enter password">

    <select name="usrRole">
        <#list roles as role>
            <option value="${role}">${role.getName()}</option>
        </#list>
    </select>
    <button type="submit">Add user</button>
</form>
</body>
</html>