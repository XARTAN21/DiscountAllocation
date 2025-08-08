package org.example.model;

public class WeightConfig {
    private double performanceScore;
    private double seniorityMonths;
    private double targetAchievedPercent;
    private double activeClients;

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public double getSeniorityMonths() {
        return seniorityMonths;
    }

    public void setSeniorityMonths(double seniorityMonths) {
        this.seniorityMonths = seniorityMonths;
    }

    public double getTargetAchievedPercent() {
        return targetAchievedPercent;
    }

    public void setTargetAchievedPercent(double targetAchievedPercent) {
        this.targetAchievedPercent = targetAchievedPercent;
    }

    public double getActiveClients() {
        return activeClients;
    }

    public void setActiveClients(double activeClients) {
        this.activeClients = activeClients;
    }
}
