package com.api.server;

import java.time.Instant;

public class ServerStatus {
    private boolean isOnline;
    private double responseTimeMs;
    private double errorRate;
    private int activePlayers;
    private Instant lastChecked;

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

    // Update status method
    public void updateStatus(boolean isOnline, double responseTime, double errorRate, int activePlayers) {
        this.isOnline = isOnline;
        this.responseTimeMs = responseTime;
        this.errorRate = errorRate;
        this.activePlayers = activePlayers;
        this.lastChecked = Instant.now();
    }
}

