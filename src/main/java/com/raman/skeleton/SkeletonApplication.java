package com.raman.skeleton;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Raman on 15/11/15.
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

    }
}
