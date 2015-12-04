package com.raman.skeleton.dbOperations.mapper;

import com.raman.skeleton.models.SkeletonModel;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Raman on 04/12/2015.
 *
 * Mapper class for mapping the resule set from DAO to the model
 */
public class SkeletonMapper implements ResultSetMapper<SkeletonModel> {

    /**
     * Map function to map the result set from the SkeletonDAO to the Skeleton Model
     * @param i Index
     * @param resultSet ResultSet
     * @param statementContext Statement Contect
     * @return SkeletonModel
     * @throws SQLException
     */
    @Override
    public SkeletonModel map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        SkeletonModel skeletonModel = new SkeletonModel()
                .setId(resultSet.getLong("ID"))
                .setContent(resultSet.getString("Content"));

        return skeletonModel;
    }
}
