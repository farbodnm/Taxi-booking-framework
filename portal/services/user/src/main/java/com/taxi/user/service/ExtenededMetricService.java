package com.taxi.user.service;

import com.taxi.framework.metrics.service.AbstractMetricImpl;

public class ExtenededMetricService extends AbstractMetricImpl {
    public ExtenededMetricService(int port) {
        //Initializing metrics only for our team purpose
        RunHttpServer(port);
        RegisterMetrics();
    }
}
