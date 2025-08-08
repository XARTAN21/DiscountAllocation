package org.example.model;

public class AllocationResult {
    private String id;
    private double assignedDiscount;
    private String justification;

    public AllocationResult(String id, double assignedDiscount, String justification) {
        this.id = id;
        this.assignedDiscount = assignedDiscount;
        this.justification = justification;
    }

    public String getId() { return id; }
    public double getAssignedDiscount() { return assignedDiscount; }
    public String getJustification() { return justification; }
}
