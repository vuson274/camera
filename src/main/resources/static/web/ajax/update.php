<?php  
	session_start();
	if (isset($_POST['id']) && isset($_POST['qty'])){
		$id = (int)$_POST['id'];
		$qty = (int)$_POST['qty'] <= 0 ? 1 : (int)$_POST['qty'];

		if(isset($_SESSION['carts']) && !empty($_SESSION['carts'])){
			$_SESSION['carts'][$id]['qty'] = $qty;
			return 1;
		}
	}
?>