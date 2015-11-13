package patterns;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String cadena;
    	String pauta;
        try {
			while (true) {
				System.out.println("");
				System.out.println("Introdueix la pauta (pattern) a buscar (EXIT per sortir): ");
				pauta = sc.nextLine();
			    Pattern pattern = 
			    Pattern.compile(pauta, Pattern.UNICODE_CHARACTER_CLASS);
			    
			    if (pauta.equals("EXIT")) throw new Exception();
			    
			    System.out.println("Introdueix ara la cadena (matcher) on es buscarà: ");
				cadena = sc.nextLine();  
				
				
			    Matcher matcher = 
			    pattern.matcher(cadena);

			    boolean found = false;
			    while (matcher.find()) {
			        System.out.println("Pauta trobada: <" + matcher.group() + "> i comença a l'índex " +
			        matcher.start() + " i acaba a l'índex " + matcher.end());
			        found = true;
			    }
			    if(!found){
			    	System.out.println("Pauta no trobada");
			    }
			}
		} catch (Exception e) {
			System.out.println("Sortida");
		} finally {
			sc.close();	
		}
        
    } 
    /*
     * Pattern.compile(pauta, Pattern.CASE_INSENSITIVE); para no tener en cuenta mayusculas y misnusculas
     * 
     * Pattern.UNICODE_CHARACTER_CLASS  toma en cuenta como caracter a las palabras acentuadas
     * [a-c[x-z]][a-c] que empiece a a la c o de x a z y continue con a a la c
     * claudator dentro del claudator  es negacion, y cuando lo tiuene fuera es incio de linea
     * 
     * [0-9 && [3-5]] numeros del cero al nueve y que sean del 3 al 5
     * [0-9 && [^3-5]] numeros del cero al nueve y que no sean del 3 al 5
     * 
     * 
     *\d busca solo digitos
     *
     *a+
     *aaaaaaaa
     *solo encontrará las a sin el espàcio en blanco
     *a{3,} coge de tres a mas letras a 
     *
     * .*bat todos los caracter hasta bat (hola soc en batman)
     * 
     * .*?bat 
     * 
     */
}