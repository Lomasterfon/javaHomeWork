package homework6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileEditor {

	public  void sameWords(File file) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s;
			String[] str = null;
			for (; (s = br.readLine()) != null;) {
				str = s.split(" ");
			}
			for (int i = 0; i < str.length; i++) {
				System.out.println(str [i].toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
