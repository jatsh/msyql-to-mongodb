package com.netease.jv.service;


import com.netease.jv.mapper.CmsHeroesMapper;
import com.netease.jv.model.CmsHeroes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsHeroesService {

    @Resource
    private CmsHeroesMapper cmsHeroesMapper;

   public   List<CmsHeroes> queryAll() {
        return cmsHeroesMapper.queryAll();
    }

    public int deleteByPrimaryKey(Integer id) {
        return cmsHeroesMapper.deleteByPrimaryKey(id);
    }


    public int insert(CmsHeroes record) {
        return cmsHeroesMapper.insert(record);
    }


    public int insertSelective(CmsHeroes record) {
        return cmsHeroesMapper.insertSelective(record);
    }


    public CmsHeroes selectByPrimaryKey(Integer id) {
        return cmsHeroesMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(CmsHeroes record) {
        return cmsHeroesMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(CmsHeroes record) {
        return cmsHeroesMapper.updateByPrimaryKey(record);
    }

}
