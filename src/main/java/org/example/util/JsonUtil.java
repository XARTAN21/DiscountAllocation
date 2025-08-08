package org.example.util;

import com.google.gson.Gson;
import org.example.model.AllocationRequest;
import org.example.model.AllocationResult;
import org.example.model.Config;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new Gson();

    public static AllocationRequest readInput(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, AllocationRequest.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read input JSON", e);
        }
    }

    public static void writeOutput(List<AllocationResult> results) {
        try (FileWriter writer = new FileWriter("output.json")) {
            gson.toJson(results, writer);
            System.out.println("Results written to output.json");
        } catch (Exception e) {
            throw new RuntimeException("Failed to write output JSON", e);
        }
    }

    public static Config readConfig(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Config.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read config JSON", e);
        }
    }
}
