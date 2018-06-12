package combination;

/*
* http://study-and-dev.com/blog/sda_theory_combinatoric/
* сочетания
*/
public class Combination1 extends Combination {

    public Combination1(int number) {
        super(number);
    }

    @Override
    public void execute() {


        /* количество цифр */
        int n = this.number - 1;

        /* размер ящика */
        int m = n;

        /* перебор по всем размерам ящиков */
        for (int k = 2; k <= m; k++) {


            /* ящик будет в виде массива размера m */
            Integer[] arr = new Integer[k];

            int i, j;

        /* заполняю ящик цифрами, начиная с 0 */
            for (i = 0; i < k; i++) {
                arr[i] = i + 1;
            }



            do {
            /* распечатываю комбинацию */
//                for (i = 0; i < k; i++) {
//                    System.out.print(arr[i]);
//                }
//                System.out.println();
                count++;

                for ( j = k - 1 ; j >= 0 && arr [j] >= n + 1 - k + j; j--) ;
                if ( j >= 0){
                    arr [j] ++;
                    for (i = j + 1; i < k; i++)
                        arr [i] = arr [i-1]  + 1;
                }
                else break;


            } while (true);
        }
    }

}
