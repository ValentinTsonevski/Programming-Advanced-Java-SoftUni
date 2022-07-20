import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());
        memory = new long[number + 1];
        if (number == 0) {
            System.out.println(0);
            return;
        }
        long result = fib(number);
        System.out.println(result);


    }

    private static long fib(int number) {
        if ((number < 2)) {
            return 1;
        }
        if(memory[number] != 0){
            return memory[number];
        }
        memory[number] =fib(number - 1) + fib(number - 2);
        return memory[number];

    }
}
