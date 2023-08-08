<?php 
	session_start();
	include_once '../../Model/product.php';
	$product = new Product(); 
	if (isset($_POST['action'])) {
		$action =$_POST['action'];
		if($action == "add"|| $action=='add_detail') {
				$id =(int)$_POST['id'];
				$result = $product->getProductID($id);
				if (!isset($_SESSION['carts']) && empty($_SESSION['carts'])){
					$_SESSION['carts'][$id] = $result;
					$_SESSION['carts'][$id]['qty'] = 1;
				}else{
					if (array_key_exists($id, $_SESSION['carts'])) {
						$_SESSION['carts'][$id]['qty'] += 1;
					}else{
						$_SESSION['carts'][$id] = $result;
						$_SESSION['carts'][$id]['qty'] = 1;
					}
				}
		}

	}



?>

