package problem1;

import java.util.ArrayList;

public class SignsPlusMinus {

    ArrayList<String> signsCombinations = new ArrayList<String>();

    public ArrayList<String> execute(int deep) {
        ArrayList<String> stringArray = new ArrayList<String>();
        initSigns(stringArray, deep);
        return signsCombinations;
    }

    public void initSigns(ArrayList<String> stringArray, int deep) {
        ArrayList<String> innerArray = new ArrayList<String>();
        innerArray.add("+");
        innerArray.add("-");
        signsCombinations.addAll(innerArray);
        createSigns(innerArray, deep - 1);
    }

    public void createSigns(ArrayList<String> stringArray, int deep) {
        if (deep > 0) {
            ArrayList<String> innerArray = new ArrayList<String>();
            for (String string : stringArray) {
                innerArray.add(string + "+");
                innerArray.add(string + "-");
            }
            signsCombinations.addAll(innerArray);
            createSigns(innerArray, deep - 1);
        }

    }

}
