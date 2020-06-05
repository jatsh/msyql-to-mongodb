package com.netease.jv.mysqltomongo;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.netease.jv.model.CmsHeroes;
import com.netease.jv.repository.CmsHeroesRepository;
import com.netease.jv.service.CmsHeroesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class MysqltomongoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private CmsHeroesRepository repository;

    @Resource
    private CmsHeroesService cmsHeroesService;

    /**
     * 测试新增
     */
    @org.junit.jupiter.api.Test
    public void testSave() {
        List<CmsHeroes> list = cmsHeroesService.queryAll();
        for (CmsHeroes cmsHeroes : list) {
            String cnDataJsonStr = cmsHeroes.getCnDataJson();
            JSONObject object = JSONObject.parseObject(JSONObject.toJSON(cmsHeroes).toString());
            object.put("cnDataJson", JSONObject.parseObject(cnDataJsonStr));
            repository.save(object);
            log.info("【heroes】id: {},name:{} \n", cmsHeroes.getId(), cmsHeroes.getCnName());
        }
    }

    @org.junit.jupiter.api.Test
    public void testQuery() {
        Sort sort = Sort.by("thumbUp", "updateTime").descending();
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        Page<JSONObject> all = repository.findAll(pageRequest);
        log.info("【总页数】= {}", all.getTotalPages());
        log.info("【总条数】= {}", all.getTotalElements());
        log.info("【当前页数据】= {}", JSONUtil.toJsonStr(all.getContent()
                .stream()
                .map(cmsHeroes -> "cnName：" + cmsHeroes.getString("cnName"))
                .collect(Collectors.toList())));
    }

    /**
     * 测试删除
     */
    @org.junit.jupiter.api.Test
    public void testDelete() {
        // 全部删除
        repository.deleteAll();
    }

}