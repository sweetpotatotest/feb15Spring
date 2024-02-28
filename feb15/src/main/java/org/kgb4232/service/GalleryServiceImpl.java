package org.kgb4232.service;

import java.util.List;

import org.kgb4232.dao.GalleryDAO;
import org.kgb4232.dto.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("galleryService")
public class GalleryServiceImpl extends AbstractService implements GalleryService{

	@Autowired
	private GalleryDAO galleryDAO;
	
	public int galleryInsert(GalleryDTO dto) {
		//세션 추가
		if(util.getSession().getAttribute("mid") != null) {
			dto.setMid((String) util.getSession().getAttribute("mid"));
			return galleryDAO.galleryInsert(dto);					
		} else {
			return 0;
		}
	}

	public List<GalleryDTO> galleryList() {
		return galleryDAO.galleryList();
	}

	public GalleryDTO detail(String no) {
		return galleryDAO.detail(no);
	}
	
	 
	
}
