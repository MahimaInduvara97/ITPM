package com.itpmweb.servlet;

import com.itpmweb.*;

import com.itpmweb.model.CustomFile;
import com.itpmweb.services.Main;
import com.itpmweb.util.UnzipUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServletSize")
public class UploadServletSize extends HttpServlet {
	//private final String UPLOAD_DIRECTORY = Main.WEBCONTENTDIR + "/uploads";

	int SumCs=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String path= request.getParameter("path");
		
		
		complexity_size(path);
		request.setAttribute("TotalSum",SumCs);
		request.getRequestDispatcher("/size.jsp").forward(request, response);
		   
	}

	private void complexity_size(String url) throws IOException {

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

	    int Cs = 0;

	    int Wkw = 1;
	    int Wid = 1;
	    int Wop = 1;
	    int Wnv = 1;
	    int Wsl = 1;

	    int Nkw = 0;
	    int Nid = 0;
	    int Nop = 0;
	    int Nnv = 0;
	    int Nsl = 0;

	    int Nrw = 0;
	    int Lno = 0;
	    
	    SumCs=0;
	    int myArray[]=new int[NoOfLines];

	    while (sc.hasNextLine()) {
	      String nextLine = sc.nextLine();
	      // System.out.println("\nLINE:\t" + nextLine);

	      
	      
	      
	      // ...........STRING LITERAL...........

	      String nextLine_sl = nextLine;
	      int count_sl = 0;

	      Pattern pattern_sl = Pattern.compile("\"[\\w\\s]*\"");
	      Matcher matcher_sl = pattern_sl.matcher(nextLine_sl);
	      while (matcher_sl.find()) {
	        // System.out.println(matcher_sl.group(1));
	        count_sl++;
	      }

	      // System.out.println("STRING LITERAL\t:" + count_sl);
	      Nsl = count_sl;

	      
	      
	      
	      // ...........NUMERIC MATCH...........

	      String nextLine_nv = nextLine;
	      int count_nv = 0;

	      Pattern pattern = Pattern.compile("([0-9]+)");
	      Matcher matcher = pattern.matcher(nextLine_nv);
	      while (matcher.find()) {
	        // System.out.println(matcher.group(1));
	        count_nv++;
	      }

	      // System.out.println("NUMERIC\t:" + count_nv);
	      Nnv = count_nv;

	      
	      
	      
	      // ...........OPARAND MATCH...........

	      String nextLine_op = nextLine;

	      String[] operators1 = { "+", "-", "*", "/", "%", ">", "<", "!", "|", "^", "~", ",", ".", "=" };
	      String[] operators2 = { "++", "--", "==", "!=", ">=", "<=", "--", "&&", "||", "<<", ">>", "->", "::", "+=", "-=",
	          "*=", "/=", "|=", "&=", "%=" };
	      String[] operators3 = { ">>>", "<<<", "<<=", ">>=", "^=" };
	      String[] operators4 = { ">>>=" };

	      int count = 0;

	      for (int i = 0; i < operators4.length; i++) {
	        String str = operators4[i];
	        int index = 0;
	        while (true) {
	          index = nextLine_op.indexOf(str, index);
	          if (index != -1) {
	            count++;
	            index += str.length();
	            // System.out.println(str);
	          } else {
	            break;
	          }
	        }
	        nextLine_op = nextLine_op.replace(str, "");
	      }

	      for (int i = 0; i < operators3.length; i++) {
	        String str = operators3[i];
	        int index = 0;
	        while (true) {
	          index = nextLine_op.indexOf(str, index);
	          if (index != -1) {
	            count++;
	            index += str.length();
	            // System.out.println(str);
	          } else {
	            break;
	          }
	        }
	        nextLine_op = nextLine_op.replace(str, "");
	      }

	      for (int i = 0; i < operators2.length; i++) {
	        String str = operators2[i];
	        int index = 0;
	        while (true) {
	          index = nextLine_op.indexOf(str, index);
	          if (index != -1) {
	            count++;
	            index += str.length();
	            // System.out.println(str);
	          } else {
	            break;
	          }
	        }
	        nextLine_op = nextLine_op.replace(str, "");
	      }

	      for (int i = 0; i < operators1.length; i++) {
	        String str = operators1[i];
	        int index = 0;
	        while (true) {
	          index = nextLine_op.indexOf(str, index);
	          if (index != -1) {
	            count++;
	            index += str.length();
	            // System.out.println(str);
	          } else {
	            break;
	          }
	        }
	        nextLine_op = nextLine_op.replace(str, "");
	      }

	      // System.out.println("OPARAND\t:" + count);
	      Nop = count;

	      
	      
	      
	      // ...........KEY WORD MATCH...........

	      String nextLine_kw = nextLine;

	      String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
	          "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto",
	          "if", "implements", "import", "instanceof", "int", "interface", "long", "nativ", "new", "package", "private",
	          "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
	          "throw", "throws", "transient", "try", "void", "volatile", "while" };

	      nextLine_kw = nextLine_kw.replace("{", " ");
	      nextLine_kw = nextLine_kw.replace("}", " ");
	      nextLine_kw = nextLine_kw.replace("(", " ");
	      nextLine_kw = nextLine_kw.replace(")", " ");
	      nextLine_kw = nextLine_kw.replace("[", " ");
	      nextLine_kw = nextLine_kw.replace("]", " ");
	      nextLine_kw = nextLine_kw.replace(".", " ");
	      nextLine_kw = nextLine_kw.replace(";", " ");
	      nextLine_kw = nextLine_kw.replace("  ", " ");

	      String[] nextLineParts = nextLine_kw.split(" ");

	      int keywordCountTotal = 0;
	      for (int j = 0; j < keywords.length; j++) {
	        int keywordCount = 0;
	        for (int i = 0; i < nextLineParts.length; i++) {
	          if (keywords[j].equals(nextLineParts[i])) {
	            // System.out.println(keywords[j]);
	            keywordCount++;
	          }
	        }
	        keywordCountTotal += keywordCount;
	      }

	      Nkw = keywordCountTotal;

	      
	      
	      
	      // ...........RESERVED WORDS...........

	      String nextLine_rw = nextLine;

	      String[] reservedWords = {"String", "Boolean","do-while", "main"};

	      nextLine_rw = nextLine_rw.replace("{", " ");
	      nextLine_rw = nextLine_rw.replace("}", " ");
	      nextLine_rw = nextLine_rw.replace("(", " ");
	      nextLine_rw = nextLine_rw.replace(")", " ");
	      nextLine_rw = nextLine_rw.replace("[", " ");
	      nextLine_rw = nextLine_rw.replace("]", " ");
	      nextLine_rw = nextLine_rw.replace(".", " ");
	      nextLine_rw = nextLine_rw.replace(";", " ");
	      nextLine_rw = nextLine_rw.replace("  ", " ");

	      // System.out.println(nextLine_rw);

	      String[] nextLineParts02 = nextLine_rw.split(" ");

	      int reservedWordsCountTotal = 0;

	      for (int j = 0; j < reservedWords.length; j++) {
	        int reservedWordsCount = 0;
	        for (int i = 0; i < nextLineParts02.length; i++) {
	          if (reservedWords[j].equals(nextLineParts02[i])) {
	            // System.out.println(reservedWords[j]);
	            reservedWordsCount++;
	          }
	        }
	        reservedWordsCountTotal += reservedWordsCount;
	      }

	      Nrw = reservedWordsCountTotal;

	      
	      
	      
	      // ...........IDENTIFIER...........

	      String nextLine_id = nextLine;
	      int count_id = 0;

	      Pattern pattern_id = Pattern.compile("(?:\\b[_a-zA-Z]|\\B\\$)[_$a-zA-Z0-9]*+");
	      Matcher matcher_id = pattern_id.matcher(nextLine_id);
	      while (matcher_id.find()) {
	        // System.out.println(matcher_id.group(1));
	        count_id++;
	      }

	      count_id = count_id - Nkw - Nrw; // Remove Keywords + Reserved Words

	      Nid = count_id;




	      // ...........COMPLEXITY SIZE...........

	      Cs = (Wkw * Nkw) + (Wid * Nid) + (Wop * Nop) + (Wnv * Nnv) + (Wsl * Nsl);
	      
	      
	      
	      Lno ++;
	      
	      
	      System.out.print("Lno:" + Lno);
	      System.out.print("\tNkw:\t" + Nkw);
	      System.out.print("\tNid:\t" + Nid);
	      System.out.print("\tNop:\t" + Nop);
	      System.out.print("\tNnv:\t" + Nnv);
	      System.out.print("\tNsl:\t" + Nsl);
	      System.out.print("\tCs:\t" + Cs + "\n");
	      
	      myArray[Lno-1]=Cs;
	      SumCs += myArray[Lno-1];
	      
	    }
	    
	    
	    //System.out.println(SumCs);
	    sc.close();
	  
	 
	    
	}
	

	

}
