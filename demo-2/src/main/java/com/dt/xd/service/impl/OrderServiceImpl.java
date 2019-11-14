package com.xinda.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinda.mapper.BusinessOrderMapper;
import com.xinda.mapper.ServiceOrderMapper;
import com.xinda.mapper.ServiceOrderProgressMapper;
import com.xinda.model.BusinessOrder;
import com.xinda.model.ServiceOrder;
import com.xinda.model.ServiceOrderExample;
import com.xinda.model.ServiceOrderProgress;
import com.xinda.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("orderService")
/**
 * @author: aoliao 
 * @updateTime: 2019/11/4 8:54
 */
public class OrderServiceImpl implements OrderService {
    @Resource
    BusinessOrderMapper businessOrderMapper;
    @Resource
    ServiceOrderMapper serviceOrderMapper;
    @Resource
    ServiceOrderProgressMapper serviceOrderProgressMapper;

    @Override
    /**
     * 增加业务订单
     * @author: aoliao
     * @param: businessOrder
     * @updateTime: 2019/11/4 8:49
     * @return: boolean
     */
    public boolean addBusinessOrder(BusinessOrder businessOrder) {
        return businessOrderMapper.insert(businessOrder)!=0;
    }

    @Override
    /**
     * 删除业务订单
     * @author: aoliao
     * @param: businessOrderId
     * @updateTime: 2019/11/4 8:51
     * @return: boolean
     */
    public boolean deleteBusinessOrder(String businessOrderId) {
        return businessOrderMapper.deleteByPrimaryKey(businessOrderId)!=0;
    }

    @Override
    /**
     * 增加服务订单
     * @author: aoliao
     * @param: serviceOrder
     * @updateTime: 2019/11/4 8:51
     * @return: boolean
     */
    public boolean addServiceOrder(ServiceOrder serviceOrder) {
        return serviceOrderMapper.insert(serviceOrder)!=0;
    }

    @Override
    /**
     * 删除服务订单
     * @author: aoliao
     * @param: serviceOrderId
     * @updateTime: 2019/11/4 8:51
     * @return: boolean
     */
    public boolean deleteServiceOrder(String serviceOrderId) {

        return serviceOrderMapper.deleteByPrimaryKey(serviceOrderId)!=0;
    }

    @Override
    /**
     * 增加服务进度
     * @author: aoliao
     * @param: serviceOrderProgress
     * @updateTime: 2019/11/4 8:51
     * @return: boolean
     */
    public boolean addServiceTime(ServiceOrderProgress serviceOrderProgress) {
        return serviceOrderProgressMapper.insert(serviceOrderProgress)!=0;
    }

    @Override
    /**
     * 获取服务进度
     * @author: aoliao
     * @param: serviceId
     * @updateTime: 2019/11/4 8:52
     * @return: com.xinda.model.ServiceOrderProgress
     */
    public ServiceOrderProgress getServiceTime(String serviceId) {

        return serviceOrderProgressMapper.selectByPrimaryKey(serviceId);
    }

    @Override
    /**
     * 获取订单列表
     * @author: aoliao
     * @updateTime: 2019/11/6 15:59
     * @return: com.github.pagehelper.PageInfo
     */
    public PageInfo getOrderList(int pageNum, int pageSize, String memberId, String word, Date startDate,Date endDate) {

        ServiceOrderExample serviceOrderExample = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = serviceOrderExample.createCriteria();
        criteria.andMemberIdEqualTo(memberId);

        //模糊查询
        if (word!=null&&!"".equals(word)&&!"null".equals(word)){
            criteria.andServiceNameLike("%"+word+"%");
        }

        if (startDate!=null&&endDate!=null){
            criteria.andCreateTimeBetween(startDate,endDate);
        }

        //从第pageNum页开始，每页显示pageSize条记录
        PageHelper.startPage(pageNum, pageSize);
        List<ServiceOrder> orderList = serviceOrderMapper.selectByExample(serviceOrderExample);

        return new PageInfo(orderList);
    }

}
