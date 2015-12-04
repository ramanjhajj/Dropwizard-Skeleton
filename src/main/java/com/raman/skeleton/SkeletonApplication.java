package com.raman.skeleton;

import com.raman.skeleton.api.Resource;
import com.raman.skeleton.dbOperations.SkeletonDAO;
import com.raman.skeleton.filter.SkeletonFilter;
import com.raman.skeleton.healthcheck.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
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
        new SkeletonApplication().run("server", "config/default.yml");
    }

    @Override
    public void initialize(Bootstrap<SkeletonConfiguration> bootstrap)
    {
        AssetsBundle assetsBundle = new AssetsBundle("/assets/", "/", "index.html", "static");
        bootstrap.addBundle(assetsBundle);
    }

    @Override
    public void run(SkeletonConfiguration skeletonConfiguration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, skeletonConfiguration.getDataSourceFactory(), "SkeletonDB");
        final SkeletonDAO skeletonDAO = dbi.onDemand(SkeletonDAO.class);

        SkeletonFilter skeletonFilter = new SkeletonFilter();
        environment.servlets().addFilter("SkeletonFilter", skeletonFilter)
                .addMappingForUrlPatterns(null, true, "/*");

        //Creating a health check and adding to environment
        TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck("test");
        environment.healthChecks().register("template", templateHealthCheck);


        //Creating a resource
        Resource resource = new Resource("test","test", skeletonDAO);
        //adding a resource to jersey
        environment.jersey().register(resource);
    }
}
