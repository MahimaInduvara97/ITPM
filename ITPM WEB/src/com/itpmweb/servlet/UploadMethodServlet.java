package com.itpmweb.servlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadMethodServlet
 */
@WebServlet("/UploadMethodServlet")
public class UploadMethodServlet extends HttpServlet {
	ArrayList<Integer> Lno_col = new ArrayList<Integer>();
	ArrayList<Integer> Cm_col = new ArrayList<Integer>();
	ArrayList<String> Statment_col = new ArrayList<String>();
	ArrayList<Integer>Wpdtp_col  = new ArrayList<Integer>();
	ArrayList<Integer>Npdtp_col = new ArrayList<Integer>();
	ArrayList<Integer>Wcdtp_col = new ArrayList<Integer>();
	ArrayList<Integer>Ncdtp_col = new ArrayList<Integer>();
	ArrayList<Integer>Wmrt_col = new ArrayList<Integer>();
	int SumCm=0;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path= request.getParameter("path");
		complexity_Methods(path);
		request.setAttribute("Total",SumCm);
		
		request.setAttribute("Lno_col",Lno_col);
		request.setAttribute("Cm_col",Cm_col);
		request.setAttribute("Wpdtp_col",Wpdtp_col);
		request.setAttribute("Statment",Statment_col);
		request.setAttribute("Npdtp_col",Npdtp_col);
		request.setAttribute("Wcdtp_col",Wcdtp_col);
		request.setAttribute("Ncdtp_col",Ncdtp_col);
		request.setAttribute("Wmrt_col",Wmrt_col);
		request.getRequestDispatcher("/MethodTable.jsp").forward(request, response);
		
	}

		public void complexity_Methods(String url) throws IOException{
			
			String filePath=url;
			int NoOfLines;
			
			
			final File file = new File(filePath);
			System.out.println("Upload Successfull");
			
			try
			(
			   FileReader       input = new FileReader(filePath);
			   LineNumberReader count = new LineNumberReader(input);
			)
			{
			   while (count.skip(Long.MAX_VALUE) > 0)
			   {
			      
			   }

			   NoOfLines = count.getLineNumber() + 1;                 
			   System.out.println("File Reading Successfull");
			}
			
			
		    Scanner sc = new Scanner(file);
		    
		    int Cm = 0; //Complexity of a line which includes a method signature

		    int Wmrt = 0; //Weight due to method return type
		    int Wpdtp = 1; //Weight of primitive data type parameters
		    int Npdtp = 0; //Number of primitive data type parameters
		    int Wcdtp = 2; //Weight of composite data type parameters
		    int Ncdtp = 0; //Number of composite data type parameters
		    int Lno = 0;
		    
		    SumCm=0;
		    int myArray[]=new int[NoOfLines];
		    Lno_col.clear();
		    Cm_col.clear();
		    Wpdtp_col.clear();
		    Npdtp_col.clear();
		    Wcdtp_col.clear();
		    Ncdtp_col.clear();
		    Wmrt_col.clear();
		    Statment_col.clear();
		    
		    while (sc.hasNextLine()) {
		        String nextLine = sc.nextLine();
		        Statment_col.add(nextLine);
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
		        Lno++;
		       
		        System.out.print("Lno:" + Lno);
				Lno_col.add(Lno);
				System.out.print("\tCm_col:\t" + Cm_col);
				Cm_col.add(Cm);
				System.out.print("\tNid:\t" + Wpdtp_col);
				Wpdtp_col.add(Wpdtp);
				System.out.print("\tNpdtp:\t" + Npdtp_col);
				Npdtp_col.add(Npdtp);
				System.out.print("\tWcdtp:\t" + Wcdtp_col);
				Wcdtp_col.add(Wcdtp);
				System.out.print("\tNcdtp:\t" + Ncdtp_col);
				Ncdtp_col.add(Ncdtp);
				System.out.print("\tWmrt:\t" + Wmrt_col + "\n");
				Wmrt_col.add(Wmrt);
		        
		        // System.out.println("LNO:"+Lno+"		"+"cm :" +Cm+"	"+"Wmrt:"+Wmrt+"	"+"Wpdtp:"+Wpdtp+"	"+"Npdtp:"+Npdtp+"	"+"Wcdtp:"+Wcdtp+"	"+"Ncdtp:"+Ncdtp);
		       
		       // myArray[Lno-1]=Cm;
			     // SumCm += myArray[Lno-1];
		    }
		    
		sc.close();
		  	}
		
}
