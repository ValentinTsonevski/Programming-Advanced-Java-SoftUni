import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengthOfSets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       int first = lengthOfSets[0];
       int second = lengthOfSets[1];

        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            set1.add(scanner.nextLine());
        }
        for (int i = 0; i < second; i++) {
            set2.add(scanner.nextLine());
        }
        set1.retainAll(set2);
        System.out.println(String.join(" ", set1));
    }
}
