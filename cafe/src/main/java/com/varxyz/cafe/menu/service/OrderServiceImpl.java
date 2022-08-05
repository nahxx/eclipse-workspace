package com.varxyz.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.cafe.menu.domain.OrderList;
import com.varxyz.cafe.menu.domain.OrderMenu;
import com.varxyz.cafe.menu.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	public void addOrderMenu(OrderMenu orderMenu) {
		orderDao.addOrderMenu(orderMenu);
	}
	
	public void addOrderList(OrderList orderList) {
		orderDao.addOrderList(orderList);
	}
	
	public OrderMenu getOrderMenuByOid(long oid) {
		return orderDao.findOrderMenuByOid(oid);
	}
	
	public List<OrderList> getOrderListByOid(long oid) {
		return orderDao.findOrderListByOid(oid);
	}
	
	public long getRecentlyOid() {
		return orderDao.findRecentlyOid();
	}
}
