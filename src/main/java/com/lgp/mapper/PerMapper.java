package com.lgp.mapper;

import java.util.List;

import com.lgp.domain.Per;


public interface PerMapper {

    int insert(String name);
    Per selectById(Integer id);
    Integer selectByName(String name);
    List<Per> selectAll();
   

}
