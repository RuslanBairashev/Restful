<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
    <style>
        body {
            font: 11pt Arial, Helvetica, sans-serif; /* Рубленый шрифт текста */
            margin: 0; /* Отступы на странице */
        }
        h1 {
            font-size: 36px; /* Размер шрифта */
            margin: 0; /* Отступы на странице */
        }
    </style>
</head>
<body>
<h1>Edit user</h1>
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
    <tr>
        <td width="25%" align="center">${usr[0].getFirstName()}</td>
        <td width="25%" align="center">${usr[0].getLastName()}</td>
        <td width="25%" align="center">${usr[0].getLogin()}</td>
        <td width="25%" align="center">${usr[0].getUsrRole().getName()}</td>
    </tr>
    </tbody>
</table>
<br/>
<form method="post">
    <input type="text" name="firstName" value=${usr[0].getFirstName()}>
    <input type="text" name="lastName" value=${usr[0].getLastName()}>
    <input type="text" name="login" value=${usr[0].getLogin()}>
    <input type="text" name="password" placeholder="Enter password" required="required">

    <select name="usrRole">
        <#list roles as role>
            <option value="${role}">${role.getName()}</option>
        </#list>
    </select>
    <button type="submit">Edit user</button>
</form>
</body>
</html>