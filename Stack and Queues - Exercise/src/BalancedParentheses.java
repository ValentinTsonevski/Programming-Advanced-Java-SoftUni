import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<Character> openingBracketStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                openingBracketStack.push(currentBracket);
            } else {
                if(openingBracketStack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBracketStack.pop();
                if (currentBracket == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                } else if (currentBracket == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                } else if (currentBracket == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                }
            }

        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
