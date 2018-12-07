package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here


        Scanner sc = new Scanner(System.in);

        try {

            double l = sc.nextDouble();
            double w = sc.nextDouble();
            double h = sc.nextDouble();
            Box box = new Box(l, w, h);
            System.out.println(box.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
