<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Тест</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h3><c:out value="${quiz.name}"/> </h3>
    <p><c:out value="${quiz.description}"/> </p>

    <div>
        <button onclick="redirectToPage('/quizQuestions')" class="btn">Почати</button>
    </div>

    <div class="quiz-button">

    </div>

</div>


</body>
</html>