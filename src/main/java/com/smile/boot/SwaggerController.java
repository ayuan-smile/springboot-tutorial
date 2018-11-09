package com.smile.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/api/test")
//https://blog.csdn.net/catoop/article/details/50668896
public class SwaggerController {

	/**
	 * 这里指定RequestMethod，如果不指定Swagger会把所有RequestMethod都输出，在实际应用中，具体指定请求类型也使接口更为严谨。
	 * @ApiOperation:用于方法，描述方法
	 * @ApiParam:表示单独的请求参数，包含多个 @ApiImplicitParams,@ApiImplicitParam
	 */
	@ResponseBody
	@RequestMapping(value = "/show1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	@ApiOperation(value = "测试接口1", notes = "接口1详细描述")
	public String show1(
			@ApiParam(required = true, name = "name", value = "姓名") @RequestParam(name = "name", required = true) String stuName) {
		JSONObject obj = new JSONObject();
		obj.put("key1", "value21");
		return obj.toJSONString();
	}


	@ResponseBody
	@RequestMapping(value = "/show2", method = RequestMethod.GET) 
	@ApiOperation(value = "测试接口2", notes = "接口2详细描述")
	public String show2(
			@ApiParam(required = true, name = "name", value = "姓名") @RequestParam(name = "name", required = true) String stuName) {
		String json = "{error:'1212'}";
		return json;
	}
}
