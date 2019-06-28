/*
  question link : https://leetcode.com/problems/find-median-from-data-stream/description/
*/

import java.util.ArrayList;

class RunningMedian {

    /** initialize your data structure here. */
    private ArrayList<Integer> dataPoints;
    private int size;
    public RunningMedian() {
        dataPoints = new ArrayList<>();
        size = 0;
    }
    
    /*
      the number is added (placed) in ascending order thereby reducing the time
      required to sort every time to find the median.
    */
    public void addNum(int num) {
        if(dataPoints.size() == 0) {
            dataPoints.add(num);
        }
        else if(dataPoints.size() == 1) {
            if(dataPoints.get(0) < num) {
                dataPoints.add(num);
            }
            else {
                dataPoints.add(0,num);
            }
        }
        else {
            int i = -1;
            for(i=0;i<dataPoints.size();i++) {
               if(num < dataPoints.get(i)) {
                   break;
               } 
            }
            dataPoints.add(i,num);
        }
        size++;
    }
    
    public double findMedian() {
        double median = 0;
        if(size % 2 != 0) {
            median = (double)dataPoints.get(this.size/2);
        }
        else {
            int num1 = dataPoints.get(this.size/2);
            int num2 = dataPoints.get((this.size/2)-1);
            median = (double)(num1+num2)/2;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
