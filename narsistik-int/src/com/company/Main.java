package com.company;



public class Main {

    public static void main(String[] args) {
        int testInt =5;
        int[] digsdebug = new int[10];
        boolean isNarc;
        isNarc = checkNarc(testInt);


    }

    public static int getDigsinOrder(long locTestInt , int[] digitsinOrder){
        int lastDigitIndex = 0;
        int currentDigitIndex;
        double currentDigitVal;
        double locRemainder;


        for(int i = 0; i < 10; i++){ //to know number of digits test has
            if(Math.pow(10,i) >= locTestInt){
                lastDigitIndex = i;
                break;
            }
        }

        currentDigitIndex = lastDigitIndex;
        //if current digit index =0 , 1
        double locDivisor;
        locRemainder = locTestInt;
        while(currentDigitIndex > 0){

            locDivisor = Math.pow(10, currentDigitIndex -1);
            currentDigitVal = Math.floorDiv((long) locRemainder, (long) locDivisor);
            digitsinOrder[currentDigitIndex -1] = (int) currentDigitVal;
            locRemainder = locRemainder % locDivisor;
            currentDigitIndex--;
        }
        return lastDigitIndex;
    }

    public static boolean checkNarc(long locTestInt){
        long locSum=0;
        int[] locDigsinOrder = new int[10];
        int lastDigitIndex;
        lastDigitIndex = getDigsinOrder(locTestInt, locDigsinOrder);
        int currentDigitIndex=0;
        while(currentDigitIndex <= lastDigitIndex){

            locSum +=Math.pow(locDigsinOrder[currentDigitIndex],lastDigitIndex);
            currentDigitIndex++;
        }


        return (locSum == locTestInt);
    }
}
