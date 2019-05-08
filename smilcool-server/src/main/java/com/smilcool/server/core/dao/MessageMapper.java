package com.smilcool.server.core.dao;

import com.smilcool.server.core.pojo.po.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectByReceiveUserIdAndState(@Param("receiveUserId") Integer receiveUserId, @Param("state") int state);

    void updateStateById(@Param("id") Integer id, @Param("state") Integer state);
}