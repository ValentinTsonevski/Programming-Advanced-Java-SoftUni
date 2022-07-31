import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Double>> shopsInfo = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
       String[] currentShopInfo = input.split(", ");
       String shopName = currentShopInfo[0];
       String productName = currentShopInfo[1];
       double productPrice = Double.parseDouble(currentShopInfo[2]);

       shopsInfo.putIfAbsent(shopName,new LinkedHashMap<>());

            shopsInfo.get(shopName).put(productName,productPrice);

            input = scanner.nextLine();
        }

        for (Map.Entry<String,Map<String,Double>> entry :shopsInfo.entrySet()){
            System.out.printf("%s->%n",entry.getKey());
           for (Map.Entry<String,Double> secondEntry : entry.getValue().entrySet()){

               System.out.printf("Product: %s, Price: %.1f%n",secondEntry.getKey(),secondEntry.getValue());
           }

        }


    }
}
