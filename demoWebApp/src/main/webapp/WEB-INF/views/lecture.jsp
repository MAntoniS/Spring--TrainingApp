<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          >
</head>
<body>
<div class="lectureView">
    <div class="lectureMessage"><c:out value="${spittle.message}" /></div>
    <div>
        <span class="lectureTime"><c:out value="${spittle.time}" /></span>
    </div>
</div>
</body>
</html>