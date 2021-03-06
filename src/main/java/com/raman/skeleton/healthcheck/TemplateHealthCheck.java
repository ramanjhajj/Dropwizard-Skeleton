package com.raman.skeleton.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Raman on 16/11/15.
 * This is the default health check of the application to check if the
 * template check the string TEST, in application, health check should
 * be more specific to the application not just this skeleton health check
 */
public class TemplateHealthCheck extends HealthCheck {

    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }

}
