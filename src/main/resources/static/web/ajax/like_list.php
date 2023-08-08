<?php
    session_start();
    include_once "../../Model/product.php";
    $like = new Product(); 
    if(isset($_POST['action'])){
        $action=$_POST['action'];
        if($action=="like"){
            $id = $_POST['id'];
            $result = $like->getProductID($id);
            if(!isset($_SESSION['like']) && empty($_SESSION['like'])){
                $_SESSION['like'][$id] = $result;
                $_SESSION['like'][$id]['qty'] = 1;
            }else{
                if (array_key_exists($id, $_SESSION['like'])) {
                    $_SESSION['like'][$id]['qty'] += 1;
                }else{
                    $_SESSION['like'][$id] = $result;
                    $_SESSION['like'][$id]['qty'] = 1;
                }
            }
        }
    } 


?>