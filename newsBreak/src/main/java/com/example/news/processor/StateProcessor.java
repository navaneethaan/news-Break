package com.example.news.processor;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import com.example.news.common.metaResponse;
import com.example.news.dao.StateDao;
import com.example.news.dto.StateDetailDto;
import com.example.news.model.StatesDetails;

@Component
public class StateProcessor {
	@Autowired
	StateDao stdao;
	@Autowired
	metaResponse metaresponse;
	//FindAllPage
	public List<StateDetailDto> getallprocessorPage(int page){
		List<StateDetailDto> statedetaildto=new ArrayList<>();
		PageRequest preq=PageRequest.of(page -1, 10);//( pageNo ,sizeofpage)
		Page<StatesDetails>pg=(Page<StatesDetails>) stdao.findAll(preq);
		metaresponse.meta1(pg);
		List<StatesDetails>stateList=pg.getContent();
		for (StatesDetails statedetail : stateList) {
			StateDetailDto stateDto = new StateDetailDto(statedetail);
			statedetaildto.add(stateDto);
		}
		return statedetaildto;
	}
//	FindAll
	public List<StateDetailDto> getAllprocessor() throws Exception{
		try {
			List <StateDetailDto> sdto= new ArrayList<>();
			List <StatesDetails> sd=stdao.findAll();
			for (StatesDetails statesDetails : sd) {
				StateDetailDto dto= new StateDetailDto(statesDetails);
				sdto.add(dto);
			}
			return sdto;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}

	public StateDetailDto addProcessor(StateDetailDto statedto ) {

		StateDetailDto sdto = new StateDetailDto();
		StatesDetails sd=sdto.isStateDetails(statedto);
		return new StateDetailDto (stdao.save(sd));
	}
	public StateDetailDto getProcessor(int id) {
		StatesDetails statedetail=stdao.findById(id);
		StateDetailDto sddto=new StateDetailDto(statedetail);

		return sddto;

	}
	public StateDetailDto updateProcessor(StateDetailDto sdto) throws Exception {
		StateDetailDto dto=new StateDetailDto();
		StatesDetails sd= dto.isStateDetails(sdto);
		StatesDetails sdt=stdao.findById(sdto.getId());
		if(sdt.equals(null)) {
			throw new Exception("In this id not present..");
		}
		stdao.save(sd);
		return new StateDetailDto(sd);

	}
	public StateDetailDto deletedprocessor(int id) {
		StatesDetails sd=stdao.findById(id);
		stdao.delete(sd);
		return null;
	}
}