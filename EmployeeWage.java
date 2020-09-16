public class EmployeeWage {

	public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

	private final String company;
	private final int empRatePerHrs;
	private final int workingDaysPerMonth;
	private final int maxHrsPerMonth;
	private int totalEmpWage;

	public void EmpWageBuilder(String company, int empRatePerHrs,
                    int workingDaysPerMonth, int maxHrsPerMonth) {
		this.company = company;
		this.empRatePerHrs = empRatePerHrs;
		this.workingDaysPerMonth = workingDaysPerMonth;
		this.maxHrsPerMonth = maxHrsPerMonth;

	public void computeEmpWage() {

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
		totalEmpWage = totalEmpHrs * empRatePerHrs;
	}

	@Override
	public String toString() {
		return "Total Emp Wage for " + company + " is " + totalEmpWage;
	}

	public static void main(String[] args) {
		EmpWageBuilder google = new EmpWageBuilder("Google", 20, 2, 10);
		EmpWageBuilder facebook = new EmpWageBuilder("Facebook", 10, 6, 30);
		google.computeEmpWage();
		System.out.println("Google");
		facebook.computeEmpWage();
		System.out.println("Facebook");
	}
}
