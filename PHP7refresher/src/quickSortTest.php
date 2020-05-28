<?php


require 'quickSort.php';

$sorter = new \dummy\quicksort\QuickSort();
$arr = array(5, 3, 1, 7, -1);
$sorter->sort($arr);
echo json_encode($arr, JSON_PRETTY_PRINT);
