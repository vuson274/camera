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
    $.ajax({
        url         : '/likeProduct',
        type        : 'get',
        dataType    : 'json',
        data        : { id : id },
        success : function(data){
            $("#heart").load(' #like');
            $('.favorite_list').slideDown('fast');
            $('.favorite_list').delay(10000).slideUp('fast');
        },
        error : function(data){
        }
    });
});

//xóa sản phẩm yêu thích
$(document).on('click','.delete',function(e){
    var id= $(this).attr('id');
    $.ajax({
        url         : '/delLikeProduct',
        type        : 'get',
        dataType    : 'json',
        data        : { id : id },
        success : function(data){
            $("#heart").load(' #like');
            $('body').load('index.php?page=favorite')
        },
        error : function(data){
        }
    });
});



//chi tiết sản phẩm
$(document).on('click','.detail',function(e){
    var id = $(this).attr('id');
    // var action = 'detail';
    $.ajax({
        url         : '/productDetail',
        type        : 'get',
        dataType    : 'json',
        data        : { id : id },
        success : function(data){
            var name= data.name;
            $('#imgDetail').html('<img src="/getimage/'+data.mainImage+'">');
            $('.modal-body .proDes').html(data.description);
            $('.modal-body h3').html(name);
            $('.modal-body h4').html(Number(data.price).toLocaleString('en')+"đ");
            $('.modal-body a').attr('id',data.id);
        },
        error : function(data){
        }
    });
});

$(document).on('keyup','#search_input',function(e){
    $("#form_search").css({'position':'absolute','top':'120px'});
    $("#show_search").css('margin-top','-530px');
    let searchText = $(this).val();
    if (searchText != "") {
        $.ajax({
            url: "/searchProduct",
            method: "get",
            data: {
                name: searchText,
            },
            success: function (response) {
               let result =  response.map(value =>{
                    return  '<a href="/product/'+value.id+'" class="list-group-item list-group-item-action border-1"><img style="width: 10%;" src="/getimage/'+value.mainImage+'" alt=""> &ensp;' +value.name+'</a>'
                })
                $("#show-list").html(result);
            },
        });
    } else {
        $("#show-list").html("");
    }
});


// $(document).on('click','.page',function(e){
//     var id = $(this).attr('id');
//     var from = (id-1)*20;
//     $.ajax({
//         url         : '/page',
//         type        : 'get',
//         dataType    : 'json',
//         data        : { from:from},
//         success : function(data){
//             let result = data.map(value => {
//                 return '<div  id="product"   class="col-lg-3 col-md-4 col-sm-6 mix  pro'+value.category.id+'cat">\n' +
//                     '    <div class="product__item">\n' +
//                     '        <div class="product__item__pic set-bg" data-id="'+value.id+'" data-setbg="/getimage/'+value.mainImage+'">\n' +
//                     '            <ul class="product__hover">\n' +
//                     '                <li><a href="#detail" data-toggle="modal" data-target="#detail" class="detail" id="'+value.id+'"><span class="fa fa-eye"></span></a></li>\n' +
//                     '                <li><a  class="heart" id="'+value.id+'"><span class="icon_heart_alt"></span></a></li>\n' +
//                     '                <li><a href="#order" class="order" id="'+value.id+'"><span class="icon_bag_alt" type="buy"></span></a></li>\n' +
//                     '            </ul>\n' +
//                     '        </div>\n' +
//                     '        <div class="product__item__text">\n' +
//                     '            <h6>\n' +
//                     '                <a href="/product/'+value.id+'">'+value.name+'</a>\n' +
//                     '            </h6>\n' +
//                     '            <div class="product__price">'+value.price+'</div>\n' +
//                     '        </div>\n' +
//                     '    </div>\n' +
//                     '</div>\n'
//             })
//             console.log(result);
//             $("#page").html(result);
//         },
//         error : function(data){
//         }
//     });
// });

$(document).on('click','.cart-btn',function(e){
    $('#detail').modal('hide');
});
