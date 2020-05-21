package com.itpmweb.model;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class method {
	static File file = new File(
			"C:\\Users\\Charuka\\Downloads\\git\\repository\\ITPM WEB\\WebContent\\uploads\\math\\Maths1.java");
  public static void main(String[] args) throws FileNotFoundException{
	  complexity_method();
    
  } 
  
  public static void complexity_method() throws FileNotFoundException {
    Scanner sc = new Scanner(file);

    int Cm = 0; //Complexity of a line which includes a method signature

    int Wmrt = 0; //Weight due to method return type
    int Wpdtp = 1; //Weight of primitive data type parameters
    int Npdtp = 0; //Number of primitive data type parameters
    int Wcdtp = 2; //Weight of composite data type parameters
    int Ncdtp = 0; //Number of composite data type parameters

    while (sc.hasNextLine()) {
        String nextLine = sc.nextLine();
        // System.out.println("\nLINE:\t" + nextLine);

        
        
        
        // ...........STRING LITERAL...........

        String nextLine_Wpdtp = nextLine;
      
        
        String[] methodsprimitive = { "byte", "short", "int", "long", "float", "double", "boolean", "char"};
        String[] methodscompocitive = { "String", "Arrays", "Classes"};
        
        int count_Npdtp = 0;

        for (int i = 0; i < methodsprimitive.length; i++) {
        	
          String str = methodsprimitive[i];
          if(methodsprimitive[i] != "void") {
          int index = 0;
          while (true) {
            index = nextLine_Wpdtp.indexOf(str, index);
            if (index != -1) {
              count_Npdtp++;
              index += str.length();
     
              // System.out.println(str);
            } else {
              break;
            }
          }
          }
          nextLine_Wpdtp = nextLine_Wpdtp.replace(str, "");
        }
      
        Npdtp=count_Npdtp;
        
        String nextLine_Ncdtp = nextLine;
        int count_Ncdtp = 0;

        for (int i = 0; i < methodscompocitive.length; i++) {
          String str = methodscompocitive[i];
          if(methodscompocitive[i] != "void") {
          int index = 0;
          while (true) {
            index = nextLine_Ncdtp.indexOf(str, index);
            if (index != -1) {
              count_Ncdtp++;
              index += str.length();
              
              //System.out.println("str"+str);
            } else {
              break;
            }
          }
          }
          nextLine_Ncdtp = nextLine_Ncdtp.replace(str, "");
        }
       // System.out.println(nextLine_Ncdtp);
        Ncdtp = count_Ncdtp;
        //System.out.println("w"+Wmrt);
        
        Cm = Wmrt + (Wpdtp * Npdtp) + (Wcdtp * Ncdtp);
        System.out.println("cm :" +Cm+"	"+"Wmrt:"+Wmrt+"	"+"Wpdtp:"+Wpdtp+"	"+"Npdtp:"+Npdtp+"	"+"Wcdtp:"+Wcdtp+"	"+"Ncdtp:"+Ncdtp);
        
    }
    
sc.close();
  	}
 }