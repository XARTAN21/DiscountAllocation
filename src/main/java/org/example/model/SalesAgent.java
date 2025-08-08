package org.example.model;

public class SalesAgent {
    private String id;
    private int performanceScore;
    private int seniorityMonths;
    private int targetAchievedPercent;
    private int activeClients;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getPerformanceScore() { return performanceScore; }
    public void setPerformanceScore(int performanceScore) { this.performanceScore = performanceScore; }
    public int getSeniorityMonths() { return seniorityMonths; }
    public void setSeniorityMonths(int seniorityMonths) { this.seniorityMonths = seniorityMonths; }
    public int getTargetAchievedPercent() { return targetAchievedPercent; }
    public void setTargetAchievedPercent(int targetAchievedPercent) { this.targetAchievedPercent = targetAchievedPercent; }
    public int getActiveClients() { return activeClients; }
    public void setActiveClients(int activeClients) { this.activeClients = activeClients; }
}
