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


@WebServlet("/UploadServletVariables")
public class UploadServletVariables extends HttpServlet {
	// private final String UPLOAD_DIRECTORY = Main.WEBCONTENTDIR + "/uploads";
	ArrayList<Integer> Lno_col = new ArrayList<Integer>();
	ArrayList<String> Statment_col = new ArrayList<String>();
	ArrayList<Integer> Wvs_col = new ArrayList<Integer>();
	ArrayList<Integer> Npdtv_col = new ArrayList<Integer>();
	ArrayList<Integer> Ncdtv_col = new ArrayList<Integer>();
	ArrayList<Integer> Cv_col = new ArrayList<Integer>();
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
			request.getRequestDispatcher("/variable.jsp").forward(request, response);
			
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

		int Wgv = 2;
		int Wlv = 1;
		int Wpdtv = 1;
		int Wcdtv = 2;
		
		try {
			Wgv = Integer.parseInt(request.getParameter("weighglob"));
		}catch (Exception e) {
			Wgv	= 2;
		}
		try {
			Wlv  = Integer.parseInt(request.getParameter("weightloc"));
		}catch (Exception e) {
			Wlv	= 1;
		}try {
			Wpdtv = Integer.parseInt(request.getParameter("weightpv"));
		}catch (Exception e) {
			Wpdtv		= 1;
		}try {
			Wcdtv = Integer.parseInt(request.getParameter("weightcv"));
		}catch (Exception e) {
			Wcdtv		= 2; 
		}
		
		
		weights.add(Wgv);
		weights.add(Wlv);
		weights.add(Wpdtv);
		weights.add(Wcdtv);
		
		Lno_col.clear();
		Wvs_col.clear();
		Npdtv_col.clear();
		Ncdtv_col.clear();
		Cv_col.clear();
		
		
		for(int k=0; k<statements.size();k++) {
			String line = statements.get(k);

				int Wvs=0;
				int Cv = 0;
				int Npdtv = 0;
				int Ncdtv = 0;
				boolean pdtp = false;
				boolean wmrtIsPrimitive = false;

		        // ...........STRING LITERAL...........

		        String nextLine_Wpdtv = line;
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
	    								Npdtv++;
	    								pdtp = true;
	    							}
	    						}
	    						
	    						if(!pdtp) {
	    							Ncdtv++;
	    						}
	    						
	    						pdtp = false;
	    					}
	    				}else {
	    					System.out.println("parameters are : NULL");
	    					Npdtv = 0;
	    				}
	    				

	    				System.out.println("primitive no : "+Npdtv);
	    				System.out.println("Compocition no : "+Ncdtv);
	    			}
	    			
	    			
	    			if(methodToken[1].contains("void") || methodToken[2].contains("void")) {
	    				Wvs = 0;
	    				System.out.println("void found at line "+k);
	    				
	    			}else{
		    			for(int i=0;i<primitive.length;i++)
		    			{
		    				if(methodToken[1].equals(primitive[i]) || methodToken[2].equals(primitive[i]))
		    				{
		    					Wvs = 1;
		    					System.out.println("primitive "+primitive[i]+" found at line "+k);

		    				}

		    			}
		    			
		    			if(!wmrtIsPrimitive) {
		    				Wvs = 2;
							System.out.println("composite  found at line "+k);
							
		    			}
		    			
		    			wmrtIsPrimitive = false;
		    		}
	    			
	    			
			        Cv  = Wvs * (Wpdtv * Npdtv) + (Wcdtv * Ncdtv);


		    	}
		    	
		    	System.out.println("Line : "+k);
		    	System.out.println("Wvs : "+ Wvs);
		    	System.out.println("Npdtv : "+Npdtv);
		    	System.out.println("Ncdtv : "+Ncdtv);
		    	System.out.println("---------------------------- \n");
		    	
		    	Statment_col.add(line);
				Wvs_col.add(Wvs);
				Npdtv_col.add(Npdtv);
				Ncdtv_col.add(Ncdtv);
				Cv_col.add(Cv);

	       
		}
		
		System.out.println("statmnt size: "+Statment_col.size());
		System.out.println("Wvs_col size: "+Wvs_col.size());
		System.out.println("Npdtv_col size: "+Npdtv_col.size());
		System.out.println("Ncdtv_col size: "+Ncdtv_col.size());
		System.out.println("Cv_col size: "+Cv_col.size());
		
		request.setAttribute("Statment", Statment_col);
		request.setAttribute("Wvs_col", Wvs_col);
		request.setAttribute("Npdtv_col", Npdtv_col);
		request.setAttribute("Ncdtv_col", Ncdtv_col);
		request.setAttribute("Cv_col", Cv_col);
		request.setAttribute("weights", weights);
		request.getRequestDispatcher("/VariableTableDisplay.jsp").forward(request, response);

	}
}
