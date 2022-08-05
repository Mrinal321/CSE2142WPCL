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

				String studentNames[] = getString().split(Constants.studentEntryDeliaiter);
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

				String studentNames[] = getString().split(Constants.studentEntryDeliaiter);
				int randomStudent = ( (Math.abs( (new Random()).nextInt() ) % 2 ) *2 ) % 3;
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

	        	DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormate);
				bufferedWriter.write(Constants.studentEntryDeliaiter + args[0].substring(1) + Constants.lastUpdateMessage + dateFormat.format(new Date()));
				bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println(Constants.loadedMessage);
		}
		else if(args[0].contains(Constants.findEntry))
		{
			System.out.println(Constants.loadingMessage);
			try {

				String studentNames[] = getString().split(Constants.studentEntryDeliaiter);
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

				char studentNameTOChar[] = getString().toCharArray();
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
		return bufferedReader.readLine();
	}
}