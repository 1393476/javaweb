<!DOCTYPE html>
<html lang="zh">

    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Qing's Web</title>
        
        <script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
        <style type="text/css">
            
            .moveBar {
                position: absolute;
                width: 250px;
                height: 300px;
                background: #666;
                border: solid 1px #000;
                margin: 0px;
                left:200px;
                top:200px;
            }
            
            #banner {
                background: #52CCCC;
                cursor: move;
            }
        </style>
    </head>

    <body >

        <div class="moveBar">
            <div id="banner">div</div>
            <div class="content">other</div>
        </div>
        
        <script>
            jQuery(document).ready(
                function() {
                    $('#banner').mousedown(
                        function(event) {
                            var isMove = true;
                            var abs_x = event.pageX - $('div.moveBar').offset().left;
                            var abs_y = event.pageY - $('div.moveBar').offset().top;
                            $(document).mousemove(function(event) {
                                if(isMove) {
                                    var obj = $('.moveBar');
                                    obj.css({
                                        'left': event.pageX - abs_x,
                                        'top': event.pageY - abs_y
                                    });
                                }
                            }).mouseup(
                                function() {
                                    isMove = false;
                                }
                            );
                        }
                    );
                }
            );
        </script>
    </body>

</html>