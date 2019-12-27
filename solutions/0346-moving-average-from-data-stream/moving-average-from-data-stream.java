// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
// Example:
//
//
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
//
//
//  
//


class MovingAverage {
    public int curr_size = 0;
    public int max_size;
    public int index = 0;
    private int[] dataArr;
    private int curr_sum = 0;
    

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.max_size = size;
        dataArr = new int[size];
    }
    
    public double next(int val) {
        curr_sum += val;
        index = (index+1)%max_size;
        if(curr_size == max_size){
            curr_sum -= dataArr[index];
        }
        else{
            curr_size++;
        }
        dataArr[index] = val;
        return (double)curr_sum / curr_size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
