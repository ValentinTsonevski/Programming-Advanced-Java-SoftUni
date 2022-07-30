import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] player1Numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] player2Numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int round = 1;
        int totalRounds = 50;

        Set<Integer> player1 = new LinkedHashSet<>();
        fillPlayer1(player1Numbers, player1);

        Set<Integer> player2 = new LinkedHashSet<>();
        fillPlayer2(player2Numbers, player2);

        while (!player1.isEmpty() || !player2.isEmpty()){
            round ++;
            if(round == totalRounds){
                break;
            }

            Integer player1Card = player1.iterator().next();
            player1.remove(player1Card);

            Integer player2Card = player2.iterator().next();
            player2.remove(player2Card);

           if(player1Card > player2Card){
               player1.add(player1Card);
               player1.add(player2Card);

           }else if (player2Card > player1Card){
               player2.add(player1Card);
               player2.add(player2Card);
           }



        }
    if(player2.size() > player1.size()){
        System.out.println("Second player win!");
    }else if (player1.size() > player2.size()){
        System.out.println("First player win!");
    }else{
        System.out.println("Draw!");
    }

    }



    private static void fillPlayer1(int[] player1Numbers, Set<Integer> player1) {
        for (int i = 0; i < player1Numbers.length; i++) {
            player1.add(player1Numbers[i]);
        }
    }

    private static void fillPlayer2(int[] player2Numbers, Set<Integer> player2) {
        for (int i = 0; i < player2Numbers.length; i++) {
            player2.add(player2Numbers[i]);
        }
    }
}
