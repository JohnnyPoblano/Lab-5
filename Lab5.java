/*
**  John G
**  CIS 131
**  LAB 5
*/

public class Lab5 {

    // Constants
    final static int NUM_OF_EMPLOYEES = 6;
    
    final static int EMPLOYEE_NUMBER_MIN = 1000;
    final static int EMPLOYEE_NUMBER_MAX = 9999;
    
    final static int HOURS_WORKED_MIN = 30;
    final static int HOURS_WORKED_MAX = 50;

    /* Quarter constants should be similar to pay rate constants so
    they can be passed into the same function */
    final static double QUARTER_0 = 0.00;
    final static double QUARTER_1 = 0.25;
    final static double QUARTER_2 = 0.50;
    final static double QUARTER_3 = 0.75;
    final static int QUARTER_LOW_INDEX = 0;
    final static int QUARTER_HIGH_INDEX = 3;
    final static double[] QUARTER_ARRAY = {QUARTER_0, QUARTER_1, QUARTER_2, QUARTER_3};

    /* Pay rate constants should be similar to quarter constants so
    they can be passed into the same function */
    final static int PAY_RATE_MIN = 7;
    final static int PAY_RATE_MAX = 20;
    final static double PAY_RATE_INCREMENT_0 = 0.00;
    final static double PAY_RATE_INCREMENT_1 = 0.50;
    final static int PAY_RATE_LOW_INDEX = 0;
    final static int PAY_RATE_HIGH_INDEX = 1;
    final static double[] PAY_RATE_INCREMENT_ARRAY = {PAY_RATE_INCREMENT_0, PAY_RATE_INCREMENT_1};

    final static double OVERTIME_PAY_RATE = 1.75;
    
    public static void main(String args[]) { //-------------------------------MAIN-------------------------------//

        // Array declarations
        int[] empNo = new int[NUM_OF_EMPLOYEES];
        double[] payRate = new double[NUM_OF_EMPLOYEES];
        double[] hoursWorked = new double[NUM_OF_EMPLOYEES];
        double[] regularPay = new double[NUM_OF_EMPLOYEES];
        double[] overtimePay = new double[NUM_OF_EMPLOYEES];
        double[] totalPay = new double[NUM_OF_EMPLOYEES];

        // Populate arrays
        generateEmployeeNumbers(empNo);
        generateHoursWorked(hoursWorked);
        generatePayRates(payRate);

    } //--------------------------------------------------------------------END MAIN----------------------------//

    // Initialize int array as all 0's
    public static void initializeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    // Generate random employee numbers into an array
    public static void generateEmployeeNumbers(int[] array) {

        // Set all values of array = 0
        initializeArray(array);
        
        // For loop to assign each element of the array an employee number
        for (int i = 0; i < array.length; i++) {
            int employeeNumber = IR4.getRandomNumber(EMPLOYEE_NUMBER_MIN, EMPLOYEE_NUMBER_MAX);
            int count;
            // Do while loop to create new numbers while employeeNumber == an existing element in the array
            // Counter variable acts as a flag to ensure the newly generated value is also unique
            do {
                count = 0;
                for (int j = 0; j < array.length; j++) {
                    if (employeeNumber == array[j]) {
                        employeeNumber = IR4.getRandomNumber(EMPLOYEE_NUMBER_MIN, EMPLOYEE_NUMBER_MAX);
                        count++;
                    }
                }
            } while (count > 0);

            // Assign the value to the index i, then move on to the next iteration of i
            array[i] = employeeNumber;
        }

    }

    // Generate random hours worked into an array
    public static void generateHoursWorked(double[] array) {
        
        for (int i = 0; i < array.length; i++) {
            
            double hoursWorked = (int) IR4.getRandomNumber(HOURS_WORKED_MIN, HOURS_WORKED_MAX);
            
            // Add on quarter-hourly increments randomly (0, 0.25, 0.50, 0.75)
            if (hoursWorked != HOURS_WORKED_MAX) {
                int rand = IR4.getRandomNumber(QUARTER_LOW_INDEX, QUARTER_HIGH_INDEX);
                hoursWorked += QUARTER_ARRAY[rand];
            }
            
            array[i] = hoursWorked;
        }
    }

    // Generate random pay rates into an array
    public static void generatePayRates(double[] array) {

        for (int i = 0; i < array.length; i++) {
            
            double payRate = (int) IR4.getRandomNumber(PAY_RATE_MIN, PAY_RATE_MAX);
            
            // Add on half-hour increments randomly
            if (payRate != PAY_RATE_MAX) {
                int rand = IR4.getRandomNumber(0, 1);
                hoursWorked += QUARTER_ARRAY[rand];
            }
            
            array[i] = hoursWorked;
        }
    }

    public static void generateRandomDoublesWithIncrements(double[] array, double[] incrementArray, int minimum, int maximum, int lowIndex, int highIndex) {
        
        for (int i = 0; i < array.length; i++) {
            
            double hoursWorked = (int) IR4.getRandomNumber(minimum, maximum);
            
            // Add on increments randomly
            if (hoursWorked != maximum) {
                int rand = IR4.getRandomNumber(lowIndex, highIndex);
                hoursWorked += QUARTER_ARRAY[rand];
            }
            
            array[i] = hoursWorked;
        }
    }

}