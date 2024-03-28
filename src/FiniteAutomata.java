import java.util.Scanner;

public class FiniteAutomata {
    
    // Start state
    private static final int START_STATE = 0;
    //State End
    private static final int[] ACCEPT_STATES = {2};
    
    //  Transition Table
    private static final int[][] TRANSITION_TABLE = {
        // State 0
        {1, 0},  
        // State 1
        {1, 2},  
        // State 2
        {1, 0},  
    };
    
    // Check Accepted or Rejected
    public static boolean isAccepted(String input) {
        int currentState = START_STATE;
        for (char c : input.toCharArray()) {
            int inputDigit = Character.getNumericValue(c);
            currentState = TRANSITION_TABLE[currentState][inputDigit];
        }
        for (int acceptState : ACCEPT_STATES) {
            if (currentState == acceptState) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input(consisting of 0 and 1): ");
        String input = scanner.nextLine();
        
        if (isAccepted(input)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }
        
        scanner.close();
    }
}
