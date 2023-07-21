// datatable
$('#bang').DataTable();
//end datatable

// Sửa product
$(document).on('click', '.editproduct', function(){
    var id = $(this).attr('id');
    var stt = $(this).attr('stt');
    $array = javascript_array[stt-1];
    //console.log($array);
    $('#eid').val($array.id);
    $('#ename').val($array.name);
    $('#ecategories_id').val($array.categories_id);
    $('#eavatar').val($array.avatar);
    $('#eprice').val($array.price);
    $('#equantity').val($array.quantity);
    $('#edescription').val($array.description);
    $('#estatus').val($array.status);
    $("#modalupdate").modal('show');
    
});
//and sửa product
//sửa supplier
$(document).on('click','.editsupplier', function(){
    var id = $(this).attr('id');
    var stt = $(this).attr('stt');
    $array = javascript_array[stt-1];
    //console.log($array);
    $('#eid').val($array.id);
    $('#ename').val($array.name);
    $('#eavatar').val($array.avatar);
    $('#edescription').val($array.description);
    
    $('#modalupdate').modal('show');    
});
//and sửa
//sửa user
$(document).on('click','.edituser', function(){
    var id = $(this).attr('id');
    var stt = $(this).attr('stt');
    $array = javascript_array[stt-1];
    //console.log($array);
    $('#eid').val($array.id);
    $('#ename').val($array.name);
    $('#eemail').val($array.email);
    $('#epassword').val($array.password);
    $('#ephone').val($array.phone);
    $('#elevel').val($array.level);
    $('#eavatar').val($array.avatar);
    
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
    var errorphone = document.getElementById('errorphone');
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
    var errorname = document.getElementById('errorname');
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
    var avatar = document.getElementById('avatar').value;
    var erroravatar = document.getElementById('erroravatar');
    if(avatar =='' || avatar == null){
        erroravatar.innerHTML = 'Không được để trống';
    }else{
        erroravatar.innerHTML = '';
    }
};

function checkeAvatar() {
    var eavatar = document.getElementById('eavatar').value;
    var erroravatar = document.getElementById('erroravatar');
    if(eavatar =='' || eavatar == null){
        erroravatar.innerHTML = 'Không được để trống';
    }else{
        erroravatar.innerHTML = '';
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
    var errorprice = document.getElementById('errorprice');

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


function checkPass() {
    var password = document.getElementById('password').value;
    var pass = password.trim();
    var errorpassword = document.getElementById('errorpassword');
    if(pass =='' || pass == null) {
        errorpassword.innerHTML = 'Không được để trống ';
    }else if (pass.length){
        errorpassword.innerHTML = 'Nhập ít nhất 6 ký tự';
    }else{
        errorpassword.innerHTML = '';
    }
};

