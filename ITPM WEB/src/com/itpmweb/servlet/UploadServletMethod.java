package com.itpmweb.servlet;

import com.itpmweb.*;
import com.itpmweb.model.SizeTable;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.xml.ws.Action;

//import ArrayUtils.contains;
import java.util.*;

@WebServlet("/UploadServletMethod")
public class UploadServletMethod extends HttpServlet {
	// private final String UPLOAD_DIRECTORY = Main.WEBCONTENTDIR + "/uploads";
	ArrayList<Integer> Lno_col = new ArrayList<Integer>();
	ArrayList<String> Statment_col = new ArrayList<String>();
	ArrayList<Integer> Wmrt_col = new ArrayList<Integer>();
	ArrayList<Integer> Npdtp_col = new ArrayList<Integer>();
	ArrayList<Integer> Ncdtp_col = new ArrayList<Integer>();
	ArrayList<Integer> Cm_col = new ArrayList<Integer>();
	ArrayList<String> statements = new ArrayList<String>();

	int SumCs = 0;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("weights Worked!");
		complexity_varible(req,resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		


		String path = request.getParameter("path");
		if (!(path.contains("java") || path.contains("cpp"))) {
			System.out.println("Upload UnSuccessful. Wrong File Format");
			ArrayList<String> message = new ArrayList<String>();
			request.setAttribute("message", "Upload UnSuccessful. Wrong File Format");
			request.getRequestDispatcher("/method.jsp").forward(request, response);
			
		} else {
			
			final File file = new File(path);

			System.out.println("Upload Successfull");

			try (FileReader input = new FileReader(path); LineNumberReader count = new LineNumberReader(input);) {
				while (count.skip(Long.MAX_VALUE) > 0) {

				}
				System.out.println("File Reading Successfull");
			}
			Scanner sc = new Scanner(file);
			System.out.println("Upload Successfull");

			while(sc.hasNext()) {
				statements.add(sc.nextLine());
			}
			sc.close();
			
		complexity_varible(request,response);

	}
	}
	
	private void complexity_varible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Statment_col.clear();
		
		ArrayList<Integer> weights = new ArrayList<Integer>();
		
		


		int SumCs = 0;

		int Wpdtp = 1;
		int Wcdtp=2;
		int Wvrt = 0;
		int Wprt = 1;
		int Wcrt = 2;
		
		try {
			Wpdtp = Integer.parseInt(request.getParameter("weightPdtp"));
		}catch (Exception e) {
			Wpdtp	= 1;
		}
		try {
			Wcdtp  = Integer.parseInt(request.getParameter("weightCdtp"));
		}catch (Exception e) {
			Wcdtp	= 2;
		}try {
			Wvrt = Integer.parseInt(request.getParameter("weightVrt"));
		}catch (Exception e) {
			Wvrt		= 0;
		}try {
			Wprt = Integer.parseInt(request.getParameter("weightPrt"));
		}catch (Exception e) {
			Wprt		= 1; 
		}try {
			Wcrt = Integer.parseInt(request.getParameter("weightCrt"));
		}catch (Exception e) {
			Wcrt		= 2; 
		}
		
		weights.add(Wprt);
		weights.add(Wcrt);
		weights.add(Wvrt);
		weights.add(Wpdtp);
		weights.add(Wcdtp);
		
		Lno_col.clear();
		Wmrt_col.clear();
		Npdtp_col.clear();
		Ncdtp_col.clear();
		Cm_col.clear();

		
		
		for(int k=0; k<statements.size();k++) {
			String line = statements.get(k);

				int Wmrt=0;
				int Cm = 0;
				int Npdtp = 0;
				int Ncdtp = 0;
				boolean pdtp = false;
				boolean wmrtIsPrimitive = false;

		        // ...........STRING LITERAL...........

		        String nextLine_Wpdtp = line;
		        String[] primitive = { "byte", "short", "int", "long", "float", "double", "boolean", "char"};
		        String[] compocitive = { "String", "Arrays", "Classes"};

		        if(line.contains("public") && line.contains("(") && line.contains(")")) {
	    			
	    			int mstart = line.indexOf("public");
	    			int mend = line.indexOf("(");
	    			String method = line.substring(mstart, mend);
	    			String[] methodToken = method.split(" ");
	    			for(String m : methodToken) {
	    				System.out.println("method withot param : "+m);
	    			}
	    			
	    			if(line.contains("(") && line.contains(")")) {
	    				System.out.println("parameter true");
	    				int start = line.indexOf("(");
	    				int end = line.indexOf(")")+1;
	    				
	    				String parameters = line.substring(start, end);
	    				String[] params = parameters.split(",");
	    				
	    				
	    				if(!params[0].equals("()")) {
	    					System.out.println("parameters are : "+parameters);
	    					for (int i = 0; i < params.length; i++) {
	    						for(String p : primitive) {
	    							if(params[i].contains(p)) {
	    								Npdtp++;
	    								pdtp = true;
	    							}
	    						}
	    						
	    						if(!pdtp) {
	    							Ncdtp++;
	    						}
	    						
	    						pdtp = false;
	    					}
	    				}else {
	    					System.out.println("parameters are : NULL");
	    					Npdtp = 0;
	    				}
	    				

	    				System.out.println("primitive no : "+Npdtp);
	    				System.out.println("Compocition no : "+Ncdtp);
	    			}
	    			
	    			
	    			if(methodToken[1].contains("void") || methodToken[2].contains("void")) {
	    				Wmrt = 0;
	    				System.out.println("void found at line "+k);
	    				
	    			}else{
		    			for(int i=0;i<primitive.length;i++)
		    			{
		    				if(methodToken[1].equals(primitive[i]) || methodToken[2].equals(primitive[i]))
		    				{
		    					Wmrt = 1;
		    					System.out.println("primitive "+primitive[i]+" found at line "+k);

		    				}

		    			}
		    			
		    			if(!wmrtIsPrimitive) {
		    				Wmrt = 2;
							System.out.println("composite  found at line "+k);
							
		    			}
		    			
		    			wmrtIsPrimitive = false;
		    		}
	    			
	    			
			        Cm  = Wmrt + (Wpdtp * Npdtp) + (Wcdtp * Ncdtp);


		    	}
		    	
		    	System.out.println("Line : "+k);
		    	System.out.println("Wmrt : "+ Wmrt);
		    	System.out.println("Npdtp : "+Npdtp);
		    	System.out.println("Ncdtp : "+Ncdtp);
		    	System.out.println("---------------------------- \n");
		    	
		    	Statment_col.add(line);
				Wmrt_col.add(Wmrt);
				Npdtp_col.add(Npdtp);
				Ncdtp_col.add(Ncdtp);
				Cm_col.add(Cm);

	       
		}
		
		System.out.println("statmnt size: "+Statment_col.size());
		System.out.println("Wmrt_col size: "+Wmrt_col.size());
		System.out.println("Npdtp_col size: "+Npdtp_col.size());
		System.out.println("Ncdtp_col size: "+Ncdtp_col.size());
		System.out.println("Cm_col size: "+Cm_col.size());
		
		request.setAttribute("Statment", Statment_col);
		request.setAttribute("Wmrt_col", Wmrt_col);
		request.setAttribute("Npdtp_col", Npdtp_col);
		request.setAttribute("Ncdtp_col", Ncdtp_col);
		request.setAttribute("Cm_col", Cm_col);
		request.setAttribute("weights", weights);
		request.getRequestDispatcher("/MethodTableDisplay.jsp").forward(request, response);

	}
}
