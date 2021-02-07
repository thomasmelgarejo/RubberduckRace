package com.door;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RaceSimulator {
    MotherList motherObj = new MotherList();
    Random rand = new Random();
    public static final int numberOdDucksPerQueue=4;

    /**Controller of the RaceSimulator
     *
     */
    public void programNavigator(){

        //Creates a ArrayList with n*n dummy ducks in random order
        ArrayList<String> arr= createStartingArrayList(numberOdDucksPerQueue);

        //Create empty MotherList
        MotherList motherList = createEmptyMothersList(numberOdDucksPerQueue);

        //populate MotherList
        motherObj = populateMotherList(motherList, arr);

        //race
        race(motherObj);
        //System.out.println("VINNER" + race(motherObj));

    }

    /**Duck Race simulated
     * @param motherObj
     */
    private void race(MotherList motherObj) {
        int n = numberOdDucksPerQueue;
        Duck transferDuck=null;

        //print MotherList
        System.out.println(motherObj);

        //Runs correct number of steps, example 25ducks = 25-> 16-> 9-> 4-> 1 = 4 iterationer (elemination rounds)
        for (int i = 1; 1 <= (n-i)*(n-i) ; i++) {

            //Here are empty Queue's inserted into smallBigQ, (template made)
            MotherList emptyMotherList = createEmptyMothersList(n-i);

            //25 duck gives...16 iterations...9 iterations...4 iterations...1 iteration
            int iterationer = (n - i) * (n - i);
            for (int j = 0; j < iterationer; j++) {

                //Extract data from motherlist
                boolean isTransferred=false;

                while (!isTransferred){
                    int randomExtract = radNo(1+n-i);
                    transferDuck = motherObj.momList.get(randomExtract).takeDuck();

                    //System.out.println("transferDuck: "+transferDuck);
                    if(transferDuck != null){
                        isTransferred=true;
                    }
                    else {isTransferred=false;}
                }

                //Inserts Duck
                boolean isInserted=false;
                while (isTransferred){
                    int randomInsert = radNo(n-i);

                    //Inserts duck, if fail returns false
                    isInserted = emptyMotherList.momList.get(randomInsert).addDuck(transferDuck,n-i);

                    if (isInserted){isTransferred=false;}
                }

            }

            printStage(emptyMotherList);

            motherObj.momList.clear();
            motherObj.momList.addAll(emptyMotherList.momList);

        } //big for-loop

    }

    /**Prints the results of the raceSimulation step by step
     *
     * @param mo
     */
    private void printStage(MotherList mo) {
        System.out.println("*************************************************************");
        if (mo.momList.size()==1){
            System.out.print("          VINNER: ");
        }
        System.out.println(mo);
        if (mo.momList.size()==1){
            System.out.print("*************************************************************");
        }


    }

    /**MotherList is a ArrayList with Queue<Duck> as elements
     *
     * @param numberOfQueues
     * @return
     */
    private MotherList createEmptyMothersList(int numberOfQueues) {
        MotherList motherObj1 = new MotherList();
        for (int j = 0; j < numberOfQueues; j++) {
           SmallQueue smallQueue3 = new SmallQueue();
            motherObj1.addQue(smallQueue3);
        }
        return motherObj1;
    }

    /**Populates the MotherList with dummy data
     *
     * @param motherList
     * @param arrList
     * @return
     */
    private MotherList populateMotherList(MotherList motherList, ArrayList<String> arrList) {

        int counter=0;
        for (int i = 0; i < numberOdDucksPerQueue; i++) {

            for (int j = 0; j < numberOdDucksPerQueue; j++) {
                motherList.momList.get(i).addDuck(new Duck(arrList.get(counter)),numberOdDucksPerQueue);
                counter++;
            }
        }
        //System.out.println(motherList);
        return motherList;
    }

    /**Creating arrayList with dummy ducks
     *
     * @param duckPerQueue
     * @return
     */
    private ArrayList<String> createStartingArrayList(int duckPerQueue) {
        ArrayList<Integer> allDucksListNumbers = new ArrayList<>();
        ArrayList<String> allDucksListNames = new ArrayList<>();

        int noDucks = duckPerQueue*duckPerQueue;
        ThreadLocalRandom.current().ints(0, noDucks).distinct().limit(noDucks).forEach(allDucksListNumbers::add);

        for (int i = 0; i <noDucks ; i++) {
            allDucksListNames.add("Duck" + allDucksListNumbers.get(i));
        }

        return allDucksListNames;
    }

    /**Random number generator
     *
     * @param interval
     * @return
     */
    public int radNo(int interval){
        return rand.nextInt(interval);
    }

}
