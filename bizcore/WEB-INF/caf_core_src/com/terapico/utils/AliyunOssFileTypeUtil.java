package com.terapico.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AliyunOssFileTypeUtil {
	private static final Map<String, String> data = new HashMap<>();
	private static final Map<String, String> foundResult = new HashMap<>();
	static {
		data.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet","xlsx");
		data.put("application/vnd.openxmlformats-officedocument.spreadsheetml.template","xltx");
		data.put("application/vnd.openxmlformats-officedocument.presentationml.template","potx");
		data.put("application/vnd.openxmlformats-officedocument.presentationml.slideshow","ppsx");
		data.put("application/vnd.openxmlformats-officedocument.presentationml.presentation","pptx");
		data.put("application/vnd.openxmlformats-officedocument.presentationml.slide","sldx");
		data.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document","docx");
		data.put("application/vnd.openxmlformats-officedocument.wordprocessingml.template","dotx");
		data.put("application/vnd.ms-excel.addin.macroEnabled.12","xlam");
		data.put("application/vnd.ms-excel.sheet.binary.macroEnabled.12","xlsb");
		data.put("application/vnd.android.package-archive","apk");
		data.put("application/mac-binhex40","hqx");
		data.put("application/mac-compactpro","cpt");
		data.put("application/msword","doc");
		data.put("application/ogg","ogg");
		data.put("application/pdf","pdf");
		data.put("text/rtf","rtf");
		data.put("application/vnd.mif","mif");
		data.put("application/vnd.ms-excel","xls");
		data.put("application/vnd.ms-powerpoint","ppt");
		data.put("application/vnd.oasis.opendocument.chart","odc");
		data.put("application/vnd.oasis.opendocument.database","odb");
		data.put("application/vnd.oasis.opendocument.formula","odf");
		data.put("application/vnd.oasis.opendocument.graphics","odg");
		data.put("application/vnd.oasis.opendocument.graphics-template","otg");
		data.put("application/vnd.oasis.opendocument.image","odi");
		data.put("application/vnd.oasis.opendocument.presentation","odp");
		data.put("application/vnd.oasis.opendocument.presentation-template","otp");
		data.put("application/vnd.oasis.opendocument.spreadsheet","ods");
		data.put("application/vnd.oasis.opendocument.spreadsheet-template","ots");
		data.put("application/vnd.oasis.opendocument.text","odt");
		data.put("application/vnd.oasis.opendocument.text-master","odm");
		data.put("application/vnd.oasis.opendocument.text-template","ott");
		data.put("application/vnd.oasis.opendocument.text-web","oth");
		data.put("application/vnd.sun.xml.writer","sxw");
		data.put("application/vnd.sun.xml.writer.template","stw");
		data.put("application/vnd.sun.xml.calc","sxc");
		data.put("application/vnd.sun.xml.calc.template","stc");
		data.put("application/vnd.sun.xml.draw","sxd");
		data.put("application/vnd.sun.xml.draw.template","std");
		data.put("application/vnd.sun.xml.impress","sxi");
		data.put("application/vnd.sun.xml.impress.template","sti");
		data.put("application/vnd.sun.xml.writer.global","sxg");
		data.put("application/vnd.sun.xml.math","sxm");
		data.put("application/vnd.symbian.install","sis");
		data.put("application/vnd.wap.wbxml","wbxml");
		data.put("application/vnd.wap.wmlc","wmlc");
		data.put("application/vnd.wap.wmlscriptc","wmlsc");
		data.put("application/x-bcpio","bcpio");
		data.put("application/x-bittorrent","torrent");
		data.put("application/x-bzip2","bz2");
		data.put("application/x-cdlink","vcd");
		data.put("application/x-chess-pgn","pgn");
		data.put("application/x-cpio","cpio");
		data.put("application/x-csh","csh");
		data.put("application/x-dvi","dvi");
		data.put("application/x-futuresplash","spl");
		data.put("application/x-gtar","gtar");
		data.put("application/x-hdf","hdf");
		data.put("application/x-java-archive","jar");
		data.put("application/x-java-jnlp-file","jnlp");
		data.put("application/x-javascript","js");
		data.put("application/x-kspread","ksp");
		data.put("application/x-kchart","chrt");
		data.put("application/x-killustrator","kil");
		data.put("application/x-latex","latex");
		data.put("application/x-rpm","rpm");
		data.put("application/x-sh","sh");
		data.put("application/x-shar","shar");
		data.put("application/x-shockwave-flash","swf");
		data.put("application/x-stuffit","sit");
		data.put("application/x-sv4cpio","sv4cpio");
		data.put("application/x-sv4crc","sv4crc");
		data.put("application/x-tar","tar");
		data.put("application/x-tcl","tcl");
		data.put("application/x-tex","tex");
		data.put("application/x-troff-man","man");
		data.put("application/x-troff-me","me");
		data.put("application/x-troff-ms","ms");
		data.put("application/x-ustar","ustar");
		data.put("application/x-wais-source","src");
		data.put("application/zip","zip");
		data.put("audio/x-mpegurl","m3u");
		data.put("audio/x-pn-realaudio","ra");
		data.put("audio/x-wav","wav");
		data.put("audio/x-ms-wma","wma");
		data.put("audio/x-ms-wax","wax");
		data.put("chemical/x-pdb","pdb");
		data.put("chemical/x-xyz","xyz");
		data.put("image/bmp","bmp");
		data.put("image/gif","gif");
		data.put("image/ief","ief");
		data.put("image/png","png");
		data.put("image/vnd.wap.wbmp","wbmp");
		data.put("image/x-cmu-raster","ras");
		data.put("image/x-portable-anymap","pnm");
		data.put("image/x-portable-bitmap","pbm");
		data.put("image/x-portable-graymap","pgm");
		data.put("image/x-portable-pixmap","ppm");
		data.put("image/x-rgb","rgb");
		data.put("image/x-xbitmap","xbm");
		data.put("image/x-xpixmap","xpm");
		data.put("image/x-xwindowdump","xwd");
		data.put("text/css","css");
		data.put("text/richtext","rtx");
		data.put("text/tab-separated-values","tsv");
		data.put("text/vnd.sun.j2me.app-descriptor","jad");
		data.put("text/vnd.wap.wml","wml");
		data.put("text/vnd.wap.wmlscript","wmls");
		data.put("text/x-setext","etx");
		data.put("video/vnd.mpegurl","mxu");
		data.put("video/x-flv","flv");
		data.put("video/x-ms-wm","wm");
		data.put("video/x-ms-wmv","wmv");
		data.put("video/x-ms-wmx","wmx");
		data.put("video/x-ms-wvx","wvx");
		data.put("video/x-msvideo","avi");
		data.put("video/x-sgi-movie","movie");
		data.put("x-conference/x-cooltalk","ice");
		data.put("video/3gpp","3gp");
		data.put("application/postscript","ai");
		data.put("audio/x-aiff","aif");
		data.put("audio/x-aiff","aifc");
		data.put("audio/x-aiff","aiff");
		data.put("text/plain","asc");
		data.put("application/atom+xml","atom");
		data.put("audio/basic","au");
		data.put("application/octet-stream","bin");
		data.put("application/x-netcdf","cdf");
		data.put("image/cgm","cgm");
		data.put("application/octet-stream","class");
		data.put("application/x-director","dcr");
		data.put("video/x-dv","dif");
		data.put("application/x-director","dir");
		data.put("image/vnd.djvu","djv");
		data.put("image/vnd.djvu","djvu");
		data.put("application/octet-stream","dll");
		data.put("application/octet-stream","dmg");
		data.put("application/octet-stream","dms");
		data.put("application/xml-dtd","dtd");
		data.put("video/x-dv","dv");
		data.put("application/x-director","dxr");
		data.put("application/postscript","eps");
		data.put("application/octet-stream","exe");
		data.put("application/andrew-inset","ez");
		data.put("application/srgs","gram");
		data.put("application/srgs+xml","grxml");
		data.put("application/x-gzip","gz");
		data.put("application/x-gzip","tgz");
		data.put("text/html","htm");
		data.put("text/html","html");
		data.put("image/x-icon","ico");
		data.put("text/calendar","ics");
		data.put("text/calendar","ifb");
		data.put("model/iges","iges");
		data.put("model/iges","igs");
		data.put("image/jp2","jp2");
		data.put("image/jpeg","jpe");
		data.put("image/jpeg","jpeg");
		data.put("image/jpeg","jpg");
		data.put("audio/midi","kar");
		data.put("application/octet-stream","lha");
		data.put("application/octet-stream","lzh");
		data.put("audio/mp4a-latm","m4a");
		data.put("audio/mp4a-latm","m4p");
		data.put("video/vnd.mpegurl","m4u");
		data.put("video/x-m4v","m4v");
		data.put("image/x-macpaint","mac");
		data.put("application/mathml+xml","mathml");
		data.put("model/mesh","mesh");
		data.put("audio/midi","mid");
		data.put("audio/midi","midi");
		data.put("video/quicktime","mov");
		data.put("audio/mpeg","mp2");
		data.put("audio/mpeg","mp3");
		data.put("video/mp4","mp4");
		data.put("video/mpeg","mpe");
		data.put("video/mpeg","mpeg");
		data.put("video/mpeg","mpg");
		data.put("audio/mpeg","mpga");
		data.put("model/mesh","msh");
		data.put("application/x-netcdf","nc");
		data.put("application/oda","oda");
		data.put("video/ogv","ogv");
		data.put("image/pict","pct");
		data.put("image/pict","pic");
		data.put("image/pict","pict");
		data.put("image/x-macpaint","pnt");
		data.put("image/x-macpaint","pntg");
		data.put("application/postscript","ps");
		data.put("video/quicktime","qt");
		data.put("image/x-quicktime","qti");
		data.put("image/x-quicktime","qtif");
		data.put("audio/x-pn-realaudio","ram");
		data.put("application/rdf+xml","rdf");
		data.put("application/vnd.rn-realmedia","rm");
		data.put("application/x-troff","roff");
		data.put("text/sgml","sgm");
		data.put("text/sgml","sgml");
		data.put("model/mesh","silo");
		data.put("application/x-koan","skd");
		data.put("application/x-koan","skm");
		data.put("application/x-koan","skp");
		data.put("application/x-koan","skt");
		data.put("application/smil","smi");
		data.put("application/smil","smil");
		data.put("audio/basic","snd");
		data.put("application/octet-stream","so");
		data.put("image/svg+xml","svg");
		data.put("application/x-troff","t");
		data.put("application/x-texinfo","texi");
		data.put("application/x-texinfo","texinfo");
		data.put("image/tiff","tif");
		data.put("image/tiff","tiff");
		data.put("application/x-troff","tr");
		data.put("text/plain","txt");
		data.put("model/vrml","vrml");
		data.put("application/voicexml+xml","vxml");
		data.put("video/webm","webm");
		data.put("model/vrml","wrl");
		data.put("application/xhtml+xml","xht");
		data.put("application/xhtml+xml","xhtml");
		data.put("application/xml","xml");
		data.put("application/xml","xsl");
		data.put("application/xslt+xml","xslt");
		data.put("application/vnd.mozilla.xul+xml","xul");
		data.put("image/webp","webp");
	}
	
	public static String inferFileTypeByUrl(String url) {
		if (url == null || url.isEmpty()) {
			return null;
		}
		url = url.trim().toLowerCase();
		if (url.endsWith("/")) {
			url = url.substring(0, url.length()-1);
		}
		try {
			URI uri = new URI(url);
			url = uri.getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		int pos = url.lastIndexOf("/");
		if (pos >=0) {
			url = url.substring(pos+1);
		}
		
		String step1 = findInUsed(url);
		if (step1 != null) {
			return step1;
		}
		String step2 = findInData(url);
		if (step2 != null) {
			return step2;
		}
		pos = url.lastIndexOf(".");
		if (pos >= 0) {
			return url.substring(pos+1);
		}
		return null;
	}
	
	private static String findInData(String url) {
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, String> ent = it.next();
			String postfix = ent.getKey();
			if (url.endsWith(postfix)) {
				foundResult.put(postfix, ent.getValue());
				return ent.getValue();
			}
			int pos = postfix.lastIndexOf("/");
			if (pos > 0) {
				postfix = postfix.substring(pos+1);
				if (url.endsWith(postfix)) {
					foundResult.put(postfix, ent.getValue());
					return ent.getValue();
				}
			}
		}
		return null;
	}

	private static String findInUsed(String url) {
		String fileName = url;
		Iterator<Entry<String, String>> it = foundResult.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, String> ent = it.next();
			String postfix = ent.getKey();
			if (fileName.endsWith(postfix)) {
				return ent.getValue();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String[] inputs = {
				"https://github.com/aliyun/aliyun-oss-java-sdk/blob/69da8533e7a8f25ad50aade531b1d2e9633e34db/src/main/resources/mime.types.2.vnd.openxmlformats-officedocument.wordprocessingml.document",
				"https://github.com/aliyun/aliyun-oss-java-sdk/blob/69da8533e7a8f25ad50aade531b1d2e9633e34db/src/main/resources/mime.types/",
				"https://github.com/aliyun/aliyun-oss-java-sdk/blob/69da8533e7a8f25ad50aade531b1d2e9633e34db/src/main/resources/mime.types?a=b",
				"https://github.com/aliyun/aliyun-oss-java-sdk/blob/69da8533e7a8f25ad50aade531b1d2e9633e34db/src/main/resources/mime.types#aad?a=b" };
		for(String inStr: inputs) {
			System.out.println(inferFileTypeByUrl(inStr));
		}
	}
}
