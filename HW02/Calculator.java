import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String input = scanner.next().toLowerCase();

        switch (input) {
            case "add":
                System.out.println("Enter two integers:");

                int add1 = 0;
                int add2 = 0;

                if(scanner.hasNextInt()) {
                    add1 = scanner.nextInt();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                if(scanner.hasNextInt()) {
                    add2 = scanner.nextInt();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                System.out.printf("Answer: %d\n", add1 + add2);
                break;
            case "subtract":
                System.out.println("Enter two integers:");
                int sub1 = 0;
                int sub2 = 0;

                if(scanner.hasNextInt()) {
                    sub1 = scanner.nextInt();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                if(scanner.hasNextInt()) {
                    sub2 = scanner.nextInt();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                System.out.printf("Answer: %d\n", sub1 - sub2);
                break;
            case "multiply":
                System.out.println("Enter two doubles:");

                double multiply1 = 0;
                double multiply2 = 0;

                if(scanner.hasNextDouble()) {
                    multiply1 = scanner.nextDouble();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                if(scanner.hasNextDouble()) {
                    multiply2 = scanner.nextDouble();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                System.out.printf("Answer: %.2f\n", multiply1 * multiply2);
                break;
            case "divide":
                System.out.println("Enter two doubles:");

                double divide1 = 0;
                double divide2 = 0;

                if(scanner.hasNextDouble()) {
                    divide1 = scanner.nextDouble();
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                if(scanner.hasNextDouble()) {
                    divide2 = scanner.nextDouble();

                    if(divide2 == 0) {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                System.out.printf("Answer: %.2f\n", divide1 / divide2);
                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                String string1 = scanner.next();
                String string2 = scanner.next();

                int compareResult = string1.compareTo(string2);

                if(compareResult == 0) {
                    System.out.println("Answer: Chicken or Egg.");
                } else if(compareResult < 0) {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", string1, string2);
                } else {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", string2, string1);
                }

                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}