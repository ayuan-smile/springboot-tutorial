package com.smile.boot;

import com.smile.boot.config.MyProps;
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
@RequestMapping("/api/yaml")
public class YmlController {

	@Autowired
	private MyProps myProps;
	
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
		
		System.out.println("simpleProp: " + myProps.getSimpleProp());
		
		System.out.println("arrayProps: " + myProps.getArrayProps());
		System.out.println("listProp1: " + myProps.getListProp1());
		System.out.println("listProp2: " + myProps.getListProp2());
		System.out.println("mapProps: " + myProps.getMapProps());

		obj.put("yml", myProps);
		return obj.toJSONString();
	}
}
