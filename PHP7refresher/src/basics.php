<?php
print('hi');

function parse(float ...$args){
    echo '<pre>'.json_encode($args, JSON_PRETTY_PRINT).'</pre>';
}
parse('11.1',1,2,3,4,5,6,false);

function parse1(array $args){
    echo '<pre>'.json_encode($args, JSON_PRETTY_PRINT).'</pre>';
    return null;
}
//associative array
parse1(array("hi"=>'1','hello'=>2,1=>3,true=>4));


// you can define an input as callable
function parseCallable(string $func){
    echo 'this is the main func\r\n';
    call_user_func($func);

}
function callable1(){
    echo 'This is the function inside';
}
parseCallable('callable1');

interface food {
    function do($a,$b):int;
};
class cake implements food{
    function do($a,$b):int{
        return new cake();
    }

}
class salad implements food{
    function do($a,$b):int{
        return new cake();
    }
}
function restaurant(food $food): salad{
    echo var_dump($food);
    return new salad;
}

restaurant(new cake());


