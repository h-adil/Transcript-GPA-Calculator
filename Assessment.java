//package Assignment2;
//
//public class Assessment extends Course{
//
//	private int weight;
//	
//	private char type;
//	
//	public Assessment() {
//		weight = 0;
//		type = ' ';
//	}
//	
//	/**
//	 * This method initializes the two parameters and calls super for 
//	 * extending course class.
//	 * @param type Char
//	 * @param weight Integer
//	 */
//	
//	public Assessment(char type, int weight) {
//		super();
//		this.weight = weight;
//		this.type = type;
//	}
//	
//	/**
//	 * This method gets the instance of the assessments.
//	 * @param type Char
//	 * @param weight Integer
//	 * @return Instance of assessment objects
//	 */
//	
//	public static Assessment getInstance(char type, int weight) {
//		return Assessment.getInstance(type, weight);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Assessment other = (Assessment) obj;
//		if (type != other.type)
//			return false;
//		if (weight != other.weight)
//			return false;
//		return true;
//	}
//
//	/**
//	 * Getter method for weight
//	 * @return weight
//	 */
//	public int getWeight() {
//		return this.weight;
//	}
//	
//	
//}
