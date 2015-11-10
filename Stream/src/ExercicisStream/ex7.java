package ExercicisStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ex7 {

	public static void main(String[] args) {
		/* Crear un programa que llegeixi un fitxer de text,
		 * per a cada car�cter guardarem les seves repeticions i 
		 * guardarem un fitxer de sortida que contingui. Caracter, 
		 * repeticions, percentatge.
		 */
		
		//String path = "C:/Users/isma/git/Stream/Stream/nuevo";
		String path = "/home/users/inf/wiaw2/iaw188216/git/Stream/Stream/nuevo";

		File f = new File(path);
		File fileOut = new File("porcentaje.txt");
		
		if (f.exists() && f.canRead()){
			try {
				fileProcessing( f, fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void fileProcessing(File f, File fileOut) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		
		ArrayList<Character> caracteres = new ArrayList<Character>();
		
		
		try {
			in = new FileReader(f);
			out = new FileWriter(fileOut);
			int x;	
			while ((x= in.read()) != -1) {
				caracteres.add((char)x);
			}
			ArrayList result = new ArrayList();
			
			for (Character c : caracteres) {
				if (!result.contains(c)){
					result.add(c);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
