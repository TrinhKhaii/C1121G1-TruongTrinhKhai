package service;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 15:05
*/

import model.MedicalRecordDTO;

import java.util.List;

public interface IMedicalRecordService {
    List<MedicalRecordDTO> findAllMedicalRecord();

    void insertMedicalRecord(MedicalRecordDTO medicalRecordDTO);

    void deleteMedicalRecord(Integer id);

    void updateMedicalRecord(MedicalRecordDTO medicalRecordDTO);
}
