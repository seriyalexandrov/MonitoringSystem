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
        <div id="logo" onclick="getInfo()">Meow</div>
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

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $.getJSON('phones.json', function(data){
            var items = [];

            $.each(data, function(key, val){
                $.each(val, function(Pkey, Pval) {
                    items.push('<li id="' + String(Pkey) + '">' + String(Pval) + '</li>');
                });
            });

            $('<ul/>', {
                'class': 'my-new-list',
                html: items.join('')
            }).appendTo('body');
        });
    });
    function getInfo(){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8080/RestService-1.0/rs/service/getInfo",
            success: function (data) {
                $.each(data, function(key, val){
                    alert(key+' '+val)
                });
            }
        });
    };
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

