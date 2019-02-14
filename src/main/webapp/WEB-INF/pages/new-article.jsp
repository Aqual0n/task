<%--
  Created by IntelliJ IDEA.
  User: Aqualon
  Date: 14.02.2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Добавление статьи</title>
    <spring:url value="/resources/css/reset.css" var="resetCss" />
    <spring:url value="/resources/css/fonts.css" var="fontsCss" />
    <spring:url value="/resources/css/styles.css" var="stylesCss" />

    <link rel="stylesheet" href="${resetCss}">
    <link rel="stylesheet" href="${fontsCss}">
    <link rel="stylesheet" href="${stylesCss}">
</head>
    <body>
        <div class="container">
            <h1 class="add-article-title">Добавление статьи</h1>

            <form action="/blog/new-article/add" class="add-article-form" method="post">
                <label for="new-article-title">Заголовок</label>
                <input type="text" id="new-article-title" name="articleTitle" class="text-input new-article-title">

                <label for="new-article-text">Текст статьи</label>
                <textarea name="articleText" id="new-article-text" cols="30" rows="10" class="text-input new-article-text"></textarea>
                <div class="form-footer">
                    <label>
                        <input type="file" class="visually-hidden" name="articleImage" id="upload-file">
                        <span class="article-image-file new-article-btn"></span>
                    </label>

                    <a href="/blog" class="cancel-btn new-article-btn">Отмена</a>
                    <button class="submit-article-btn new-article-btn" type="submit">Добавить</button>
                </div>
            </form>
        </div>
    </body>
</html>
