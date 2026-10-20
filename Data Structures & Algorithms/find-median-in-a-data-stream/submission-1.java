class MedianFinder {
    PriorityQueue<Integer> upQueu;
    PriorityQueue<Integer> downQueue;
    public MedianFinder() {
        upQueu = new PriorityQueue<>();
        downQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        downQueue.add(num);
        upQueu.add(downQueue.poll());
        if(upQueu.size()> downQueue.size()) {
            downQueue.add(upQueu.poll());
        }
    }
    
    public double findMedian() {
        double result ;

        if(upQueu.isEmpty()) {
            return downQueue.peek();
        }

        int topDown = downQueue.peek();
        int topUp = upQueu.peek();

        if(upQueu.size() == downQueue.size()) {
           result = (double) (topDown+topUp)/2;
        }
        else {
            if (upQueu.size() < downQueue.size()) {
                result = (double) topDown;
            }
            else {
                result = (double) topDown;
            }
        }
        return result;
    
    }
}
