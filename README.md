# Synchronization-tool
同步工具项目

## 接口文档
### 获取最新同步内容接口
* URL:/content/get_latest_text
* 输入参数
无
* 输出参数  
{  
  &ensp;&ensp;&ensp;&ensp;success:true,  
	&ensp;&ensp;&ensp;&ensp;message:"这是同步的内容XXX"  
}  
{  
  &ensp;&ensp;&ensp;&ensp;success:false,  
	&ensp;&ensp;&ensp;&ensp;message:"获取同步内容失败"  
}  
* 特殊说明  
如果无最新同步内容，返回success:true,

### 同步内容接口
* URL:/content/save  
* 输入参数  
{  
    &ensp;&ensp;&ensp;&ensp;"text":"这是要同步的内容"  
}  
* 输出参数  
{  
  &ensp;&ensp;&ensp;&ensp;success:true,  
	&ensp;&ensp;&ensp;&ensp;message:"同步内容成功"  
}  
{  
  &ensp;&ensp;&ensp;&ensp;success:false,  
	&ensp;&ensp;&ensp;&ensp;message:"同步内容失败"  
}  
* 特殊说明  
如果同步内容与上次同步相同，会返回success:false;message:该内容与上次同步内容相同
