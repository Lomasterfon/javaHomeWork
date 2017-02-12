package homework5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Texteditor {
	
	public static String  returnWords(){
	try(
	BufferedReader f = new BufferedReader(new FileReader("d.txt")))
	{
		String str = "";
		for (; (str = f.readLine()) != null;)
			System.out.println(str);
	}catch(IOException e){
	 System.out.println("ERROR"); 
	}
	return null;
	}
}


