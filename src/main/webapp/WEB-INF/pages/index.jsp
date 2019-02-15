<%--
  Created by IntelliJ IDEA.
  User: Aqualon
  Date: 10.02.2019
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Блог</title>
	<spring:url value="/resources/img/header-logo.png" var="logoImg" />
	<spring:url value="/resources/img/article-image.png" var="articleImage" />
	<spring:url value="/resources/css/reset.css" var="resetCss" />
	<spring:url value="/resources/css/fonts.css" var="fontsCss" />
	<spring:url value="/resources/css/styles.css" var="stylesCss" />

	<link rel="stylesheet" href="${resetCss}">
	<link rel="stylesheet" href="${fontsCss}">
	<link rel="stylesheet" href="${stylesCss}">
</head>
	<body>
    	<div class="container">
			<header class="main-header">
				<img src="${logoImg}" alt="Логотип UnitBean" class="header-logo">
				<a href="/blog/new-article" class="add-article-btn">Добавить статью</a>
				<h1 class="main-heading">Статьи, 24</h1>
			</header>

			<ul class="article-list">
				<%--Для дебага вёрстки--%>
				<%--
				<li class="article-container">
					<div class="article-content-wrapper">
						<div class="article-header-wrapper">
							<h2 class="article-title">Мобильные приложения в маркетинге</h2>
							<time class="article-date">11 янв. 2017</time>
						</div>
						<p class="article-preview">
							<a href="/blog/article/show-article">Мобильные приложения - мощный инструмент маркетинга. И многочисленные примеры компаний, ведущих бизнес  в различных сферах, подтверждают это</a>
						</p>
					</div>
				</li>
				<li class="article-container">
					<div class="article-content-wrapper">
						<div class="article-header-wrapper">
							<h2 class="article-title">Как сделать интернет-магазин успешным</h2>
							<time class="article-date">11 янв. 2017</time>
						</div>
						<p class="article-preview">
							<a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit ipsam eligendi voluptas saepe labore dignissimos.</a>
						</p>
					</div>
				</li>
				<li class="article-container">
					<div class="article-content-wrapper">
						<div class="article-header-wrapper">
							<h2 class="article-title">Игровые механики и как они могут помочь</h2>
							<time class="article-date">11 янв. 2017</time>
						</div>
						<p class="article-preview">
							<a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur, accusamus. Amet, nesciunt nisi assumenda velit.</a>
						</p>
					</div>
				</li>
				<li class="article-container">
					<div class="article-content-wrapper">
						<div class="article-header-wrapper">
							<h2 class="article-title">Что нового в IOS 10</h2>
							<time class="article-date">11 янв. 2017</time>
						</div>
						<p class="article-preview">
							<a href="/blog/article/show-article">Вчера Крейг Федериги, вице-президент Apple, представил «самое большое» обновление (по его словам) iOS. Новая версия мобильной операционной системы Apple включает совершенно новый экран блокировки, обновленные уведомления, расширенную поддержку 3D Touch и новые инструменты для взаимодействия с приложениями. Заинтригованы? Давайте подробнее.</a>
						</p>
					</div>
				</li>--%>

				<c:forEach items="${articleList }" var="article">
					<li class="article-container">
						<div class="article-content-wrapper">
							<div class="article-header-wrapper">
								<h2 class="article-title">${article.getArticleTitle()}</h2>
								<time class="article-date">${article.getArticleDate()}</time>
							</div>
							<spring:url value = "/article/show-article/${article.get_id()}" var = "articleURL"/>
							<p class="article-preview">
								<a href="${articleURL}">${article.getArticleText()}</a>
							</p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>
