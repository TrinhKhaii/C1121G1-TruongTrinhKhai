package service;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 00:20
*/

import model.dto.FacilityDTO;
import model.service.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IFacilityService {
    List<FacilityDTO> selectAllFacilityDTO();

    void insertRoom(Room room) throws SQLException;

    void insertHouse(House house) throws SQLException;

    void insertVilla(Villa villa) throws SQLException;

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();

    Map<String, String> checkVilla(Villa villa);

    Map<String, String> checkHouse(House house);

    Map<String, String> checkRoom(Room room);
}
