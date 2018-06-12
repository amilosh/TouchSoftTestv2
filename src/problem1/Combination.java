package problem1;

import java.util.ArrayList;

/**
 * This class create arithmetic  expression
 * from one numbers combination and one sign combination,
 * and return result of this combination
 */
public class Combination {

    /**
     * Why this method is too longer?
     * I encountered the following problems:
     * 1) We have division operation, and we can get double result.
     *    We must using double to result will be correct.
     *    Example:
     *        java: 1/3 + 1/3 + 1/3  // 0
     *        real: 1/3 + 1/3 + 1/3  // 1
     * 2) Operations of multiplication and division perform before plus-minus
     * 3) Result of current operation calculation depends on preview and next operations
     * 4) First sign have not preview operation; last sign have not next operation     *
     */
    public double calculate(ArrayList<Long> listLong, String signsCombination) {
        double result = 0;
        if ((listLong.size() - 1) == signsCombination.length()) {

            char[] signsArray = signsCombination.toCharArray();

            /* A. Only one arithmetic sign */
            if (signsArray.length == 1) {
                if (signsArray[0] == '+') {
                    result = (double) ((double) listLong.get(0) + (double) listLong.get(1));
                } else if (signsArray[0] == '-') {
                    result = (double) ((double) listLong.get(0) - (double) listLong.get(1));
                } else if (signsArray[0] == '*') {
                    result = (double) ((double) listLong.get(0) * (double) listLong.get(1));
                } else if (signsArray[0] == '/') {
                    result = (double) ((double) listLong.get(0) / (double) listLong.get(1));
                }
            }

            /* B. Two or more arithmetic signs */
            else if (signsArray.length > 1) {
                for (int i = 0; i < signsArray.length; i++) {

                    /* First sign */
                    if (i == 0) {
                        if ((signsArray[i] == '+') | (signsArray[i] == '-')) {
                            result = (double) (listLong.get(i));
                            // START  -  signs "*" или "/" go in a row, and then innerResult is added to result
                        } else if ((signsArray[i] == '*') | (signsArray[i] == '/')) {
                            double innerResult = (double) (listLong.get(i));
                            int j = i;
                            do {
                                if (signsArray[j] == '*') {
                                    innerResult = (double) ((double) innerResult * (double) listLong.get(j + 1));
                                } else if (signsArray[j] == '/') {
                                    innerResult = (double) ((double) innerResult / (double) listLong.get(j + 1));
                                }
                                j++;
                            }
                            while (!(j > (signsArray.length - 1)) && ((signsArray[j] == '*') | (signsArray[j] == '/')));
                            result += (double) (innerResult);
                        }
                        // END

                    /* Last sign */
                    } else if (i == (signsArray.length - 1)) {
                        if (signsArray[i] == '+') {
                            result += (double) (listLong.get(i + 1));
                            if (signsArray[i - 1] == '+') {
                                result += (double) (listLong.get(i));
                            } else if ((signsArray[i - 1] == '-')) {
                                result -= (double) (listLong.get(i));
                            }
                        } else if (signsArray[i] == '-') {
                            result -= (double) (listLong.get(i + 1));
                            if (signsArray[i - 1] == '+') {
                                result += (double) (listLong.get(i));
                            } else if ((signsArray[i - 1] == '-')) {
                                result -= (double) (listLong.get(i));
                            }
                        } else if (signsArray[i] == '*') {
                            if ((signsArray[i - 1] == '*') | (signsArray[i - 1] == '/')) {

                            } else if (signsArray[i - 1] == '+') {
                                result = (double) ((double) result + ((double) listLong.get(i) * (double) listLong.get(i + 1)));
                            } else if (signsArray[i - 1] == '-') {
                                result = (double) ((double) result - ((double) listLong.get(i) * (double) listLong.get(i + 1)));
                            }
                        } else if (signsArray[i] == '/') {
                            if ((signsArray[i - 1] == '*') | (signsArray[i - 1] == '/')) {

                            } else if (signsArray[i - 1] == '+') {
                                result = (double) ((double) result + ((double) listLong.get(i) / (double) listLong.get(i + 1)));
                            } else if (signsArray[i - 1] == '-') {
                                result = (double) ((double) result - ((double) listLong.get(i) / (double) listLong.get(i + 1)));
                            }
                        }


                    /* Inner sign */
                    } else if (i > 0) {
                        if ((signsArray[i] == '+') | (signsArray[i] == '-')) {      // если знак "+" или "-"
                            if (signsArray[i - 1] == '+') {
                                result += (double) (listLong.get(i));
                            } else if ((signsArray[i - 1] == '-')) {
                                result -= (double) (listLong.get(i));
                            }
                        } else if ((signsArray[i] == '*') | (signsArray[i] == '/')) {      // если знак "*" или "/"
                            // START  -  signs "*" или "/" go in a row, and then innerResult is added to result
                            if ((signsArray[i - 1] == '*') | (signsArray[i - 1] == '/')) {
                                continue;
                            } else {
                                double innerResult = (double) listLong.get(i);
                                int j = i;
                                do {
                                    if (signsArray[j] == '*') {
                                        innerResult = (double) ( (double)innerResult *  (double)listLong.get(j + 1));
                                    } else if (signsArray[j] == '/') {
                                        innerResult = (double) ((double) innerResult /  (double)listLong.get(j + 1));
                                    }
                                    j++;
                                }
                                while (!(j > (signsArray.length - 1)) && ((signsArray[j] == '*') | (signsArray[j] == '/')));
                                if (signsArray[i - 1] == '+') {
                                    result += (double) (innerResult);
                                } else if (signsArray[i - 1] == '-') {
                                    result -= (double) (innerResult);
                                }
                            }
                            // END
                        }
                    }
                }
            }
        }
        return result;
    }

}
