<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lesson page</title>
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
<h1>Lesson page</h1>
<table width="1000" border="1" cellpadding="4" cellspacing="0">
    <thead bgcolor="#C0C0C0">
    <tr>
        <th>name</th>
        <th>startTime</th>
        <th>endTime</th>
        <th>dayOfWeek</th>
        <th>teacher</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td width="20%" align="center">${lesson[0].name}</td>
            <td width="20%" align="center">${lesson[0].startTime}</td>
            <td width="20%" align="center">${lesson[0].endTime}</td>
            <td width="20%" align="center">${lesson[0].dayOfWeek}</td>
            <td width="20%" align="center">${lesson[0].teacher.getFirstName()} ${lesson[0].teacher.getLastName()}</td>
        </tr>
        <br/>
    </tbody>
</table>
<br/>
<form method="post">
    <input type="text" name="name" placeholder="Enter name">
    <input type="time" name="startTime" placeholder="Enter startTime">
    <input type="time" name="endTime" placeholder="Enter endTime">

    <select name="dayOfWeek">
        <#list days as dayOfWeek>
            <option value="${dayOfWeek}">${dayOfWeek}</option>
        </#list>
    </select>
    <select name="teacher" >
        <#list teachers as teacher>
            <option value="${teacher.getId()}">${teacher.getFirstName()}, ${teacher.getLastName()}</option>
        </#list>
    </select>
    <button type="submit">Update lesson</button>
</form>
<br/>
<form action="/courses/${lesson[0].getCourse().getId()}/delete/${lesson[0].id}" method="post">
    <button type="type">Delete lesson</button>
</form>
</body>
</html>