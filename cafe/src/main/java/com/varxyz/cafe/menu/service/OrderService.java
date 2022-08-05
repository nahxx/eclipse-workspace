package com.varxyz.cafe.menu.service;

import java.util.List;

import com.varxyz.cafe.menu.domain.OrderList;
import com.varxyz.cafe.menu.domain.OrderMenu;

public interface OrderService {
	void addOrderMenu(OrderMenu orderMenu);
	void addOrderList(OrderList orderList);
	OrderMenu getOrderMenuByOid(long oid);
	List<OrderList> getOrderListByOid(long oid);
	long getRecentlyOid();
}
