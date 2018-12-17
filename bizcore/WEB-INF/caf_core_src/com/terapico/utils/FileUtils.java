package com.terapico.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {

	public static boolean isReadableFile(File file) {
		return (file.exists() && file.isFile() && file.canRead());
	}

	public static PrintStream createFileForPrint(File file) throws IOException {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
		}
		file.createNewFile();
		
		FileOutputStream fout = new FileOutputStream(file);
		PrintStream fprint = new PrintStream(fout);
		return fprint;
	}
	
	public static String readFileAsString(File inputFile) throws Exception {
		FileInputStream fin = new FileInputStream(inputFile);
		InputStreamReader reader = new InputStreamReader(fin, StandardCharsets.UTF_8);
		StringBuilder sb = new StringBuilder();
		char[] buff = new char[1024];
		int n;
		while((n=reader.read(buff)) > 0) {
			sb.append(buff,0, n);
		}
		fin.close();
		return sb.toString();
	}

}
