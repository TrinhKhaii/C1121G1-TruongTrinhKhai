package repository.impl;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 14:43
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
    private static final String INSERT_NEW_PATIENT = "insert into patient(patient_code, patient_name, start_date, end_date, reason, medical_record_code) values (?, ?, ?, ?, ?, ?);";
    private static final String DELETE_MEDICAL_RECORD = "delete from patient where patient_id = ?";
    private static final String UPDATE_MEDICAL_RECORD = "update patient set patient_name = ?, start_date = ?, end_date = ?, reason = ? where patient_id = ?;";
    @Override
    public List<MedicalRecordDTO> findAllMedicalRecord() {
        List<MedicalRecordDTO> medicalRecordDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEDICAL_RECORD)) {
            System.out.println(SELECT_ALL_MEDICAL_RECORD);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer recordId = rs.getInt("medical_record_id");
                String recordCode = rs.getString("medical_record_code");
//                Integer patientId = rs.getInt("patient_id");
                String patientCode = rs.getString("patient_code");
                String patientName = rs.getString("patient_name");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String reason = rs.getString("reason");
                medicalRecordDTOList.add(new MedicalRecordDTO(recordId, recordCode, patientCode, patientName, startDate, endDate, reason));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecordDTOList;
    }

    @Override
    public void insertMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PATIENT)) {
            preparedStatement.setString(1, medicalRecordDTO.getPatientCode());
            preparedStatement.setString(2, medicalRecordDTO.getPatientName());
            preparedStatement.setString(3, medicalRecordDTO.getStartDate());
            preparedStatement.setString(4, medicalRecordDTO.getEndDate());
            preparedStatement.setString(5, medicalRecordDTO.getReason());
            preparedStatement.setString(6, medicalRecordDTO.getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicalRecord(Integer id) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MEDICAL_RECORD)) {
            System.out.println(DELETE_MEDICAL_RECORD);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MEDICAL_RECORD)) {
            System.out.println(UPDATE_MEDICAL_RECORD);
            preparedStatement.setString(1, medicalRecordDTO.getPatientName());
            preparedStatement.setString(2, medicalRecordDTO.getStartDate());
            preparedStatement.setString(3, medicalRecordDTO.getEndDate());
            preparedStatement.setString(4, medicalRecordDTO.getReason());
            preparedStatement.setInt(5, medicalRecordDTO.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
