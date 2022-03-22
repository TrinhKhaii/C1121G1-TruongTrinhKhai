package repository;
/*
    Created by Trinh Khai
    Date: 20/03/2022
    Time: 00:01
*/

import model.dto.FacilityDTO;
import model.service.*;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityRepository {
    List<FacilityDTO> selectAllFacilityDTO();

    void insertRoom(Room room) throws SQLException;

    void insertHouse(House house) throws SQLException;

    void insertVilla(Villa villa) throws SQLException;

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();
}
