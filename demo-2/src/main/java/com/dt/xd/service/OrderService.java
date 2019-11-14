package com.xinda.service;

import com.github.pagehelper.PageInfo;
import com.xinda.model.BusinessOrder;
import com.xinda.model.ServiceOrder;
import com.xinda.model.ServiceOrderProgress;

import java.util.Date;

public interface OrderService {

    /**消费者操作后创建服务订单**/
    public boolean addBusinessOrder(BusinessOrder businessOrder);

    public boolean deleteBusinessOrder(String businessOrderId);

    /**消费者订单**/
    public boolean addServiceOrder(ServiceOrder serviceOrder);

    public boolean deleteServiceOrder(String serviceOrderId);

    /**服务订单过程**/
    public boolean addServiceTime(ServiceOrderProgress serviceOrderProgress);

    public ServiceOrderProgress getServiceTime(String serviceId);

    public PageInfo  getOrderList(int pageNum, int pageSize, String memberId, String word, Date startDate, Date endDate);




}
