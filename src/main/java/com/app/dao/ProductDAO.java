package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.myBatis.config.MyBatisConfig;
import com.app.vo.ProductVO;

public class ProductDAO {
//	매번 sqlSession을 생성하지 않기위해 필드에 선언해주고 참조해서 사용한다
	public SqlSession sqlSession;
	
	public ProductDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(ProductVO productVO) {
		sqlSession.insert("product.insert", productVO);
	}
	
	public List<ProductVO> selectAll() {
		List<ProductVO> productLists = sqlSession.selectList("product.selectAll");
		return productLists;
	}
	
	public Optional<ProductVO> selectOne(Long id) {
		return Optional.ofNullable(sqlSession.selectOne("product.select", id));
	}
	
	public void update(ProductVO productVO) {
		sqlSession.update("product.update", productVO);
	}
	
	public void delete(Long id) {
		sqlSession.delete("product.delete", id);
	}
}



