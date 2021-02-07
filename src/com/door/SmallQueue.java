package com.door;

import java.util.LinkedList;
import java.util.Queue;

public class SmallQueue {
    private Queue<Duck> que = new LinkedList<>();

    /**Adds a duck to Queue
     *
     * @param duck
     * @param limitSize
     * @return
     */
    public boolean addDuck(Duck duck, int limitSize){
        if (que.size()<limitSize){
        que.add(duck); return true;}
        else {return false;}
    }

    /**Extract and removes duck from Queue
     *
     * @return
     */
    public Duck takeDuck(){
        Duck returnDuck;
        if(que.size()>0){
            returnDuck = que.peek();
            que.remove();
            return returnDuck;
        }
        else {
            return null;
        }
    }

    @Override
    public String toString() {
        return ""+que;
    }
}
