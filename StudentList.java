import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args.length == 0){
			System.out.println(Constants.emptyData);
		}
		else if(args[0].equals(Constants.showAll)) {
			System.out.println(Constants.loadingMessage);
			try {

				String studentNameLine = getString();
				String studentNames[] = studentNameLine.split(Constants.studentEntryDeliaiter);
				for(String student : studentNames) {
					System.out.println(student);
				}
			} catch (Exception e){

			}
			System.out.println(Constants.loadedMessage);
		}
		else if(args[0].equals(Constants.showRandom))
		{
			System.out.println(Constants.loadingMessage);
			try {
				String studentNameLine = getString();
				//System.out.println(studentNameLine);
				String studentNames[] = studentNameLine.split(Constants.studentEntryDeliaiter);
				Random Rand = new Random();
				int randomStudent = ( (Math.abs( Rand.nextInt() ) % 2 ) *2 ) % 3;
					System.out.println(studentNames[randomStudent]);
			} catch (Exception e){

			}
			System.out.println(Constants.loadedMessage);
		}
		else if(args[0].contains(Constants.addEntry)){
			System.out.println(Constants.loadingMessage);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constants.studentList, true));
				String studentNameLine = args[0].substring(1);
	        	Date dataformet = new Date();
	        	String df = Constants.dateFormate;
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String updateData= dateFormat.format(dataformet);
				bufferedWriter.write(Constants.studentEntryDeliaiter + studentNameLine + Constants.lastUpdateMessage + updateData);
				bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println(Constants.loadedMessage);
		}
		else if(args[0].contains(Constants.findEntry))
		{
			System.out.println(Constants.loadingMessage);
			try {
				String studentNameLine = getString();
				String studentNames[] = studentNameLine.split(Constants.studentEntryDeliaiter);
				boolean done = false;
				String studentName = args[0].substring(1);
				for(int idx = 0; idx < studentNames.length && !done; idx++) {
				if(studentNames[idx].equals(studentName)) {
					System.out.println(Constants.dataFoundMessage);
						done = true;
				}
			}
			} catch (Exception e){

			}
			System.out.println(Constants.loadedMessage);
		}
		else if(args[0].contains(Constants.showCount))
		{
			System.out.println(Constants.loadingMessage);
			try {
				String studentNameLine = getString();
				char studentNameTOChar[] = studentNameLine.toCharArray();
				boolean in_word = false;
				int count = 0;
				for(char nameChar : studentNameTOChar) {
					if(nameChar ==' ')
					{
						if (!in_word) {
							count++;
							in_word = true;
						}
						else {
							in_word = false;
						}
				}
			}
			System.out.println(count + Constants.dataFoundMessage);
			} catch (Exception e){

			}
			System.out.println(Constants.studentList);
		}
		else {
			System.out.println(Constants.wrongInputMessage);
		}
	}

	private static String getString() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constants.studentList)));
		String studentNamesLine = bufferedReader.readLine();
		return studentNamesLine;
	}
}