package com.isgoto.synchronous.service;

import com.isgoto.synchronous.mapper.ContentMapper;
import com.isgoto.synchronous.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    private ContentMapper contentMapper;

    /**
     * 保存同步内容
     * @param content
     * @return
     */
    public Boolean save(Content content) {
        Integer count = contentMapper.save(content);
        return count > 0;
    }

    /**
     * 获取最新同步文本
     * @return
     */
    public String getLatestText(){
        Content content = contentMapper.getLatest();
        if (content == null){
            return "";
        }
        return content.getText();
    }
}
