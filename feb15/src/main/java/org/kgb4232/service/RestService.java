package org.kgb4232.service;

import org.kgb4232.dao.RestDAO;
import org.kgb4232.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestService extends AbstractService{

	
	@Autowired
	private RestDAO restDAO;
	
	public int sendEmail() {
		if (util.getSession().getAttribute("mid") != null) {
			//메일 발송 + key 데이터베이스에 저장
			String email = getEmail((String) util.getSession().getAttribute("mid"));
			String key = util.randomKey();
			
			MemberDTO dto = new MemberDTO();
			dto.setMemail(email);
			dto.setMkey(key);
			dto.setMid((String) util.getSession().getAttribute("mid"));
			restDAO.setKey(dto); //서버에 키 저장하기
			//util.sendEmail(email, key);
			return 1;
		} else {
			return 0;
		}
	}
	public String getEmail(String email) {
		return restDAO.getEmail(email);
	}
	
	
}
