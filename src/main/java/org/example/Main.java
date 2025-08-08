package org.example;

import org.example.model.AllocationRequest;
import org.example.model.AllocationResult;
import org.example.model.Config;
import org.example.service.DiscountAllocator;
import org.example.util.JsonUtil;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            AllocationRequest request = JsonUtil.readInput("src/main/resources/input.json");
            Config config = JsonUtil.readConfig("src/main/resources/config.json");

            DiscountAllocator allocator = new DiscountAllocator(config);
            List<AllocationResult> results = allocator.allocateDiscounts(request);

            JsonUtil.writeOutput(results);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}