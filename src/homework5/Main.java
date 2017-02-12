package homework5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		sameWords();
	}
		public static void sameWords() throws Exception {
			try (BufferedReader br = new BufferedReader(new FileReader("backup.txt"))) {
				String s;
				String[] str = null;
				for (; (s = br.readLine()) != null;) {
					str = s.split(" ");
					for (int i = 0; i < str.length; i++) {
						System.out.println(str [i].toString());
					}
				}
								
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}


