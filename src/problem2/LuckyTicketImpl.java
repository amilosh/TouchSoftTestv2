package problem2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LuckyTicketImpl implements LuckyTicket {

    @Override
    public boolean isLucky(String number) {
        if (number.length() %2 != 0) {
            return false;
        } else {
            int rank = 17;
            long ticketSize = number.length();

            // на сколько частей надо делить строку
            long part =  (long) ticketSize/ (long) rank;

            if (part == 0) {
                if (number.length() %2 != 0) {
                    return false;
                } else {
                    int size = number.length()/2;

                    String first = number.substring(0, size);
                    String second = number.substring(size);

                    long firstInt = Long.parseLong(first);
                    long secondInt = Long.parseLong(second);

                    int firstSum = sumNumeralsInNumber(firstInt);
                    int secondSum = sumNumeralsInNumber(secondInt);


                    if (firstSum == secondSum) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                String first = number.substring(0, (int) ticketSize/2);
                String second = number.substring((int) ticketSize/2);

                long firstSize = first.length();
                long secondSize = second.length();


                long sumFirst = sumPart(first);
                long sumSecond = sumPart(second);

                if (sumFirst == sumSecond) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public long countLucky(long min, long max) {
        /* считаю сумму шести цифр и заполняю двумерный HashMap по количеству упоминаний суммы  */
        Map<Integer, AtomicInteger> countSums = getNumbersOfSumsMention();

        long allLuckyTicket = 0;

        long smallNumber = (long) min / 1000000l;
        long bigNumber = (long) max / 1000000l;

        if ((smallNumber == bigNumber) | ((bigNumber - smallNumber) == 1l)) {
            for (long i = min; i <= max; i++) {
                if (new LuckyTicketImpl().isLucky(Long.toString(i))) {
                    allLuckyTicket++;
                }
            }
        } else {
            long topSmallNumber = smallNumber*1000000 + 999999;
            long bottomBigNumber = bigNumber*1000000;

            for (long i = min; i <= topSmallNumber; i++) {
                if (new LuckyTicketImpl().isLucky(Long.toString(i))) {
                    allLuckyTicket++;
                }
            }

            for (long i = (smallNumber + 1); i < bigNumber; i++) {
                int sumLeft = sumNumeralsInNumber(i);
                int countRight = countSums.get(sumLeft).get();
                allLuckyTicket += countRight;
            }

            for (long i = bottomBigNumber; i <= max; i++) {
                if (new LuckyTicketImpl().isLucky(Long.toString(i))) {
                    allLuckyTicket++;
                }
            }

        }


        return allLuckyTicket;
    }

    private Map<Integer, AtomicInteger> getNumbersOfSumsMention() {
        Map<Integer, AtomicInteger> countSums = new HashMap<Integer, AtomicInteger>();
        for (int i = 1; i <= 999999; i++) {
            int sumNumeralsInNumber = sumNumeralsInNumber(i);
            boolean b = countSums.containsKey(sumNumeralsInNumber);
            if (!b) {
                countSums.put(sumNumeralsInNumber, new AtomicInteger(1));
            } else {
                countSums.get(sumNumeralsInNumber).incrementAndGet();
            }
        }
        //System.out.println(countSums);
        return countSums;
    }

    /*
        * метод, который считает сумму цифр в каждой половинке
        * */
    public long sumPart(String part) {
        if (part.length() < 17) {
            return sumNumeralsInNumber(Long.parseLong(part));
        } else {
            long resultSum = 0;
            long piece = part.length()/17;
            for (int i = 0; i <= piece; i++) {
                if (i == piece) {
                    String stringPiece = part.substring(i*17);
                    resultSum += sumNumeralsInNumber(Long.parseLong(stringPiece));
                } else {
                    String stringPiece = part.substring(i*17, (i+1)*17);
                    resultSum += sumNumeralsInNumber(Long.parseLong(stringPiece));
                }

            }
            return resultSum;

        }
    }

    /* сумма цифр в числе */
    public int sumNumeralsInNumber(long number) {
        int sum = 0;
        while (number != 0 ){
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
}
