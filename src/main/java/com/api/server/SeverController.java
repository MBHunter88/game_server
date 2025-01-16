package com.api.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/server")

public class SeverController {
    private ServerStatus serverStatus = new ServerStatus(true, 120, 0.5, 20);

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> getHealth() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", serverStatus.isOnline() ? "ok" : "down");
        health.put("uptime", Instant.now().toEpochMilli() - serverStatus.getLastChecked().toEpochMilli());
        return ResponseEntity.ok(health);
    }

    @GetMapping("/status")
    public ResponseEntity<ServerStatus> getStatus() {
        return ResponseEntity.ok(serverStatus);
    }

        // Get server status log history
        @GetMapping("/status/logs")
        public ResponseEntity<List<String>> getStatusLogs() {
            return ResponseEntity.ok(serverStatus.getStatusLog());
        }

        // Update server status and log changes
        @PostMapping("/update")
        public ResponseEntity<String> updateServerStatus(
        @RequestParam boolean isOnline,
        @RequestParam double responseTimeMs,
        @RequestParam double errorRate,
        @RequestParam int activePlayers) {

            serverStatus.updateStatus(isOnline, responseTimeMs, errorRate, activePlayers);
            return ResponseEntity.ok("Server status updated successfully.");

    }
}
