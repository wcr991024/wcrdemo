package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dt.cn.model.sysUser.Operator;
import com.dt.cn.service.OperatorService;

@Controller
public class OperatorController {
	@Resource
	OperatorService operatorService;

	/*
	 * @RequestMapping("/dingdan") public String findBusiness(Map<String,Object>
	 * map) { List<Operator> business= operatorService.findBusiness();
	 * map.put("business", business); System.out.println(business); return
	 * "operator_orderform"; }
	 */
	/*
	 * @RequestMapping("/yonghu") public String findUser1(Map<String,Object> map) {
	 * List<Operator> user= operatorService.findUser1(); map.put("user", user);
	 * 
	 * return "operator_user";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("/fuwushang") public String findService(Map<String,Object>
	 * map) { List<Operator> service= operatorService.findService();
	 * map.put("service", service);
	 * 
	 * return "operator_facilitator";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("/feiyong") public String findExpence(Map<String,Object> map)
	 * { List<Operator> expence= operatorService.findExpence(); map.put("expence",
	 * expence);
	 * 
	 * return "operator_expenses";
	 * 
	 * }
	 */
		@RequestMapping("/tuijian")
		public String findRecommend(Map<String,Object> map) {
			List<Operator> recommend= operatorService.findRecommend();
			map.put("recommend", recommend);
			
			return "operator_recommend";

}



}
