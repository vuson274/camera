<?php  
	session_start();
	if (isset($_POST['id'])){
		$id = (int)$_POST['id'];
		if(isset($_SESSION['carts']) && !empty($_SESSION['carts'])){
			unset($_SESSION['carts'][$id]);
			return 1;
		}
	}
?>