<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
</head>
<body>
<form action="insert" method="post">
    <input type="hidden" name="id"  >
    名称:<input type="text" name="name" placeholder="please enter ~" >
    描述:<input type="text" name="descripton" placeholder="please enter ~" >
    日期:<input type="date" name="begindt">- <input type="date" name="enddt">
    预计销售量:<input type="text" name="total" placeholder="please enter ~" >
    状态:<input type="text" name="status" placeholder="please enter ~" >
    <c:forEach items="${pros}" var="li" >
            <c:choose>
                <c:when test="${fn:contains(ids, li.id)}">
                    <input type="checkbox" name="ids" value="${li.id}" >
                </c:when>
                <c:otherwise>
                    <input type="checkbox" checked="checked" name="ids" value="${li.id}" >
                </c:otherwise>
            </c:choose>
    </c:forEach>
    <button>修改</button>
</form>



</body>
</html>
