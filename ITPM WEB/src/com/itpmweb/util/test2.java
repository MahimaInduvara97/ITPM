package com.itpmweb.util;

class Pattern{
    public static void main(String[] args) {
        int rows = 5;
         float rows1 = 55;
        for(int i = 1; i <= rows; ++i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
