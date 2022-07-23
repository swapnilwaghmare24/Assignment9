package com.bridgelabz.wages;

public class EmployeeWages
{
    final int PRESENT = 1;
    final int PART_TIME = 2;
    final int FULL_TIME = 8;
    final int WAGE_PER_HOUR = 20;
    final int MAX_WORKING_DAYS = 20;
    final int MAX_WORKING_HOUR = 60;

    public int checkEmpAttendance(int totalWorkingHour)
    {
        if (totalWorkingHour == MAX_WORKING_HOUR - (FULL_TIME / 2))
        {
            return PART_TIME;
        }
        else
        {
            return (int) (Math.random() * 3);
        }
    }

    public int getWorkingHour(int isEmpPresent)
    {
        switch (isEmpPresent)
        {
            case PRESENT:
                return FULL_TIME;

            case PART_TIME:
                return FULL_TIME / 2;

            default:
                return 0;
        }
    }

    public double calculateEmployeeWages()
    {
        int totalWorkingHour = 0;
        int day = 0;
        while (day < MAX_WORKING_DAYS && totalWorkingHour < MAX_WORKING_HOUR)
        {
            day++;
            int isEmpPresent = checkEmpAttendance(totalWorkingHour);

            int empHr = getWorkingHour(isEmpPresent);

            totalWorkingHour = totalWorkingHour + empHr;
        }
        System.out.println("Working Hour : " + totalWorkingHour + " Hour");
        return totalWorkingHour * WAGE_PER_HOUR;
    }

    public static void main(String[] args)
    {

        EmployeeWages employeeWages = new EmployeeWages();

        double totalSalary = employeeWages.calculateEmployeeWages();
        System.out.println("Employee monthly salary : $" + totalSalary + " USD");
    }

}

