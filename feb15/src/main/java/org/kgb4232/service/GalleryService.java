package org.kgb4232.service;

import java.util.List;

import org.kgb4232.dto.GalleryDTO;

public interface GalleryService {

	public int galleryInsert(GalleryDTO dto);
	
	public List<GalleryDTO> galleryList();
	
	public GalleryDTO detail(String no);
}
