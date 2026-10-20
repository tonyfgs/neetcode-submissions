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
        if(upQueu.size() < downQueue.size()) {
           return downQueue.peek();
        }
        return ((double) downQueue.peek() + upQueu.peek()) / 2;

    }
}
