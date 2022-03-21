package repository.impl;
/*
    Created by Trinh Khai
    Date: 20/03/2022
    Time: 00:03
*/

import model.dto.FacilityDTO;
import model.service.Facility;
import model.service.RentType;
import model.service.ServiceType;
import repository.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_FACILITY = "select * from service";
    private static final String SELECT_ALL_FACILITY_DTO = "select service.service_id, service.service_name, service.service_area, service.service_cost, service.service_max_people, service.standard_room,\n" +
            "service.description_other_convenience, ifnull(service.pool_area, -1) as pool_area, ifnull(service.number_of_floors, -1) as number_of_floors, rent_type.rent_type_name, service_type.service_type_name\n" +
            "from service\n" +
            "inner join rent_type on service.rent_type_id = rent_type.rent_type_id\n" +
            "inner join service_type on service.service_type_id = service_type.service_type_id\n" +
            "group by service.service_id\n" +
            "order by service.service_id;";
    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";
    private static final String SELECT_ALL_RENT_TYPE = "elect * from rent_type";

    @Override
    public List<FacilityDTO> selectAllFacilityDTO() {
        List<FacilityDTO> facilityDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY_DTO)) {
            System.out.println(SELECT_ALL_FACILITY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("service_id");
                String serviceName = rs.getString("service_name");
                Integer serviceArea = rs.getInt("service_area");
                Double serviceCost = rs.getDouble("service_cost");
                Integer serviceMaxPeople = rs.getInt("service_max_people");
                String standardRoom = rs.getString("standard_room");
                String descriptionOtherConvenience = rs.getString("description_other_convenience");
                Float poolArea = rs.getFloat("pool_area");
                Integer numberOfFloors = rs.getInt("number_of_floors");
                String rentTypeName = rs.getString("rent_type_name");
                String serviceTypeName = rs.getString("service_type_name");

                facilityDTOList.add(new FacilityDTO(id, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeName, serviceTypeName, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityDTOList;
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
        List<RentType> rentTypeList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("rent_type_id");
                String name = rs.getString("rent_type_name");
                Double cost = rs.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(id, name, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("service_type_id");
                String name = rs.getString("service_type_name");
                serviceTypeList.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
