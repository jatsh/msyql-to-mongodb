package com.netease.jv.controller;

import com.netease.jv.model.CmsHeroes;
import com.netease.jv.service.CmsHeroesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class CmsHeroesController {

    @Resource
    private CmsHeroesService cmsHeroesService;

    @RequestMapping("/cmsHeroes")
    @ResponseBody
    public List<CmsHeroes> cmsHeroes() {
        return cmsHeroesService.queryAll();
    }
}
