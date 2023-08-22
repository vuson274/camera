// datatable
$('#bang').DataTable();
//end datatable

// Sửa product
$(document).on('click', '.editproduct', function(){
    var id = $(this).attr('data-id');
    var categoryId = $(this).attr('data-category')
    var brandId = $(this).attr('data-brand');
    var name = $(this).attr('data-name');
    var origin = $(this).attr('data-orrigin');
    var price = $(this).attr('data-price');
    var quantity = $(this).attr('data-quantity');
    var des = $(this).attr('data-des');
    var sale = $(this).attr('data-sale');
    document.getElementById('ecategory').value= categoryId;
    document.getElementById('ebrand').value= brandId;
    $('#eid').val(id);
    $('#ename').val(name);
    $('#eorigin').val(origin);
    $('#eprice').val(price);
    $('#equantity').val(quantity);
    $('#edescription').val(des);
    $('#esale').val(sale);
    $("#modalupdate").modal('show');
});
//and sửa product
//sửa brand
$(document).on('click','.editsupplier', function(){
    var id = $(this).attr('data-id');
    var name = $(this).attr('data-name');
    $('#eid').val(id);
    $('#ename').val(name);
    $('#modalupdate').modal('show');    
});
//and sửa
//sửa user
$(document).on('click','.edituser', function(){
    var id = $(this).attr('data-id');
    var name = $(this).attr('data-name');
    var email = $(this).attr('data-email');
    var phone = $(this).attr('data-phone');
    $('#eid').val(id);
    $('#ename').val(name);
    $('#eemail').val(email);
    $('#ephone').val(phone);
    $('#modalupdate').modal('show');
});
//and sửa
//sửa categories
$(document).on('click','.editcategories',function(){
    var id = $(this).attr('data-id');
    var name = $(this).attr('data-name');
    $('#eid').val(id);
    $('#ename').val(name);
    $('#modalupdate').modal('show'); 
});
//and sửa





function checkEmail(){
   
    var email = document.getElementById('email').value;
    var erroremail = document.getElementById('erroremail');
    var regexEmail = /[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}/igm;
    if(email == '' || email == null){
        erroremail.innerHTML = 'Email không được để trống';
    }else if(!regexEmail.test(email)){
        erroremail.innerHTML = 'Email sai định dạng';

    }else{
        erroremail.innerHTML = '';  
    }

};

function checkeEmail(){

    var email = document.getElementById('email').value;
    var erroremail = document.getElementById('erroreemail');
    var regexEmail = /[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}/igm;
    if(email == '' || email == null){
        erroremail.innerHTML = 'Email không được để trống';
    }else if(!regexEmail.test(email)){
        erroremail.innerHTML = 'Email sai định dạng';

    }else{
        erroremail.innerHTML = '';
    }

};

function checkPhone() {
    var phone = document.getElementById('phone').value;
    var errorphone = document.getElementById('errorphone');
    //var phonee = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    var phoner = /^(\()?\d{3}(\))?(-|\s)?\d{3}(-|\s)\d{4}$/;
    if(phone =='' || phone ==null){
        errorphone.innerHTML = 'Số điện thoại không đc để trống';
    }else if(phoner.test(phone)){
        errorphone.innerHTML = 'không được nhập chữ';
    }else{
        errorphone.innerHTML = '';
    }
};

function checkePhone() {
    var ephone = document.getElementById('ephone').value;
    var errorphone = document.getElementById('errorephone');
    //var phonee = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    var phoner = /^(\()?\d{3}(\))?(-|\s)?\d{3}(-|\s)\d{4}$/;
    if(ephone =='' || ephone ==null){
        errorphone.innerHTML = 'Số điện thoại không đc để trống';
    }else if(phoner.test(ephone)){
        errorphone.innerHTML = 'không được nhập chữ';
    }else{
        errorphone.innerHTML = '';
    }
};

function checkname() {
    var name = document.getElementById('name').value;
    var errorname = document.getElementById('errorname');
    var namer = /^[A-Za-z\s]+$/;

    if(name =='' || name == null){
        errorname.innerHTML = 'Tên không đc để trống';
    } else if(!namer.test(name)){
        errorname.innerHTML = 'Tên không được là số';
    }else{
        errorname.innerHTML = '';
    }

};

function checkename() {
    var ename = document.getElementById('ename').value;
    var errorname = document.getElementById('errorename');
    var namer = /^[A-Za-z\s]+$/;

    if(ename =='' || ename == null){
        errorname.innerHTML = 'Tên không đc để trống';
    } else if(!namer.test(ename)){
        errorname.innerHTML = 'Tên không được là số';
    }else{
        errorname.innerHTML = '';
    }

};

function checkAvatar() {
    var avatar = document.getElementById('image');
    var fileSize = avatar.files[0].size;
    var fileType = avatar.files[0].type;
    var erroravatar = document.getElementById('erroravatar');
    if( fileSize < 1048576) {
        switch (fileType) {
            case 'image/png':
            case 'image/jpeg':
                erroravatar.innerHTML = '';
                break;
            default:
                erroravatar.innerHTML = 'Vui lòng chọn file jpg, png';
        }
    } else {
        erroravatar.innerHTML = 'Dung lượng ảnh không được vượt quá 1MB';
    }

};

function checkeAvatar() {
    var avatar = document.getElementById('eimage');
    var fileSize = avatar.files[0].size;
    var fileType = avatar.files[0].type;
    var erroravatar = document.getElementById('erroreavatar');
    if( fileSize < 1048576) {
        switch (fileType) {
            case 'image/png':
            case 'image/jpeg':
                erroravatar.innerHTML = '';
                break;
            default:
                erroravatar.innerHTML = 'Vui lòng chọn file jpg, png';
        }
    } else {
        erroravatar.innerHTML = 'Dung lượng ảnh không được vượt quá 1MB';
    }

};

function checkPrice() {
    
    var price = document.getElementById('price').value;
    var errorprice = document.getElementById('errorprice');

    if(price == '' || price == null){
        errorprice.innerHTML = 'Giá tiền không được để trống';
    }else if(price <= 0){
        errorprice.innerHTML = 'Giá tiền phải lớn hơn 0';
    }
    else{
        errorprice.innerHTML = '';
    }
};

function checkePrice() {
    
    var eprice = document.getElementById('eprice').value;
    var errorprice = document.getElementById('erroreprice');

    if(eprice == '' || eprice == null){
        errorprice.innerHTML = 'Giá tiền không được để trống';
    }else if(eprice <= 0){
        errorprice.innerHTML = 'Giá tiền phải lớn hơn 0';
    }
    else{
        errorprice.innerHTML = '';
    }
};

function checkQuantity(){
    var quantity = document.getElementById('quantity').value;
    var errorquantity = document.getElementById('errorquantity');

    if(quantity == '' || quantity == null){
        errorquantity.innerHTML = 'Số lương không được để trống';
    }else if(quantity <= 0){
        errorquantity.innerHTML = 'Số lương phải lớn hơn 0';
    }
    else{
        errorquantity.innerHTML = '';
    }
};
function checkeQuantity(){
    var quantity = document.getElementById('equantity').value;
    var errorquantity = document.getElementById('errorequantity');

    if(quantity == '' || quantity == null){
        errorquantity.innerHTML = 'Số lương không được để trống';
    }else if(quantity <= 0){
        errorquantity.innerHTML = 'Số lương phải lớn hơn 0';
    }
    else{
        errorquantity.innerHTML = '';
    }
};
function checkQuantity(){
    var quantity = document.getElementById('quantity').value;
    var errorquantity = document.getElementById('errorquantity');

    if(quantity == '' || quantity == null){
        errorquantity.innerHTML = 'Số lương không được để trống';
    }else if(quantity <= 0){
        errorquantity.innerHTML = 'Số lương phải lớn hơn 0';
    }
    else{
        errorquantity.innerHTML = '';
    }
};



function checkPass() {
    var password = document.getElementById('password').value;
    var pass = password.trim();
    var errorpassword = document.getElementById('errorpassword');
    if(pass =='' || pass == null) {
        errorpassword.innerHTML = 'Không được để trống ';
    }else if (pass.length < 6 ){
        errorpassword.innerHTML = 'Nhập ít nhất 6 ký tự';
    }else{
        errorpassword.innerHTML = '';
    }
};

function checkePass() {
    var password = document.getElementById('epassword').value;
    var pass = password.trim();
    var errorpassword = document.getElementById('errorepassword');
    if(pass =='' || pass == null) {
        errorpassword.innerHTML = 'Không được để trống ';
    }else if (pass.length < 6 ){
        errorpassword.innerHTML = 'Nhập ít nhất 6 ký tự';
    }else{
        errorpassword.innerHTML = '';
    }
};

//check xuất sứ product
function checkOrigin(){
    var origin = document.getElementById('origin').value;
    var errororigin = document.getElementById('errororigin');
    if(origin == '' || origin == null){
        errororigin.innerHTML = "Vui lòng nhập xuất xứ";
    } else {
        errororigin.innerHTML = '';
    }
};

function checkeOrigin(){
    var origin = document.getElementById('eorigin').value;
    var errororigin = document.getElementById('erroreorigin');
    if(origin == '' || origin == null){
        errororigin.innerHTML = "Vui lòng nhập xuất xứ";
    } else {
        errororigin.innerHTML = '';
    }
};


// check sale product
function checkSale(){
    var sale = document.getElementById('sale').value;
    var errorsale = document.getElementById('errorsale');
    if (sale == '' || sale == null){
        errorsale.innerHTML = " Vui lòng nhập một số ";
    }  else if( sale < 0 ){
        errorsale.innerHTML = " Vui lòng nhập một số không âm ";
    } else {
        errorsale.innerHTML = '';
    }

};

function checkeSale(){
    var sale = document.getElementById('esale').value;
    var errorsale = document.getElementById('erroresale');
    if (sale == '' || sale == null){
        errorsale.innerHTML = " Vui lòng nhập một số ";
    }  else if( sale < 0 ){
        errorsale.innerHTML = " Vui lòng nhập một số không âm ";
    } else {
        errorsale.innerHTML = '';
    }

};



//check image product
function checkImageMain(){
    var mainImg = document.getElementById('mainImage');
    var sizeMain = mainImg.files[0].size;
    var typeMain = mainImg.files[0].type;
    var errormain = document.getElementById('errormain');
    if( sizeMain < 1048576) {
        switch (typeMain) {
            case 'image/png':
            case 'image/jpeg':
            case 'image/webp':
                errormain.innerHTML = '';
                break;
            default:
                errormain.innerHTML = 'Vui lòng chọn file jpg, png, webp';
        }
    } else {
        errormain.innerHTML = 'Dung lượng ảnh không được vượt quá 1MB';
    }

};

function checkImageSecond(){
    var secondImg = document.getElementById('secondImage');
    var sizeSecond = secondImg.files[0].size;
    var typeSecond = secondImg.files[0].type;
    var errorsecond = document.getElementById('errorsecond');
    if( sizeSecond < 1048576) {
        switch (typeSecond) {
            case 'image/png':
            case 'image/jpeg':
            case 'image/webp':
                errorsecond.innerHTML = '';
                break;
            default:
                errormain.innerHTML = 'Vui lòng chọn file jpg, png, webp';
        }
    } else {
        errorsecond.innerHTML = 'Dung lượng ảnh không được vượt quá 1MB';
    }
}

function checkeImageMain(){
    var mainImg = document.getElementById('emainImage');
    var sizeMain = mainImg.files[0].size;
    var typeMain = mainImg.files[0].type;
    var errormain = document.getElementById('erroremain');
    if( sizeMain < 1048576) {
        switch (typeMain) {
            case 'image/png':
            case 'image/jpeg':
            case 'image/webp':
                errormain.innerHTML = '';
                break;
            default:
                errormain.innerHTML = 'Vui lòng chọn file jpg, png, webp';
        }
    } else {
        errormain.innerHTML = 'Dung lượng ảnh không được vượt quá 1MB';
    }

};

function checkeImageSecond(){
    var secondImg = document.getElementById('esecondImage');
    var sizeSecond = secondImg.files[0].size;
    var typeSecond = secondImg.files[0].type;
    var errorsecond = document.getElementById('erroresecond');
    if( sizeSecond < 1048576) {
        switch (typeSecond) {
            case 'image/png':
            case 'image/jpeg':
            case 'image/webp':
                errorsecond.innerHTML = '';
                break;
            default:
                errormain.innerHTML = 'Vui lòng chọn file jpg, png, webp';
        }
    } else {
        errorsecond.innerHTML = 'Dung lượng ảnh không được vượt quá 1MB';
    }
}

$(document).ready(function(){

    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd'
    });

    $(function(){
        $("#from_date").datepicker();
        $("#to_date").datepicker();
    });
    $('#filter').click(function(){
        var from_date = $('#from_date').val();
        var to_date = $('#to_date').val();
        if(from_date != '' && to_date != '')
        {
            $.ajax({
                url:"/admin/filter",
                method:"get",
                data:{from_date:from_date, to_date:to_date},
                success:function(data)
                {
                    $('#pro').html('<div className="huge" style="font-size: 40px;">'+data[0]+'</div><div>Product </div>');
                    $('#member').html('<div className="huge" style="font-size: 40px;">'+data[1]+'</div><div>Member </div>');
                }
            });
        }
        else
        {
            alert("Please Select Date");
        }
    });
});