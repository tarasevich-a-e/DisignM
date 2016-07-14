<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCUMENT html>
<html lang="en" xmlns="http://www.w3.org/1999/html" ng-app='app'>
<head>
    <base href="/"/>
    <meta charset="UTF-8">
    <title>INDEX</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>
    <script type="text/javascript" src="js/sh_header.js"></script>
    <script src="js/angular.min.js"></script>
    <script src="js/main.js" type="text/javascript"></script>

</head>
<body>
<ang-header></ang-header>

<!--***********************************************************************************************************-->
<a name="magazin"></a>
<form action="/veshi" method="get" id="f_veshi"></form>
<div class="dbody">
    <div class="img">
        <div class="str123">

            <button form="f_veshi" value="on" class="btn-invisible" name="t_bruki">
                <div id="pic1">
                    <span class="nadpis_span">Брюки</span>
                    <div id="pic1f" class="effect">
                    </div>
                </div>
            </button>

            <button form="f_veshi" value="on" class="btn-invisible" id="btn-3" name="t_kofti">
                <div id="pic3">
                    <span class="nadpis_span">Кофты</span>
                    <div id="pic3f" class="effect">
                    </div>
                </div>
            </button>
            <button form="f_veshi" value="on" class="btn-invisible" id="btn-4" name="t_majki">
                <div id="pic4">
                    <span class="nadpis_span">Майки</span>
                    <div id="pic4f" class="effect">
                    </div>
                </div>
            </button>
        </div>
        <div class="str4">
            <button form="f_veshi" value="on" class="btn-invisible" name="t_svitshot">
                <div id="pic2">
                    <span class="nadpis_span">Свитшоты</span>
                    <div id="pic2f" class="effect">
                    </div>
                </div>
            </button>
        </div>
    </div>
</div>
<a name="o_sebe"></a>
<!--***********************************************************************************************************-->
<ang-footer></ang-footer>

</body>
</html>