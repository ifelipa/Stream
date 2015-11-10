package ExercicisStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ex4 {

	public static void main(String[] args) {
		 //String path="C:/Users/isma/git/Stream/Stream";
		String path = "/home/users/inf/wiaw2/iaw188216/git/Stream/Stream/";

		File pathDirectory = new File(path);
		File[] listFileDirectory = null;

		if (pathDirectory.isDirectory()) {
			listFileDirectory = pathDirectory.listFiles();

			String directoryNameNewPath = path + "/backUp" + numeroBackUp(listFileDirectory);
			File newDictory = new File(directoryNameNewPath);
			newDictory.mkdir();
			try {
				createBackUp(listFileDirectory, directoryNameNewPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin");
	}

	private static void createBackUp(File[] listFileDirectory, String directoryNameNewPath) throws IOException {
		for (File inFile : listFileDirectory) {
			if (inFile.isFile()) {
				if (inFile.canRead()) {
					File outFile = new File(directoryNameNewPath + "/" + inFile.getName());
					outFile.createNewFile();
					createCopy(inFile, outFile);
				} else {
					System.out.println("No se puede leer el fichero" + inFile.getName());
				}
			}
		}
	}

	private static void createCopy(File inFile, File outFile) throws IOException {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(inFile);
			out = new FileOutputStream(outFile);
			int b = 0;

			while ((b = in.read()) != -1) {
				out.write(b);
			}
		
		} finally {
			in.close();
			out.close();
		}

	}

	private static int numeroBackUp(File[] listaFicheros) {

		int numberBackUp = -1;
		for (File file : listaFicheros) {
			String aux = file.getName();
			if (file.isDirectory() && aux.matches("^backUp[0-9]")) {				
				int n = Integer.parseInt(aux.substring(aux.length() - 1, aux.length()));
				if (n > numberBackUp) {
					numberBackUp = n;
				}
			}
		}
		return (numberBackUp + 1);
	}

}
