$(document).on('click', '.del-cart  ', function(e){
    e.preventDefault();
    var id = $(this).val(); // id sản phẩm

    $.ajax({
        url         : 'assets/ajax/del-cart.php',
        type        : 'post',
        dataType    : 'html',
        data        : { id : id },

        success : function(data){
            
        	$("#total-price").load(' .total-price');
            $("#cart").load(' #data-cart');
            $("#carts").load(' #bag-carts');
            $('body').load('index.php?page=shop-cart');
        },

        error : function(){
            
        }
    });

});


$(document).on('change', '.update-cart', function(){
    var qty  = $(this).val();
    var id = $(this).attr('name');

    $.ajax({
        url         : 'assets/ajax/update.php',
        type        : 'post',
        dataType    : 'html',
        data        : { id : id, qty : qty },

        success : function(data){
            $("#cart").load(' #data-cart');
            $("#total-price").load(' .total-price');
        },

        error : function(){
            
        }
    });
});


$(document).on("click",".order", function(e){
    var id = $(this).attr('id');
    var action = "add";
    // alert (id);
    $.post('assets/ajax/order.php',{id: id, action: action},function(data){

        $("#carts").load(' #bag-carts');
        $('.notiProduct').slideDown('fast');
        $('.notiProduct').delay(10000).slideUp('fast');
    });
});


$(document).on("click",".cart-btn", function(e){
    var id = $(this).attr('id');
    var action = "add_detail";
    // alert (id);
    $.post('assets/ajax/order.php',{id: id, action: action},function(data){

        $("#carts").load(' #bag-carts');
        $('.notiProduct').slideDown('fast');
        $('.notiProduct').delay(10000).slideUp('fast');
    });
});


//yêu thích sản phẩm
$(document).on('click','.heart',function(e){
    var id= $(this).attr('id');
    var action = 'like';
    // alert(id);
    $.post('assets/ajax/like_list.php',{id: id, action: action},function(data){
        // $('.product__item').html(data);
        $("#heart").load(' #like');
        $('.favorite_list').slideDown('fast');
        $('.favorite_list').delay(10000).slideUp('fast');
    });
});

//xóa sản phẩm yêu thích
$(document).on('click','.delete',function(e){
    var id= $(this).attr('id');
    var action = 'delete';
    $.post('assets/ajax/del_favorite.php',{id: id, action: action},function(data){
        $("#heart").load(' #like');
        $('body').load('index.php?page=favorite')
    });
});



//chi tiết sản phẩm
$(document).on('click','.detail',function(e){
    var id = $(this).attr('id');
    var action = 'detail';
    // alert(id);
    $.ajax({
        url         : 'assets/ajax/detailProduct.php',
        type        : 'post',
        dataType    : 'json',
        data        : { id : id, action : action },

        success : function(data){
            var name= data.name;
            $('#imgDetail').html('<img src="'+data.avatar+'">');
            $('.modal-body h3').html(name);
            $('.modal-body h4').html(Number(data.price).toLocaleString('en')+"đ");
            $('.modal-body a').attr('id',data.id);
        },

        error : function(){
            
        }
    });
});

$(document).on('click','.cart-btn',function(e){
    $('#detail').modal('hide');
});
