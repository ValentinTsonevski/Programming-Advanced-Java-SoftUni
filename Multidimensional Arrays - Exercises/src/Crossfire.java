import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        List<List<Integer>> matrix = new ArrayList<>();
        fillTheMatrix(matrix,rows, cols);

        String inputCommands = scanner.nextLine();
        while (!inputCommands.equals("Nuke it from orbit")) {
            String[] tokens = inputCommands.split(" ");
            int rowForIndex = Integer.parseInt(tokens[0]);
            int colForIndex = Integer.parseInt(tokens[1]);
            int damageRadius = Integer.parseInt(tokens[2]);

            nukeTheTarget(matrix,rowForIndex,colForIndex,damageRadius);
            removeEmptyLines(matrix);

            inputCommands = scanner.nextLine();
        }
        printTheMatrix(matrix);

    }

    private static void printTheMatrix(List<List<Integer>> matrix) {
        for (List<Integer> list: matrix){
            for (Integer integer : list){
                System.out.print(integer + " ");
            }
            System.out.println();
         }
    }

    private static void fillTheMatrix(List<List<Integer>> matrix,int rows, int cols) {

     int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter);
                counter++;
            }
        }
    }

    public static boolean validIndex(int startIndex,int size){
    return startIndex >= 0 &&  startIndex < size;
    }

    public static void nukeTheTarget(List<List<Integer>> matrix,int row,int col,int radius){
        for (int i = col + radius; i >= col - radius ; i--) {
            if(validIndex(row, matrix.size()) && validIndex(i, matrix.get(row).size())){
          matrix.get(row).remove(i);
            }
        }
        for (int i = row - radius; i <= row + radius ; i++) {
            if(validIndex(i, matrix.size())  && validIndex(col,matrix.get(i).size()) && i != row ){
         matrix.get(i).remove(col);
            }
        }
        
    }

    public static void removeEmptyLines(List<List<Integer>> matrix){
        for (int i = 0; i < matrix.size(); i++) {
            if(matrix.get(i).size() == 0){
                matrix.remove(i);
                i--;
            }
        }
    }

}
