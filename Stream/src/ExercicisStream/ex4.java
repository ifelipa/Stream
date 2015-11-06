package ExercicisStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ex4 {

	public static void main(String[] args) {
		//String path="C:/Users/isma/git/Stream/Stream";
		String path="/home/users/inf/wiaw2/iaw188216/git/Stream/Stream/";
		
		File pathDirectory = new File(path);
		File [] listFileDirectory=null;
		
		if (pathDirectory.isDirectory()){
			listFileDirectory= pathDirectory.listFiles();
			
			String directoryNameNewPath = path+"/backUp"+numeroBackUp(listFileDirectory);			
			File newDictory = new File(directoryNameNewPath);
			newDictory.mkdir();
			copyBackUp(listFileDirectory,directoryNameNewPath);			
		}
	}

	private static void copyBackUp(File[] listFileDirectory, String directoryNameNewPath) {
		for (File file : listFileDirectory) {
			if (file.isFile()){
				if (file.canRead()){
					
				
				FileInputStream in = null;
				FileOutputStream out = null;
				
				try {
					in = new FileInputStream(file);
					
					
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				
				
				
				}else{
					System.out.println("No se puede leer el fichero" + file.getName());				}
				
			}
		}
		
	}





	private static int numeroBackUp(File[] listaFicheros) {
		
		int numberBackUp=-1;
		for (File file : listaFicheros) {
			String aux = file.getName();			
			if (file.isDirectory() && aux.matches("^backUp[0-9]")){
				System.out.println(file.getName());
				int n = Integer.parseInt(aux.substring(aux.length()-1, aux.length()));
				if(n>numberBackUp){
					numberBackUp=n;
				}
			}
		}
		return (numberBackUp+1);
	}
	

}
