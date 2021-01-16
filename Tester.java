package Assignment2;

import java.io.IOException;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws InvalidTotalException, IOException {
		String filePath = "/Users/adilhashmi/Desktop/EECS2030/Assignment 2/input.txt";
		Transcript transcript1 = new Transcript(filePath, "/Users/adilhashmi/Desktop/EECS2030/Assignment 2/output.txt");
		ArrayList<Student> listOfStudents = transcript1.buildStudentArray();
		transcript1.printTranscript(listOfStudents);

	}

}
