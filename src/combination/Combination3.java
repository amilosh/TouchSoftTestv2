package combination;

public class Combination3 extends Combination {

    public Combination3(int number) {
        super(number);
    }

    @Override
    public void execute() {
        /* количество цифр */
        int n = this.number - 1;

        /* размер ящика */
        //int m = n;

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }

        int k = input.length;
        int N = (int) Math.pow(2d, Double.valueOf(k));
        for (int i = 1; i < N; i++) {
            String code = Long.toBinaryString(N | i).substring(1);
            for (int j = 0; j < k; j++) {
                if (code.charAt(j) == '1') {
                    //System.out.print(intArr[j]);
                }
            }
            count++;
            //System.out.println();
        }
        count -= k;
    }

}
