package com.raman.skeleton.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raman.skeleton.dbOperations.mapper.SkeletonMapper;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Raman on 04/12/2015.
 *
 * Skeleton Model which is the result returned by the DAO.
 */
public class SkeletonModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonProperty
	private long id;

	@NotNull
	@JsonProperty
	private String content;

	public SkeletonModel()
	{
		// Jackson deserialization
	}

	public SkeletonModel(long id, String content)
	{
		this.id = id;
		this.content = content;
	}

	public long getId()
	{
		return this.id;
	}

	public SkeletonModel setId(long id) {
		this.id = id;
		return this;
	}

	public String getContent()
	{
		return this.content;
	}

	public SkeletonModel setContent(String content){
		this.content = content;
		return this;
	}
}
