package problem3;

import java.util.ArrayList;
import java.util.Arrays;

public class SummaCycle {

    public ArrayList<Integer[]> allMaxProduct;
    public long maxProduct;
    public long numberOfCombinations;
    private long allNumberOfCombinations;

    public SummaCycle() {
        this.allMaxProduct = new ArrayList<Integer[]>();
        this.maxProduct = 0;
        this.numberOfCombinations = 0;
    }

    public ArrayList<Integer[]> getAllMaxProduct() {
        return allMaxProduct;
    }

    public long getMaxProduct() {
        return maxProduct;
    }

    public void execute(int number) {
        /* количество цифр */
        int n = (int) number - 1;

        /* размер ящика */
        int m = n;

        int firstMin = 0;
        int firstMax = 0;

        int minBox = 0;
        int maxBox = 0;

        if (number < 100) {
            firstMin = 1;
            firstMax = n;
            minBox = 2;
            maxBox = m;
        } else {
            firstMin = (int) (number * 0.2);
            firstMax = (int) (number * 0.5);
            minBox = 7;
            maxBox = 12;
        }



        /* перебор по всем размерам ящиков */
//        for (int k = 2; k <= m; k++) {
        for (int k = minBox; k <= maxBox; k++) {

            /* ящик будет в виде массива размера m */
            Integer[] arr = new Integer[k];

            int i, j;



        /* заполняю ящик цифрами, начиная с number */
//            было
//            for (i = 0; i < k; i++) {
//                arr[i] = n - i;
//            }

            for (i = 0; i < k; i++) {
                arr[i] = firstMax - i;
            }

            do {
                //allNumberOfCombinations++;

                if (number >= 100) {
                    if (arr[0] < firstMin) {
                        break;
                    }
                }


                if (sumOfArray(arr) == number) {
//                    for (i = 0; i < k; i++) {
//                        System.out.print(arr[i] + " ");
//                    }
                    //System.out.println();
                    int multiplicationOfNumbers = multiplicationOfNumbers(arr);
                    if (multiplicationOfNumbers == this.maxProduct) {
                        Integer[] arrInsert = new Integer[k];
                        arrInsert = Arrays.copyOf(arr, k);
                        this.allMaxProduct.add(arrInsert);
                    } else if (multiplicationOfNumbers > this.maxProduct) {
                        this.allMaxProduct.clear();
                        Integer[] arrInsert = new Integer[k];
                        arrInsert = Arrays.copyOf(arr, k);
                        this.allMaxProduct.add(arrInsert);
                        this.maxProduct = multiplicationOfNumbers;
                    }
                    numberOfCombinations++;
                }

                int zSum = 0;
                for (int z = 0; z < k; z++) {
                    zSum += arr[z];
                    if ((zSum > number) && (arr[z] != 1)) {
                        int x = number - zSum + arr[z];
                        int x1 = x;
                        if (x1 < (k - z)) {
                            int x2 = arr[z - 1] - 1;
                            for (int q = z - 1; q < k; q++) {
                                arr[q] = x2--;
                            }
                        } else {
                            for (int q = z; q < k; q++) {
                                arr[q] = x1--;
                            }
                        }

                        if (sumOfArray(arr) > number && (arr[arr.length - 1] == 1)) {
                            int x2 = arr[z - 1] - 1;
                            for (int q = z - 1; q < k; q++) {
                                arr[q] = x2--;
                            }

                        }

                        if (sumOfArray(arr) == number && (arr[k - 1] != 0)) {
//                            for (i = 0; i < k; i++) {
//                                System.out.print(arr[i] + " ");
//                            }
                            //System.out.println();
                            int multiplicationOfNumbers = multiplicationOfNumbers(arr);
                            if (multiplicationOfNumbers == this.maxProduct) {
                                Integer[] arrInsert = new Integer[k];
                                arrInsert = Arrays.copyOf(arr, k);
                                this.allMaxProduct.add(arrInsert);
                            } else if (multiplicationOfNumbers > this.maxProduct) {
                                this.allMaxProduct.clear();
                                Integer[] arrInsert = new Integer[k];
                                arrInsert = Arrays.copyOf(arr, k);
                                this.allMaxProduct.add(arrInsert);
                                this.maxProduct = multiplicationOfNumbers;
                            }
                            numberOfCombinations++;
                        }
                        break;
                    }
                }

                for (j = k - 1; j >= 0 && arr[j] <= k - j; j--) ;
                if (j >= 0) {
                    arr[j] = arr[j] - 1;
                    for (i = j + 1; i < k; i++)
                        arr[i] = arr[i - 1] - 1;
                } else break;

            } while (true);
        }

    }

    /* возвращает сумму чисел массива */
    private int sumOfArray(Integer[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    /* возвращает произведение чисел массива */
    public int multiplicationOfNumbers(Integer[] array) {
        int multiplication = 1;
        for (int number : array) {
            multiplication *= number;
        }
        return multiplication;
    }

}
