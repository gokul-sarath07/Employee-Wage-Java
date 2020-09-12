public class EmployeeWage {

	public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

	public static int computeEmpWage(String company, int empRatePerHrs,
					int workingDaysPerMonth, int maxHrsPerMonth) {

		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;

		while (totalEmpHrs <= maxHrsPerMonth || totalWorkingDays < workingDaysPerMonth) {
			totalWorkingDays++;
			int empCheck= (int) Math.floor( Math.random() * 10 ) % 3;
			switch (empCheck) {
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				case IS_PART_TIME:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#: "+ totalWorkingDays + " Emp Hr: " + empHrs);
		}
		int totalEmpWage = totalEmpHrs * empRatePerHrs;
		System.out.println("Total Emp Wage for " + company + " is " + totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args) {
		computeEmpWage("Google", 20, 2, 10);
		computeEmpWage("Facebook", 10, 6, 30);
	}
}
