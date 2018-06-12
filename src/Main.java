import combination.Combination;
import combination.Combination1;
import combination.Combination2;
import combination.Combination3;
import problem1.BestFitImpl;
import problem2.LuckyTicketImpl;
import problem3.SummandsImpl;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // PROBLEM 1-1
//        String digits = "999999999999";   // 12 digits - long
//        long expectedResult = (long) 1999998l;
//        BestFitImpl bestFit = new BestFitImpl();
//        ArrayList<String> resultExpressions = bestFit.fitPlusMinus(digits, expectedResult);
//        System.out.println("Expressions: " + resultExpressions);
//        System.out.println("number of combinations: " + resultExpressions.size());

        // PROBLEM 1-2
//        String digits = "9999999999";
//        long expectedResult = 3486784401l;  // more than 2147483647 (int)
//        BestFitImpl bestFit = new BestFitImpl();
//        ArrayList<String> resultExpressions = bestFit.fit(digits, expectedResult);
//        System.out.println("Expressions: " + resultExpressions);
//        System.out.println("number of combinations: " + resultExpressions.size());

        // PROBLEM 2-1
//        String ticketNumber = "123456789123456789123456789123456789"; // 36 digits - more than long
//        LuckyTicketImpl luckyTicket = new LuckyTicketImpl();
//        System.out.println(luckyTicket.isLucky(ticketNumber));

        // PROBLEM 2-2
//        Long min = 123456654321L;
//        Long max = 729496654321L;
//        LuckyTicketImpl luckyTicket = new LuckyTicketImpl();
//        System.out.println("Number of lucky tickets: " + luckyTicket.countLucky(min, max));

        // PROBLEM 3-1 and 3-2
        // I did not find a quick way to go over all the combinations of numbers that in the sum will give our number.
        // I used recursion and cycles.
        // 1) Recursion
        // i use recursion, so if number > 4374 than will be overflow of stack memory (for my JVM)
        // 145L - 13699698 combinations - 15.5 sec
        // 160L - 38328319 combinations - 46.7 sec
//        SummandsImpl summandsRecursion = new SummandsImpl();
//        summandsRecursion.allMaxProductRecursion(111L);
        // 2) Cycle
        // i use cycle
        // 145L - 13699698 combinations - 16.8 sec
        // 160L - 38328319 combinations - 46.8 sec
        // 160L - 29599642 combinations - 15.4 sec (optimization)
        // 170L - 54427664 combinations - 34.4 sec (optimization)
//        SummandsImpl summandsCycle = new SummandsImpl();
//        long before = System.nanoTime();
//        summandsCycle.allMaxProductCycle(111L);
//        long after = System.nanoTime();
//        long time = (long) ((long) after - (long) before) / 1000000l;
//        System.out.println("время: " + time);



        /* select of combination */
//        Combination1 combination1 = new Combination1(25);
//        countAndTime(combination1);
//
//        Combination2 combination2 = new Combination2(25);
//        countAndTime(combination2);
//
//        Combination3 combination3 = new Combination3(25);
//        countAndTime(combination3);

    }

    public static void countAndTime(Combination combination) {
        System.out.println(combination.getClass().getName());
        long before = System.nanoTime();
        combination.execute();
        System.out.println("количество комбинаций: " + combination.count);
        long after = System.nanoTime();
        long time = (long) ((long) after - (long) before) / 1000000l;
        System.out.println("время: " + time);
        System.out.println();


    }

}
