package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DiscountAllocatorTest {
    private final Config defaultConfig = createDefaultConfig();
    private final DiscountAllocator allocator = new DiscountAllocator(defaultConfig);

    @Test
    public void testNormalAllocation() {
        AllocationRequest request = new AllocationRequest();
        request.setSiteKitty(10000);
        request.setSalesAgents(Arrays.asList(
                createAgent("A1", 90, 18, 85, 12),
                createAgent("A2", 70, 6, 60, 8)
        ));

        List<AllocationResult> results = allocator.allocateDiscounts(request);

        assertEquals(2, results.size());
        double total = results.stream().mapToDouble(AllocationResult::getAssignedDiscount).sum();
        assertEquals(10000, total, 0.01);
        assertTrue(results.get(0).getAssignedDiscount() > results.get(1).getAssignedDiscount());
    }

    @Test
    public void testAllSameData() {
        AllocationRequest request = new AllocationRequest();
        request.setSiteKitty(9000);
        request.setSalesAgents(Arrays.asList(
                createAgent("A1", 80, 12, 75, 10),
                createAgent("A2", 80, 12, 75, 10),
                createAgent("A3", 80, 12, 75, 10)
        ));

        List<AllocationResult> results = allocator.allocateDiscounts(request);

        double total = results.stream().mapToDouble(AllocationResult::getAssignedDiscount).sum();
        assertEquals(9000, total, 0.01);

        double base = results.get(0).getAssignedDiscount();
        results.forEach(r -> assertEquals(base, r.getAssignedDiscount(), 1.0));
    }

    @Test
    public void testRoundingPrecision() {
        AllocationRequest request = new AllocationRequest();
        request.setSiteKitty(100);
        request.setSalesAgents(Arrays.asList(
                createAgent("A1", 50, 5, 50, 5),
                createAgent("A2", 50, 5, 50, 5),
                createAgent("A3", 50, 5, 50, 5)
        ));

        List<AllocationResult> results = allocator.allocateDiscounts(request);

        double total = results.stream().mapToDouble(AllocationResult::getAssignedDiscount).sum();
        assertEquals(100, total, 0.01);
    }

    @Test
    public void testInvalidPerformanceThrowsError() {
        AllocationRequest request = new AllocationRequest();
        request.setSiteKitty(10000);
        request.setSalesAgents(Arrays.asList(
                createAgent("A1", 110, 12, 80, 10) // Invalid score
        ));

        assertThrows(IllegalArgumentException.class, () -> {
            allocator.allocateDiscounts(request);
        });
    }

    @Test
    public void testDuplicateIdFails() {
        AllocationRequest request = new AllocationRequest();
        request.setSiteKitty(10000);
        request.setSalesAgents(Arrays.asList(
                createAgent("A1", 90, 18, 85, 12),
                createAgent("A1", 70, 6, 60, 8) // Duplicate ID
        ));

        assertThrows(IllegalArgumentException.class, () -> {
            allocator.allocateDiscounts(request);
        });
    }

    private SalesAgent createAgent(String id, int perf, int seniority, int target, int clients) {
        SalesAgent a = new SalesAgent();
        a.setId(id);
        a.setPerformanceScore(perf);
        a.setSeniorityMonths(seniority);
        a.setTargetAchievedPercent(target);
        a.setActiveClients(clients);
        return a;
    }

    private Config createDefaultConfig() {
        Config c = new Config();
        WeightConfig w = new WeightConfig();
        w.setPerformanceScore(0.4);
        w.setSeniorityMonths(0.2);
        w.setTargetAchievedPercent(0.25);
        w.setActiveClients(0.15);
        c.setWeights(w);
        c.setMinPerAgent(0);
        c.setMaxPerAgent(10000);
        return c;
    }
  
}