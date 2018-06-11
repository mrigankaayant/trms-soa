package com.ayantsoft.trms.resourcing.service;

import java.util.List;

import com.ayantsoft.trms.resourcing.model.Candidate;

public interface CandidateService {

	Candidate get(Integer id);

	Candidate get(String name);

    List<Candidate> getAll();

    void create(Candidate company);

    Candidate update(Candidate company);

    void delete(Integer id);

    void delete(Candidate company);
}
