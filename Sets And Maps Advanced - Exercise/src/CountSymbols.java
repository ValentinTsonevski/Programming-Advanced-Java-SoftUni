import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map <Character,Integer> text = new TreeMap();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if(text.containsKey(symbol)){
                text.put(symbol,text.get(symbol) + 1);
            }else{
                text.put(symbol,1);
            }
        }
        for (var entry : text.entrySet()){
            System.out.printf("%s: %d time/s%n",entry.getKey(),entry.getValue());
        }



    }
}
