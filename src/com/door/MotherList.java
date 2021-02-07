package com.door;

import java.util.ArrayList;
import java.util.List;

public class MotherList {
    List<SmallQueue> momList = new ArrayList<>();

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
