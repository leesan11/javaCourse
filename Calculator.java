import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("List of operations: add subtract multiply divide alphabetize\n");
        System.out.print("Enter an operation:\n");
        String operation = input.nextLine();
        switch (operation.toLowerCase()) {
            case "add":
                System.out.println("Enter two integers: ");
                if (input.hasNextInt()) {
                    int numOne = input.nextInt();
                    int numTwo = input.nextInt();
                    System.out.println("Answer: " + (numOne + numTwo));
                }else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "subtract":
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    int numThree = input.nextInt();
                    int numFour = input.nextInt();
                    System.out.println("Answer: " + (numThree - numFour));
                }else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "multiply":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    double numFive = input.nextDouble();
                    double numSix = input.nextDouble();
                    System.out.printf("Answer: %.2f", (numFive*numSix));
                }else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "divide":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    double numSeven = input.nextDouble();
                    double numEight = input.nextDouble();
                    if (numEight == 0) {
                        System.out.println("Invalid input entered. Terminating...");
                    } else {
                        System.out.printf("Answer: %.2f",(numSeven/numEight));
                    }
                }else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                if (input.hasNext()) {
                    String first = input.next();
                    String second = input.next();
                    if (first.toLowerCase().compareTo(second.toLowerCase()) > 0) {
                        System.out.println("Answer: "+second + " comes before " + first + " alphabetically.");
                    } else if (first.toLowerCase().compareTo(second.toLowerCase()) < 0) {
                        System.out.println("Answer: "+first + " comes before " + second + " alphabetically.");
                    } else {
                        System.out.println("Answer: Chicken or Egg.");
                    }

                }else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
                input.close();

        }
    }
}