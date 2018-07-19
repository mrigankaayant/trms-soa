package com.ayantsoft.trms.resourcing.dao;

import java.util.List;
import com.ayantsoft.trms.resourcing.model.IncentiveStructure;

public interface IncentiveStructureDao {
	
	List<IncentiveStructure> findIncentiveList(String typeFor);

}
