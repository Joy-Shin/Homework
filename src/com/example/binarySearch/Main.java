package com.example.binarySearch;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] oddsArray = new int[]{1,3,5,7,9,11,13,15};
        BinarySearch b = new BinarySearch(intArray, 1, 10, 7);
        //BinarySearch bi = new BinarySearch(oddsArray, 1, 15, 7);
        System.out.println(b);
        //System.out.println(bi);
    }
}
