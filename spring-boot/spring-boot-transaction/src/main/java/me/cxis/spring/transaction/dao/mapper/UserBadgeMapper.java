package me.cxis.spring.transaction.dao.mapper;

import me.cxis.spring.transaction.dao.model.UserBadgeDO;

public interface UserBadgeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserBadgeDO row);

    int insertSelective(UserBadgeDO row);

    UserBadgeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBadgeDO row);

    int updateByPrimaryKey(UserBadgeDO row);
}