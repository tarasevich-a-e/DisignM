/**
 * Created by taras_000 on 10.06.2016.
 */
$('document').ready(function () {
    $('#pic1').hover(
        function(){
            $('#pic1f').animate({
                height: '449px', width: '970px', margin: '20px auto auto 20px'
            }, 200);
            $('#pic1f').css({opacity: '0.5'});
            $('#pic1').css({color: 'white'});
        },
        function(){
            $('#pic1f').animate({
                height: '200px', width: '500px', margin: '145px auto auto 255px'
            }, 200);
            $('#pic1f').animate({opacity: '0'}, 50);
            $('#pic1').css({color: 'black'});
        });
    $('#pic2').hover(
        function(){
            $('#pic2f').animate({
                height: '968px', width: '480px', margin: '20px auto auto 20px'
            }, 200);
            $('#pic2f').css({opacity: '0.5'});
            $('#pic2').css({color: 'white'});
        },
        function(){
            $('#pic2f').animate({
                height: '200px', width: '50px', margin: '431px auto auto 235px'
            }, 200);
            $('#pic2f').animate({opacity: '0'}, 50);
            $('#pic2').css({color: 'black'});
        });
    $('#pic3').hover(
        function(){
            $('#pic3f').animate({
                height: '450px', width: '449px', margin: '20px auto auto 20px'
            }, 200);
            $('#pic3f').css({opacity: '0.5'});
            $('#pic3').css({color: 'white'});
        },
        function(){
            $('#pic3f').animate({
                height: '100px', width: '100px', margin: '195px auto auto 195px'
            }, 200);
            $('#pic3f').animate({opacity: '0'}, 50);
            $('#pic3').css({color: 'black'});
        });
    $('#pic4').hover(
        function(){
            $('#pic4f').animate({
                height: '450px', width: '449px', margin: '20px auto auto 20px'
            }, 200);
            $('#pic4f').css({opacity: '0.5'});
            $('#pic4').css({color: 'white'});
        },
        function(){
            $('#pic4f').animate({
                height: '100px', width: '100px', margin: '195px auto auto 195px'
            }, 200);
            $('#pic4f').animate({opacity: '0'}, 50);
            $('#pic4').css({color: 'black'});
        });
});
