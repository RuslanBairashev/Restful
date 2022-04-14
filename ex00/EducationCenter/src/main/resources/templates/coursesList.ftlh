<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of courses</title>
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
<h1>List of courses</h1>
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
    <#list courses as course>
        <tr >
            <td width="25%" align="center">
                <a href="/courses/${course.id}">${course.name}</a>
            </td>
            <td width="25%" align="center">${course.startDate}</td>
            <td width="25%" align="center">${course.endDate}</td>
            <td width="25%" align="center">${course.description}</td>
        </tr>
    </#list>
    </tbody>
</table>
<br/>
<form method="post">
    <input type="text" name="name" placeholder="Enter name">
    <input type="date" name="startDate" placeholder="Enter startDate">
    <input type="date" name="endDate" placeholder="Enter endDate">
    <input type="text" name="description" placeholder="Enter description">
    <button type="submit">Add course</button>
</form>
</body>
</html>