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
    <div class="quiz-option">
        <p><c:out value="${question.text}"/></p>

        <c:set var="isImage" value="${quiz.isImage}"/>
        <c:set var="correctAnswer" value="${question.correctAnswer}"/>

        <c:if test="${isImage == false}">
            <c:forEach var="answer" items="${question.answers}" varStatus="status">
                <input type="radio" id="answer${status.index}" name="answer" value="${answer}">
                <label for="answer${status.index}">${answer}</label><br>
            </c:forEach>
        </c:if>

        <c:if test="${isImage == true}">
            <c:forEach var="answer" items="${question.answers}" varStatus="status">
                <input type="radio" id="answer${status.index}" name="answer" value="${answer}">
                <label for="answer${status.index}"><img src="${answer}" alt="answer${status.index}" width="100"
                                                        height="100"></label>
            </c:forEach>
        </c:if>

    </div>
    <div>
        <button onclick="redirectToPage(getQuestionURI())" class="btn">Вибрати</button>
    </div>

    <script>
        function getQuestionURI() {
            const index = getSelectedAnswerId();
            console.log('Selected Question ID:', index);

            let s = "/quizQuestions?answerIndex=" + index;
            console.log(s);
            return index !== undefined ? s : null;
        }

        function getSelectedAnswerId() {
            const options = document.querySelectorAll('input[name="answer"]');
            let selectedIndex;

            for (const option of options) {
                if (option.checked) {
                    selectedIndex = option.id.replace('answer', '');
                    break;
                }
            }
            console.log('getSelectedAnswerId result:', selectedIndex);
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
</div>
</body>
</html>
