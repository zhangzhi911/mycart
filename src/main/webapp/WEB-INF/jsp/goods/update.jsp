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
<form action="update" method="post">
    <input type="hidden" name="id"  value="${activity.id}" >
    名称:<input type="text" name="name" placeholder="${activity.name}" value="${activity.name}" >
    描述:<input type="text" name="descripton" placeholder="${activity.descripton}" value="${activity.descripton}" >
   <%--日期:<input type="date" >- <input type="date">--%>
    预计销售量:<input type="text" name="total" placeholder="${activity.total}" value="${activity.total}" >
    状态:<input type="text" name="status" placeholder="${activity.status}"  value="${activity.status}" >
    <c:forEach items="${pros}" var="li" >
            <c:choose>
                <c:when test="${fn:contains(ids, li.id)}">
                    <input type="checkbox" name="ids" id="idd" value="${li.id}" >
                    <label for="idd" >${li.name}</label>
                </c:when>
                <c:otherwise>
                    <input type="checkbox" checked="checked" name="ids" id="idd" value="${li.id}" >
                    <label for="idd" >${li.name}</label>
                </c:otherwise>
            </c:choose>
    </c:forEach>
    <button>修改</button>
</form>



</body>
</html>
