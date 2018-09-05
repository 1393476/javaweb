<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #div1{
            width: 0;
            height: 0;
            border-left: 10px solid green;
            border-right: 10px solid red;
            border-top: 10px solid yellow;
            border-bottom: 10px solid blue;
            border-radius: 100px;
            position: absolute;
            left: 0;
            top: 0;
        }
    </style>
    <script>
        document.onmousemove=function(e){
            var div=document.getElementById("div1");
            div.style.left=e.clientX+"px";
            div.style.top=e.clientY+"px";
        }
    </script>
</head>
<body>
    <div id="div1"></div> 
</body>
</html>