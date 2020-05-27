<?php
class X {
    var $abc = 10;
}

class Y {

    var $abc = 20;
    function changeValue($obj)
    {
        $obj = new Y();
    }
}

$x = new X();
$y = new Y();

print( $x->abc."\n"); //outputs 10
$y->changeValue($x);
print( $x->abc."\n"); //outputs 10 not 20 same as java does.

class X1 {
    var $abc = 10;
}

class Y1 {

    var $abc = 20;
    function changeValue(&$obj)
    {
        $obj = new Y1();
    }
}

$x1 = new X1();
$y1 = new Y1();

print($x1->abc."\n"); //outputs 10
$y1->changeValue($x1);
print($x1->abc."\n"); //outputs 20 not possibl


function change(array $a){
    $a[0] = 1;
}

$b = array(1,2,3,4,5);
//null coalescing
$b[0] = $b[0] ?? 'a';
//change($b);
print($b[0]);

class root {

}
class dummy extends root{
    function do($a):root{
        return new dummy;
    }
}
$d = new dummy();
$d->do('hi');



//The spaceship operator <=>
$spaceshipResult = array(3000,2) <=> array(2,70,100,1000);
echo "\r\r".$spaceshipResult."\r";


//Constants new way
const PERSON = array('me','you','them');

//Constants kind of old way
Define('OFFICE',array(1,2,3,4));
echo json_encode(PERSON,JSON_PRETTY_PRINT) ;
echo json_encode(OFFICE,JSON_PRETTY_PRINT) ;