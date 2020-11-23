<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>DemoWebApp</title>
</head>
<body>
<div class="lectureForm">
    <h1>Wyrzuć to z siebie...</h1>
    <form method="POST" name="lectureForm">
        <textarea name="message" cols="80" rows="5"></textarea><br/>
        <input type="submit" value="Dodaj" />
    </form>
</div>
<div class="listTitle">
    <h1>Last lectures</h1>
    <ul class="lectureList">
        <c:forEach items="${lecturList}" var="lecture" >
            <li id="lecture_<c:out value="lecture.id"/>">
                <div class="lectureMessage"><c:out value="${lecture.topic}" /></div>
                <div>
                    <span class="spittleTime"><c:out value="${lecture.time}" /></span>
                </div>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${fn:length(lectureList) gt 20}">
        <hr />
        <s:url value="/lectures?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Pokaż więcej</a>
    </c:if>
</div>
</body>
</html>