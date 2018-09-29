package com.lgp.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgp.domain.Per;
import com.lgp.mapper.PerMapper;
import com.lgp.service.PerService;

@Service
public class PerServiceImpl implements PerService{

	@Autowired
	private PerMapper Mapper;
	@Override
	public boolean selectByName(String name) {
		
		return Mapper.insert(name)>0;
	}

	@Override
	public Per selectById(Integer id) {
		
		return Mapper.selectById(id);
	}

}
