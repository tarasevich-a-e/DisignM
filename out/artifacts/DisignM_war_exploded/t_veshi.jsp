<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCUMENT html>
<html lang="en" xmlns="http://www.w3.org/1999/html" ng-app='app'>
<head>
    <base href="/"/>
    <meta charset="UTF-8">
    <title>Bruki</title>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/script_bruki.js"></script>
    <script type="text/javascript" src="js/sh_header.js"></script>
    <script src="js/angular.min.js"></script>
    <script src="js/main.js" type="text/javascript"></script>
</head>
<body>

<ang-header></ang-header>

<!--***********************************************************************************************************-->
<ang-submenu></ang-submenu>
<!--***********************************************************************************************************-->
<!--Dinamic block-->
<form action="/veshi/" method="get" id="f_veshi_id"></form>
<div class="tovar" ng-controller="tabCtrl">
    {{getRecords(${ojson})}}
    {{getColCart(${chcart})}}
    <div class="tovar_v" style="height: {{records.length | len2Fil}}px">
        <div class="tovar_opis" ng-repeat="record in records">
            <button name="{{record.type_v}}" form="f_veshi_id" value="{{record.id}}" class="btn-invisible">
                <div class="t_image {{record.type_v}}{{record.id}}" style="background: url('{{record.link}}') 100% 100% no-repeat"><div class="t_effect"></div></div>

            </button>
            <!--button name="{{record.type_v}}" form="f_veshi_id" value="{{record.id}}" style="height: 20px; width: 50px;"></button-->
            <div class="t_name">{{record.name}}</div>
            <div class="t_type">{{record.type}}</div>
            <div class="t_cost">{{record.cost | filmoney}}</div>
            <div id="t_add_cart">
                <button class="btn-invisible" ng-click="dincCart(record.type_v,record.id)">
                    <div id="t_add_cart_v"><!--Korr css-->
                        <span id="t_add_cart_v_span">Добавить в 🏀</span>
                    </div>
                </button>
            </div>
        </div>
    </div>
</div>

<!--***********************************************************************************************************-->
<ang-footer></ang-footer>

</body>
</html>