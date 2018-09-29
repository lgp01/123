package com.lgp.service;

import com.lgp.domain.Per;

public interface PerService {

	
	    boolean selectByName(String name);
	    Per selectById(Integer id);

}
