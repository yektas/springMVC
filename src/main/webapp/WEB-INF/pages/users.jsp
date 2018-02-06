<%--
  Created by IntelliJ IDEA.
  User: sercanyektas
  Date: 22.11.2017
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        Highcharts.chart('container1', {
            chart: {
                zoomType: 'x'
            },
            title: {
                text: 'Memory Usage'
            },
            subtitle: {
                text: document.ontouchstart === undefined ?
                    'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            },
            xAxis: {
                type: 'datetime',
                labels: {
                    formatter: function () {
                        return moment(this.value).format("YYYY-MM-DD");
                    }
                }

            },
            yAxis: {
                title: {
                    text: 'Memory_MB',

                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 5
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },

            series: [{
                type: 'area',
                name: 'Memory',
                data: pushedArray

            }]
        });
    </script>
</head>
<body>

<div id="networkUsage" class="col-md-4">
    <div id="container1"></div>
</div>


<p>${user.name}</p>
<p>${user.email}</p>
<p>${user.password}</p>
<p>${user.registerDate}</p>


<!--
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.kullanici_id}</td>
            <td>${user.ad_soyad}</td>
            <td>${user.email}</td>
            <td>${user.sifre}</td>
        </tr>
    </c:forEach>
</table>
-->
</body>
</html>
<%@ page isELIgnored="false" %>