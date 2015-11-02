package ExercicisStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ex3 {

	public static void main(String[] args) {
		String f1 = "f1";
		String f2 = "f2";
		File inA = new File(f1);
		File inB = new File(f2);

		try {
			comparar(inA, inB);
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

	private static void comparar(File inA, File inB) throws IOException {
		FileReader readerA = null;
		FileReader readerB = null;
		BufferedReader bf1 = null;
		BufferedReader bf2 = null;
		String line1;
		String line2;

		try {
			readerA = new FileReader(inA);
			readerB = new FileReader(inB);

			bf1 = new BufferedReader(readerA);
			bf2 = new BufferedReader(readerB);
			int nline = 1;

			while ((line1 = bf1.readLine()) != null && (line2 = bf2.readLine()) != null) {
				
				if (line1.length() == line2.length()) {
					if (!line1.equals(line2)) {
						System.out.println("La linea "+ line1 +" es diferente a \n"+ line2);
						System.out.println("Linea numero" + nline + "\n");
					}
				}else{
					System.out.println("La linea \""+ line1 +"\" es diferente en tamaño de \n \""+ line2+"\"");
					System.out.println("Linea numero: " + nline );
				}
				nline++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			readerA.close();
			readerB.close();
			bf1.close();
			bf2.close();
		}

	}

}
