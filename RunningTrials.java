/**
 * Running Trials
 * Author: Anthony Torres and Carolyn Yao
 * Does this compile or finish running within 5 seconds? Y/N
 *      runTrialsRecur: NO
 *      runTrialsMemoized:
 *      runTrialsBottomUp: 
 */

public class RunningTrials {

  // Do not change the parameters!
  public int runTrialsRecur(int possibleSpeeds, int days) {
    int minTests = 0;
    int min = Integer.MAX_VALUE;
    // Your code here
    if (days == 0 || possibleSpeeds == 0) return 0; //If no days or speeds left, there are no more tests to run.
    if (days == 1)  return possibleSpeeds;          //If only 1 day left, you need to run tests for each speed left.
    for (int i = 1; i <= possibleSpeeds; i++)
    {
      minTests = Math.max((runTrialsRecur(possibleSpeeds-1, i-1)), (runTrialsRecur(possibleSpeeds-i, days-1) ) );
      if(minTests < min) min = minTests;
    }
    return minTests+1;
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int runTrialsMemoized() {
    int minTests = 0;
    // Your optional code here
    return minTests;
  }

  // Do not change the parameters!
  public int runTrialsBottomUp(int possibleSpeeds, int days) {
    int minTests = 0;
    // Your code here
    return minTests;
  }

  public static void main(String args[]){
      RunningTrials running = new RunningTrials();

      // Do not touch the below lines of code, your output will automatically be formatted
      int minTrials1Recur = running.runTrialsRecur(12, 5);
      int minTrials1Bottom = running.runTrialsBottomUp(12, 5);
     // int minTrials2Recur = running.runTrialsRecur(20, 8);
      //int minTrials2Bottom = running.runTrialsBottomUp(20, 8);
      System.out.println("12 speeds, 5 weeks: " + minTrials1Recur + " " + minTrials1Bottom);
      //System.out.println("20 speeds, 8 weeks: " + minTrials2Recur + " " + minTrials2Bottom);
  }
}
