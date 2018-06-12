package problem1;

import java.util.ArrayList;

public interface BestFit {

    /*
    * This method returns all possible combinations
    * */
    public ArrayList<String> fitPlusMinus(String digits, long expectedResult);

    /*
    * This method returns all possible combinations
    * */
    public ArrayList<String> fit(String digits, long expectedResult);

}
