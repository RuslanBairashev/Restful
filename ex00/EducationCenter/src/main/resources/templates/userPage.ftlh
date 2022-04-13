<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User page</title>
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
<h1>User page</h1>
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
        <br/>
    </tbody>
</table>
<a href="/users/${usr[0].getId()}/edit"}>Edit user</a>
<br/>
<a href="/users/${usr[0].getId()}/delete"}>Delete user</a>
<br/>

</body>
</html>