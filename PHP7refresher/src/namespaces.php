<?php

require 'anonymousClass.php';
require 'serialize.php';
use dummy\serialize\{newObj1 as oldObj, newnewObj as oldoldObj };
use dummy\anonymouseClass\root as toor;
echo dummy\anonymouseClass\AAA. PHP_EOL;
echo dummy\serialize\AAA . PHP_EOL;
$temp = new toor();

new oldoldObj();
new oldObj();
echo $temp->rootVal;