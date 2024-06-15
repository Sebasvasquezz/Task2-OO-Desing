package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Calculate is a utility class for performing calculations on numbers read from a file.
 * It uses a MyLinkedList to store the numbers and provides methods to read numbers from a file,
 * calculate mean and standard deviation of the numbers.
 */
public class Calculate {

    private MyLinkedList<Double> numbers;

    /**
     * Constructs a new Calculate object with an empty linked list.
     */
    public Calculate() {
        this.numbers = new MyLinkedList<>();
    }

    /**
     * Reads numbers from the specified file and adds them to the linked list.
     *
     * @param filename the name of the file to read numbers from.
     */
    public void readNumbersFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); 
                if (!line.isEmpty()) {
                    try {
                        Double number = Double.parseDouble(line);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Performs a calculation on the numbers stored in the linked list using the specified operation.
     *
     * @param operation a function representing the operation to perform on the linked list.
     * @return the result of the calculation.
     */
    public double calculate(Function<MyLinkedList<Double>, Double> operation) {
        return operation.apply(numbers);
    }


    /**
     * Main method to read numbers from a file, calculate mean and standard deviation,
     * and print the results to the console.
     *
     * @param args the command-line arguments. Expects the path to the file containing numbers.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide the file path as a command-line argument");
            System.exit(1);
        }

        String filePath = args[0];

        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile(filePath);

        double mean = calculator.calculate(list -> list.calculateMean());
        double stdDev = calculator.calculate(list -> list.calculateStandardDeviation());

        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + stdDev);
    }

    /**
     * Retrieves the linked list containing the numbers.
     *
     * @return the linked list containing the numbers.
     */
    public MyLinkedList<Double> getNumbers(){
        return numbers;
    }
    
}
