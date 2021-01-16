package Assignment2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;


/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Adil Hashmi
Student Number: 216455172
Course Section: E
 */


/**
 * This class generates a transcript for each student, whose information is in the text file.
 * 
 *
 */

public class Transcript {
	private ArrayList<Object> grade = new ArrayList<Object>();
	private File inputFile;
	private String outputFile;

	/**
	 * This the the constructor for Transcript class that 
	 * initializes its instance variables and call readFie private
	 * method to read the file and construct this.grade.
	 * @param inFile is the name of the input file.
	 * @param outFile is the name of the output file.
	 */
	public Transcript(String inFile, String outFile) {
		inputFile = new File(inFile);	
		outputFile = outFile;	
		grade = new ArrayList<Object>();
		this.readFile();
	}// end of Transcript constructor

	/** 
	 * This method reads a text file and add each line as 
	 * an entry of grade ArrayList.
	 * @exception It throws FileNotFoundException if the file is not found.
	 */
	private void readFile() {
		Scanner sc = null; 
		try {
			sc = new Scanner(inputFile);	
			while(sc.hasNextLine()){
				grade.add(sc.nextLine());
			}      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}		
	} // end of readFile

	/**
	 * This method builds a student ArrayList by extracting information
	 * from the input.txt file.
	 * @return Student ArrayList
	 * @throws InvalidTotalException If file is not created then throw exception
	 */
	
	public ArrayList<Student> buildStudentArray() throws InvalidTotalException{


		ArrayList<String> temp = new ArrayList<String>();


		ArrayList<Double> gradeReceivedForAssignment;
		ArrayList<Integer> weight;
		ArrayList<Student> students = new ArrayList<Student>();


		for (int i = 0; i < grade.size(); i++) {
			temp = new ArrayList<>(Arrays.asList(((String) grade.get(i)).split(",")));
			gradeReceivedForAssignment = new ArrayList<Double>();
			weight = new ArrayList<Integer>();
			students.add(new Student());
			students.get(i).setName(temp.get(temp.size()-1));
			students.get(i).setStudentID(temp.get(2));
			students.get(i).getCourseTaken().add(new Course());
			students.get(i).getCourseTaken().get(0).setCode(temp.get(0));
			students.get(i).getCourseTaken().get(0).setCredit(Double.parseDouble(temp.get(1)));
			//students.get(i).getCourseTaken().get(0).getAssignment().add(new Assessment());
			for(int j = 3; j < temp.size()-1; j++) {
				students.get(i).getCourseTaken().get(0).getAssignment().add(new Assessment(temp.get(j).charAt(0), Integer.parseInt(temp.get(j).substring(1, 3))));
			}
			for(int x = 0; x < students.get(i).getCourseTaken().get(0).getAssignment().size(); x++) {
				weight.add(students.get(i).getCourseTaken().get(0).getAssignment().get(x).getWeight());
			}
			for(int y = 3; y < temp.size()-1; y++) {
				gradeReceivedForAssignment.add(Double.parseDouble(temp.get(y).substring(4, 6)));
			}
			students.get(i).addGrade(gradeReceivedForAssignment, weight);
		}
		students = new ArrayList<Student>(findDup(students));
		return students;
	}
	
	/**
	 * This method prints the transcript of each student with the proper layout,
	 * it shows the student name, id, course code of courses taken and grades as 
	 * well as final gpa.
	 * @param students object
	 * @throws IOException Input output exception
	 */

	public void printTranscript(ArrayList<Student> students) throws IOException {
		File fileForOutput = new File(this.outputFile);
		FileWriter writer = new FileWriter(fileForOutput);
		for(int i = 0; i < students.size(); i++) {
			writer.write(students.get(i).getName() + "	" + students.get(i).getStudentID() + "\n");
			writer.write("--------------------\n");
			ArrayList<Course> courseList = new ArrayList<Course>(students.get(i).getCourseTaken());
			ArrayList<Double> finalGradeList = new ArrayList<Double>(students.get(i).getFinalGrade());
			for (int j = 0; j < courseList.size(); j++) {
				writer.write(courseList.get(j).getCode() + "	" + finalGradeList.get(j) + "\n");
			}
			writer.write("--------------------\n");	
			writer.write("GPA: " + students.get(i).weightedGPA() + "\n");	
		}
		writer.close();
	}
	
	/**
	 * Finds the duplicate student to put all the information
	 * into one students transcript.
	 * @param students ArrayList
	 * @return ArrayList of students
	 */ 
	
	public ArrayList<Student> findDup(ArrayList<Student> students){
		Student student = new Student();
		for(int i = 0; i < 9; i++) {
			student.setName(students.get(i).getName());
			student.setStudentID(students.get(i).getStudentID());
			student.setCourseTaken(students.get(i).getCourseTaken());
			student.setFinalGrade(students.get(i).getFinalGrade());			
			for(Student e: students) {
				if(student.equals(e) && student.getCourseTaken().get(0).getCode() != e.getCourseTaken().get(0).getCode()) {
					student.getCourseTaken().add(e.getCourseTaken().get(0));
					student.getFinalGrade().add(e.getFinalGrade().get(0));
				}
			}
		}
		int counter = 0;
		Iterator<Student> it = students.iterator();
		ArrayList<Student> newList = new ArrayList<Student>();
		while(counter < 9) {
			Student s = it.next();
			Student s1 = new Student(s.getStudentID(), s.getName(), s.getCourseTaken());
			s1.setFinalGrade(s.getFinalGrade());
			newList.add(s1);
			counter++;
		}
		return newList;
		
	}
	

}// end of Transcript

//--------------------------------------------------------------------------

class Student {

	private String studentID;
	
	private String name;
	
	private ArrayList<Course> courseTaken;
	
	private ArrayList<Double> finalGrade;
	
	
	public Student() {
		studentID = (" ");
		name = (" ");
		courseTaken = new ArrayList<Course>();
		finalGrade = new ArrayList<Double>();
	}

	/**
	 * This method initializes the three parameters that uniquely identify a student.
	 * @param studentID String
	 * @param name String 
	 * @param courseTaken String
	 */
	
	public Student(String studentID, String name, ArrayList<Course> courseTaken) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.courseTaken = new ArrayList<Course>(courseTaken);
	}
	
	/**
	 * This method calculates the final grade of the students and adds them to the finalGrade.
	 * @param grade ArrayList Double
	 * @param weight ArrayList Integer
	 * @throws InvalidTotalException If the grade inputs do not equal to 100
	 */
	
	public void addGrade(ArrayList<Double> grade, ArrayList<Integer> weight) throws InvalidTotalException {
		int totalWeight = 0;
		double firstGrade = 0;
		double calculatedFinalGrade = 0;
		for(int i = 0; i < weight.size(); i++) {
			totalWeight = totalWeight + weight.get(i);
		}
		
		if(totalWeight != 100) {
			throw new InvalidTotalException("Must be 100, you got " + totalWeight);
		}
		else {
			for(int j = 0; j < grade.size(); j++) {
				firstGrade = (grade.get(j)/100) * weight.get(j);
				calculatedFinalGrade = Math.round((calculatedFinalGrade + firstGrade) * 10) / 10.0;
			}
			finalGrade.add(calculatedFinalGrade);
		}
	}
	
	/**
	 * This method takes potential grades and sorts them according to their
	 * corresponding GPA number grade, also rounds the final GPA to one 
	 * decimal place.
	 * @return GPA of students
	 */
	
	public Double weightedGPA() {
		double rawTotal = 0.0;
		double totalCredits = 0.0;
		double GPA;
		double grade;
		
		for(int i = 0; i < courseTaken.size(); i++) {
			totalCredits = totalCredits + courseTaken.get(i).getCredit();
		}
		
		for(int i = 0; i < finalGrade.size(); i++) {
			grade = finalGrade.get(i);
			
			if(47 <= grade && grade <= 49.99) {
				rawTotal = rawTotal + (1.0 * courseTaken.get(i).getCredit());
			}
			else if(50 <= grade && grade <= 54.99) {
				rawTotal = rawTotal + (2.0 * courseTaken.get(i).getCredit());
			}
			else if(55 <= grade && grade <= 59.99) {
				rawTotal = rawTotal + (3.0 * courseTaken.get(i).getCredit());
			}
			else if(60 <= grade && grade <= 64.99) {
				rawTotal = rawTotal + (4.0 * courseTaken.get(i).getCredit());
			}
			else if(65 <= grade && grade <= 69.99) {
				rawTotal = rawTotal + (5.0 * courseTaken.get(i).getCredit());
			}
			else if(70 <= grade && grade <= 74.99) {
				rawTotal = rawTotal + (6.0 * courseTaken.get(i).getCredit());
			}
			else if(75 <= grade && grade <= 79.99) {
				rawTotal = rawTotal + (7.0 * courseTaken.get(i).getCredit());
			}
			else if(80 <= grade && grade <= 89.99) {
				rawTotal = rawTotal + (8.0 * courseTaken.get(i).getCredit());
			}
			else if(90 <= grade && grade <= 100) {
				rawTotal = rawTotal + (9.0 * courseTaken.get(i).getCredit());
			}
			else {
				rawTotal = rawTotal + (0.0 * courseTaken.get(i).getCredit());
			}
		}
		
		GPA = Math.round((rawTotal / totalCredits) * 10) / 10.0;
			return GPA;
	}
	
	/**
	 * Getter method for studentID.
	 * @return studentID
	 */

	public String getStudentID() {
		return studentID;
	}
	
	/**
	 * Setter method for studentID.
	 * @param studentID
	 */

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * Getter method for getName.
	 * @return name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for getName.
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for courseTaken.
	 * @return courseTaken
	 */

	public ArrayList<Course> getCourseTaken() {
		return courseTaken;
	}

	/**
	 * Setter method for courseTaken.
	 * @param courseTaken
	 */
	
	public void setCourseTaken(ArrayList<Course> courseTaken) {
		this.courseTaken = courseTaken;
	}
	
	/**
	 * Getter method for finalGrade.
	 * @return finalGrade
	 */
	
	public ArrayList<Double> getFinalGrade() {
		return finalGrade;
	}

	/**
	 * Setter method for finalGrade.
	 * @param finalGrade
	 */ 
	
	public void setFinalGrade(ArrayList<Double> finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentID == null) {
			if (other.studentID != null)
				return false;
		} else if (!studentID.equals(other.studentID))
			return false;
		return true;
	}

}

//--------------------------------------------------------------------------

class Course extends Student{

	private String code;
	
	private double credit;
	
	private ArrayList<Assessment> assignment;

	
	public Course() {
		code = (" ");
		assignment = new ArrayList<Assessment>();
		credit = 0.0;
	}
	
	/**
	 * This method initializes three parameters and calls super for extending 
	 * from student class.
	 * @param course String
	 * @param assignment ArrayList 
	 * @param credit Double
	 */
	
	public Course(String course, ArrayList<Assessment> assignment, double credit) {
		super();
		this.code = course;
		this.assignment = new ArrayList<Assessment>(assignment);
		this.credit = credit;
	}
	
	/**
	 * This method creates a course using another course.
	 * @param course
	 */
	
	public Course(Course course) {
		this.code = course.code;
		this.assignment = new ArrayList<Assessment>(course.assignment);
		this.credit = course.credit;
	}

	/**
	 * Getter method for getCode.
	 * @return code
	 */
	
	public String getCode() {
		return code;
	}

	/**
	 * Getter method for assignment.
	 * @return assignment
	 */
	
	public ArrayList<Assessment> getAssignment() {
		return assignment;
	}

	/**
	 * Getter method for credit
	 * @return credit 
	 */
	
	public double getCredit() {
		return credit;
	}

	/**
	 * Setter method for code
	 * @param code
	 */
	
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Setter method for assignment 
	 * @param assignment
	 */
	
	public void setAssignment(ArrayList<Assessment> assignment) {
		this.assignment = assignment;
	}

	/**
	 * Setter method for credit
	 * @param credit
	 */
	
	public void setCredit(double credit) {
		this.credit = credit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
			return false;
		return true;
	}
	
	
}

//--------------------------------------------------------------------------

class Assessment extends Course{

	private int weight;
	
	private char type;
	
	public Assessment() {
		weight = 0;
		type = ' ';
	}
	
	/**
	 * This method initializes the two parameters and calls super for 
	 * extending course class.
	 * @param type Char
	 * @param weight Integer
	 */
	
	public Assessment(char type, int weight) {
		super();
		this.weight = weight;
		this.type = type;
	}
	
	/**
	 * This method gets the instance of the assessments.
	 * @param type Char
	 * @param weight Integer
	 * @return Instance of assessment objects
	 */
	
	public static Assessment getInstance(char type, int weight) {
		return Assessment.getInstance(type, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assessment other = (Assessment) obj;
		if (type != other.type)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	/**
	 * Getter method for weight
	 * @return weight
	 */
	public int getWeight() {
		return this.weight;
	}
	
	
}

//--------------------------------------------------------------------------

class InvalidTotalException extends Exception {
	public InvalidTotalException(String errMsg) {
		super(errMsg);
	}
	
}