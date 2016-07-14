
/**
 * Created by taras_000 on 11.06.2016.
 */
$('document').ready(function () {
    $('#vesh_bruki').hover(
        function () {
            $('#vesh_bruki').css({'border-bottom': '2px solid #D8A464'});
        },
        function () {
            $('#vesh_bruki').css({'border-bottom': '0px'});
        }
    );
    $('#vesh_kofti').hover(
        function () {
            $('#vesh_kofti').css({'border-bottom': '2px solid #D8A464'});
        },
        function () {
            $('#vesh_kofti').css({'border-bottom': '0px'});
        }
    );
    $('#vesh_majki').hover(
        function () {
            $('#vesh_majki').css({'border-bottom': '2px solid #D8A464'});
        },
        function () {
            $('#vesh_majki').css({'border-bottom': '0px'});
        }
    );
    $('#vesh_svitshoti').hover(
        function () {
            $('#vesh_svitshoti').css({'border-bottom': '2px solid #D8A464'});
        },
        function () {
            $('#vesh_svitshoti').css({'border-bottom': '0px'});
        }
    );
    
    
/*
    $('.t_image').hover(
        function(){
            $('.t_effect').animate({
                height: '376px', width: '370px', margin: '10px'
            }, 200);
            $('.t_effect').css({opacity: '0.5'});
        },
        function(){
            $('.t_effect').animate({
                height: '100px', width: '100px', margin: '150px'
            }, 200);
            $('.t_effect').animate({opacity: '0'}, 50);

        });
        */
});