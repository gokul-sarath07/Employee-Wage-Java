public class EmployeeWage {
	public static void main(String[] args) {

		int present = 1;
		double valcheck=Math.floor(Math.random()*10)%2;

		if (valcheck == present)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is Absent");
	}
}
