import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int count = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        for (String kid : input) {
            kidsQueue.offer(kid);
        }

       while (kidsQueue.size() > 1){
           for (int i = 1; i < count ; i++) {
               kidsQueue.offer(kidsQueue.poll());
           }
           System.out.println("Removed" + " " + kidsQueue.poll());
       }
        System.out.println("Last is " + kidsQueue.poll());


    }
}
