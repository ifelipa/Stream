package ExercicisStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex5 {

	public static void main(String[] args) {

		 String path="C:/Users/isma/git/Stream/Stream";
		File f = new File(path);
		File [] listFile = f.listFiles();
		
		for (File file : listFile) {
			if (file.isFile()){
				if(file.canRead()){
					try {
						fileProcessing(file);
					} catch (IOException e) {
						System.out.println("Error en el procesamiento de fichero");
					}	
				}else{
					System.out.println("El fichero"+  file.getName() +" no puede ser leido");
				}			
			}
		}
	}

	private static void fileProcessing(File file) throws IOException {
		FileReader in = null;
		BufferedReader bf = null;
		String line;
		int nLine=0;
		int nCharacter=0;
		try {
			in= new FileReader(file);
			bf = new BufferedReader(in);
			while ( (line=bf.readLine()) != null){
				String [] aux = line.replaceAll(" ","").split("");
				nCharacter+=aux.length;
				nLine++;
			}
			System.out.println("El fichero " + file.getName() + 
					"\n tiene "+ nLine + " lineas y "+ nCharacter + " caracteres" );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			in.close();
			bf.close();
		}
		
		
	}

	

}
