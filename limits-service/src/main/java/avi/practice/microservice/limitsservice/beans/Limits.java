package avi.practice.microservice.limitsservice.beans;

public class Limits {
    private int minLimit;
    private int maxLimit;

    public Limits(int minLimit, int maxLimit) {
        super();
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }
}
