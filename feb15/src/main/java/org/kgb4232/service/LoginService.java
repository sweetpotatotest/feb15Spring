package org.kgb4232.service;

import org.kgb4232.dao.LoginDAO;
import org.kgb4232.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	public LoginDTO login(LoginDTO dto) {
		return loginDAO.login(dto);
	}

	public void mcountUp(LoginDTO loginDTO) {
		loginDAO.mcountUp(loginDTO);
	}

	public void mcountReset(LoginDTO loginDTO) {
		loginDAO.mcountReset(loginDTO);
	}

	
}
