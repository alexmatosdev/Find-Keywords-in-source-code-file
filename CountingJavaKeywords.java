import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/*
 * Class: CMSC214 
 * Instructor: Cristopher Fallon
 * Date: 3/4/2022
 * Description: This class uses File to decrypt a previously encrypted class
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Alex Matos
*/

public class CountingJavaKeywords {

	public static void main (String[] args) throws IOException {
		
		Scanner scanner = new Scanner(createWriteFile());
		int nKeywords = 0;
		Stack<Character> stack = new Stack<Character>();
		
		
		while (scanner.hasNextLine()) {
			Scanner line = new Scanner(scanner.nextLine());
			while (line.hasNext()) {
				String word = line.next();
				if (stack.isEmpty() && (word.contains("null") || word.contains("true") || word.contains("false"))) {
					nKeywords++;
					System.out.println("keyword was added");
				}
				if ((word.contains("\"") || word.contains("/*") || word.contains("//")) && stack.isEmpty() == true) {
					stack.add('"');
					System.out.println("Added to stack!");
				}
				else if ((word.contains("\"") || word.contains("/*") || word.contains("//")) && stack.isEmpty() == false) {
					stack.pop();
					System.out.println("Removed from stack!");
				}
			}
		}
		System.out.println("The number of keywords in the source file is " + nKeywords + "!");
	}
	
	public static File createWriteFile() throws IOException {
		File file = new File("C:\\Users\\Alex Matos\\eclipse-workspace\\MatosA_Project06\\src\\sourcefile.txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		fw.write("public class HelloWorld {\r\n"
				+ "	public static void main(String[] args) {\r\n"
				+ "		System.out.println(\"Hello World null\");\r\n"
				+ "		String hq = null;\r\n"
				+ "		boolean billie = true;\r\n"
				+ "		boolean gina = false;\r\n"
				+ "	}\r\n"
				+ "}");
		fw.close();
		return file;
	}
}
