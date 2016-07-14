'use strict'
/**
 * Created by taras_000 on 16.06.2016.
 */
var app = angular.module('app',[]);

app.config(['$locationProvider',function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);
/*----------------------------ДИРЕКТИВЫ-------------------------*/
//Добавляем хедер на страницы
app.directive('angHeader', function () {
    return {
      restrict: 'E',
        templateUrl: "../box_header.html"
    };
});

//Добавляем саб меню на страницы
app.directive('angSubmenu', function () {
    return {
        restrict: 'E',
        templateUrl: "../box_submenu.html"
    }
});

//Добавляем футер на страницы
app.directive('angFooter', function () {
    return {
        restrict: 'E',
        templateUrl: "../box_footer.html"
    };
});
/*----------------------------КОНТРОЛЛЕРЫ-------------------------*/
app.controller('headCtrl', function ($rootScope, $scope, incCart) {
    $scope.incCart = incCart;
});

//Передаем JSON массив полученный из сервлета через JSP в Angular (позже разобраться с прямой передачей JSON объектов в Angular)
app.controller('tabCtrl', ['$scope', 'incCart', '$http',function ($scope, incCart, $http) {
    $scope.getRecords = function (tab) {
        $scope.records = tab;
    };

    $scope.incCart = incCart;

    $scope.getColCart = function (t) {
        incCart.setInc(t);
    };

    $scope.dincCart = function (str1,str2) {
      incCart.addCart();
        var str = str1 + '=' + str2;
        $http.get('http://localhost:8080/cart?'+str)
            .success(function (result) {
                console.log('result = ', result);
            })
            .error(function (result) {
                console.log('result = ', result);
            });
    };
}]);

//Вывод данных о конкретном товаре //veshi.jsp (выводит один выбраный товар)
app.controller('veshCtrl', ['$rootScope', '$scope', 'incCart', '$http', function ($rootScope, $scope, incCart, $http) {
    $scope.getRecords = function (tab) {
        $scope.records = tab;
        $rootScope.title_s = $scope.records[0].name;
    };

    $scope.incCart = incCart;

    $scope.getColCart = function (t) {
        incCart.setInc(t);
    };

    $scope.dincCart = function (str1,str2) {
        incCart.addCart();
        var str = str1 + '=' + str2; //Передать строку в параметрах с количеством(к-к-к)
        $http.get('http://localhost:8080/cart?'+str)
            .success(function (result) {
                console.log('result = ', result);
            })
            .error(function (result) {
                console.log('result = ', result);
            });
    };
}]);

app.controller('cartCtrl', ['$scope', 'incCart', '$http', function ($scope, incCart, $http) {
    var f = 0;
    $scope.a_cart = [];
    $scope.i_cart = [];
    $scope.incCart = incCart;

    $scope.getRecords = function (tab) {
        $scope.records = tab;
        if(f == 0){
            console.log('f mi tyt = ', f);
             for (var i=0; i <$scope.records.length; i++){
             $scope.a_cart.push({str: "1"});
             }
             console.log('GetRecords a_cart',$scope.a_cart);
        }
        f++;
    };
   
    $scope.getItog = function () {
        var itog = 0;
        for (var i=0; i <$scope.a_cart.length; i++){
             itog = itog + $scope.a_cart[i].str * $scope.records[i].cost;
        }
        return itog;
    };

    $scope.getColCart = function (t) {
        incCart.setInc(t);
    };

    $scope.sendMail = function () {
        $http.get('http://localhost:8080/email?mail=' + $scope.podpis_mail + '&type=zacaz')
            .success(function (result) {
                console.log('result = ', result);
            })
            .error(function (result) {
                console.log('result = ', result);
            });
    };
    
    $scope.sumCart = function (a,b) {
        var c = $scope.a_cart[b].str;
        return a*c;
    };

}]);

app.controller('footCtrl',function ($scope, $http) {
    $scope.sendMail = function () {
        $http.get('http://localhost:8080/email?mail=' + $scope.podpis_mail + '&type=podpiska')
            .success(function (result) {
                console.log('result = ', result);
            })
            .error(function (result) {
                console.log('result = ', result);
            });
    };
});
/*----------------------------ФАБРИКИ-------------------------*/
//Фабрика для инкримента корзины
app.factory('incCart',function () {
    var inc = 0;
    return {
      addCart: function () {
          inc++;
      },
      getInc: function () {
          return inc;
      },
      setInc: function (tex) {
          if (tex > inc){inc=tex;}
      }
    };
});

/*----------------------------ФИЛЬТРЫ-------------------------*/
app.filter('filmoney', function () {
    return function (str) {
        return str = str + " руб.";
    };
});

app.filter('iCart', function () {
    return function (str) {
            if(str == '0'){
                return '';
            }else{
                return str;        
            }
    };
});

app.filter('lenFil', function () {
    return function (str) {
        if(str == '70'){
            return '370';
        }else{
            return str;
        }
    };
});
app.filter('len2Fil', function () {
    return function (str) {
        for (var i = 1; i <10; i++){
            if((str - 4*i) <= 0){
                str=550*i;
                return str;
            }
        }
    };
});

