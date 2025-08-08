package org.example.model;

import java.util.List;

public class AllocationRequest {
    private double siteKitty;
    private List<SalesAgent> salesAgents;

    public double getSiteKitty() { return siteKitty; }
    public void setSiteKitty(double siteKitty) { this.siteKitty = siteKitty; }
    public List<SalesAgent> getSalesAgents() { return salesAgents; }
    public void setSalesAgents(List<SalesAgent> salesAgents) { this.salesAgents = salesAgents; }
}
