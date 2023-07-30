/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.straumann.patient.service.domain.ports.input.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.straumann.domain.valueobject.PatientID;
import com.straumann.patient.domain.PatientDomainService;
import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.service.domain.dto.PatientDTO;
import com.straumann.patient.service.domain.exception.PatientNotFoundException;
import com.straumann.patient.service.domain.mapper.PatientDataMapper;
import com.straumann.patient.service.domain.ports.output.repo.PatientRepository;

/**
 * @author Sunil Anjanappa
 *
 */
@Service
public class PatientApplicationServiceImpl implements PatientApplicationService {

	private final PatientDomainService patientDomainService;

	private final PatientDataMapper patientDataMapper;

	private final PatientRepository patientRepository;

	public PatientApplicationServiceImpl(PatientDomainService patientDomainService, PatientDataMapper patientDataMapper,
			PatientRepository patientRepository) {
		this.patientDomainService = patientDomainService;
		this.patientDataMapper = patientDataMapper;
		this.patientRepository = patientRepository;
	}

	@Override
	@Transactional
	public PatientDTO createPatient(PatientDTO patientDTO) {
		Patient patient = patientDataMapper.createPatientDtoToPatient(patientDTO);
		patientDomainService.validateAndInitiatePatient(patient);
		Patient savedPatient = patientRepository.save(patient);
		return patientDataMapper.patientToPatientDto(savedPatient);
	}

	@Override
	@Transactional
	public PatientDTO updatePatient(PatientDTO patientDTO) {
		Patient patient = patientDataMapper.createPatientDtoToPatient(patientDTO);
		Patient savedPatient = patientRepository.save(patient);
		return patientDataMapper.patientToPatientDto(savedPatient);
	}

	@Override
	public void deletePatient(String id) {
		patientRepository.delete(new PatientID(UUID.fromString(id)));
	}

	@Override
	public PatientDTO getPatientById(String id) {
		Optional<Patient> patientOptional = patientRepository.findById(new PatientID(UUID.fromString(id)));
		if (patientOptional.isEmpty()) {
			throw new PatientNotFoundException("patient not foud for ID : " + id);
		}
		return patientDataMapper.patientToPatientDto(patientOptional.get());
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		Optional<List<Patient>> patientOptional = patientRepository.findAll();
		if (patientOptional.isEmpty()) {
			throw new PatientNotFoundException("No Patient Exist");
		}
		List<PatientDTO> ret = new ArrayList<>();
		for (Patient patient : patientOptional.get()) {
			ret.add(patientDataMapper.patientToPatientDto(patient));
		}
		return ret;
	}

}
