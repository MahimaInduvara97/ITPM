package com.itpmweb.services;

import com.itpmweb.model.CustomFile;
import com.itpmweb.model.FileRead;

public interface FileReadService {
	
	public void openFile(FileRead file, CustomFile fileobj);
	public void readFile(FileRead file, CustomFile fileobj);
	public void closeFile(FileRead file);
	
}
