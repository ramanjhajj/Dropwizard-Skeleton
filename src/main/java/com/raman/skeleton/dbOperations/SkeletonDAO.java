package com.raman.skeleton.dbOperations;

import com.raman.skeleton.dbOperations.mapper.SkeletonMapper;
import com.raman.skeleton.models.SkeletonModel;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by Raman on 04/12/2015.
 *
 * Skeleton DAO for the SQL Database queries
 */
@RegisterMapper(SkeletonMapper.class)
public interface SkeletonDAO {

    @SqlQuery("Select * from Users where id = :id")
    SkeletonModel exampleQuery(@Bind("id") long id);

    /**
     * create the user profile table
     */
    @SqlUpdate("create table if not exists USERS (userid SERIAL, username varchar(100) not null, password varchar(100) not null, CONSTRAINT user_pkey PRIMARY KEY (userid), CONSTRAINT users_username_key UNIQUE (username))")
    void createUserTable();
}
