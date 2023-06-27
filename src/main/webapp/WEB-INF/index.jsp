<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Новини</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <h1>Новини</h1>
                    <h2>${date}</h2>
                </div>
            </div>
            <hr />
            <div class="row">
                <c:forEach items="${page.content}" var="news">
                    <div class="col-md-4">
                        <h3>${news.title}</h3>
                        <div>${news.content}</div>
                    </div>
                </c:forEach>
            </div>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="?page=${previousPage.pageNumber}">Предишна</a></li>
                <c:forEach var="page" begin="1" end="${page.totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${page}">${page}</a>
                    </li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="?page=${nextPage.pageNumber}">Следваща</a></li>
            </ul>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>