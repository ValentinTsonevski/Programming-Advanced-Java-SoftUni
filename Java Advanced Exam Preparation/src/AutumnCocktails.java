import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersQue = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] freshnesStack = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < freshnesStack.length; i++) {
            stack.push(freshnesStack[i]);
        }

        for (int i = 0; i < numbersQue.length; i++) {
            que.add(numbersQue[i]);
        }

        Map<String,Integer> cocktailsCount = new TreeMap<>();


        while (!(stack.isEmpty() || que.isEmpty())){
         int ingredientQue = que.poll();
         int currentFreshnessStack = stack.pop();

         if(ingredientQue == 0){
             stack.push(currentFreshnessStack);
         continue;
         }

        int sum =  ingredientQue * currentFreshnessStack;

            if (sum == 150) {
                cocktailsCount.putIfAbsent("Pear Sour",0);
                cocktailsCount.put("Pear Sour", cocktailsCount.get("Pear Sour") + 1);

            } else if (sum == 250) {
                cocktailsCount.putIfAbsent("The Harvest",0);
                cocktailsCount.put("The Harvest",cocktailsCount.get("The Harvest") +1);

            } else if (sum == 300) {
                cocktailsCount.putIfAbsent("Apple Hinny",0);
                cocktailsCount.put("Apple Hinny",cocktailsCount.get("Apple Hinny") +1);

            } else if (sum == 400) {
                cocktailsCount.putIfAbsent("High Fashion",0);
                cocktailsCount.put("High Fashion", cocktailsCount.get("High Fashion") +1);
            }
            else{
             que.addLast(ingredientQue + 5);
            }

        }

        if(cocktailsCount.size() != 4){
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }else{
            System.out.println("It's party time! The cocktails are ready!");
        }

        if(!que.isEmpty()){
            int sum = que.stream().mapToInt(Integer -> Integer).sum();
            System.out.printf("Ingredients left: %d%n",sum);
        }


                for(var entry : cocktailsCount.entrySet()){
                    String output = String.format(" # %s --> %d", entry.getKey(), entry.getValue());
                    System.out.println(output);
                }

    }
}
