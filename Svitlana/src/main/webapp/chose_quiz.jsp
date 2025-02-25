<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Тест</title>
    <link rel="stylesheet" href="css/style.css">
<%--    <script src="js/script.js"></script>--%>

</head>
<body>
<div class="container">
    <div class="quiz-option">
    <c:forEach var="quiz" items="${quizzes}" varStatus="status">
        <input type="radio" id="quiz${status.index}" name ="quiz" value="${quiz.name}">
        <label for="quiz${status.index}">${quiz.name}</label><br>
    </c:forEach>
    </div>
    <div>
        <input type="hidden" id="quizIndex" value="${index}">
        <button onclick="redirectToPage(getQuizURI())" class="btn">Вибрати</button>
    </div>

</div>

<script>
    function getQuizURI() {
        const index = getSelectedQuizId();
        console.log('Selected Quiz ID:', index);
        let s = "/quiz?index=" + index;
        console.log(s);
        return index !== undefined ? s : null;
    }

    function getSelectedQuizId() {
        const options = document.querySelectorAll('input[name="quiz"]');
        let selectedIndex;

        for (const option of options) {
            if (option.checked) {
                selectedIndex = option.id.replace('quiz', '');
                break;
            }
        }
        console.log('getSelectedQuizId result:', selectedIndex);
        return selectedIndex;
    }

    function redirectToPage(pageUrl) {
        if (pageUrl !== null) {
            window.location.href = pageUrl;
        } else {
            alert("Link error.");
        }
    }
</script>
</body>
</html>