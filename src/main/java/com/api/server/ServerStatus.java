package com.api.server;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ServerStatus {
    private boolean isOnline;
    private double responseTimeMs;
    private double errorRate;
    private int activePlayers;
    private Instant lastChecked;

    // List to store logs
    private final List<String> statusLog = new ArrayList<>();

    public ServerStatus(boolean isOnline, double responseTimeMs, double errorRate, int activePlayers) {
        this.isOnline = isOnline;
        this.responseTimeMs = responseTimeMs;
        this.errorRate = errorRate;
        this.activePlayers = activePlayers;
        this.lastChecked = Instant.now();
    }

    // Getters
    public boolean isOnline() { return isOnline; }
    public double getResponseTimeMs() { return responseTimeMs; }
    public double getErrorRate() { return errorRate; }
    public int getActivePlayers() { return activePlayers; }
    public Instant getLastChecked() { return lastChecked; }
    public List<String> getStatusLog() { return statusLog; }

    // Update status method
    public void updateStatus(boolean isOnline, double responseTime, double errorRate, int activePlayers) {
        this.isOnline = isOnline;
        this.responseTimeMs = responseTime;
        this.errorRate = errorRate;
        this.activePlayers = activePlayers;
        this.lastChecked = Instant.now();

        // Add entry to log
        String logEntry = String.format("[%s] Status: %s | Response Time: %.2fms | Error Rate: %.2f%% | Players: %d",
                lastChecked, isOnline ? "Online" : "Offline", responseTime, errorRate, activePlayers);
        statusLog.add(logEntry);

    }
}

