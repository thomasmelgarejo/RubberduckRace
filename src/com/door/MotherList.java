package com.door;

import java.util.ArrayList;
import java.util.List;

public class MotherList {
    private List<SmallQueue> momList = new ArrayList<>();

    /**Makes momlist accesible from other classes
     *
     * @return
     */
    public List<SmallQueue> getMomList(){
        return this.momList;
    }

    /**Adds a Queue to a arraylist
     *
     * @param queList
     */
    public void addQue(SmallQueue queList){
        momList.add(queList);
    }

    @Override
    public String toString() {
        return  "" + momList;
    }
}
