<%--
  Created by IntelliJ IDEA.
  User: sercanyektas
  Date: 4.12.2017
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.src.js"></script>
</head>
<body>
<form id="myForm">
    <input type="text" name="selected_date" id="datepicker"/>

    <button class="btn" type="submit"> SUBMIT</button>
</form>
YOU SELECTED THIS DATE AND TIME;
Date: <p id="myDate"></p>
Time: <p id="myTime"></p>


<script>

    $(document).ready(function () {
        var valid_date;
        var valid_time;
        var myData = {};
        $("#datepicker").datepicker({
            dateFormat: "dd/mm/yy"
        });
        $("#datepicker").change(function () {
            moment.locale();
            var date = $(this).datepicker("getDate", $(this).val());
            valid_date = moment(date).format('L');
            valid_time = moment(date).format('h:mm:ss');
        });
        $("#myForm").submit(function (e) {

            var url = window.location.protocol + "//" + window.location.host + "/deneme/test-post";
            myData["date"] = valid_date;
            myData["time"] = valid_time;
            $.ajax({
                type: "POST",
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                url: url,
                data: JSON.stringify(myData),
                success: function (data) {

                    console.log(data.date);
                    $("#myDate").html(data["date"]);
                    $("#myTime").html(data["time"]);

                }

            });

            e.preventDefault(); // avoid to execute the actual submit of the form.
        });

    });


</script>
</body>
</html>
<%@ page isELIgnored="false" %>