package problem1;

import java.util.ArrayList;

public class Permute {

    ArrayList<ArrayList<Long>> combinations = new ArrayList<ArrayList<Long>>();

    public ArrayList<ArrayList<Long>> execute(String digits) {
        ArrayList<Long> combination = new ArrayList<Long>();
        permute(digits, digits.length(), combination);
        return combinations;
    }

    public void permute(String digits, int stayNumber, ArrayList<Long> combination) {
        for (int i = 1; i < stayNumber; i++) {

            ArrayList<Long> innerCombination = new ArrayList<Long>(combination);
            String firsNumber = digits.substring(0, i);
            String secondNumber = digits.substring(i, stayNumber);

            //Integer x = Integer.valueOf(firsNumber);
            Long x = Long.parseLong(firsNumber);
            innerCombination.add(x);

            permute(secondNumber, stayNumber - i, innerCombination);


            //Integer y = Integer.valueOf(secondNumber);
            Long y = Long.parseLong(secondNumber);

            innerCombination.add(y);
            combinations.add(innerCombination);


        }

    }

}
