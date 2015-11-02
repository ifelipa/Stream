package ExercicisStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ex2 {
	public static void main(String[] args) {
		
		//dividir
		String pathname ="outagain.txt";
		String baseName="baseName";
		File bigfile = new File(pathname);
		int chunkSize = 10;
		
		try {
			copiarXbytes(bigfile, baseName, chunkSize);
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}

	private static void copiarXbytes(File bigfile , String baseName, int chunkSize) throws IOException {
		
		InputStream in = null;
		OutputStream out = null;
	    byte[] b = null;
		
		
		try {
			in= new FileInputStream(bigfile);
			b = new byte[chunkSize];
			int i=0;
			
			while ((in.read(b, 0, chunkSize)) != -1) {
				out = new FileOutputStream(baseName+i);
				out.write(b);
				i++;
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			in.close();
			out.close();
		}
		
		
		
	}
}
