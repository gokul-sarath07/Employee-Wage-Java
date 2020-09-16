public class EmployeeWage {

	public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmployeeWage() {
		companyEmpWageArray =  new CompanyEmpWage[5];
	}

	private void addCompanyEmpWage(String company, int empRatePerHour,
						int numOfWorkingDays, int maxHoursPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour,
												numOfWorkingDays, maxHoursPerMonth);
		numOfCompany++;
	}

	private int computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}

	private int computeEmpWage(CompanyEmpWage companyEmpWage) {

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
		return totalEmpHrs * companyEmpWage.empRatePerHrs;
	}

	public static void main(String[] args) {
		EmployeeWage empWageBuilder = new EmployeeWage();
		empWageBuilder.addCompanyEmpWage("Google", 20, 2, 10);
		empWageBuilder.addCompanyEmpWage("Facebook", 10, 6, 30);
		empWageBuilder.computeEmpWage();
	}
}
