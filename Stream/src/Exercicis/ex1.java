package Exercicis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex1 {
	public static void main(String[] args) throws IOException{

		FileInputStream in1 = null;
		FileInputStream in2 = null;
		FileInputStream in3 = null;
		FileOutputStream out = null;
		
		try {
			in1 = new FileInputStream("exemple1.txt");
			in2 = new FileInputStream("exemple1.txt");
			in3 = new FileInputStream("exemple1.txt");
			
			out = new FileOutputStream("union.txt");
			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}
	
	

}
