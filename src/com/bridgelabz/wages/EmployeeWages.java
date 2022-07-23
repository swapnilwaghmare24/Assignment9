package com.bridgelabz.wages;

public class EmployeeWages
{
    final int PRESENT = 1;
    final int PART_TIME = 2;
    public int checkEmpAttendance(int totalWorkingHour, int fullTimeWorkingHour, int maxWorkingHour)
    {
        if (totalWorkingHour == maxWorkingHour - (fullTimeWorkingHour / 2)) {
            return PART_TIME;
        } else
        {
            return (int) (Math.random() * 3);
        }
    }

    public int getWorkingHour(int isEmpPresent, int fullTimeWorkingHour)
    {
        switch (isEmpPresent)
        {
            case PRESENT:
                return fullTimeWorkingHour;

            case PART_TIME:
                return fullTimeWorkingHour / 2;

            default:
                return 0;
        }
    }

    public double calculateEmployeeWage(int fullTimeWorkingHour, int wagePerHour, int maxWorkingDay, int maxWorkingHour)
    {
        int totalWorkingHour = 0;
        int day = 0;
        while (day < maxWorkingDay && totalWorkingHour < maxWorkingHour)
        {
            day++;
            int isEmpPresent = checkEmpAttendance(totalWorkingHour, fullTimeWorkingHour, maxWorkingHour);

            int empHr = getWorkingHour(isEmpPresent, fullTimeWorkingHour);

            totalWorkingHour = totalWorkingHour + empHr;
        }
        System.out.println("Working Hour : " + totalWorkingHour + " Hour");
        return totalWorkingHour * wagePerHour;
    }

    public static void main(String[] args) {

        EmployeeWages employeeWages = new EmployeeWages();

        double tcsSalary = employeeWages.calculateEmployeeWage(8, 15, 20, 60);
        System.out.println("Employee monthly salary : $" + tcsSalary + " USD");

        double wiproSalary = employeeWages.calculateEmployeeWage(10, 20, 18, 60);
        System.out.println("Employee monthly salary : $" + wiproSalary + " USD");
    }

}

