<?php


namespace dummy\quicksort;


class QuickSort
{
    function sort(array &$arr){
        $low = 0;
        $high = sizeof($arr)-1;
        $this->quickSort($arr,$low,$high);
    }
    private function quickSort(array &$arr,int $low,int $high){
        if ($low < $high){

            $parIndex = $this->partition($arr,$low,$high);
            $this->quickSort($arr, $low, $parIndex-1);
            $this->quickSort($arr, $parIndex+1, $high);
        }

    }
    private function partition(array &$arr,int $low,int $high){
        $i = $low -1 ;
        $pivot = $arr[$high];
        for ($j = $low; $j<=$high-1; $j++){
            if ($arr[$j] < $pivot) {
                $i++;
                $this->swap($arr, $i, $j);
            }

        }
        $this->swap($arr,$i+1,$high);
        return $i+1;

    }
    private function swap(array &$arr, int $src, int $dest){
        $temp = $arr[$src];
        $arr[$src] = $arr[$dest];
        $arr[$dest] = $temp;
    }

}