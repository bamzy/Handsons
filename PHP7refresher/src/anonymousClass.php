<?php
//This is how frameworks are created!!!
//The class is created only one and can even have a constructor
// An anonymous class can event inherit
class root{
    public $rootVal = 19;
}
$framework = new class(18) extends root{
    private $var = 1;
    public $temp = 2;
    function __construct($input)
    {
        $this->var = $input;
    }

    public function print(){
        print($this->rootVal) ;
    }
    public static function test(){
        echo "I'm inside test()\r";
    }

};

$framework->print();
$framework::test();
