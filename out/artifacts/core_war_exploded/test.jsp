<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 20.02.2016
  Time: 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel="stylesheet" href="css/nivo-slider.css">
    <link href="css/templatemo_style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/denisStylesheet.css" rel="stylesheet">
    <link rel="stylesheet" href="css/main.css">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <title>Test</title>

</head>
<body>
<header>
    <div id="logo-container">
        <div id="logo"><a href="/">Meow</a></div>
        <div id="subtitle">A pretty-kitty demo</div>
    </div>
</header>

<div id="content">
    <div id="slider" class="nivoSlider">
        <a href="#"><img src="images/catPic/cat.jpg" alt="slide 1" /></a>
        <a href="#"><img src="images/catPic/maine-coon-cat.jpg" alt="slide 2" /></a>
        <a href="#"><img src="images/catPic/97147537_Britanec_kot.jpg" alt="slide 3" /></a>
    </div>
</div>

<button onclick="loadPhones2()"></button>
<div id="content2" class="container-fluid">
</div>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "phones.json",
            success:
                    function loadPhones() {

                        var xhr = new XMLHttpRequest();

                        xhr.open('GET', 'phones.json', true);


                        xhr.send();


                        xhr.onreadystatechange = function() {
                            if (xhr.readyState != 4) return;

                            if (xhr.status != 200) {
                                // обработать ошибку
                                alert(xhr.status + ': ' + xhr.statusText);
                            } else {
                                // вывести результат
                                alert(xhr.responseText);
                            }

                        }
                    }
        });
    });
    function showContent(link, divtarget) {
        var cont = document.getElementById(divtarget);
        (function _f() {
            var http = createRequestObject();
            if( http ) {
                http.open('GET', link, true);
                http.onreadystatechange = function () {
                    if (http.readyState == 4) {
                        alert(http.responseText)
                        setTimeout(_f, 3000);
                    }
                };
                http.send(null);
            } else {
                cont.innerHTML = 'Ошибка сети';
                setTimeout(_f, 3000);
            }
        })();
    }
    function loadPhones2() {
        showContent('phones.json', '#content2')
    }
</script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript", src="js/jquery.nivo.slider.pack.js"></script>
<script >
    $(window).load(function() {
        $('#slider').nivoSlider({
            prevText: '',
            nextText: '',
            controlNav: false,
        });
    });
</script>

<script src="js/vendor/jquery.fluidbox.min.js"></script>
<script src="js/main.js"></script>

<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', 'YOUR_GOOGLE_ANALYTICS_ID', 'auto');
    ga('send', 'pageview');

</script>

</body>
</html>

