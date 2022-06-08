package repository;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 14:42
*/

import model.MedicalRecordDTO;

import java.util.List;

public interface IMedicalRecordRepository {
    List<MedicalRecordDTO> findAllMedicalRecord();

    void insertMedicalRecord(MedicalRecordDTO medicalRecordDTO);

    void deleteMedicalRecord(Integer id);

    void updateMedicalRecord(MedicalRecordDTO medicalRecordDTO);
}
