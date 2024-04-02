public class FiniteAutomata {
    
    // Start state
    private final int START_STATE = 0;
    //State End
    private final int[] ACCEPT_STATES = {2};
    
    //  Transition Table
    private final int[][] TRANSITION_TABLE = {
        // State 0
        {1, 0},  
        // State 1
        {1, 2},  
        // State 2
        {1, 0},  
    };
    
    // Check Accepted or Rejected
    public boolean isAccepted(String input) {
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
}
