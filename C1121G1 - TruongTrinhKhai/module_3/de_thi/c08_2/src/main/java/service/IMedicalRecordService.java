package service;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 19:49
*/

import model.MedicalRecordDTO;

import java.util.List;
import java.util.Map;

public interface IMedicalRecordService {
    List<MedicalRecordDTO> findAllMedicalRecord();

    void insertMedicalRecord(MedicalRecordDTO medicalRecordDTO);

    void deleteMedicalRecord(Integer id);

    Map<String, String> check(MedicalRecordDTO medicalRecordDTO);

    MedicalRecordDTO selectMedicalRecordDTOByCode(String code);
}
