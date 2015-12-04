package com.raman.skeleton.api;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.raman.skeleton.dbOperations.SkeletonDAO;
import com.raman.skeleton.models.SkeletonModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Raman on 15/11/15.
 * This is the resource class of the application, which can be
 * accessed at the url /hello-world
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final SkeletonDAO skeletonDAO;

    public Resource(String template, String defaultName, SkeletonDAO skeletonDAO) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.skeletonDAO = skeletonDAO;
    }

    @GET
    @Timed
    public SkeletonModel sayHello(@QueryParam("name") Optional<String> name) {

        final String value = String.format(template, name.or(defaultName));
        return new SkeletonModel(counter.incrementAndGet(), value);
    }
}
