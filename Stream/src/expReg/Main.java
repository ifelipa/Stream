package expReg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		/*
		 * las cadenas (string) nunca debe usarse un comparado logico para
		 * compararlos he de usarse el equals(Object anObject), compareTo(String
		 * anotherString)
		 * 
		 * 
		 * [a-d[m-p]] Un caràcter entre a i d o entre m i p : [a-dm-p]
		 * [[a-d][m-p][x-z]]
		 */

		String text = "El que pregunta una vegada és maldestra una vegada, el que no pregunta mai sempre és tonto";

		String regex = "[a-z]{7}[aeiou]";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(text);

		while (m.find() == true) {
			System.out.println("Cadena: " + m.group());
		}
		
		
		 String line = "This order was placed for QT3000! OK?";
	      String pattern = "(.*)(\\d+)(.*)";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m1 = r.matcher(line);
	      while(m1.find( )) {
	         System.out.println("Found value: " + m1.group(1));
	         System.out.println("Found value: " + m1.group(2));
	         System.out.println("Found value: " + m1.group(3));
	      }
	      
	      Pattern pt = Pattern.compile("un");
	      Matcher mt = pt.matcher("Aixo es un text de un exemple");
	      
	      boolean found = false;
	      
	      while (mt.find()){
	    	  System.out.println("I found the text <<" + mt.group() + ">> starting at "+ "index "+ mt.start() + " and ending at index " + mt.end());
	    	  found =true;
	      }
	      if (!found){
	    	  System.out.println("no match found.");
	      }
	      

	}

}
