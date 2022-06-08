package repository.impl;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 19:41
*/

import model.MedicalRecordDTO;
import repository.IMedicalRecordRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordRepository implements IMedicalRecordRepository {
    private final BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_MEDICAL_RECORD = "select medical_record.medical_record_id, medical_record.medical_record_code, patient.patient_id, patient.patient_code, patient.patient_name, patient.start_date, patient.end_date, patient.reason\n" +
            "from medical_record\n" +
            "inner join patient on medical_record.medical_record_code = patient.medical_record_code;";
    private static final String SELECT_MEDICAL_RECORD_BY_CODE = "select medical_record.medical_record_id, medical_record.medical_record_code, patient.patient_code, patient.patient_name, patient.start_date, patient.end_date, patient.reason\n" +
            "from medical_record\n" +
            "inner join patient on medical_record.medical_record_code = patient.medical_record_code\n" +
            "where medical_record.medical_record_code = ?;";

    @Override
    public List<MedicalRecordDTO> findAllMedicalRecord() {
        List<MedicalRecordDTO> medicalRecordDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEDICAL_RECORD)) {
            System.out.println(SELECT_ALL_MEDICAL_RECORD);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("medical_record_id");
                String code = rs.getString("medical_record_code");
                String patientCode = rs.getString("patient_code");
                String patientName = rs.getString("patient_name");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String reason = rs.getString("reason");
                medicalRecordDTOList.add(new MedicalRecordDTO(id, code, patientCode, patientName, startDate, endDate, reason));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecordDTOList;
    }

    @Override
    public void insertMedicalRecord(MedicalRecordDTO medicalRecordDTO) {

    }

    @Override
    public void deleteMedicalRecord(Integer id) {

    }

    @Override
    public MedicalRecordDTO selectMedicalRecordByCode(String code) {
        MedicalRecordDTO medicalRecordDTO = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEDICAL_RECORD_BY_CODE)) {
            preparedStatement.setString(1, code);
            System.out.println(SELECT_MEDICAL_RECORD_BY_CODE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("medical_record_id");
                String patientCode = rs.getString("patient_code");
                String patientName = rs.getString("patient_name");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String reason = rs.getString("reason");
                medicalRecordDTO = new MedicalRecordDTO(id, code, patientCode, patientName, startDate, endDate, reason);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecordDTO;
    }
}
