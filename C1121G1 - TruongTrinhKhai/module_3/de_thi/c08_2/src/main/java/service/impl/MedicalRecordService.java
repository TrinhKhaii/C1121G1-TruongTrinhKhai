package service.impl;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 19:49
*/

import model.MedicalRecordDTO;
import repository.IMedicalRecordRepository;
import repository.impl.MedicalRecordRepository;
import service.IMedicalRecordService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordService implements IMedicalRecordService {
    private final IMedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();
    private static final String MEDICAL_RECORD_CODE_REGEX = "^BA-\\d{3}$";
    private static final String PATIENT_CODE_REGEX = "^BN-\\d{3}$";
    private static final String STRING_REGEX = "^\\w+( \\w+)*$";

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

    }

    @Override
    public Map<String, String> check(MedicalRecordDTO medicalRecordDTO) {
        Map<String, String> error = new HashMap<>();
        if (!medicalRecordDTO.getCode().matches(MEDICAL_RECORD_CODE_REGEX)) {
            error.put("code", "Mã bệnh án phải có định dạng BA-XXX");
        }
        if (!medicalRecordDTO.getPatientCode().matches(PATIENT_CODE_REGEX)) {
            error.put("patientCode", "Mã bệnh nhân phải có định dạng BN-XXX");
        }
        if (!medicalRecordDTO.getPatientName().matches(STRING_REGEX)) {
            error.put("patientName", "Tên bệnh nhân không được có thêm khoảng trắng hoặc không có ký tự");
        }
        if (!medicalRecordDTO.getReason().matches(STRING_REGEX)) {
            error.put("reason", "Lý do không được có thêm khoảng trắng hoặc không có ký tự");
        }
        return error;
    }

    @Override
    public MedicalRecordDTO selectMedicalRecordDTOByCode(String code) {
        return medicalRecordRepository.selectMedicalRecordByCode(code);
    }
}
