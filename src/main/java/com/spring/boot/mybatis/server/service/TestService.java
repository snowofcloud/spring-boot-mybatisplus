package com.spring.boot.mybatis.server.service;

import com.spring.boot.mybatis.server.entity.Entity;

import java.util.List;

/**
 * @auther xuxq
 * @date 2019/1/21 21:58
 */
public interface TestService {
    void saveEntity(Entity entity);
    void saveEntity(List<Entity> entityList);
    List<Entity> searchEntity(String searchContent);
}
