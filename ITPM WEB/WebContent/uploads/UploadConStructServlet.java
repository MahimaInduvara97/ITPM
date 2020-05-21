package com.itpmweb.servlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadMethodServlet
 */
@WebServlet("/UploadConStructServlet")
public class UploadConStructServlet extends HttpServlet {
	ArrayList<Integer> Lno_col = new ArrayList<Integer>();
	ArrayList<String> Statment_col = new ArrayList<String>();
	ArrayList<Integer>Ccs_col = new ArrayList<Integer>();
	ArrayList<Integer>Nccs_col  = new ArrayList<Integer>();
	ArrayList<Integer>Nics_col = new ArrayList<Integer>();
	ArrayList<Integer>Nswitch_col = new ArrayList<Integer>();
	ArrayList<Integer>Ncase_col = new ArrayList<Integer>();
	ArrayList<Integer>Ccspps_col = new ArrayList<Integer>();
	
	//int SumCm=0;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path= request.getParameter("path");
		
		if (!(path.contains("java") || path.contains("cpp"))) {
			System.out.println("Upload UnSuccessful. Wrong File Format");
			ArrayList<String> message = new ArrayList<String>();
			request.setAttribute("message", "Upload UnSuccessful. Wrong File Format");
			request.getRequestDispatcher("/controlStruture.jsp").forward(request, response);
			
		} else {
		//int Wccs=Integer.parseInt(request.getParameter("Wccs"));
		//int Wics=Integer.parseInt(request.getParameter("Wics"));
		//int Wswitch=Integer.parseInt(request.getParameter("Wswitch"));
		//int Wcase=Integer.parseInt(request.getParameter("Wcase"));
		
		complexity_ControlStructure(path);
		//request.setAttribute("Total",SumCm);
		
		request.setAttribute("Lno_col",Lno_col);
		
		request.setAttribute("Statment",Statment_col);
		request.setAttribute("Ccs_col",Ccs_col);
		request.setAttribute("Nccs_col",Nccs_col);
		
		request.setAttribute("Nics_col",Nics_col);
		request.setAttribute("Nswitch_col",Nswitch_col);
		request.setAttribute("Ncase_col",Ncase_col);
		request.setAttribute("Ccspps_col",Ccspps_col);
		
		request.getRequestDispatcher("/controlSructuretable.jsp").forward(request, response);
		
	}
	}
		public void complexity_ControlStructure(String url ) throws IOException{
			
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
		    
		   

		    int Ccs = 0;

		  /*  int Wccs = 2;
		    int Wics = 3;
		    int Wswitch = 2;
		    int Wcase = 1;
		    */
		    int Wccs = 2;
		    int Wics = 3;
		    int Wswitch = 2;
		    int Wcase = 1;
		    
		   //  Wccs = tWccs;
		    // Wics = tWics;
		    //Wswitch = tWswitch;
		    // Wcase = tWcase;

		    int Nccs = 0;
		    int Nics = 0;
		    int Nswitch = 0;
		    int Ncase = 0;

		    int Lno = 0;
		    int Ccspps = 0;
		    int Ccspps_temp = 0;

		    Stack<Integer> stack = new Stack<Integer>(); 
		    
		    Lno_col.clear();
		    Statment_col.clear();
		    Ccs_col.clear();
		    Nccs_col.clear();
		    Nics_col.clear();
		    Nswitch_col.clear();
		    Ncase_col.clear();
		    Ccspps_col.clear();
		    
		    while (sc.hasNextLine()) {
		      String nextLine = sc.nextLine();
		      Statment_col.add(nextLine);
		      System.out.print("\nLINE  "+ Lno + ":\t");
		      Lno_col.add(Lno);
		      // System.out.println(nextLine);

		      int Nccs_temp = 0;
		      int Nics_temp = 0;
		      int Nswitch_temp = 0;
		      int Ncase_temp = 0;
		      // int Ccspps_temp = 0;

		      Pattern pattern_if = Pattern.compile("if\\s*\\(");
		      Matcher matcher_if = pattern_if.matcher(nextLine);
		      while (matcher_if.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(2);
		        Ccspps_temp += 2;
		        Nccs_temp++;
		      }

		      Pattern pattern_else = Pattern.compile("else\\s*\\:");
		      Matcher matcher_else= pattern_else.matcher(nextLine);
		      while (matcher_else.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(2);
		        Ccspps_temp += 2;
		        Nccs_temp++;
		      }

		      Pattern pattern_elseif = Pattern.compile("else\\s*if\\s*\\(");
		      Matcher matcher_elseif = pattern_elseif.matcher(nextLine);
		      while (matcher_elseif.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(2);
		        Ccspps_temp += 2;
		        Nccs_temp++;
		      }

		      // ...........................................................
		      
		      Pattern pattern_for = Pattern.compile("for\\s*\\(");
		      Matcher matcher_for = pattern_for.matcher(nextLine);
		      while (matcher_for.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(3);
		        Ccspps_temp += 3;
		        Nics_temp++;
		      }

		      Pattern pattern_while = Pattern.compile("while\\s*\\(");
		      Matcher matcher_while = pattern_while.matcher(nextLine);
		      while (matcher_while.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(3);
		        Ccspps_temp += 3;
		        Nics_temp++;
		      }

		      Pattern pattern_dowhile = Pattern.compile("do\\s*\\{");
		      Matcher matcher_dowhile = pattern_dowhile.matcher(nextLine);
		      while (matcher_dowhile.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(3);
		        Ccspps_temp += 3;
		        Nics_temp++;
		      }

		      // ...........................................................

		      Pattern pattern_switch = Pattern.compile("switch\\s*\\(");
		      Matcher matcher_switch = pattern_switch.matcher(nextLine);
		      while (matcher_switch.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(2);
		        Ccspps_temp += 2;
		        Nswitch_temp++;
		      }

		      // ...........................................................

		      Pattern pattern_case = Pattern.compile("case\\s*\\:");
		      Matcher matcher_case= pattern_case.matcher(nextLine);
		      while (matcher_case.find()) {
		        // System.out.println(matcher.group(1));
		        stack.push(1);
		        Ccspps_temp += 2;
		        Ncase_temp++;
		      }

		      // ...........................................................

		      Pattern pattern_pop = Pattern.compile("\\}");
		      Matcher matcher_pop= pattern_pop.matcher(nextLine);
		      while (matcher_pop.find()) {
		        // System.out.println(matcher.group(1));
		        int stack_size = stack.size();
		        if(stack_size>0){
		          int poped_value = stack.pop();
		          // System.out.println("POPED" + poped_value);
		          Ccspps_temp -= poped_value;
		          if(Ccspps_temp>0){
		            Ccspps += Ccspps_temp;
		          }
		        }
		      }

		      Nccs += Nccs_temp;
		      Nics += Nics_temp;
		      Nswitch += Nswitch_temp;
		      Ncase += Ncase_temp;

		      System.out.print("\tNccs:\t" + Nccs_col);
		      Nccs_col.add(Nccs_temp);
		      System.out.print("\tNics:\t" + Nics_col);
		      Nics_col.add(Nics_temp);
		      System.out.print("\tNswitch:\t" + Nswitch_col);
		      Nswitch_col.add( Nswitch_temp);
		      System.out.print("\tNcase:\t" +  Ncase_col);
		      Ncase_col.add( Ncase_temp);
		      System.out.print("\tCcspps_temp:\t" + Ccspps_col);
		      Ccspps_col.add( Ccspps_temp);
		      
		      Ccs = (Nccs_temp * Wccs) + (Nics_temp * Wics) + (Nswitch_temp * Wswitch) + (Ncase_temp * Wcase) + Ccspps_temp;
			    System.out.print("\tCcs :\t" + Ccs_col);
			      Ccs_col.add(Ccs);
		      
		   
		     
		      Lno++;

		    }

		    
		  /*  Ccs = (Nccs * Wccs) + (Nics * Wics) + (Nswitch * Wswitch) + (Ncase * Wcase) + Ccspps;
		    System.out.print("\tCcs :\t" + Ccs_col);
		      Ccs_col.add( Ccs);
		      
		    System.out.print("Lno:" +Lno_col);
			Lno_col.add(Lno);
			System.out.println("\tCcs:\t\t" + Ccs_col);
			Ccs_col.add(Ccs);
		    System.out.println("\n\n\tNccs:\t\t" +Nccs_col);
		   Nccs_col.add(Nccs);
		    System.out.println("\tNics:\t\t" + Nics_col);
		    Nics_col.add(Nics);
		    System.out.println("\tNswitch:\t" + Nswitch);
		   Nswitch_col.add(Nswitch);
		    System.out.println("\tNcase:\t\t" + Ncase);
		    Ncase_col.add(Ncase);
		    System.out.println("\tCcspps:\t\t" + Ccspps);
		    Ccspps_col.add(Ccspps);
		    
*/
		    sc.close();
		  }
		
}

