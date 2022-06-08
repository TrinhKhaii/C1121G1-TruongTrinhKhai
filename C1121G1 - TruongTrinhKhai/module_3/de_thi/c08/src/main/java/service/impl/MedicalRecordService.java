package service.impl;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 15:06
*/

import model.MedicalRecordDTO;
import repository.IMedicalRecordRepository;
import repository.impl.MedicalRecordRepository;
import service.IMedicalRecordService;

import java.util.List;

public class MedicalRecordService implements IMedicalRecordService {
    private final IMedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();
    @Override
    public List<MedicalRecordDTO> findAllMedicalRecord() {
        return medicalRecordRepository.findAllMedicalRecord();
    }

    @Override
    public void insertMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        medicalRecordRepository.insertMedicalRecord(medicalRecordDTO);
    }

    @Override
    public void deleteMedicalRecord(Integer id) {
        medicalRecordRepository.deleteMedicalRecord(id);
    }

    @Override
    public void updateMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        medicalRecordRepository.updateMedicalRecord(medicalRecordDTO);
    }
}
