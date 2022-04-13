<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of lessons</title>
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
<h1>List of lessons</h1>
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
    <#list lessons as lesson>
        <tr >
            <td width="20%" align="center">${lesson.name}</td>
            <td width="20%" align="center">${lesson.startTime}</td>
            <td width="20%" align="center">${lesson.endTime}</td>
            <td width="20%" align="center">${lesson.dayOfWeek}</td>
            <td width="20%" align="center">${lesson.teacher.getFirstName()} ${lesson.teacher.getLastName()}</td>
        </tr>
    </#list>
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
    <button type="submit">Add course</button>
</form>
</body>
</html>