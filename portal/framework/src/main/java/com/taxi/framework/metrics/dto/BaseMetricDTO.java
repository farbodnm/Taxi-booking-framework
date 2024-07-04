package com.taxi.framework.metrics.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.prometheus.client.exporter.HTTPServer;

@Getter
@Setter
@NoArgsConstructor
public class BaseMetricDTO {

    private HTTPServer server;

}
