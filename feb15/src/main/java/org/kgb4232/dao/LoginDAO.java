package org.kgb4232.dao;

import org.kgb4232.dto.LoginDTO;
import org.kgb4232.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO extends AbstractDAO{

	
	public LoginDTO login(LoginDTO dto) {
		return sqlSession.selectOne("login.login", dto);
	}

	public void mcountUp(LoginDTO loginDTO) {
		sqlSession.update("login.mcountUp", loginDTO);
	}

	public void mcountReset(LoginDTO loginDTO) {
		sqlSession.update("login.mcountReset", loginDTO);
	}


	public void setKey(MemberDTO dto) {
		sqlSession.update("login.setKey", dto);
	}
}
