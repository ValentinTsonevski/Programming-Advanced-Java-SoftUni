import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] malesInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] femalesInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> femalesQue = new ArrayDeque();
        ArrayDeque<Integer> malesStack = new ArrayDeque();

        for (int i = 0; i < malesInput.length; i++) {
            malesStack.push(malesInput[i]);
        }

        for (int i = 0; i < femalesInput.length; i++) {
            femalesQue.add(femalesInput[i]);
        }

        int matches = 0;

        while (!(femalesQue.isEmpty() || malesStack.isEmpty())){
            int firstFemale = femalesQue.peek();
            int firstMale = malesStack.peek();

            if(firstFemale <= 0){
                femalesQue.poll();
                continue;
            }

            if(firstMale <= 0){
             malesStack.pop();
             continue;
            }

            if(firstFemale % 25 == 0){
                femalesQue.poll();
                femalesQue.poll();
                continue;
            }
            if (firstMale % 25 == 0){
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            int male = malesStack.pop();
            int female = femalesQue.poll();

            if(male == female){

              matches ++;
            }
            else{
             malesStack.push(male -2);
            }


        }

        System.out.println("Matches: " + matches);

        if(malesStack.isEmpty()){
            System.out.println("Males left: none");
        }
        else{
              String toPrint  = String.format("Males left: %s",malesStack.stream()
                      .map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(toPrint);
        }

        if(femalesQue.isEmpty()){
            System.out.println("Females left: none");
        }
        else{
                String toPrint = String.format("Females left: %s",femalesQue.stream()
                        .map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(toPrint);
        }


    }
}
