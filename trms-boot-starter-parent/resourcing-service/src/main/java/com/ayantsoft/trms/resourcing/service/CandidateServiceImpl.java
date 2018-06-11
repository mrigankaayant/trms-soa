package com.ayantsoft.trms.resourcing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import com.ayantsoft.trms.resourcing.model.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Override
	public Candidate get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidate get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAll() {
		Candidate c1 = new Candidate();
		c1.setId(1);
		Candidate c2 = new Candidate();
		c2.setId(2);
		return Arrays.asList(c1, c2);
	}

	@Override
	public void create(Candidate company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Candidate update(Candidate company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Candidate company) {
		// TODO Auto-generated method stub
		
	}

}
