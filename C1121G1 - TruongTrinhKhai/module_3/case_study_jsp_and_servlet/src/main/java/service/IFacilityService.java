package service;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 00:20
*/

import model.dto.FacilityDTO;
import model.service.RentType;
import model.service.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityService {
    List<FacilityDTO> selectAllFacilityDTO();

    void insertRoom() throws SQLException;

    void insertHouse() throws SQLException;

    void insertVilla() throws SQLException;

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();
}
