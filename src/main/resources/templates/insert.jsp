<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
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
    日期:<input type="date" name="begindt">- <input type="date" name="enddt">
    预计销售量:<input type="text" name="total" placeholder="please enter ~" >
    状态:<input type="text" name="status" placeholder="please enter ~" >
    <button>添加</button>
</form>



</body>
</html>
