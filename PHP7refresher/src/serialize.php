<?php
namespace  dummy\serialize;
class newObj1 {
    public $prop = "helllo world";
    private $priv = "this is private";
    private $arr = [true,1,2,3,'a'];
}
const AAA = 33;

class newnewObj {
    public $var = "just something";
}
$serializedData = serialize(new newObj1());
echo $serializedData . PHP_EOL;

//echo unserialize($serializedData,["allowed_classes"=> ["newObj1"]])->prop;
//json_encode(deser)

//assert(false, 'This is an error!');

//assert(1>10, new myException('some error') );