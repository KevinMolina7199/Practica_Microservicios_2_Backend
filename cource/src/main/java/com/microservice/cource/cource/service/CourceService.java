package com.microservice.cource.cource.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.cource.cource.models.Cource;
import com.microservice.cource.cource.repository.CourceRepository;

@Service
public class CourceService {

	@Autowired
	private CourceRepository couRepository;

	public List<Cource> listCource() {
		return couRepository.findAll();
	}

	public Cource create(Cource cource) {
		return couRepository.save(cource);
	}

	public Map<String, String> deleteCource(Long courceId) {
		Map<String, String> result = new HashMap<>();
		Optional<Cource> userOptional = couRepository.findById(courceId);

		if (userOptional.isPresent()) {
			couRepository.deleteById(courceId);
		}

		return result;
	}

	public Optional<Cource> findById(Long id) {
		return couRepository.findById(id);
	}

}