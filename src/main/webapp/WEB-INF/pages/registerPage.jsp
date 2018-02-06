<%--
  Created by IntelliJ IDEA.
  User: sercanyektas
  Date: 21.11.2017
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.src.js"></script>

    <script>
        $(document).ready(function () {
            $("#datePicker").datepicker();
        });
    </script>
</head>


<body>

<h3> testing </h3>

<!--
<form action="/deneme/register" method="post">
    <div class="form-group">
    <input type="text" class="form-control" placeholder="Ad-soyad" name="ad_soyad">
    <input type="text" class="form-control" placeholder="E-mail" name="email">
    <input type="password" class="form-control" placeholder="Şifre" name="sifre">
    <button type="submit"> Kayıt ol</button>
    </div>
</form>
-->

<form action="/deneme/mongo-register" method="post">
    <div class="form-group">
        <input type="text" class="form-control" placeholder="Ad-soyad" name="name">
        <input type="text" class="form-control" placeholder="E-mail" name="email">
        <input type="password" class="form-control" placeholder="Şifre" name="password">
        <p>Date: <input type="text" id="datePicker" name="registerDate"></p>
        <button class="btn btn-primary" type="submit"> Kayıt ol</button>
    </div>
</form>


</body>
</html>
<%@ page isELIgnored="false" %>
