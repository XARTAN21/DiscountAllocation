package org.example.model;

public class Config {
    private WeightConfig weights;
    private double minPerAgent;
    private double maxPerAgent;

    public WeightConfig getWeights() {
        return weights;
    }

    public void setWeights(WeightConfig weights) {
        this.weights = weights;
    }

    public double getMinPerAgent() {
        return minPerAgent;
    }

    public void setMinPerAgent(double minPerAgent) {
        this.minPerAgent = minPerAgent;
    }

    public double getMaxPerAgent() {
        return maxPerAgent;
    }

    public void setMaxPerAgent(double maxPerAgent) {
        this.maxPerAgent = maxPerAgent;
    }
}
