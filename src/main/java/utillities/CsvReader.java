package utillities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

	private static CsvReader reader;
	static BufferedReader br = null;
	private static List<String> headers = new ArrayList<String>();
	static String seperator = " ";

	/**
	 * use this if file contains firstLine as header fields
	 * @param filename
	 */
	public CsvReader(String filename, String seperator) {
		this.seperator = seperator;
		readFile(filename, true);
	}

	public CsvReader(String filename, String seperator, String... fields) {
		this.seperator = seperator;
		for (String field : fields) {
			headers.add(field);
		}
		readFile(filename, false);
	}

	private void readFile(String filename, boolean header) {
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			if (header) {
				try {
					String head = br.readLine();
					String[] fields = head.split(seperator);
					for (String f : fields) {
						headers.add(f.trim());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<HashMap<String, String>> getCsvData() {
		List<HashMap<String, String>> data = new LinkedList<HashMap<String,String>>();
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(line != null) {
			HashMap<String , String> map = new HashMap<String, String>();
			String s[] = line.split(seperator);
			if(s.length != headers.size()) {
				System.out.println("Fields length and Header Length Misamtch");
			}else {
				for(int i=0; i<s.length; i++) {
					map.put(headers.get(i), s[i]);
				}
			}
		data.add(map);
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	return data;
	}
}
