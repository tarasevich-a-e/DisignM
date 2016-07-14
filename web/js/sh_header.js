$('document').ready(function () {
    var location = window.location.pathname; //получаем строку пути относительно хоста, без атрибутов
/*
    if ((location == '/') || (location == '/index.jsp')){
            $('#m_glav').css({'border-bottom': '2px solid #D8A464'});
            $('#m_magazin').css({'border-bottom': '0px'});
    }

    if (location == '/veshi'){
        $('#m_glav').css({'border-bottom': '0px'});
        $('#m_magazin').css({'border-bottom': '2px solid #D8A464'});
    }
*/
    $('ang-header').on('mouseover','#m_magazin',function () {
        $('#m_magazin').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-header').on('mouseout','#m_magazin',function () {
        $('#m_magazin').css({'border-bottom': '0px'});
    });

    $('ang-header').on('mouseover','#m_osebe',function () {
        $('#m_osebe').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-header').on('mouseout','#m_osebe',function () {
        $('#m_osebe').css({'border-bottom': '0px'});
    });

    $('ang-header').on('mouseover','#dop_menu',function () {
        $('#dop_menu').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-header').on('mouseout','#dop_menu',function () {
        $('#dop_menu').css({'border-bottom': '0px'});
    });

    $('ang-header').on('mouseover','#m_glav',function () {
        $('#m_glav').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-header').on('mouseout','#m_glav',function () {
        $('#m_glav').css({'border-bottom': '0px'});
    });
/*Эффекты для кнопок саб меню*/
    $('ang-submenu').on('mouseover','#vesh_bruki',function () {
        $('#vesh_bruki').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-submenu').on('mouseout','#vesh_bruki',function () {
        $('#vesh_bruki').css({'border-bottom': '0px'});
    });
    $('ang-submenu').on('mouseover','#vesh_kofti',function () {
        $('#vesh_kofti').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-submenu').on('mouseout','#vesh_kofti',function () {
        $('#vesh_kofti').css({'border-bottom': '0px'});
    });
    $('ang-submenu').on('mouseover','#vesh_majki',function () {
        $('#vesh_majki').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-submenu').on('mouseout','#vesh_majki',function () {
        $('#vesh_majki').css({'border-bottom': '0px'});
    });
    $('ang-submenu').on('mouseover','#vesh_svitshoti',function () {
        $('#vesh_svitshoti').css({'border-bottom': '2px solid #D8A464'});
    });
    $('ang-submenu').on('mouseout','#vesh_svitshoti',function () {
        $('#vesh_svitshoti').css({'border-bottom': '0px'});
    });
});