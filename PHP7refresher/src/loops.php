<?php
namespace dummy\loops;
$arr = array("1","3","4","5","6","7");

for ($i = 0 ; $i < sizeof($arr); $i++){
//    echo 'hi';
    print($arr[$i]);
}

foreach ($arr as $val){
    print($val);

}
$productRowData = array(1=>'a',2=>'b', 3=>'c',8=>'d');


foreach ($productRowData as $key => $value) {
    echo 'key : '  . $key . PHP_EOL;
    echo 'value: ' . $value . PHP_EOL;
    echo PHP_EOL;
}
echo $productRowData[8];
