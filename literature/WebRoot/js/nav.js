//jquery方法：首先得到导航条到页面顶部的高度:
$(".span24").offset().top;
//然后页面滚动函数即
$(window).scroll(function(){
    var mytop = $(window).scrollTop();
    if(mytop>$(".span24").offset().top){
        $(".span24").addClass("current");
    }else{
         $(".span24").removeClass("current");
    }
});