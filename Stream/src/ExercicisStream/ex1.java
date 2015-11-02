package ExercicisStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ex1 {
	public static void main(String[] args) {
		System.out.println("Introduce el numero de ficheros");
		Scanner sc = new Scanner(System.in);
		int nfile= sc.nextInt();
		
		ArrayList<File> fileIn = new ArrayList<File>();
		
		for (int i = 0; i < nfile; i++) {
			System.out.println("Introduce nombre del fichero n� :"+ (i+1));
			//Creamos el fichero para comprobar si existe
			sc= new Scanner(System.in);
			File file = new File(sc.next());
			if (!file.exists()){
				System.out.println("el fichero no existe");
				break;
			}
			fileIn.add(file);
		}
		
		//pidiendo el nombre de fichero de salida
		System.out.println("Introduce el nombre de fichero de salida");
		sc= new Scanner(System.in);
		File fileOut = new File(sc.next());
		
		for (int i = 0; i < fileIn.size(); i++) {
			File in = fileIn.get(i);
			try {
				copiar( in, fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void copiar(File origen, File destino)throws IOException {
		FileReader in = null;
		FileWriter out = null;
		BufferedReader bfReader= null;
		
		try {
			in = new FileReader(origen);
			out = new FileWriter(destino, true);
			bfReader = new BufferedReader(in);
			String line;
			while ((line= bfReader.readLine()) != null) {
				out.write(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			in.close();
			out.close();
			bfReader.close();
		}
		
	}
	

	

}
