package BankAccount;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<Integer, BankAccount> bankAccountMap = new LinkedHashMap();
        while (!input.equals("End")) {
            String[] commandParts = input.split(" ");
            String command = commandParts[0];

            String output = null;
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int id = bankAccount.getId();
                bankAccountMap.put(id, bankAccount);

                output = "Account ID" + id + " created";

            } else if (command.equals("Deposit")) {
            int id = Integer.parseInt(commandParts[1]);
            int amount = Integer.parseInt(commandParts[2]);
            BankAccount bankAccount = bankAccountMap.get(id);
            if(bankAccount != null) {
                bankAccount.deposit(amount);
                output = "Deposited " + amount + " to ID" + id;
            }
            else{
                output = "Account does not exist";
            }

            }else if (command.equals("SetInterest")){
                double interest = Double.parseDouble(commandParts[1]);
            BankAccount.setInterestRate(interest);

            }else{
                int id = Integer.parseInt(commandParts[1]);
                int years = Integer.parseInt(commandParts[2]);
                BankAccount bankAccount = bankAccountMap.get(id);
                if(bankAccount != null){
                output = String.format("%.2f",bankAccount.getInterestRate(years));
                }
                else{
                    output = "Account does not exist";
                }
            }
           if(output != null) {
               System.out.println(output);
           }
        input = scanner.nextLine();
        }

    }


}

