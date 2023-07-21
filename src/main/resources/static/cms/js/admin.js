$('#bang').DataTable();

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
                url:"assets/filter/filter.php",  
                method:"POST",  
                data:{from_date:from_date, to_date:to_date},  
                success:function(data)  
                {  
                   $('#statistic').html(data);  
                }  
            });  
        }  
        else  
        {  
            alert("Please Select Date");  
        }  
    });

    // $('.edit_data').click(function(){  
    //    $('#insert').val("Cập nhật");
    //    $('.modal-title').html('Sửa thông tin quản trị viên'); 
    //    $('#insert_form')[0].reset();  
    // });


    // $('#add').click(function(){  
    //     $('#insert').val("Thêm");
    //     $('.modal-title').html('Thêm thông tin quản trị viên');
    //     $('#insert_form')[0].reset();  
    // }); 




    // $('#insert_form').on("submit", function(event){  
    //    event.preventDefault();  
    //    if($('#name').val() == "")  
    //     {  
    //         alert("Name is required");  
    //     }  
    //    else if($('#email').val() == '')  
    //     {  
    //         alert("Email is required");  
    //     }  
    //    else if($('#pass').val() == '')  
    //     {  
    //         alert("Password is required");  
    //     }  
    //     else if($('#phone').val() == '')  
    //     {  
    //         alert("Phone is required");  
    //     }  
    //     else  
    //     {  
    //         $.ajax({  
    //             url:"assets/filter/insert.php",  
    //             method:"POST",  
    //             data:$('#insert_form').serialize(),  
    //             beforeSend:function(){  
    //                 $('#insert').val("Inserting");  
    //             },  
    //              success:function(data){  

    //                 $('#insert_form')[0].reset();  
    //                 $('#add_data_Modal').modal('hide');  
    //                 $('#employee_table').html(data);
                       
    //             }  
    //         });  
    //     }  
    // });  

    // $('.edit_data').on('click',function(){
    //     var id= $(this).attr('id');
    //     $.ajax({
    //         url:"assets/filter/fetch_data.php",
    //         method:"POST",
    //         data:{id:id},
    //         dataType:"json",
    //         success:function(data){  
    //             $('#name').val(data.name);  
    //             $('#email').val(data.email);   
    //             $('#phone').val(data.phone);  
    //             $('#position').val(data.level); 
    //             $('#add_data_Modal').modal('show'); 


    //         }  
    //     });

        
    // });


});  

 

