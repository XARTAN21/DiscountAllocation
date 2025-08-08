package org.example.service;

import org.example.model.AllocationRequest;
import org.example.model.AllocationResult;
import org.example.model.Config;
import org.example.model.SalesAgent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiscountAllocator {

    private final Config config;

    public DiscountAllocator(Config config) {
        this.config = config;
    }

    public List<AllocationResult> allocateDiscounts(AllocationRequest request) {
        List<SalesAgent> agents = request.getSalesAgents();
        double siteKitty = request.getSiteKitty();
        try {
            validateAgents(agents);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            File output = new File("output.json");
            if(output.exists()){
                output.delete();
            }
            System.exit(0);
        }
        double maxPerf = agents.stream().mapToDouble(SalesAgent::getPerformanceScore).max().orElse(1);
        double maxSeniority = agents.stream().mapToDouble(SalesAgent::getSeniorityMonths).max().orElse(1);
        double maxTarget = agents.stream().mapToDouble(SalesAgent::getTargetAchievedPercent).max().orElse(1);
        double maxClients = agents.stream().mapToDouble(SalesAgent::getActiveClients).max().orElse(1);

        List<Double> scores = new ArrayList<>();
        double totalScore = 0;
        for (SalesAgent a : agents) {
            double perfNorm = a.getPerformanceScore() / maxPerf;
            double seniorityNorm = a.getSeniorityMonths() / maxSeniority;
            double targetNorm = a.getTargetAchievedPercent() / maxTarget;
            double clientsNorm = a.getActiveClients() / maxClients;

            double weightedScore = (perfNorm * config.getWeights().getPerformanceScore()) +
                    (seniorityNorm * config.getWeights().getSeniorityMonths()) +
                    (targetNorm * config.getWeights().getTargetAchievedPercent()) +
                    (clientsNorm * config.getWeights().getActiveClients());

            scores.add(weightedScore);
            totalScore += weightedScore;
        }

        List<AllocationResult> results = new ArrayList<>();
        double allocatedSum = 0;
        for (int i = 0; i < agents.size(); i++) {
            double share = (scores.get(i) / totalScore) * siteKitty;
            share = Math.round(share);
            allocatedSum += share;

            String justification = generateJustification(agents.get(i));

            results.add(new AllocationResult(
                    agents.get(i).getId(),
                    share,
                    justification
            ));
        }

        double diff = siteKitty - allocatedSum;
        if (!results.isEmpty() && diff != 0) {
            AllocationResult last = results.get(results.size() - 1);
            double corrected = last.getAssignedDiscount() + diff;
            results.set(results.size() - 1,
                    new AllocationResult(last.getId(), corrected, last.getJustification()));
        }

        return results;
    }

    private void validateAgents(List<SalesAgent> agents) {
        Set<String> ids = new HashSet<>();

        for (SalesAgent agent : agents) {

            if (agent.getId() == null || agent.getId().trim().isEmpty()) {
                throw new IllegalArgumentException("Agent ID cannot be null or empty.");
            }
            if (!ids.add(agent.getId())) {
                throw new IllegalArgumentException("Duplicate ID found: " + agent.getId());
            }

            int perf = agent.getPerformanceScore();
            if (perf < 0 || perf > 100) {
                throw new IllegalArgumentException("Invalid performanceScore for agent " + agent.getId() + ": " + perf);
            }

            int seniority = agent.getSeniorityMonths();
            if (seniority < 0) {
                throw new IllegalArgumentException("Invalid seniorityMonths for agent " + agent.getId() + ": " + seniority);
            }

            int target = agent.getTargetAchievedPercent();
            if (target < 0 || target > 100) {
                throw new IllegalArgumentException("Invalid targetAchievedPercent for agent " + agent.getId() + ": " + target);
            }

            int clients = agent.getActiveClients();
            if (clients < 0) {
                throw new IllegalArgumentException("Invalid activeClients for agent " + agent.getId() + ": " + clients);
            }
        }
    }

    private String generateJustification(SalesAgent agent) {
        List<String> reasons = new ArrayList<>();

        if (agent.getPerformanceScore() >= 80)
            reasons.add("High performance");
        else if (agent.getPerformanceScore() >= 60)
            reasons.add("Moderate performance");

        if (agent.getSeniorityMonths() >= 12)
            reasons.add("Long-term contribution");

        if (agent.getTargetAchievedPercent() >= 80)
            reasons.add("High target achievement");

        if (agent.getActiveClients() >= 10)
            reasons.add("Manages large client base");

        if (reasons.isEmpty())
            reasons.add("Consistent effort");

        return String.join(" and ", reasons);
    }
}
