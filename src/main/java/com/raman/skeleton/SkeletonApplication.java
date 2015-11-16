package com.raman.skeleton;

import com.raman.skeleton.api.Resource;
import com.raman.skeleton.healthcheck.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Raman on 15/11/15.
 * This is the main entry point of the Dropqizard Application
 * which adds all the resources, filters, health checks to the
 * application environment on run.
 */
public class SkeletonApplication extends Application<SkeletonConfiguration> {

    private final Logger logger = LoggerFactory.getLogger(SkeletonApplication.class);

    public static void main(String[] args) throws Exception {
        new SkeletonApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SkeletonConfiguration> bootstrap)
    {
        AssetsBundle assetsBundle = new AssetsBundle("/assets/", "/", "index.html", "static");
        bootstrap.addBundle(assetsBundle);
    }

    @Override
    public void run(SkeletonConfiguration skeletonConfiguration, Environment environment) throws Exception {
        //Creating a resource
        Resource resource = new Resource(skeletonConfiguration.getTemplate(), skeletonConfiguration.getDefaultName());

        //Creating a health check and adding to environment
        TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(skeletonConfiguration.getTemplate());
        environment.healthChecks().register("template", templateHealthCheck);

        //adding a resource to jersey
        environment.jersey().register(resource);
    }
}
