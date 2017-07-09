<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%

    String path = request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<body>
<h2>Springmvc自定义converter</h2>
<h3>输入格式为#####-#####</h3>
product:<input id="product" type="text" name="product">
<input type="button" onclick="req();"/>
<div id="resp"></div>
<%--<form action="/mvc/test" method="post">
    <!--    private String name;
    private String description;
    private Float price;
    private Date productionDate;  -->
    <!--格式:java-javabase-12.0-2011.12.12  -->
    product:<input type="text" name="product">
    <input type="submit" value="submit">

</form>--%>
</body>


<script type="text/javascript" src="<%=basePath%>static/assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript">

    function req() {
        $.ajax({
            url: "/mvc/test",
            data: {product:$("#product").val()},
            type: "POST",
               contentType: "application/x-www-form-urlencoded",
            success: function(data){
                $("#resp").append("<h3>" + data + "</h3>");
            }
        });
    }
</script>
</html>
