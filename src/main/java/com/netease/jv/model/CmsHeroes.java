package com.netease.jv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CmsHeroes {
    private Integer id;

    private String game;

    private String role;

    private String name;

    private String slug;

    private String dataJson;

    private String cnName;

    private String cnDataJson;

    private String lastUpdateUser;

    private Date lastUpdateTime;
}