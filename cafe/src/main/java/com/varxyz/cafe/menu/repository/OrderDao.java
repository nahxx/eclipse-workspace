package com.varxyz.cafe.menu.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.menu.domain.OrderList;
import com.varxyz.cafe.menu.domain.OrderMenu;

@Repository("OrderDao")
public class OrderDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public OrderDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private long oid;
	
	public void addOrderMenu(OrderMenu orderMenu) {
		String sql = "INSERT INTO OrderMenu (totalAmount, totalPrice) VALUES(?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
         PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"oid"});
         pstmt.setLong(1, orderMenu.getTotalAmount());
         pstmt.setDouble(2, orderMenu.getTotalPrice());
         return pstmt;
      };
      jdbcTemplate.update(creator, keyHolder);
      
      oid = keyHolder.getKey().longValue();
	}
	
	public void addOrderList(OrderList orderList) {
		String sql = "INSERT INTO OrderList (oid, menuName, amount, price) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, oid, orderList.getMenuName(), orderList.getAmount(), orderList.getPrice());
	}
	
	public OrderMenu findOrderMenuByOid(long oid) {
		String sql = "SELECT oid, totalAmount, totalPrice, regDate FROM OrderMenu WHERE oid = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<OrderMenu>() {

			@Override
			public OrderMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderMenu orderMenu = new OrderMenu();
				orderMenu.setOid(rs.getLong("oid"));
				orderMenu.setTotalAmount(rs.getLong("totalAmount"));
				orderMenu.setTotalPrice(rs.getDouble("totalPrice"));
				orderMenu.setRegDate(rs.getTimestamp("regDate"));
				
				return orderMenu;
			}
			
		}, oid);
	}
	
	public List<OrderList> findOrderListByOid(long oid) {
		String sql = "SELECT olid, oid, menuName, amount, price, regDate FROM OrderList WHERE oid = ?";
		return jdbcTemplate.query(sql, new RowMapper<OrderList>() {

			@Override
			public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderList orderList = new OrderList();
				orderList.setOlid(rs.getLong("olid"));
				orderList.setMenuName(rs.getString("menuName"));
				orderList.setAmount(rs.getLong("amount"));
				orderList.setPrice(rs.getDouble("price"));
				orderList.setRegDate(rs.getTimestamp("regDate"));
				
				return orderList;
			}
			
		}, oid);
	}
	
	public long findRecentlyOid() {
		String sql = "SELECT MAX(oid) AS oid FROM OrderMenu";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Long>() {

			@Override
			public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getLong("oid");
			}
			
		});
	}
}
