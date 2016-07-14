<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCUMENT html>
<html lang="en" xmlns="http://www.w3.org/1999/html" ng-app='app'>
<head>
    <base href="/"/>
    <meta charset="UTF-8">
    <title>Ваша корзина</title>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
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
<div id="c_veshi" ng-controller="cartCtrl">
    {{getRecords(${ojson})}}
    {{getColCart(${chcart})}}
    <div id="c_veshi_vv" style="height: {{70+300*records.length | lenFil}}px">
        <table id="t_cart">
            <tr>
                <td class="t_cart_zagolovok" id="t_cart_col1">Товар</td>
                <td class="t_cart_zagolovok">Наименование</td>
                <td class="t_cart_zagolovok">Количество</td>
                <td class="t_cart_zagolovok">Цена</td>
                <td class="t_cart_zagolovok">Сумма</td>
            </tr>
            <tr ng-repeat="record in records track by $index" class="t_div_rec">
                <td>
                    <div class="t_d_img" style="background: url('{{record.link}}') center center no-repeat"></div>
                </td>
                <td class="cl_td">
                    <div class="t_d_name">{{record.name}}</div>
                    <div class="t_d_type">{{record.type}}</div>
                    <div class="t_d_size">{{record.size}}</div>
                </td>
                <td class="cl_td">
                    <div class="t_d_input">
                        <input type="number" placeholder="1" class="t_d_input_i" ng-model="a_cart[$index].str"> шт.
                    </div>
                </td>
                <td class="cl_td">
                    <div class="t_d_cost">{{record.cost | filmoney}}</div>
                </td>
                <td class="cl_td">
                    <div class="t_d_total">{{sumCart(record.cost,$index) | filmoney}}</div>
                </td>
            </tr>
        </table>
    </div>
    <div id="c_veshi_vv_itog">
        <div id="c_veshi_vv_itog_n">Итого</div>
        <div id="c_veshi_vv_itog_t">{{getItog() | filmoney}}</div>
        <div id="c_veshi_vv_itog_divin">
            <span>Ваш e-mail:</span>
            <input id="c_veshi_vv_itog_tex" type="text" ng-model="podpis_mail">
            <button id="c_veshi_vv_itog_but" ng-click="sendMail()">Заказать &rarr;</button>
        </div>
    </div>
</div>
<!--***********************************************************************************************************-->
<ang-footer></ang-footer>

</body>
</html>
