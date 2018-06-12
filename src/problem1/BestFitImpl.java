package problem1;

import java.util.ArrayList;

public class BestFitImpl implements BestFit {

    @Override
    public ArrayList<String> fitPlusMinus(String digits, long expectedResult) {
        // in this list we will record combinations
        ArrayList<String> resultExpressions = new ArrayList<String>();

        // get all combinations from digits
        Permute permute = new Permute();
        ArrayList<ArrayList<Long>> combinations = permute.execute(digits);

        // get all combinations from signs
        SignsPlusMinus signs = new SignsPlusMinus();
        ArrayList<String> signsCombinations = signs.execute(digits.length()-1);

        System.out.println("number of combination from digits and signs: " + combinations.size()*signsCombinations.size());

        Combination combination = new Combination();

        /*
        * We take all combinations from digits (like list of ArrayList<Integer>)
        * We take ll combinations from signs (like list of String)
        * and make Cartesian product
        * */
        for (ArrayList<Long> longList : combinations) {
            for (String signCombination : signsCombinations) {

                // number of signs will be equally number of numbers minus 1
                if ((longList.size() - 1) == signCombination.length()) {

                    // create expression from one numbers combination and one sign combination
                    // and return result of expression
                    double result = combination.calculate(longList, signCombination);

                    if (result == (double) expectedResult) {

                        // we will concatenate signs and numbers combinations to one String
                        String expression = Concat.execute(longList, signCombination);

                        resultExpressions.add(expression);
                    }
                }

            }
        }

        return resultExpressions;
    }

    @Override
    public ArrayList<String> fit(String digits, long expectedResult) {
        // in this list we will record combinations
        ArrayList<String> resultExpressions = new ArrayList<String>();

        // get all combinations from digits
        Permute permute = new Permute();
        ArrayList<ArrayList<Long>> combinations = permute.execute(digits);
        long numberOfDigitsCombinations = combinations.size();
        //System.out.println("количество комбинаций из цифр: " + numberOfDigitsCombinations);

        // get all combinations from signs
        Signs signs = new Signs();
        ArrayList<String> signsCombinations = signs.execute(digits.length()-1);
        long numberOfSignsCombinations = signsCombinations.size();
        //System.out.println("количество комбинаций из знаков: " + numberOfSignsCombinations);

        System.out.println("number of combination from digits and signs: " + combinations.size()*signsCombinations.size());

        Combination combination = new Combination();

        /*
        * We take all combinations from digits (like list of ArrayList<Integer>)
        * We take ll combinations from signs (like list of String)
        * and make Cartesian product
        * */
        for (ArrayList<Long> integerList : combinations) {
            for (String signCombination : signsCombinations) {

                // number of signs will be equally number of numbers minus 1
                if ((integerList.size() - 1) == signCombination.length()) {

                    // create expression from one numbers combination and one sign combination
                    // and return result of expression
                    double result = combination.calculate(integerList, signCombination);

                    if (result == (double) expectedResult) {

                        // we will concatenate signs and numbers combinations to one String
                        String expression = Concat.execute(integerList, signCombination);

                        resultExpressions.add(expression);
                    }
                }

            }
        }

        return resultExpressions;
    }
}
