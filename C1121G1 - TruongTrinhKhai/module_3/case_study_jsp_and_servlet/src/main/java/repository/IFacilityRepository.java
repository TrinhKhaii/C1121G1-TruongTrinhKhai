package repository;
/*
    Created by Trinh Khai
    Date: 20/03/2022
    Time: 00:01
*/

import model.dto.FacilityDTO;
import model.service.Facility;
import model.service.RentType;
import model.service.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityRepository {
    List<FacilityDTO> selectAllFacilityDTO();

    void insertRoom() throws SQLException;

    void insertHouse() throws SQLException;

    void insertVilla() throws SQLException;

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();
}
