import java.util.*;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).
                sorted((e1,e2) -> e2.compareTo(e1)).limit(3).forEach(e -> System.out.print(e + " "));

    }

}
