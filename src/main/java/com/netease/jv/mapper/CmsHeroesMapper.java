package com.netease.jv.mapper;


import com.netease.jv.model.CmsHeroes;

import java.util.List;

public interface CmsHeroesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsHeroes record);

    int insertSelective(CmsHeroes record);

    CmsHeroes selectByPrimaryKey(Integer id);

    List<CmsHeroes> queryAll();

    int updateByPrimaryKeySelective(CmsHeroes record);

    int updateByPrimaryKey(CmsHeroes record);
}