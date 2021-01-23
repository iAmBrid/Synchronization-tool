package com.isgoto.synchronous.mapper;

import com.isgoto.synchronous.model.Content;
import org.apache.ibatis.annotations.*;

public interface ContentMapper {

    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "text",column = "text"),
            @Result(property = "ip",column = "ip"),
            @Result(property = "createTime",column = "create_time")
    })
    @Select("select * from content order by create_time desc limit 0,1")
    public Content getLatest();

    @Insert("insert into content(text, ip, create_time) values(#{text}, #{ip}, #{createTime})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    public Integer save(Content content);
}
