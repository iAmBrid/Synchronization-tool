package com.isgoto.synchronous.controller;

import com.alibaba.fastjson.JSONObject;
import com.isgoto.synchronous.model.Content;
import com.isgoto.synchronous.service.ContentService;
import com.isgoto.synchronous.util.IpUtil;
import com.isgoto.synchronous.util.ResultUtil;
import com.isgoto.synchronous.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    private static final Log logger = LogFactory.getLog(ContentController.class);

    /**
     * 保存同步内容
     * @param json
     * @param request
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody String json, HttpServletRequest request){
        try{
            Content content = JSONObject.parseObject(json, Content.class);
            if (content == null || StringUtil.isBlank(content.getText())){
                return ResultUtil.fail("同步内容为空");
            }
            // 校验同步内容是否与上次相同
            String text = contentService.getLatestText();
            if (StringUtil.isNotBlank(text) && text.equals(content.getText())){
                return ResultUtil.fail("该内容与上次同步内容相同");
            }
            content.setCreateTime(new Date());
            content.setIp(IpUtil.getIpAddr(request));
            Boolean success = contentService.save(content);
            if (success){
                return ResultUtil.success("同步成功");
            }
            return ResultUtil.fail("同步失败");
        }catch (Exception exception){
            logger.error(exception.getMessage());
            return ResultUtil.fail("同步失败");
        }
    }

    /**
     * 获取最新同步文本
     * @return
     */
    @RequestMapping("/get_latest_text")
    @ResponseBody
    public String getLatestText(){
        try{
            String content = contentService.getLatestText();
            return ResultUtil.success(content);
        }catch (Exception exception){
            logger.error(exception.getMessage());
            return ResultUtil.fail("获取同步内容失败");
        }
    }
}
