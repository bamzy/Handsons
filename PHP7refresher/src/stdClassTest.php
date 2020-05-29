    <?php

//Example with StdClass
$json = '{ "foo": "bar", "number": 42 }';
$stdInstance = json_decode($json);

echo $stdInstance->foo. PHP_EOL; //"bar"
echo $stdInstance->number. PHP_EOL; //42
$var = array(1=>'1',2=>'2');
echo $var[2] . PHP_EOL;
//Example with associative array
$array = json_decode($json, true);

echo $array['foo'].PHP_EOL; //"bar"
echo $array['number'].PHP_EOL; //42

    $something = 0;
    echo ('password123' == $something) ? 'true' : 'false';


$arr = array(1,2,3,4,5,6,7);
function func($v){
    if ($v === 1 || $v===5)
        return 0;
    else return $v;
}
$newArr = array_map('func',$arr);
echo json_encode($newArr,JSON_PRETTY_PRINT);

    final class UserFactory {
        /**
         * Call this method to get singleton
         *
         * @return UserFactory
         */
        static $inst = null;
        public static
        function Instance() {
            if (UserFactory::$inst === null) {
                UserFactory::$inst = new UserFactory();
            }
            return UserFactory::$inst;
        }

        /**
         * Private ctor so nobody else can instantiate it
         *
         */
        private
        function __construct() {

    }
}
$a = UserFactory::Instance();
$b = UserFactory::Instance();
echo ($a === $b)? 'true': 'false';