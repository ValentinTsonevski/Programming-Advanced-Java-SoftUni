import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] box1QueInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] box2StackInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> box1Que = new ArrayDeque<>();
        ArrayDeque<Integer> box2Stack = new ArrayDeque<>();

        for (int i = 0; i < box1QueInput.length; i++) {
            box1Que.add(box1QueInput[i]);
        }

        for (int i = 0; i < box2StackInput.length; i++) {
            box2Stack.push(box2StackInput[i]);
        }

        int totalSumStored = 0;

        while (!(box1Que.isEmpty() || box2Stack.isEmpty())){

        int itemQue = box1Que.poll();
        int itemStack = box2Stack.pop();

        int sum = itemQue + itemStack;

        if(sum % 2 == 0){
          totalSumStored += sum;
        }
        else{
        box1Que.addFirst(itemQue);
        box1Que.addLast(itemStack);
        }

        }

        if(box1Que.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if(box2Stack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if(totalSumStored >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d",totalSumStored);
        }
        else{
            System.out.printf("Poor prey... Value: %d",totalSumStored);
        }


    }
}
