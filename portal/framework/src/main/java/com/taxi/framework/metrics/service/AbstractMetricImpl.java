package com.taxi.framework.metrics.service;

import com.taxi.framework.metrics.dto.BaseMetricDTO;
import io.prometheus.client.exporter.HTTPServer;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;

public abstract class AbstractMetricImpl extends BaseMetricDTO implements MetricInterface {

    private Counter sourceCount;
    private Gauge sourceGauge;
    private Histogram sourceHistogram;
    private Summary sourceSummary;
    
    @Override
        public String RunHttpServer(int port) {
            // Implementation for starting HTTP server
            try {
                HTTPServer server = new HTTPServer(port);
                this.setServer(server);
            } catch (Exception e) {
                return "Error starting HTTP server: " + e.getMessage();
            }
            return null;
        }

    @Override
        public Void RegisterMetrics() {
            // Implementation for registering metrics to Prometheus
            this.sourceCount = Counter.build()
                   .name("source_count")
                   .help("Count of source events")
                   .labelNames("namespace", "service", "method")
                   .register();

            this.sourceGauge = Gauge.build()
                   .name("source_gauge")
                   .help("Gauge of source events")
                   .labelNames("namespace", "service", "method")
                   .register();

            this.sourceHistogram = Histogram.build()
                   .name("source_histogram")
                   .help("Histogram of source events")
                   .buckets(0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0)
                   .labelNames("namespace", "service", "method", "status", "text")
                   .register();

            this.sourceSummary = Summary.build()
                    .name("source_summary")
                    .help("Summary of source events")
                    .quantile(0.5, 0.05) // 50th percentile with 5% tolerated error
                    .quantile(0.9, 0.01) // 90th percentile with 1% tolerated error
                    .quantile(0.99, 0.001) // 99th percentile with 0.1% tolerated error
                    .labelNames("namespace", "service", "method", "status", "text")
                    .register();
            return null;       
        }

        @Override
        public Void Failure(String namespace, String service, String method, double duration, String errorString) {
            //adding failure metrics
            this.sourceGauge.labels(namespace, service, method).dec();
            this.sourceHistogram.labels(namespace, service, method, "Error", errorString).observe(duration);
            this.sourceSummary.labels(namespace, service, method, "Error", errorString).observe(duration);
            return null;
        }
        
        @Override
        public Void Success(String namespace, String service, String method, double duration) {
            //adding success metrics
            this.sourceGauge.labels(namespace, service, method).inc();
            this.sourceHistogram.labels(namespace, service, method, "Success").observe(duration);
            this.sourceSummary.labels(namespace, service, method, "success").observe(duration);
            return null;
        }
        
        @Override
        public Void Total(String namespace, String service, String method) {
            //adding some general and basic metrics
            this.sourceCount.labels(namespace, service, method).inc();
            return null;
        }
}
