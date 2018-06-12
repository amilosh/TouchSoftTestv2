package combination;

import java.util.ArrayList;
import java.util.List;

/*
* http://qaru.site/questions/312439/algorithm-to-get-all-the-combinations-of-size-n-from-an-array-java
* 1-st answer
* */
public class Combination2 extends Combination {

    public Combination2(int number) {
        super(number);
    }

    @Override
    public void execute() {

        /* количество цифр */
        int n = this.number - 1;

        /* размер ящика */
        int m = n;

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }

        for (int k = 2; k <= m; k++) {

            //int[] input = {1, 2, 3, 4};    // input array
            //int k = 3;                             // sequence length

            List<int[]> subsets = new ArrayList<int[]>();

            int[] s = new int[k];                  // here we'll keep indices
            // pointing to elements in input array

            if (k <= input.length) {
                // first index sequence: 0, 1, 2, ...
                for (int i = 0; (s[i] = i) < k - 1; i++) ;
                subsets.add(getSubset(input, s));
                count++;
                for (; ; ) {
                    int i;
                    // find position of item that can be incremented
                    for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--) ;
                    if (i < 0) {
                        break;
                    }
                    s[i]++;                    // increment this item
                    for (++i; i < k; i++) {    // fill up remaining items
                        s[i] = s[i - 1] + 1;
                    }
                    subsets.add(getSubset(input, s));
                    count++;
                }
            }


        }

        }

        // generate actual subset by index sequence
        static int[] getSubset(int[] input, int[] subset) {
            int[] result = new int[subset.length];
            for (int i = 0; i < subset.length; i++)
                result[i] = input[subset[i]];
            return result;
        }

}
