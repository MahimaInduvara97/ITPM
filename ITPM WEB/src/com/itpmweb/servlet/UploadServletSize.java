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

//import ArrayUtils.contains;
import java.util.*;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServletSize")
public class UploadServletSize extends HttpServlet {
	// private final String UPLOAD_DIRECTORY = Main.WEBCONTENTDIR + "/uploads";
	ArrayList<Integer> Lno_col = new ArrayList<Integer>();
	ArrayList<String> Statment_col = new ArrayList<String>();
	ArrayList<Integer> Nkw_col = new ArrayList<Integer>();
	ArrayList<Integer> Nid_col = new ArrayList<Integer>();
	ArrayList<Integer> Nop_col = new ArrayList<Integer>();
	ArrayList<Integer> Nnv_col = new ArrayList<Integer>();
	ArrayList<Integer> Nsl_col = new ArrayList<Integer>();
	ArrayList<Integer> Cs_col = new ArrayList<Integer>();
	ArrayList<String> statements = new ArrayList<String>();

	int SumCs = 0;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("weights Worked!");
		String path = req.getParameter("path");
		complexity_size(path,req,resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getParameter("path");
		if (!(path.contains("java") || path.contains("cpp"))) {
			System.out.println("Upload UnSuccessful. Wrong File Format");
			ArrayList<String> message = new ArrayList<String>();
			request.setAttribute("message", "Upload UnSuccessful. Wrong File Format");
			request.getRequestDispatcher("/size.jsp").forward(request, response);
			
		} else {

		complexity_size(path,request,response);
		request.setAttribute("Lno_col", Lno_col);
		request.setAttribute("Statment", Statment_col);
		request.setAttribute("Nkw_col", Nkw_col);
		request.setAttribute("Nid_col", Nid_col);
		request.setAttribute("Nop_col", Nop_col);
		request.setAttribute("Nnv_col", Nnv_col);
		request.setAttribute("Nsl_col", Nsl_col);
		request.setAttribute("Cs_col", Cs_col);
		request.getRequestDispatcher("/SizeTableDisplay.jsp").forward(request, response);

	}
	}
	private void complexity_size(String url,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = url;
		int NoOfLines;

		final File file = new File(filePath);

		System.out.println("Upload Successfull");

		try (FileReader input = new FileReader(filePath); LineNumberReader count = new LineNumberReader(input);) {
			while (count.skip(Long.MAX_VALUE) > 0) {

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
		
		ArrayList<Integer> weights = new ArrayList<Integer>();
		
		try {
			Wkw = Integer.parseInt(request.getParameter("weightKey"));
		}catch (Exception e) {
			Wkw	= 1;
		}
		try {
			Wid  = Integer.parseInt(request.getParameter("weightIdent"));
		}catch (Exception e) {
			Wid	= 1;
		}try {
			Wop = Integer.parseInt(request.getParameter("weightOp"));
		}catch (Exception e) {
			Wop		= 1;
		}try {
			Wnv = Integer.parseInt(request.getParameter("weightNume"));
		}catch (Exception e) {
			Wnv		= 1; 
		}try {
			Wsl = Integer.parseInt(request.getParameter("weightSl"));
		}catch (Exception e) {
			Wsl		= 1; 
		}
  
		weights.add(Wkw);
		weights.add(Wid);
		weights.add(Wop);
		weights.add(Wnv);
		weights.add(Wsl);
		
		Lno_col.clear();
		Nkw_col.clear();
		Nid_col.clear();
		Nop_col.clear();
		Nnv_col.clear();
		Nsl_col.clear();
		Cs_col.clear();
		
		
		while (sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			Statment_col.add(nextLine);

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
			String[] operators2 = { "++", "--", "==", "!=", ">=", "<=", "--", "&&", "||", "<<", ">>", "->", "::", "+=",
					"-=", "*=", "/=", "|=", "&=", "%=" };
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

			String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
					"const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally",
					"float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
					"nativ", "new", "package", "private", "protected", "public", "return", "short", "static",
					"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
					"void", "volatile", "while" };

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

			String[] reservedWords = { "String", "Boolean", "do-while", "main" };

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

			Lno++;

			System.out.print("Lno:" + Lno);
			Lno_col.add(Lno);
			System.out.print("\tNkw:\t" + Nkw);
			Nkw_col.add(Nkw);
			System.out.print("\tNid:\t" + Nid);
			Nid_col.add(Nid);
			System.out.print("\tNop:\t" + Nop);
			Nop_col.add(Nop);
			System.out.print("\tNnv:\t" + Nnv);
			Nnv_col.add(Nnv);
			System.out.print("\tNsl:\t" + Nsl);
			Nsl_col.add(Nsl);
			System.out.print("\tCs:\t" + Cs + "\n");
			Cs_col.add(Cs);

			// myArray[Lno-1]=Cs;
			// SumCs += myArray[Lno-1];

		}
		sc.close();

	}
}
