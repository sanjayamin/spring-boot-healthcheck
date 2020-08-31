package com.walmart.labs.examples.hello.health;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.ListNamesResponse;

public class AppHealthIndicator extends AbstractHealthIndicator {

	private static Logger logger = LoggerFactory.getLogger(AppHealthIndicator.class);

	@Value("${info.app.version}")
	String version;

	private MetricsEndpoint metricsEndpoint;

	private static final String METRIC_NAME_UPTIME = "uptime";
	private static final String METRIC_NAME_VERSION = "version";

	@Autowired
	private void setMetricsEndpoint(MetricsEndpoint metricsEndpoint) {
		this.metricsEndpoint = metricsEndpoint;
	}

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		try {
			logger.info("health check [start]");
			// TODD: Need to validate following for uptime
			Double upSince = metricsEndpoint.metric("process.uptime", null).getMeasurements().stream()
					.filter(Objects::nonNull).findFirst().map(MetricsEndpoint.Sample::getValue).orElse(null);
			ListNamesResponse metricsResponse = metricsEndpoint.listNames();
			Set<String> metrics = metricsResponse.getNames();
			for (String metric : metrics) {
				System.out.println(metric);
			}
			// build map with health info
			Map<String, String> healthInfo = new HashMap<String, String>();
			healthInfo.put(METRIC_NAME_VERSION, version);
			long upSinceLong = Math.round(upSince);
			healthInfo.put(METRIC_NAME_UPTIME, "up since:" + new Date(upSinceLong));
			builder.up().withDetails(healthInfo);
			logger.info("health check [end]");
		} catch (Exception e) {
			logger.error("Error retrieving health info:{}", e);
			builder.down(e);
		}
	}

}
