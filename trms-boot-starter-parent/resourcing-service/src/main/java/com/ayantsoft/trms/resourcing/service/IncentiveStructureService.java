package com.ayantsoft.trms.resourcing.service;

import java.util.List;
import com.ayantsoft.trms.resourcing.model.IncentiveStructure;

public interface IncentiveStructureService {
	
	List<IncentiveStructure> findIncentiveList(String typeFor);

}
