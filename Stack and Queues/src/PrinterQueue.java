import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> documentName = new ArrayDeque<>();

        while (!input.equals("print")){
            if(input.equals("cancel")){
            if(documentName.isEmpty()){
                System.out.println("Printer is on standby");
            }else{
                System.out.println("Canceled" +" "+ documentName.pollFirst());
            }

            }else{
                documentName.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String file : documentName) {
            System.out.println(file);
        }


    }
}
