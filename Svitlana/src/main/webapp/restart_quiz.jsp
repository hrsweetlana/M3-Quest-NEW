<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Тест</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/script.js"></script>

</head>
<body>
<div class="container">
    <p>Ви успішно завершили тест!</p>
    <p>Кількість помилок : <c:out value="${counter}"/> </p>
    <button onclick="redirectToPage('/start')" class="btn">Меню</button>
</div>
</body>
</html>