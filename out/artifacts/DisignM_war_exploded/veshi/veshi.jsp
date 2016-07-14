<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCUMENT html>
<html lang="en" xmlns="http://www.w3.org/1999/html" ng-app='app'>
<head>
    <base href="/"/>
    <meta charset="UTF-8">
    <title>{{title_s}}</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="js/sh_header.js"></script>
    <script src="../js/angular.min.js"></script>
    <script src="js/main.js" type="text/javascript"></script>

</head>
<body>
<ang-header></ang-header>
<!--***********************************************************************************************************-->
<ang-submenu></ang-submenu>
<!--***********************************************************************************************************-->
<div ng-controller="veshCtrl">
    {{getRecords(${ojson})}}
    {{getColCart(${chcart})}}
    <div ng-repeat="rec in records">
        <div id="tab_veshi">
            <div id="tab_veshi_col1">
                <div id="tvc2_img" style="background: url('{{rec.link}}') center center no-repeat">

                </div>
            </div>
            <div  id="tab_veshi_col2">

                <div id="tvc2_name">
                    {{rec.name}}
                </div>
                <div id="tvc2_type">
                    {{rec.type}}
                </div>
                <div id="tvc2_cost">
                    {{rec.cost | filmoney}}
                </div>
                <div id="tvc2_discr">
                    {{rec.discribe}}
                </div>
                <div id="tvc2_bord">

                </div>
                <div id="tvc2_size">
                    <span class="v_span">Размер:</span> {{rec.size}}
                </div>
                <div id="tvc2_color">
                    <span class="v_span">Цвет:</span> <div style="width: 40px; height: 24px; background:{{rec.color}}; margin-left: 5px;"></div>
                </div>
                <div id="tvc2_quant">
                    <span class="v_span">Количество:</span> {{rec.quantity}} шт.
                </div>
                <div id="tvc2_likecart">
                    <div id="tvc2_like">
                        <button class="btn-invisible">
                            <div id="tvc2_like_v">
                                <span>&#x2665;</span>
                            </div>
                        </button>
                    </div>
                    <div id="tvc2_cart">
                        <button class="btn-invisible" ng-click="dincCart(rec.type_v,rec.id)">
                            <div id="tvc2_cart_v">
                                <span id="tvc2_cart_v_span">Добавить в корзину</span> &rarr;
                            </div>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--***********************************************************************************************************-->
<ang-footer></ang-footer>
</body>
</html>