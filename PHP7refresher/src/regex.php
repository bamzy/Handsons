<?php

preg_replace_callback_array(
    [
        '~[ab]+~i' => function ($match) {echo $match[0] . ' [a]was matched' . PHP_EOL;},
        '~[b]+~i' => function ($match) {echo $match[0] . ' [b]was matched' . PHP_EOL;}
    ],'aaaaaaaaa AAAA ba 232'
);