/**
 * Running Trials
 * Author: Anthony Torres , Deveshwar Singh, and Carolyn Yao
 * Does this compile or finish running within 5 seconds? Y/N
 *      runTrialsRecur: NO
 *      runTrialsBottomUp: YES 
 */

public class RunningTrials {

  // Do not change the parameters!

  public int runTrialsRecur(int possibleSpeeds, int days) {
    int minTests = 0;
  
    // Your code here
     /* Runs slow, commented out.
     int min = Integer.MAX_VALUE;
    if (days == 0 || possibleSpeeds == 0) return 0; //If no days or speeds left, there are no more tests to run.
    if (days == 1)  return possibleSpeeds;          //If only 1 day left, you need to run tests for each speed left.
    for (int i = 1; i <= possibleSpeeds; i++)
    {
      minTests = Math.max((runTrialsRecur(possibleSpeeds-1, i-1)), (runTrialsRecur(possibleSpeeds-i, days-1) ) );
      if(minTests < min) min = minTests;
    }
    */
    return minTests;
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
    int runTrials[][] = new int[days+1][possibleSpeeds+1];
    int max = Integer.MAX_VALUE;
    
     //Storing values for base case conditions; 1 speed left or 0 speeds left.
    for (int d = 1; d <= days; d++) 
    {
      runTrials[d][0] = 0;  //No speeds left to check, no matter the days its zero tests.    
      runTrials[d][1] = 1;  //If there is only 1 speed left to check, just one remaining test to run for that speed. #Days doesn't matter
    }

    //When one day left, #tests left is number of remaining speeds. 
        //Similar to recursive code above: if (days == 1)  return possibleSpeeds;
    for (int s = 1; s <= possibleSpeeds; s++)
    {
      runTrials[1][s] = s;
    }

    //Main for-loop is similar to recursive code above.
    for (int i = 2; i <= days; i++){ //Only need to check days greater than 1 since 1day left =1 test.
      for (int j = 2; j <= possibleSpeeds; j++){ //We have values for all j=0,1 already
        runTrials[i][j] = Integer.MAX_VALUE;
        for (int index=1; index <= j; index++){
          minTests = Math.max( runTrials[i-1][j - index], runTrials[i-1][index-1] );
          if(minTests < max) runTrials[i][j] = minTests;
   
        }
      }
    }
    return runTrials[days][possibleSpeeds];
  }

/*   public void printSpeed(int speeds[][]){
      String msg = "Testing Speed '" + s + "' on Day " + d + "...";
  }     */


  public static void main(String args[]){
      RunningTrials running = new RunningTrials();

      // Do not touch the below lines of code, your output will automatically be formatted
      int minTrials1Recur = running.runTrialsRecur(12, 5);
      int minTrials1Bottom = running.runTrialsBottomUp(12, 5);
      int minTrials2Recur = running.runTrialsRecur(20, 8);
      int minTrials2Bottom = running.runTrialsBottomUp(20, 8);
      System.out.println("12 speeds, 5 weeks: " + minTrials1Recur + " " + minTrials1Bottom);
      System.out.println("20 speeds, 8 weeks: " + minTrials2Recur + " " + minTrials2Bottom);
  }
}
