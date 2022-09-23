import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //que
        int[] steelNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //stack
        int[] carbonNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        for (int i = 0; i < steelNumbers.length; i++) {
            steel.add(steelNumbers[i]);
        }

        for (int i = 0; i < carbonNumbers.length; i++) {
            carbon.push(carbonNumbers[i]);
        }
        String sword;
        int totalSwords = 0;

        Map<String,Integer> swords = new TreeMap<>();


        while (!steel.isEmpty() && !carbon.isEmpty()){

        int currentSteel = steel.poll();
        int currentCarbon = carbon.pop();
        int sum = currentSteel + currentCarbon;

        switch (sum){

            case 70:
            sword = "Gladius";
            swords.putIfAbsent(sword,0);
                addSword(sword, swords);
                totalSwords ++;
                break;

            case 80:
            sword = "Shamshir";
                swords.putIfAbsent(sword,0);
            addSword(sword,swords);
                totalSwords ++;
                break;

            case 90:
            sword = "Katana";
                swords.putIfAbsent(sword,0);
                addSword(sword,swords);
                totalSwords ++;
                break;

            case 110:
            sword = "Sabre";
                swords.putIfAbsent(sword,0);
                addSword(sword,swords);
                totalSwords ++;
                break;

            default:
            carbon.push(currentCarbon + 5);
            break;
        }

        }

        if(totalSwords > 0){
            System.out.printf("You have forged %d swords.%n", totalSwords);
        }
        else{
            System.out.println("You did not have enough resources to forge a sword.");
        }


        if(!steel.isEmpty()){
            System.out.println("Steel left: " + steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        else{
            System.out.println("Steel left: none");
        }


        if(!carbon.isEmpty()){
            System.out.println("Carbon left: " + carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        else{
            System.out.println("Carbon left: none");
        }


     for(var entry: swords.entrySet()){
         if(entry.getValue() > 0){

         System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
         }
     }

    }


    private static void addSword(String sword, Map<String, Integer> swordsCounter) {

        int currentSwords = swordsCounter.get(sword);
        swordsCounter.put(sword,currentSwords + 1);
    }
}
