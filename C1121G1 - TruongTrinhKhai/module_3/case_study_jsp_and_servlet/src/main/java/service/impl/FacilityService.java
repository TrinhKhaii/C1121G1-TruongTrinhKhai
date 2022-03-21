package service.impl;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 00:20
*/

import model.dto.FacilityDTO;
import model.service.RentType;
import model.service.ServiceType;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.List;

public class FacilityService implements IFacilityService {
    private final IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<FacilityDTO> selectAllFacilityDTO() {
        return facilityRepository.selectAllFacilityDTO();
    }

    @Override
    public void insertRoom() throws SQLException {

    }

    @Override
    public void insertHouse() throws SQLException {

    }

    @Override
    public void insertVilla() throws SQLException {

    }

    @Override
    public List<RentType> findAllRentType() {
        return facilityRepository.findAllRentType();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return facilityRepository.findAllServiceType();
    }
}
