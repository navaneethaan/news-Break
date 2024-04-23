package com.example.news.common;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class metaResponse {
	public ArrayList< meta> metaDataList=new ArrayList<>();;

	public void meta1(Page<?>pg) {
		meta data=new meta();
		data.setCurrentPage(pg.getPageable().getPageNumber()+1);
		data.setFrom(pg.getPageable().getPageSize()*pg.getPageable().getPageNumber());
		data.setLastPage(0);//
		if(pg.isLast()) {
			data.setLastPage(1);//
		}
		data.setPerPage(pg.getNumberOfElements());//
		data.setTo(pg.getPageable().getPageSize()*pg.getPageable().getPageNumber()
						+pg.getNumberOfElements());
		data.setTotal((int)pg.getTotalElements());
		data.setTotalPage(pg.getTotalPages());
		metaDataList.add(data);
;
	}
}
