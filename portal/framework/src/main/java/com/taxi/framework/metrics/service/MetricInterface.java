package com.taxi.framework.metrics.service;

public interface MetricInterface {
    // RunHttpServer is responsilbe for starting HTTP server
    String RunHttpServer(int port);
    //RegisterMetrics is responsible for registering metrics to Prometheus
    Void RegisterMetrics();
    //Failure is responsible for submitting failures and add count and histogram metrics for a failed event
    Void Failure(String namespace, String service, String method, double duration, String errorString);
    // Success is responsible for submitting successful events and add count and histogram metrics for a successful event
    Void Success(String namespace, String service, String method, double duration);
    // Total is responsible for adding count metrics for a total event
    Void Total(String namespace, String service, String method);
}