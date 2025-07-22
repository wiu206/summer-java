public class FactorialExample {

    public static int factorial(int n, StringBuilder steps) {
        if (n <= 1) {
            steps.append("1");
            return 1;
        } else {
            steps.append(n).append(" * ");
            return n * factorial(n - 1, steps);
        }
    }

    public static void printFactorial(int n) {
        StringBuilder steps = new StringBuilder();
        int result = factorial(n, steps);
        System.out.println(n + "! = " + steps.toString() + " = " + result);
    }

    public static void main(String[] args) {
        printFactorial(3);
        printFactorial(5);
        printFactorial(0); 
    }
}

