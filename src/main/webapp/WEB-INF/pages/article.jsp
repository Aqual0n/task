<%--
  Created by IntelliJ IDEA.
  User: Aqualon
  Date: 11.02.2019
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

    <spring:url value="/resources/img/author-avatar.png" var="authorAva" />
    <spring:url value="/resources/img/article-image.png" var="articleImage" />
    <spring:url value="/resources/css/reset.css" var="resetCss" />
    <spring:url value="/resources/css/fonts.css" var="fontsCss" />
    <spring:url value="/resources/css/styles.css" var="stylesCss" />

    <link rel="stylesheet" href="${resetCss}">
    <link rel="stylesheet" href="${fontsCss}">
    <link rel="stylesheet" href="${stylesCss}">
</head>
<body class="article-body">
    <div class="container">
        <h1 class="main-article-title">${articleToJsp.getArticleTitle()}</h1>

        <img class="article-image" src="${articleImage}" alt="Изображение к статье">

        <div class="article-text-wrapper">
            <p class="article-paragraph">${articleToJsp.getArticleText()}</p>

            <%--<p class="article-paragraph">Вчера Крейг Федериги, вице-президент Apple, представил «самое большое» обновление (по его словам) iOS. Новая версия мобильной операционной системы Apple включает совершенно новый экран блокировки, обновленные уведомления, расширенную поддержку 3D Touch и новые инструменты для взаимодействия с приложениями. Заинтригованы? Давайте подробнее.</p>--%>
            <%--<p class="article-paragraph">Появилась возможность совершать действия с уведомлениями прямо на данном экране при помощи 3D Touch, кнопка «очистить все уведомления» и другие возможности.</p>--%>
            <%--<p class="article-paragraph">Удивительные изменения претерпел поиск Spotlight. Здесь теперь не только предложения Siri и результаты поиска, но и другая полезная информация: результаты матчей, ваш календарь, погода и даже воспроизведение видео!</p>--%>
            <%--<p class="article-paragraph">Самое главное нововведение — это, пожалуй, открытое API Siri для сторонних разработчиков. Теперь пользователи смогут общаться с голосовым ассистентом как с человеком: например, «открой мне последнюю статью на AppleInsider.ru», вызови такси при помощи «Таксика», «напиши в Slack генеральному директору» и так далее.</p>--%>
            <%--<p class="article-paragraph">Как заявил Федериги, Apple «привносит интеллект Siri в клавиатуру» — новая функция QuickType станет настоящей находкой для тех, кто любит початиться. Прямо здесь контактная информация, текущая локация, календарь, последние адреса.</p>--%>
        </div>

        <form action="/blog/article/add-comment" method="get" class="commentary-form">
            <img class="author-avatar current-commentator" src="${authorAva}" alt="Аватарка автора">
            <input type="text" class="commentary-textarea author-field" name="authorName" placeholder="Ваше имя">
            <textarea class="commentary-textarea" name="commentText" placeholder="Ваш комментарий" cols="30" rows="10"></textarea>
            <button class="submit-commentary-btn" type="submit"></button>
        </form>

        <%--<spring:form modelAttribute="commentFromServer" method="post" action="/blog/article/add-comment">--%>
            <%--<spring:input path="authorName"/>--%>
            <%--<spring:input path="commentaryText"/>--%>
            <%--<spring:button>Отправить комментарий</spring:button>--%>
        <%--</spring:form>--%>

        <div class="commentary-wrapper">
            <img src="${authorAva}" alt="Аватарка автора" class="author-avatar">
            <div class="commentary-content-wrapper">
                <span class="author">ZelectricDOG</span>
                <time class="commentary-date">13 июня 2016</time>
                <p class="commentary-text">А вообще на андроид похоже</p>
            </div>
        </div>
        <div class="commentary-wrapper">
            <img src="${authorAva}" alt="Аватарка автора" class="author-avatar">
            <div class="commentary-content-wrapper">
                <span class="author">Den4ik7755</span>
                <time class="commentary-date">13 июня 2016</time>
                <p class="commentary-text">Какие устройства будут поддерживать обновление?</p>
            </div>
        </div>

        <c:forEach items="${commentList }" var="comment">
            <div class="commentary-wrapper">
                <img src="${authorAva}" alt="Аватарка автора" class="author-avatar">
                <div class="commentary-content-wrapper">
                    <span class="author">${comment.getAuthorName()}</span>
                    <time class="commentary-date">${comment.getCommentDate()}</time>
                    <p class="commentary-text">${comment.getCommentText()}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
