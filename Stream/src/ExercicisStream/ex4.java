package ExercicisStream;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ex4 {

	public static void main(String[] args) {
		String path="C:/Users/isma/git/Stream/Stream";
		copiadeSeguridad(path);
	}

	private static void copiadeSeguridad(String path) {
		File pathDirectory = new File(path);
		File [] listaFicheros=null;
		String nBackUp;
		if (pathDirectory.isDirectory()){
			listaFicheros= pathDirectory.listFiles();
			nBackUp=numeroBackUp(listaFicheros);
			
		}		
	}

	private static String numeroBackUp(File[] listaFicheros) {
		ArrayList<String> dir = new ArrayList<String>();
		for (File file : listaFicheros) {
			String aux = file.getName();
			if (file.isDirectory() && aux.matches("^backUp[0-9]")){
				System.out.println(file.getName());
				dir.add(file.getName());
				
			}
		}
		Collections.sort(dir);
		
		System.out.println(dir.size()-1);
		return null;
	}
	

}
