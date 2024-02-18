package com.recursion;

public class Patterns {
    public static void main(String[] args) {
    triangle(4, 0);
    }
    static void reverseTriangle(int r, int c){
        if(r == 0) return;
        if(c < r){
            System.out.print("*");
            reverseTriangle(r, c + 1);
        }
        else{
            System.out.println();
            reverseTriangle(r - 1, 0);
        }
    }
    static void triangle(int r, int c){
        if(r == 0) return;
        if(c < r){
            triangle(r, c + 1);
            System.out.print("*");
        }
        else{
            triangle(r - 1, 0);
            System.out.println();
        }
    }
}
