<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>添加</title>
</head>
<body>
<form action="insert" method="post">
    名称:<input type="text" name="name" placeholder="please enter ~" >
    描述:<input type="text" name="descripton" placeholder="please enter ~" >
    日期:<input type="date" >- <input type="date">
    预计销售量:<input type="text" name="total" placeholder="please enter ~" >
    状态:<input type="text" name="status" placeholder="please enter ~"  >
    <c:forEach items="${pros}" var="li" >
        <input type="checkbox" name="ids" id="idd" value="${li.id}" >
        <label for="idd" >${li.name}</label>
    </c:forEach>

    <button>添加</button>
</form>



</body>
</html>
