package com.spring.boot.mybatis.server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther xuxq
 * @date 2019/1/21 21:52
 */
@Data
public class Entity implements Serializable {
    private static final long serialVersionUID = -763638353551774166L;
    public static final String INDEX_NAME = "index_entity";
    public static final String TYPE = "tstype";
    private Long id;
    private String name;
    public Entity() {
        super();
    }
    public Entity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
