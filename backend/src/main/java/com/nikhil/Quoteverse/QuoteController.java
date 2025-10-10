package com.nikhil.Quoteverse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class QuoteController {

    @GetMapping("/quotes")
    public ResponseEntity<?> getAllQuotes() {
        try {

            File file = new ClassPathResource("data/quotes.json").getFile();

            if (!file.exists()) {
                return ResponseEntity.status(404)
                        .body(Map.of("error", "quotes.json not found at " + file.getAbsolutePath()));
            }

            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> quotes = mapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});


            if (quotes.isEmpty()) {
                return ResponseEntity.status(404).body(Map.of("error", "no quotes found"));
            }

            return ResponseEntity.ok(quotes);

        } 
        catch (IOException e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }


    @GetMapping("/quotes/{id}")
    public ResponseEntity<?> getQuoteById(@PathVariable int id) {
        try {
            String basePath = System.getProperty("user.dir");
            Path filePath = Path.of(basePath)
                .resolve("QuoteVerse")
                .resolve("data")
                .resolve("quotes.json")
                .normalize();

            File file = filePath.toFile();

            if (!file.exists()) {
                return ResponseEntity.status(404)
                        .body(Map.of("error", "quotes.json not found at " + file.getAbsolutePath()));
            }

            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> quotes = mapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});

            for (Map<String, Object> quote : quotes) {
                if (quote.get("id") instanceof Number && ((Number) quote.get("id")).intValue() == id) {
                    return ResponseEntity.ok(quote);
                }
            }

            return ResponseEntity.status(404).body(Map.of("message", "Quote not found"));

        } 
        catch (IOException e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }


    @PostMapping("/quotes")
    public ResponseEntity<?> addQuote(@RequestBody Map<String, Object> newQuoteData) {
        try {
            String basePath = System.getProperty("user.dir");
            Path filePath = Path.of(basePath)
                .resolve("QuoteVerse")
                .resolve("data")
                .resolve("quotes.json")
                .normalize();

            File file = filePath.toFile();

            if (!file.exists()) {
                return ResponseEntity.status(404)
                        .body(Map.of("error", "quotes.json not found at " + file.getAbsolutePath()));
            }

            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> quotes = mapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});
            int newId = quotes.stream()
                    .mapToInt(q -> ((Number) q.get("id")).intValue())
                    .max()
                    .orElse(0) + 1;
            Map<String, Object> newQuote = new LinkedHashMap<>();
            newQuote.put("id", newId);
            newQuote.put("text", newQuoteData.get("text"));
            newQuote.put("author", newQuoteData.get("author"));
            newQuote.put("tags", newQuoteData.getOrDefault("tags", List.of()));
            quotes.add(newQuote);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, quotes);
            return ResponseEntity.ok(newQuote);
        } 
        catch (IOException e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}
