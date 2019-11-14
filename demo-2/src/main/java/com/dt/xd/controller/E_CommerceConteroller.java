package com.dt.xd.controller;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class E_CommerceConteroller {
	@Resource
	E_CommerceService eCommerceService;
	@Resource
	BusinessOrderService businessOrderService;
	@Resource
	MemberService memberService;
	@Resource
	ServiceJudgeService serviceJudgeService;
	@Resource
	OrderJudgeService orderJudgeService;
	/*
	@RequestMapping("/test")
	public String test(Map<String,Object> map) {
		List<ProviderProduct> providerProductList = eCommerceService.selectAllProviderService();
		map.put("providerProductList", providerProductList);
		return "e-commerce_product";
	}*/
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/*
	@RequestMapping("/e-commerce_shoping-car")
	public String eCommerce_shopingCar() {
		return "e-commerce_shoping-car";
	}
	*/
	/**
	 * @查询所有商品
	 */
	@RequestMapping("/selectAllProviderProduct")
	public ModelAndView selectAllProviderProduct(Map<String,Object> map,
			@RequestParam(defaultValue = "0",required = false)Integer pageStart,
			@RequestParam(defaultValue = "2",required = false)Integer pageSize) {
		List<ProviderProduct> providerProductList = eCommerceService.selectAllProviderService(pageStart-pageStart%pageSize,pageSize);
		map.put("providerProductList", providerProductList);
		map.put("count", eCommerceService.countAllProviderService());
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		return new ModelAndView("e-commerce_product");
	}
	/**
	 * @分页 + 模糊查询
	 * @param map --向前台返回数据
	 * @param pageStart 起始页
	 * @param pageSize  页面长度
	 * @param providerName 模糊查询条件
	 * @param userName 用户名传递
	 * @return  全部商品页面
	 */
	@ResponseBody
	@RequestMapping("/selectByProviderName")
	public ModelAndView selectByProviderName(Map<String,Object> map,
			@RequestParam(defaultValue = "0",required = false)Integer pageStart,
			@RequestParam(defaultValue = "3",required = false)Integer pageSize,
			@RequestParam(defaultValue = "",required = false)String providerName) {
		List<ProviderProduct> providerProductList = eCommerceService.selectByProviderNameService(pageStart-pageStart%pageSize, pageSize,providerName.trim());
		
		map.put("providerProductList", providerProductList);
		map.put("count", eCommerceService.countByProviderNameService(providerName.trim()));
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("providerName",providerName);
		return new ModelAndView("e-commerce_product");
	}
	
	
	/*
	@RequestMapping("/selectByServiceName")
	public ModelAndView selectByServiceName(Map<String,Object> map,
			@RequestParam(defaultValue = "0",required = false)Integer pageStart,
			@RequestParam(defaultValue = "3",required = false)Integer pageSize,
			@RequestParam(defaultValue = "",required = false)String serviceName) {
		List<ProviderProduct> providerProductList = eCommerceService.selectByServiceNameService(pageStart-pageStart%pageSize, pageSize,serviceName.trim());
		map.put("providerProductList", providerProductList);
		map.put("count", eCommerceService.countByServiceNameService(serviceName.trim()));
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("providerName",serviceName);
		//System.out.println(pageStart + "======" + pageSize);
		//System.out.println(providerName);
		//System.out.println(providerProductList.size());
		//System.out.println(providerProductList);
		return new ModelAndView("e-commerce_product");
	}
	*/
	/**
	 *                             _ooOoo_
	 *                            o8888888o
	 *                            88" . "88
	 *                            (| -_- |)
	 *                            O\  =  /O
	 *                         ____/`---'\____
	 *                       .'  \\|     |//  `.
	 *                      /  \\|||  :  |||//  \
	 *                     /  _||||| -:- |||||-  \
	 *                     |   | \\\  -  /// |   |
	 *                     | \_|  ''\---/''  |   |
	 *                     \  .-\__  `-`  ___/-. /
	 *                   ___`. .'  /--.--\  `. . __
	 *                ."" '<  `.___\_<|>_/___.'  >'"".
	 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
	 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
	 *          ======`-.____`-.___\_____/___.-`____.-'======
	 *                             `=---='
	 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 *                     佛祖保佑        永无BUG
	 *            佛曰:
	 *                   写字楼里写字间，写字间里程序员；
	 *                   程序人员写程序，又拿程序换酒钱。
	 *                   酒醒只在网上坐，酒醉还来网下眠；
	 *                   酒醉酒醒日复日，网上网下年复年。
	 *                   但愿老死电脑间，不愿鞠躬老板前；
	 *                   奔驰宝马贵者趣，公交自行程序员。
	 *                   别人笑我忒疯癫，我笑自己命太贱；
	 *                   不见满街漂亮妹，哪个归得程序员？
	*/
	/******************************购物车表逻辑**************************************/
	/**
	 * @加入购物车 (插入cart表)
	 * @param providerId 产品
	 * @param memberId  用户
	 * @return 购物车页面
	 */
	@ResponseBody
	@RequestMapping("/addIntoCart")
	public Map<String,Object> addIntoCart(
			HttpServletRequest request,
			@RequestParam(required = true)String providerId,
			@RequestParam(required = true)String memberId) {
		//System.out.println(providerId + "------" + memberId);
		
		Map<String,Object> map = new HashMap<String,Object>();
		int code = 0;
		//System.out.println(eCommerceService.selectByMemeberAndProviderId(memberId,providerId));
		if(eCommerceService.selectByMemeberAndProviderId(memberId,providerId)==null) {
			ProviderProduct providerProduct = eCommerceService.selectProviderProductByPrimaryKey(providerId.trim());
			Cart cart = new Cart();
			cart.setId(UniqueId.getUniqueId());
			cart.setMemberId(memberId.trim());			//会员id
			cart.setProductId(providerProduct.getId());		//平台产品id
			//cart.setServiceId("");							//服务产品id
			cart.setServiceName(providerProduct.getServiceName());				//服务名称
			cart.setServiceInfo(providerProduct.getServiceInfo());				//服务内容
			cart.setUnitPrice(providerProduct.getPrice());					//单价
			cart.setBuyNum(1);							//购买数量
			cart.setTotalPrice(providerProduct.getPrice() * 1);					//总价
			//cart.setServiceRequest("");			//服务需求
			cart.setProviderId(providerProduct.getProviderId());					//服务商id
			cart.setUnit(providerProduct.getProviderName());								//单位
			code = eCommerceService.insertSelectiveService(cart);
		}else {
			code=-1;
		}
		request.getSession().setAttribute("cartnum", eCommerceService.countByMemberIdService(memberId));
		map.put("code",code);
 		return map;
	}
	/**
	 * 	删除购物车中信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteFromCart")
	public Map<String,Object> deleteFromCart(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		String cardId = request.getParameter("cartId").toString();
		//System.out.println(cardId);
		
		int code = eCommerceService.deleteByPrimaryKeyService(cardId);
		map.put("code", code);
		
		//通过uername查询 购物车内的信息数目
		String memberId = request.getSession().getAttribute("username").toString();
		int cartnum = eCommerceService.countByMemberIdService(memberId);
		request.getSession().setAttribute("cartnum", cartnum);
		//传递到前端
		map.put("cartnum", cartnum);
		map.put("allPrice", eCommerceService.allPriceService(memberId));
		return map;
	}
	/**
	 *	 通过用户查找 购物车信息(我的购物车)
	 * @param map
	 * @param memberId
	 * @return
	 */
	@RequestMapping("/selectCartByMemberId")
	public ModelAndView selectCartByMemberId(HttpServletRequest request,Map<String,Object> map) {
		String memberId = request.getSession().getAttribute("username").toString();
		request.getSession().setAttribute("cartnum", eCommerceService.countByMemberIdService(memberId));
		List<Cart> cartList =  eCommerceService.selectByMemberIdService(memberId);
		map.put("cartList", cartList);
		map.put("count", eCommerceService.countByMemberIdService(memberId));	//request.getSession().getAttribute("username")
		map.put("allPrice", eCommerceService.allPriceService(memberId));
		return new ModelAndView("e-commerce_shoping-car");
	}
	/**
	 * 修改购买数量  “+” “-” “输入数目”的操作
	 * @param request
	 * @param productId
	 * @param buynum
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeBuyNumCart")
	public Map<String,Object> addBuyNumCart(HttpServletRequest request,String productId,Integer buynum){
		//System.out.println(productId);
		//获取username
		String memberId = request.getSession().getAttribute("username").toString();
		Map<String,Object> map = new HashMap<String,Object>();
		int unitPrice = eCommerceService.selectPriceByProductId(productId);
		int newTotalPrice = unitPrice*buynum;
		int oldTotalPrice = eCommerceService.selectTotalPriceByProductId(productId,memberId);
		int code = eCommerceService.updateNumAndPriceByProductId(memberId,productId,buynum,newTotalPrice);
		//改变后的值-改变前的值
		int changePrice = newTotalPrice-oldTotalPrice;
		//System.out.println(code);
		map.put("code", code);
		map.put("buynum", buynum);
		map.put("totalPrice", newTotalPrice);
		map.put("changePrice", changePrice);
		//System.out.println(newTotalPrice + "---" + oldTotalPrice + "====" + changePrice);
		//查找购物车是否已存在
		//boolean flag = false;
		//flag = eCommerceService.selectByMemberIdAndProductId(memberId,productId);
		
		return map;
	}
	

	/**
	 * ┌───┐   ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┐
	 * │Esc│   │ F1│ F2│ F3│ F4│ │ F5│ F6│ F7│ F8│ │ F9│F10│F11│F12│ │P/S│S L│P/B│  ┌┐    ┌┐    ┌┐
	 * └───┘   └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┘  └┘    └┘    └┘
	 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───────┐ ┌───┬───┬───┐ ┌───┬───┬───┬───┐
	 * │~ `│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│ BacSp │ │Ins│Hom│PUp│ │N L│ / │ * │ - │
	 * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─────┤ ├───┼───┼───┤ ├───┼───┼───┼───┤
	 * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ | \ │ │Del│End│PDn│ │ 7 │ 8 │ 9 │   │
	 * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤ └───┴───┴───┘ ├───┼───┼───┤ + │
	 * │ Caps │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│" '│ Enter  │               │ 4 │ 5 │ 6 │   │
	 * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴────────┤     ┌───┐     ├───┼───┼───┼───┤
	 * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│  Shift   │     │ ↑ │     │ 1 │ 2 │ 3 │   │
	 * ├─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┬────┤ ┌───┼───┼───┐ ├───┴───┼───┤ E││
	 * │ Ctrl│    │Alt │         Space         │ Alt│    │    │Ctrl│ │ ← │ ↓ │ → │ │   0   │ . │←─┘│
	 * └─────┴────┴────┴───────────────────────┴────┴────┴────┴────┘ └───┴───┴───┘ └───────┴───┴───┘
	 */
	/*********************************订单表逻辑********************************************/
	/*添加订单*/
	@RequestMapping("/e-commerce_settlement")
	public String commerceSettlement(
			HttpServletRequest request,
			Map<String,Object> map,
			@RequestParam(required = true)String serviceId) {
		//Map<String,Object> map = new HashMap<String,Object>();
		String memberId = request.getSession().getAttribute("username").toString();
		//System.out.println(memberId + "---" + serviceId);
		BusinessOrder businessOrder = businessOrderService.selectUnpaidOrder(serviceId,memberId);
		if(businessOrder!=null) {
			//businessOrder.setCreateTime(new Date());
		}else {
			ProviderProduct providerProduct = eCommerceService.selectProviderProductByPrimaryKey(serviceId);
			UniqueOrderGenerate idWorker = new UniqueOrderGenerate(0, 0);
			String id = String.valueOf(idWorker.nextId());
			//System.out.println(id);
			businessOrder = new BusinessOrder();
			businessOrder.setId(id);
			businessOrder.setBusinessNo(id);
			businessOrder.setServerId(providerProduct.getId());
			businessOrder.setOrderInfo(providerProduct.getServiceInfo());
			businessOrder.setStatus(0);//
			businessOrder.setTotalPrice(providerProduct.getPrice());
			//businessOrder.setPayType((int)Math.round(Math.random()));
			businessOrder.setMemberId(memberId);
			businessOrder.setCreateTime(new Date(System.currentTimeMillis()));
			businessOrderService.insertSelective(businessOrder);
			
		}
		//System.out.println(businessOrder);
		map.put("businessOrder", businessOrder);
		//map.put("code", code);
		//System.out.println(cartId + "====" + providerProduct);
		return "e-commerce_settlement";
	}
	/*支付*/
	@ResponseBody
	@RequestMapping("/payment")
	public Map<String,Object> payMent(HttpServletRequest request,String orderId) {
		Map<String,Object> map = new HashMap<String,Object>();
		BusinessOrder businessOrder = businessOrderService.selectByPrimaryKey(orderId);
		
		int code;
		if(businessOrder==null) {
			code = -1;//订单不存在
		}else {
			businessOrder.setStatus(1);
			if(Math.random()<0.5) {
				businessOrder.setPayType(1);
			}else{
				businessOrder.setPayType(2);
			}
			code = businessOrderService.updateByExample(businessOrder, orderId);
			
			String memberId = request.getSession().getAttribute("username").toString();
			UniqueOrderGenerate idWorker = new UniqueOrderGenerate(0, 0);
			ServiceJudge serviceJudge = new ServiceJudge();
			serviceJudge.setId(String.valueOf(idWorker.nextId()));	//id
			serviceJudge.setMemberId(memberId);						//会员id
			serviceJudge.setOrderId(businessOrder.getId());							//订单id
			serviceJudge.setProviderId(businessOrder.getServerId());	//服务商id
			serviceJudge.setStatus(1);								//未评价
			serviceJudgeService.insertServiceJudge(serviceJudge);
		}
		map.put("code", code);
		return map;
	}
	/*查找订单*/
	@RequestMapping("/e-commerce_order")
	public String eCommerceOrder(HttpServletRequest request,Map<String,Object> map) {
		String memberId = request.getSession().getAttribute("username").toString();
		List<BusinessOrder> businessOrderList = businessOrderService.selectOrderByMemberId(memberId);
		map.put("businessOrderList", businessOrderList);
		return "e-commerce_order";
	}
	/*删除订单（id）*/
	@ResponseBody
	@RequestMapping("/deleteOrder")
	public Map<String,Object> deleteOrder(String orderId) {
		Map<String,Object> map = new HashMap<String,Object>();
		int code = businessOrderService.deleteByPrimaryKey(orderId);
		map.put("code", code);
		return map;
	}
	/*按id模糊查询订单*/
	@ResponseBody
	@RequestMapping("/selectLikeByOrderId")
	public Map<String,Object> selectLikeByOrderId(String partOrderId) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<BusinessOrder> businessOrderList = businessOrderService.selectLikeByOrderId(partOrderId);
		if(businessOrderList.size()>0) {
			map.put("businessOrderList", businessOrderList);
			//System.out.println(map);
			map.put("code", 1);
		}else {
			map.put("code", 0);
		}
		return map;
	}
	/*******************************会员表************************************/
	@RequestMapping("/e-commerce_account")
	public String eCommerceAccount() {
		return "e-commerce_account";
	}
	
	@RequestMapping("/changMemberPassword")
	@ResponseBody
	public Map<String,Object> changMemberPassword(HttpServletRequest request,String id,String oldpassword,String newpassword1) {
		System.out.println(id);
		Map<String,Object> map = new HashMap<String,Object>();
		int code = 0;
		Member member = memberService.selectMemberById(id);
		System.out.println(member.getPassword() + "===" +oldpassword);
		if(member.getPassword().equals(oldpassword)) {
			member.setPassword(newpassword1);
			code= memberService.updateMemberByExample(member);
			request.getSession().setAttribute("member", member);
		}else {
			code=-1;
		}
		System.out.println(code);
		map.put("code", code);
		return map;
	}
	@ResponseBody
	@RequestMapping("/changBasicInformation")
	public Map<String,Object> changBasicInformation(HttpServletRequest request,Member member) {
//		System.out.println(member.getId());
//		System.out.println(member.getName());
//		System.out.println(member.getGender());
//		System.out.println(member.getEmail());
		Map<String,Object> map = new HashMap<String,Object>();
		Member mem = memberService.selectMemberById(member.getId());
		member.setCellphone(mem.getCellphone());
		member.setOrderNum(mem.getOrderNum());
		member.setConsume(mem.getConsume());
		member.setPassword(mem.getPassword());
		member.setRegisterTime(mem.getRegisterTime());
		member.setStatus(mem.getStatus());
		member.setRegion(mem.getRegion());
		int code = memberService.updateMemberByExample(member);
		request.getSession().setAttribute("member", member);
		map.put("member", member);
		map.put("code", code);
		return map;
	}
	
	@RequestMapping("/saveImg")//its maximum permitted size of 1048576 bytes.
	public String saveUserImg(MultipartFile file,Member member) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
		// 获取客户端传图图片的输入流
		InputStream ins = file.getInputStream();
		byte[] buffer=new byte[2048];//bit---byte---1k---1m
		int len=0;
		 // 字节输出流
		 ByteArrayOutputStream bos=new ByteArrayOutputStream();
		while((len=ins.read(buffer))!=-1){
			bos.write(buffer,0,len);
		 }
		 bos.flush();
		byte img[] = bos.toByteArray();
		member.setHeadImg(img);
		//System.out.println("图片==="+member.getHeadImg());
		int i=memberService.saveImg(member);//修改数据库
		
		result.put("code",i);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code",0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		 }				
		return "e-commerce_account";	
	}
	@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(String id) throws Exception{

		byte[] imageContent ;
		// 根据id获取当前用户的信息
		Member member = memberService.selectMemberById(id);
				        
		imageContent = member.getHeadImg();
		//System.out.println("图片==="+member.getHeadImg());//member.getCzyxm()
				        
		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	/*******************************评价表************************************/
	@ResponseBody
	@RequestMapping("/selectOrderJudge")
	public Map<String,Object> selectOrderJudge(String status) {
		Map<String,Object> map = new HashMap<String,Object>();
		//System.out.println(status);
		List<BusinessOrder> businessOrderList = orderJudgeService.selectOrderJudge(status);
		//System.out.println(businessOrderList);
		if(businessOrderList.size()>0) {
			map.put("businessOrderList", businessOrderList);
			map.put("code", 1);
		}else {
			map.put("code", 0);
		}
		return map;
	}
	@RequestMapping("/selectAddEvaluation")
	public String selectAddEvaluation(Map<String,Object> map,String judgeId) {
		ServiceJudge serviceJudge = serviceJudgeService.selectByPrimaryKey(judgeId);
		BusinessOrder businessOrder = businessOrderService.selectByPrimaryKey(serviceJudge.getOrderId());
		map.put("businessOrder", businessOrder);
		map.put("judgeId", judgeId);
		return "e-commerce_add_evaluation";
	}
	@RequestMapping("/addEvaluation")
	public String addEvaluation(String evaluateMessage) {
		return null;
	}
	@RequestMapping("/e-commerce_evaluate")
	public String eCommerceEvaluate(Map<String,Object> map) {
		map.put("businessOrderList", orderJudgeService.selectOrderJudge("1"));
		return "e-commerce_evaluate";
	}
	/********************************退出************************************/
	// ┏┓　　　┏┓
	// ┏┛┻━━━┛┻┓
	// ┃　　　　　　　┃ 　
	// ┃　　　━　　　┃
	// ┃　┳┛　┗┳　┃
	// ┃　　　　　　　┃
	// ┃　　　┻　　　┃
	// ┃　　　　　　　┃
	// ┗━┓　　　┏━┛
	// ┃　　　┃ 神兽保佑　　　　　　　　
	// ┃　　　┃ 代码无BUG！
	// ┃　　　┗━━━┓
	// ┃　　　　　　　┣┓
	// ┃　　　　　　　┏┛
	// ┗┓┓┏━┳┓┏┛
	// ┃┫┫　┃┫┫
	// ┗┻┛　┗┻┛
	/**********************************************************************/
	/**
	 * @退出登录 清除session和cookie
	 * @param request
	 * @param response
	 * @return 起始页
	 */
	@RequestMapping("/doLogOut")
	public String doLogout(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getSession().getAttribute("username"));
		request.getSession().removeAttribute("username");		//清空session信息
		request.getSession().invalidate();						//清除 session 中的所有信息
		//退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取
		Cookie[] cookie=reCookie[] cookie=request.getCookies();
		for(Cookie c:cookie){
			if("autoLogin".equals(c.getName())){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		return "redirect:/index.html";
	}
	
}

				
				
				
				
				
				
				
				
				
				