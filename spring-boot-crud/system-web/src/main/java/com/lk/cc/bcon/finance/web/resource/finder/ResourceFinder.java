package com.lk.cc.bcon.finance.web.resource.finder;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lk.cc.bcon.finance.resource.AbstractResource;

public interface ResourceFinder <R extends AbstractResource<? extends Serializable>, ID extends Serializable> {
	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the r
	 */
	R findOne(ID id);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<R> findAll();
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<R> findAll(Pageable pageable);

	
}
