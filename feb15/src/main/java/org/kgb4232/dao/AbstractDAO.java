package org.kgb4232.dao;
//부모형태
//@ none

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	@Autowired
	SqlSession sqlSession;
}
