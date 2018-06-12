package problem3;


import java.util.ArrayList;

public class SummandsImpl implements Summands {

    @Override
    public ArrayList<ArrayList<Integer>> allMaxProductRecursion(long n) {
        SummaRecursion summaRecursion = new SummaRecursion();
        summaRecursion.execute((int) n);

        //System.out.print("all combimations: " + summaRecursion.allCombinations);
        System.out.print("number of combinations: " + summaRecursion.numberOfCombinations);
        ArrayList<ArrayList<Integer>> allMaxProduct = summaRecursion.getAllMaxProduct();
        int maxProduct = summaRecursion.getMaxProduct();
        System.out.println();
        System.out.println(allMaxProduct);
        System.out.println("max * = " + maxProduct);
        System.out.println();

        return allMaxProduct;

    }

    @Override
    public ArrayList<Integer[]> allMaxProductCycle(long n) {
        SummaCycle summaCycle = new SummaCycle();
        summaCycle.execute((int) n);
        System.out.print("number of combinations: " + summaCycle.numberOfCombinations);
        System.out.println();
        ArrayList<Integer[]> allMaxProduct = summaCycle.getAllMaxProduct();
        for (Integer[] integers : allMaxProduct) {
            for (Integer number : integers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        long maxProduct = summaCycle.getMaxProduct();
        System.out.println("max * = " + maxProduct);
        System.out.println();

        return allMaxProduct;



    }
}
