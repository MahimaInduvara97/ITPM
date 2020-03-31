package com.itpmweb.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.itpmweb.model.CustomFile;
import com.itpmweb.model.FileRead;
import com.itpmweb.model.Line;

public class FileReadServiceImp implements FileReadService{

	@Override
	public void openFile(FileRead file, CustomFile fileobj) {
		try{
			file.setScanner(new Scanner(new File(fileobj.getFilePath() + file.getFileName()))); 
        }catch(Exception e){
            System.out.println("Couldn't find the file.");
        }
	}

	@Override
	public void readFile(FileRead file, CustomFile fileobj) {
		int count=1;
		ArrayList<Line> lineSet = new ArrayList<Line>();
		while(file.getScanner().hasNext()){
			Line line = new Line(count, file.getScanner().nextLine());
			lineSet.add(line);
			count++;
        }
		fileobj.setLineSet(lineSet);
		fileobj.setLastIndex(lineSet.size());
	}

	@Override
	public void closeFile(FileRead file) {
		file.getScanner().close();
	}
	
}
