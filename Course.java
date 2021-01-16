//package Assignment2;
//
//import java.util.ArrayList;
//
//public class Course extends Student{
//
//	private String code;
//	
//	private double credit;
//	
//	private ArrayList<Assessment> assignment;
//
//	
//	public Course() {
//		code = (" ");
//		assignment = new ArrayList<Assessment>();
//		credit = 0.0;
//	}
//	
//	/**
//	 * This method initializes three parameters and calls super for extending 
//	 * from student class.
//	 * @param course String
//	 * @param assignment ArrayList 
//	 * @param credit Double
//	 */
//	
//	public Course(String course, ArrayList<Assessment> assignment, double credit) {
//		super();
//		this.code = course;
//		this.assignment = new ArrayList<Assessment>(assignment);
//		this.credit = credit;
//	}
//	
//	/**
//	 * This method creates a course using another course.
//	 * @param course
//	 */
//	
//	public Course(Course course) {
//		this.code = course.code;
//		this.assignment = new ArrayList<Assessment>(course.assignment);
//		this.credit = course.credit;
//	}
//
//	/**
//	 * Getter method for getCode.
//	 * @return code
//	 */
//	
//	public String getCode() {
//		return code;
//	}
//
//	/**
//	 * Getter method for assignment.
//	 * @return assignment
//	 */
//	
//	public ArrayList<Assessment> getAssignment() {
//		return assignment;
//	}
//
//	/**
//	 * Getter method for credit
//	 * @return credit 
//	 */
//	
//	public double getCredit() {
//		return credit;
//	}
//
//	/**
//	 * Setter method for code
//	 * @param code
//	 */
//	
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	/**
//	 * Setter method for assignment 
//	 * @param assignment
//	 */
//	
//	public void setAssignment(ArrayList<Assessment> assignment) {
//		this.assignment = assignment;
//	}
//
//	/**
//	 * Setter method for credit
//	 * @param credit
//	 */
//	
//	public void setCredit(double credit) {
//		this.credit = credit;
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
//		Course other = (Course) obj;
//		if (assignment == null) {
//			if (other.assignment != null)
//				return false;
//		} else if (!assignment.equals(other.assignment))
//			return false;
//		if (code == null) {
//			if (other.code != null)
//				return false;
//		} else if (!code.equals(other.code))
//			return false;
//		if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
//			return false;
//		return true;
//	}
//	
//	
//}
	

