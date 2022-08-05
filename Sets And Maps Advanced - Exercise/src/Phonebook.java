
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phoneBook = new LinkedHashMap<>();

          String input = scanner.nextLine();
          while (!input.equals("search")){
              String[] nameAndPhoneNumber = input.split("-");
              String name = nameAndPhoneNumber[0];
              String number = nameAndPhoneNumber[1];

              phoneBook.put(name,number);

              if(phoneBook.containsKey(name)){
                  phoneBook.put(name,number);
              }

              input = scanner.nextLine();
          }

        input = scanner.nextLine();
          while (!input.equals("stop")){
              String nameLookingFor = input;
              if(phoneBook.containsKey(nameLookingFor)){

                  System.out.printf("%s -> %s%n",nameLookingFor,phoneBook.get(nameLookingFor));

              }else{
                  System.out.printf("Contact %s does not exist.%n",nameLookingFor);
              }

              input = scanner.nextLine();
          }


    }
}
