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
            <td width="25%" align="center">
                <a href="/users/${usr.id}">${usr.login}</a>
            </td>
            <td width="25%" align="center">${usr.usrRole.getName()}</td>
        </tr>
    </#list>
    </tbody>
</table>
<br/>
<form method="post">
    <select name="usr">
        <#list users as usr>
            <option value="${usr}">${usr.getFirstName()} ${usr.getLastName()}</option>
        </#list>
    </select>
    <button type="submit">Add user to course</button>
</form>
</body>
</html>