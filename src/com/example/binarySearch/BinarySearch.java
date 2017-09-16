package com.example.binarySearch;

public class BinarySearch {
    public int[] intArray;
    public int start;
    public int end;
    public int value;
    public int index;

    public BinarySearch() {}
    public BinarySearch(int[] intArray, int start, int end, int value){
        this.intArray = intArray;
        this.start = start;
        this.end = end;
        this.value = value;
        this.index = Search(intArray, start, end, value);
    }

    public int Search(int[] intArray, int start, int end, int value)
    {
        int mid = (start + end) / 2;
        if( intArray[mid] == value)
        {
            return mid;
        }
        else if(intArray[mid] > value)
        {
            return Search(intArray, start, mid, value);
        }
        else if(intArray[mid] < value)
        {
            return Search(intArray, mid, end, value);
        }
        else
            return -1;
    }

    public String toString(){
        return "Value " + value + " is located at " + index + ".";
    }
}
