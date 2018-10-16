public class Lab5 {

    // Constants
    final static int EMPLOYEE_NUMBER_MIN = 1000;
    final static int EMPLOYEE_NUMBER_MAX = 9999;
    
    final static int HOURS_WORKED_MIN = 30;
    final static int HOURS_WORKED_MAX = 50;

    final static double QUARTER_0 = 0.00;
    final static double QUARTER_1 = 0.25;
    final static double QUARTER_2 = 0.50;
    final static double QUARTER_3 = 0.75;
    final static int QUARTER_LOW_INDEX = 0;
    final static int QUARTER_HIGH_INDEX = 3;
    final static int[] QUARTER_ARRAY = {QUARTER_0, QUARTER_1, QUARTER_2, QUARTER_3};
    
    public static void main(String args[]) {

    }

    // Generate random employee number
    public static int generateEmployeeNumber() {
        int employeeNumber = (int) IR4.getRandomNumber(EMPLOYEE_NUMBER_MIN, EMPLOYEE_NUMBER_MAX);
        return employeeNumber;
    }

    // Generate random hours worked
    public static double generateHoursWorked() {
        double hoursWorked = (double) IR4.getRandomNumber(HOURS_WORKED_MIN, HOURS_WORKED_MAX);
        
        // Add on quarter-hourly increments randomly (0, 0.25, 0.50, 0.75)
        if (hoursWorked != HOURS_WORKED_MAX) {
            int rand = IR4.getRandomNumber(QUARTER_LOW_INDEX, QUARTER_HIGH_INDEX);
            hoursWorked += QUARTER_ARRAY[rand];
        }
        
        return hoursWorked; 
    }
}