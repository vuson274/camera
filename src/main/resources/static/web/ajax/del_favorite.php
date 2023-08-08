<?php
    session_start();
    if(isset($_POST['action'])){
        $action = $_POST['action'];
        if($action =='delete'){
            $id = (int)$_POST['id'];
            if(isset($_SESSION['like']) && !empty($_SESSION['like'])){
                unset($_SESSION['like'][$id]);
                return 1;
            }

        }
    }
?>