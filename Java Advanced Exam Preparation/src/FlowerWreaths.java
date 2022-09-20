import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liliesInput = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] rosesInput = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> rosesQue = new ArrayDeque();
        ArrayDeque<Integer> liliesStack = new ArrayDeque();

        for (int i = 0; i < rosesInput.length; i++) {
            rosesQue.add(rosesInput[i]);
        }

        for (int i = 0; i < liliesInput.length; i++) {
            liliesStack.push(liliesInput[i]);
        }

        int wreths = 0;
        List<Integer> storedSum = new ArrayList<>();

        while (!(rosesQue.isEmpty() || rosesQue.isEmpty())) {

            int currentRose = rosesQue.poll();
            int currentLili = liliesStack.pop();

            int sum = currentRose + currentLili;

            while (sum > 15) {
                sum -= 2;
            }

            if (sum == 15) {
                wreths++;
            } else {
                storedSum.add(sum);
            }

        }

        int sumStoredFlowers = 0;

        for (Integer sum : storedSum) {
            sumStoredFlowers += sum;
        }

        while (sumStoredFlowers >= 15) {
            sumStoredFlowers -= 15;
            wreths++;
        }

        if (wreths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreths);
        }


    }
}
