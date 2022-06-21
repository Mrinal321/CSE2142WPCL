import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args.length == 0){
			System.out.println("You didn't any data.\nPlease enter a dada.");
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String studentNameLine = bufferedReader.readLine();
				String i[] = studentNameLine.split(", ");
				for(String student : i) {
					System.out.println(student);
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String studentNameLine = bufferedReader.readLine();
				//System.out.println(studentNameLine);
				String i[] = studentNameLine.split(", ");
				Random Rand = new Random();
				int y = ( (Math.abs( Rand.nextInt() ) % 2 ) *2 ) % 3;
					System.out.println(i[y]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
				String studentNameLine = args[0].substring(1);
	        	Date dataformet = new Date();
	        	String df = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String updateData= dateFormat.format(dataformet);
				bufferedWriter.write(", "+studentNameLine+"\nList last updated on "+updateData);
				bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
				String studentNameLine = bufferedReader.readLine();
				String i[] = studentNameLine.split(",");
				boolean done = false;
				String studentName = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
				if(i[idx].equals(studentName)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String studentNameLine = bufferedReader.readLine();
				char studentNameTOChar[] = studentNameLine.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char nameChar:studentNameTOChar) {
					if(nameChar ==' ')
					{
						if (!in_word) {
							count++;
							in_word =true;
						}
						else {
							in_word=false;
						}
				}
			}
			System.out.println(count +" word(s) found ");
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else {
			System.out.println("You didn't correct input dada.\nPlease enter correct data.");
		}
	}
}