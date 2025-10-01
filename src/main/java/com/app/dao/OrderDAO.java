package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import com.app.dto.OrderDTO;
import com.app.myBatis.config.MyBatisConfig;
import com.app.vo.OrderVO;
import com.app.vo.ProductVO;

public class OrderDAO {
//	매번 sqlSession을 생성하지 않기위해 필드에 선언해주고 참조해서 사용한다
	public SqlSession sqlSession;
	
	public OrderDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(OrderVO orderVO) {
		sqlSession.insert("order.insert", orderVO);
	}
	
	public List<OrderDTO> selectAll(Long id) {
		return sqlSession.selectList("order.selectAll", id);
	}
	
	public Optional<OrderDTO> select(Long id) {
		return Optional.ofNullable(sqlSession.selectOne("order.select", id));
	}
	
	public void delete(Long id) {
		sqlSession.delete("order.delete", id);
	}
}



