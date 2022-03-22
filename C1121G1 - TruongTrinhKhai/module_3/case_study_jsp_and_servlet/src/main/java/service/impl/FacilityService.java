package service.impl;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 00:20
*/

import model.dto.FacilityDTO;
import model.service.*;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.impl.EmployeeService.STRING_REGEX;

public class FacilityService implements IFacilityService {
    private final IFacilityRepository facilityRepository = new FacilityRepository();
    private static final String SERVICE_CODE_REGEX = "^DV-\\d{4}$";

    @Override
    public List<FacilityDTO> selectAllFacilityDTO() {
        return facilityRepository.selectAllFacilityDTO();
    }

    @Override
    public void insertRoom(Room room) throws SQLException {
        facilityRepository.insertRoom(room);
    }

    @Override
    public void insertHouse(House house) throws SQLException {
        facilityRepository.insertHouse(house);
    }

    @Override
    public void insertVilla(Villa villa) throws SQLException {
        facilityRepository.insertVilla(villa);
    }

    @Override
    public List<RentType> findAllRentType() {
        return facilityRepository.findAllRentType();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return facilityRepository.findAllServiceType();
    }

    @Override
    public Map<String, String> checkVilla(Villa villa) {
        Map<String, String> error = new HashMap<>();
        if (!villa.getCode().matches(SERVICE_CODE_REGEX)) {
            error.put("code", "Service Code has the format DV-XXXX (X is the number 0-9)");
        }
        if (!villa.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
        if (villa.getArea() <= 0) {
            error.put("area", "Area must be greater than 0");
        }
        if (villa.getCost() <= 0) {
            error.put("cost", "Cost must be greater than 0");
        }
        if (villa.getMaxPeople() <= 0) {
            error.put("max_people", "Max people must be greater than 0");
        }
        if (!villa.getRoomStandard().matches(STRING_REGEX)) {
            error.put("room_standard", "Room standard cannot have any extra spaces or no characters");
        }
        if (!villa.getDescriptionOtherConvenience().matches(STRING_REGEX)) {
            error.put("description_other_convenience", "Description other convenience cannot have any extra spaces or no characters");
        }
        if (villa.getPoolArea() <= 0) {
            error.put("pool_area", "Pool area must be greater than 0");
        }
        if (villa.getNumberOfFloors() <= 0) {
            error.put("number_of_floors", "Number of floors must be greater than 0");
        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }

    @Override
    public Map<String, String> checkHouse(House house) {
        Map<String, String> error = new HashMap<>();
        if (!house.getCode().matches(SERVICE_CODE_REGEX)) {
            error.put("code", "Service Code has the format DV-XXXX (X is the number 0-9)");
        }
        if (!house.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
        if (house.getArea() <= 0) {
            error.put("area", "Area must be greater than 0");
        }
        if (house.getCost() <= 0) {
            error.put("cost", "Cost must be greater than 0");
        }
        if (house.getMaxPeople() <= 0) {
            error.put("max_people", "Max people must be greater than 0");
        }
        if (!house.getRoomStandard().matches(STRING_REGEX)) {
            error.put("room_standard", "Room standard cannot have any extra spaces or no characters");
        }
        if (!house.getDescriptionOtherConvenience().matches(STRING_REGEX)) {
            error.put("description_other_convenience", "Description other convenience cannot have any extra spaces or no characters");
        }
        if (house.getNumberOfFloors() <= 0) {
            error.put("number_of_floors", "Number of floors must be greater than 0");
        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }

    @Override
    public Map<String, String> checkRoom(Room room) {
        Map<String, String> error = new HashMap<>();
        if (!room.getCode().matches(SERVICE_CODE_REGEX)) {
            error.put("code", "Service Code has the format DV-XXXX (X is the number 0-9)");
        }
        if (!room.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
        if (room.getArea() <= 0) {
            error.put("area", "Area must be greater than 0");
        }
        if (room.getCost() <= 0) {
            error.put("cost", "Cost must be greater than 0");
        }
        if (room.getMaxPeople() <= 0) {
            error.put("max_people", "Max people must be greater than 0");
        }
        if (!room.getFreeServiceIncluded().matches(STRING_REGEX)) {
            error.put("free_service_included", "Free service included have any extra spaces or no characters");
        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }
}
