//package Assignment2;
//
//import java.util.ArrayList;
//
//public class Student {
//
//	private String studentID;
//	
//	private String name;
//	
//	private ArrayList<Course> courseTaken;
//	
//	private ArrayList<Double> finalGrade;
//	
//	
//	public Student() {
//		studentID = (" ");
//		name = (" ");
//		courseTaken = new ArrayList<Course>();
//		finalGrade = new ArrayList<Double>();
//	}
//
//	/**
//	 * This method initializes the three parameters that uniquely identify a student.
//	 * @param studentID String
//	 * @param name String 
//	 * @param courseTaken String
//	 */
//	
//	public Student(String studentID, String name, ArrayList<Course> courseTaken) {
//		super();
//		this.studentID = studentID;
//		this.name = name;
//		this.courseTaken = new ArrayList<Course>(courseTaken);
//	}
//	
//	/**
//	 * This method calculates the final grade of the students and adds them to the finalGrade.
//	 * @param grade ArrayList Double
//	 * @param weight ArrayList Integer
//	 * @throws InvalidTotalException If the grade inputs do not equal to 100
//	 */
//	
//	public void addGrade(ArrayList<Double> grade, ArrayList<Integer> weight) throws InvalidTotalException {
//		int totalWeight = 0;
//		double firstGrade = 0;
//		double calculatedFinalGrade = 0;
//		for(int i = 0; i < weight.size(); i++) {
//			totalWeight = totalWeight + weight.get(i);
//		}
//		
//		if(totalWeight != 100) {
//			throw new InvalidTotalException("Must be 100, you got " + totalWeight);
//		}
//		else {
//			for(int j = 0; j < grade.size(); j++) {
//				firstGrade = (grade.get(j)/100) * weight.get(j);
//				calculatedFinalGrade = Math.round((calculatedFinalGrade + firstGrade) * 10) / 10.0;
//			}
//			finalGrade.add(calculatedFinalGrade);
//		}
//	}
//	
//	/**
//	 * This method takes potential grades and sorts them according to their
//	 * corresponding GPA number grade, also rounds the final GPA to one 
//	 * decimal place.
//	 * @return GPA of students
//	 */
//	
//	public Double weightedGPA() {
//		double rawTotal = 0.0;
//		double totalCredits = 0.0;
//		double GPA;
//		double grade;
//		
//		for(int i = 0; i < courseTaken.size(); i++) {
//			totalCredits = totalCredits + courseTaken.get(i).getCredit();
//		}
//		
//		for(int i = 0; i < finalGrade.size(); i++) {
//			grade = finalGrade.get(i);
//			
//			if(47 <= grade && grade <= 49.99) {
//				rawTotal = rawTotal + (1.0 * courseTaken.get(i).getCredit());
//			}
//			else if(50 <= grade && grade <= 54.99) {
//				rawTotal = rawTotal + (2.0 * courseTaken.get(i).getCredit());
//			}
//			else if(55 <= grade && grade <= 59.99) {
//				rawTotal = rawTotal + (3.0 * courseTaken.get(i).getCredit());
//			}
//			else if(60 <= grade && grade <= 64.99) {
//				rawTotal = rawTotal + (4.0 * courseTaken.get(i).getCredit());
//			}
//			else if(65 <= grade && grade <= 69.99) {
//				rawTotal = rawTotal + (5.0 * courseTaken.get(i).getCredit());
//			}
//			else if(70 <= grade && grade <= 74.99) {
//				rawTotal = rawTotal + (6.0 * courseTaken.get(i).getCredit());
//			}
//			else if(75 <= grade && grade <= 79.99) {
//				rawTotal = rawTotal + (7.0 * courseTaken.get(i).getCredit());
//			}
//			else if(80 <= grade && grade <= 89.99) {
//				rawTotal = rawTotal + (8.0 * courseTaken.get(i).getCredit());
//			}
//			else if(90 <= grade && grade <= 100) {
//				rawTotal = rawTotal + (9.0 * courseTaken.get(i).getCredit());
//			}
//			else {
//				rawTotal = rawTotal + (0.0 * courseTaken.get(i).getCredit());
//			}
//		}
//		
//		GPA = Math.round((rawTotal / totalCredits) * 10) / 10.0;
//			return GPA;
//	}
//	
//	/**
//	 * Getter method for studentID.
//	 * @return studentID
//	 */
//
//	public String getStudentID() {
//		return studentID;
//	}
//	
//	/**
//	 * Setter method for studentID.
//	 * @param studentID
//	 */
//
//	public void setStudentID(String studentID) {
//		this.studentID = studentID;
//	}
//	
//	/**
//	 * Getter method for getName.
//	 * @return name
//	 */
//
//	public String getName() {
//		return name;
//	}
//	
//	/**
//	 * Setter method for getName.
//	 * @param name
//	 */
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	/**
//	 * Getter method for courseTaken.
//	 * @return courseTaken
//	 */
//
//	public ArrayList<Course> getCourseTaken() {
//		return courseTaken;
//	}
//
//	/**
//	 * Setter method for courseTaken.
//	 * @param courseTaken
//	 */
//	
//	public void setCourseTaken(ArrayList<Course> courseTaken) {
//		this.courseTaken = courseTaken;
//	}
//	
//	/**
//	 * Getter method for finalGrade.
//	 * @return finalGrade
//	 */
//	
//	public ArrayList<Double> getFinalGrade() {
//		return finalGrade;
//	}
//
//	/**
//	 * Setter method for finalGrade.
//	 * @param finalGrade
//	 */ 
//	
//	public void setFinalGrade(ArrayList<Double> finalGrade) {
//		this.finalGrade = finalGrade;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (studentID == null) {
//			if (other.studentID != null)
//				return false;
//		} else if (!studentID.equals(other.studentID))
//			return false;
//		return true;
//	}
//
//}
	

