<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh_CN">
<script type="jscript" src="/js/jquery-3.2.1.js" ></script>
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <script src="" type="jscript"></script>
</head>
<body>
<form action="/list" method="post">
    <input type="text" name="name" placeholder="please enter ~" >
    <input type="date" name="begindt">
    <input type="date" name="enddt">
    <button>查询</button>
</form>
<button ><a href="/toinsert">添加</a></button>
<button id="ps" >批量删除</button>
<table>
    <tr>
        <td>
            <input type="checkbox" class="Chi" >
        </td>
        <td>名称</td>
        <td>descr</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <td>总数</td>
        <td>状态</td>
        <td>活动名称</td>
    </tr>
    <c:forEach items="${pageinfo.list}" var="li" >
        <tr>
            <td>
            <input type="checkbox" class="Chied" value="${li.id}" >
            </td>
            <td>${li.name}</td>
            <td>${li.descripton}</td>
            <td>
                <fmt:formatDate value="${li.begindt}" timeStyle="yyyy-MM-dd" ></fmt:formatDate>
            </td>
            <td>
                <fmt:formatDate value="${li.enddt}" timeStyle="yyyy-MM-dd" ></fmt:formatDate>
            </td>
            <td>${li.total}</td>
            <td>${li.status}</td>
            <td>${li.proname}</td>
            <td>
                <a href="/toupdate?id=${li.id}">修改</a>
                <a href="/delete?ids=${li.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
<a href="/list?PageNum=${pageinfo.prePage}" >上一页</a>
<a href="/list?PageNum=${pageinfo.nextPage}" >下一页</a>

</body>
<script>
    $(".Chi").click(function () {
        $(".Chied").attr("checked",$(this).prop("checked"));
    });
    $("#ps").click(function(){
        var  id=[];
        $(".Chied").each(function(){
            id.push($(this).val())
        });
        shan(id);
    });
    function shan(id){
        $.post(
            "delete?ids="+id,{},function (data) {
                location.href="list";
            },"json"
        );
    }



</script>
</html>
