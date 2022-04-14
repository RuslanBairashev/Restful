<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course page</title>
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
<h1>Course page</h1>
<table width="1000" border="1" cellpadding="4" cellspacing="0">
    <thead bgcolor="#C0C0C0">
    <tr>
        <th>name</th>
        <th>startDate</th>
        <th>endDate</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td width="25%" align="center">${course[0].getName()}</td>
            <td width="25%" align="center">${course[0].getStartDate()}</td>
            <td width="25%" align="center">${course[0].getEndDate()}</td>
            <td width="25%" align="center">${course[0].getDescription()}</td>
        </tr>
        <br/>
    </tbody>
</table>
<a href="/courses/${course[0].getId()}/edit"}>Edit user</a>
<br/>
<form action="/courses/${course[0].getId()}/delete" method="post">
    <button type="type">Delete course</button>
</form>
</body>
</html>