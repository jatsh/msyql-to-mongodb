package com.netease.jv.repository;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsHeroesRepository extends MongoRepository<JSONObject, Long> {
}
