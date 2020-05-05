package com.terapico.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class FileUtils {

	public static boolean isReadableFile(File file) {
		return (file.exists() && file.isFile() && file.canRead());
	}

	public static PrintStream createFileForPrint(File file) throws IOException {
		ensureFile(file);
		
		FileOutputStream fout = new FileOutputStream(file);
		PrintStream fprint = new PrintStream(fout);
		return fprint;
	}

	private static void ensureFile(File file) throws IOException {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
		}
		file.createNewFile();
	}
	
	public static String readFileAsString(File inputFile) throws Exception {
		FileInputStream fin = new FileInputStream(inputFile);
		return readInputStreamAsString(fin);
	}

	public static String readInputStreamAsString(InputStream fin) throws IOException {
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

	public static byte[] readFileAsBytes(File inputFile) throws Exception {
		FileInputStream fin = new FileInputStream(inputFile);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		int n;
		byte[] buff = new byte[1024];
		while((n=fin.read(buff)) > 0) {
			bout.write(buff, 0, n);
		}
		fin.close();
		return bout.toByteArray();
	}

	public static String getFilePostFix(String imageUrl, boolean removeQueryParameters, String defVal) {
		if (imageUrl == null || imageUrl.isEmpty()) {
			return defVal;
		}
		int pos = imageUrl.lastIndexOf('?');
		if (pos > 0 && removeQueryParameters) {
			imageUrl = imageUrl.substring(0,pos);
		}
		pos = imageUrl.lastIndexOf('.');
		if (pos > 0) {
			return imageUrl.substring(pos+1);
		}
		return defVal;
	}

	public static void downloadToFile(String url, File file) throws Exception {
		Map<String, Object> result = RestUtil.getAsByteArray(new URI(url));
		byte[] content = (byte[]) result.get("body");
		ensureFile(file);
		try (FileOutputStream fout = new FileOutputStream(file)) {
			fout.write(content);
			fout.close();
		}
		System.out.println("Download [" + url + "] to " + file.getAbsolutePath());
	}

	public static void writeToFile(File file, String content) throws IOException {
		try (PrintStream prn = createFileForPrint(file)){
			prn.print(content);
		}
	}
}
