package com.api.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
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
}
