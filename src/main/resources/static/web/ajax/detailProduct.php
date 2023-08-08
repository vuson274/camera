<?php 
	include_once '../../Model/product.php';
	$product = new Product(); 
	if (isset($_POST['action'])) {
		$action=$_POST['action'];
		if ($action =='detail') {
			$id =$_POST['id'];
			$result = $product->getProductID($id);
			echo json_encode($result);
		}
	}
?> 