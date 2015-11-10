package ExercicisStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ex6 {

	public static void main(String[] args) {


		//String path = "C:/Users/isma/git/Stream/Stream/nuevo";
		String path = "/home/users/inf/wiaw2/iaw188216/git/Stream/Stream/nuevo";

		File f = new File(path);
		File ficherOrdenado = new File("ficheroABC.txt");
		File ficheroRepetido = new File("ficheroREP.txt");
		if (f.exists() && f.canRead()) {
			try {
				fileProcessing(f,ficherOrdenado,ficheroRepetido);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void fileProcessing(File f, File abcOrden, File swr) throws IOException {

		FileReader in = null;
		FileWriter outABC = null;
		FileWriter outRepeat = null;
		BufferedReader bf = null;
		ArrayList<String> order = new ArrayList<String>();
		ArrayList<String> repeat = new ArrayList<String>();
		ArrayList<String> abc = new ArrayList<String>();
		try {
			in = new FileReader(f);
			outABC = new FileWriter(abcOrden);
			outRepeat = new FileWriter(swr);
			bf = new BufferedReader(in);
			String line;
			while ((line = bf.readLine()) != null) {
				String[] aux = line.split(" ");
				for (String st : aux) {
					abc.add(st);
				}
			}
			ArrayList copia = abc;
			order = orderWord(abc);
			repeat = repeatWord(copia);
			
			for (String str : order) {
				outABC.write(str);
			}
			
			for (String str : repeat) {
				outRepeat.write(str);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			in.close();
			bf.close();
			outABC.close();
			outRepeat.close();
		}
	}

	private static ArrayList<String> repeatWord(ArrayList<String> abc) {
		ArrayList<String> aux = new ArrayList<String>();

		for (String str : abc) {
			if (!aux.contains(str)) {
				aux.add(str);
			}
		}
		//ArrayList<String> repetido = orderWord(aux);
		//return repetido;
		return aux;
	}

	private static ArrayList<String> orderWord(ArrayList<String> abc) {
		ArrayList<String> ordenada = new ArrayList<String>();

		for (String str : abc) {
			if (!ordenada.contains(str)) {
				ordenada.add(str);
			}
		}
		Collections.sort(ordenada);
		return ordenada;
	}

}
