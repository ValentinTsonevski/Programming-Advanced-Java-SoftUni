import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] vowels = scanner.nextLine().split(" ");
       String[] consonants = scanner.nextLine().split(" ");

        ArrayDeque<String> vowelsQue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        for (int i = 0; i < consonants.length; i++) {
            consonantsStack.push(consonants[i]);
        }

        for (int i = 0; i < vowels.length; i++) {
             vowelsQue.add(vowels[i]);
        }
        Set<String> pear = new HashSet<>();
        Set<String> flour = new HashSet<>();
        Set<String> pork = new HashSet<>();
        Set<String> olive = new HashSet<>();


        List<String> wordFound = new ArrayList<>();

        while (!consonantsStack.isEmpty()){

        String vowel = vowelsQue.poll();
        String consonant = consonantsStack.pop();

        if("pear".contains(vowel)){
         pear.add(vowel);
        }

        if("pear".contains(consonant)){
            pear.add(consonant);
        }
            if("flour".contains(vowel)){
                flour.add(vowel);
            }

            if("flour".contains(consonant)){
                flour.add(consonant);
            }

            if("pork".contains(vowel)){
                pork.add(vowel);
            }

            if("pork".contains(consonant)){
                pork.add(consonant);
            }

            if("olive".contains(vowel)){
                olive.add(vowel);
            }

            if("olive".contains(consonant)){
                olive.add(consonant);
            }

        vowelsQue.offer(vowel);
        }

        if(pear.size() == 4){
            wordFound.add("pear");
        }

        if(flour.size() == 5){
            wordFound.add("flour");
        }

        if(pork.size() == 4){
        wordFound.add("pork");
        }

        if(olive.size() == 5){
         wordFound.add("olive");
        }

        System.out.println("Words found: " + wordFound.size());
        System.out.println(String.join(System.lineSeparator(), wordFound));

    }
}
