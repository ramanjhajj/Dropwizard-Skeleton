package com.raman.skeleton;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Raman on 14/11/15.
 * This is the skeleton configuration class which extends Dropqizard
 * Configuration class and maps to the config.yaml file in the resources
 */
public class SkeletonConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database;

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }
}