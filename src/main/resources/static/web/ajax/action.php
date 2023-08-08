<?php
    $name = "%".$_POST['query']."%";
    include_once '../../Model/search.php';
    $search = new search();
    $result = $search->searchProduct($name);
    
    if ($result) {
        foreach ($result as $row) {
            echo '<a href="index.php?page=product-details&id='.$row['id'].'" class="list-group-item list-group-item-action border-1"><img style="width: 10%;" src="'. $row['avatar'].'" alt=""> &ensp;' . $row['name'] . '</a>';
        }
    } else {
        echo '<p class="list-group-item border-1">No Record</p>';
    }
    
?>