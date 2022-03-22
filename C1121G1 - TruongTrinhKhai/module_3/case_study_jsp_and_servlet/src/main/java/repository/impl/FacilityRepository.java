package repository.impl;
/*
    Created by Trinh Khai
    Date: 20/03/2022
    Time: 00:03
*/

import model.dto.FacilityDTO;
import model.service.*;
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
    private static final String SELECT_ALL_FACILITY_DTO = "select service.service_id, service.service_code, service.service_name, service.service_area, service.service_cost, service.service_max_people, service.standard_room,\n" +
            "service.description_other_convenience, ifnull(service.pool_area, -1) as pool_area, ifnull(service.number_of_floors, -1) as number_of_floors, rent_type.rent_type_name, service_type.service_type_name, service.free_service_included\n" +
            "from service\n" +
            "inner join rent_type on service.rent_type_id = rent_type.rent_type_id\n" +
            "inner join service_type on service.service_type_id = service_type.service_type_id\n" +
            "group by service.service_id\n" +
            "order by service.service_id;";
    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";
    private static final String INSERT_NEW_VILLA = "insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
    private static final String INSERT_NEW_HOUSE = "insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, number_of_floors, rent_type_id, service_type_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_NEW_ROOM = "insert into service(service_code, service_name, service_area, service_cost, service_max_people, free_service_included, rent_type_id, service_type_id) values (?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<FacilityDTO> selectAllFacilityDTO() {
        List<FacilityDTO> facilityDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY_DTO)) {
            System.out.println(SELECT_ALL_FACILITY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("service_id");
                String code = rs.getString("service_code");
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
                String freeServiceIncluded = rs.getString("free_service_included");

                facilityDTOList.add(new FacilityDTO(id, code, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeName, serviceTypeName, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, freeServiceIncluded));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityDTOList;
    }

    @Override
    public void insertRoom(Room room) throws SQLException {
        System.out.println(INSERT_NEW_ROOM);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ROOM)) {
            preparedStatement.setString(1, room.getCode());
            preparedStatement.setString(2, room.getName());
            preparedStatement.setInt(3, room.getArea());
            preparedStatement.setDouble(4, room.getCost());
            preparedStatement.setInt(5, room.getMaxPeople());
            preparedStatement.setString(6, room.getFreeServiceIncluded());
            preparedStatement.setInt(7, room.getRentTypeId());
            preparedStatement.setInt(8, room.getServiceTypeId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void insertHouse(House house) throws SQLException {
        System.out.println(INSERT_NEW_HOUSE);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_HOUSE)) {
            preparedStatement.setString(1, house.getCode());
            preparedStatement.setString(2, house.getName());
            preparedStatement.setInt(3, house.getArea());
            preparedStatement.setDouble(4, house.getCost());
            preparedStatement.setInt(5, house.getMaxPeople());
            preparedStatement.setString(6, house.getRoomStandard());
            preparedStatement.setString(7, house.getDescriptionOtherConvenience());
            preparedStatement.setInt(8, house.getNumberOfFloors());
            preparedStatement.setInt(9, house.getRentTypeId());
            preparedStatement.setInt(10, house.getServiceTypeId());
        }
    }

    @Override
    public void insertVilla(Villa villa) throws SQLException {
        System.out.println(INSERT_NEW_VILLA);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_VILLA)) {
            preparedStatement.setString(1, villa.getCode());
            preparedStatement.setString(2, villa.getName());
            preparedStatement.setInt(3, villa.getArea());
            preparedStatement.setDouble(4, villa.getCost());
            preparedStatement.setInt(5, villa.getMaxPeople());
            preparedStatement.setString(6, villa.getRoomStandard());
            preparedStatement.setString(7, villa.getDescriptionOtherConvenience());
            preparedStatement.setFloat(8, villa.getPoolArea());
            preparedStatement.setInt(9, villa.getNumberOfFloors());
            preparedStatement.setInt(10, villa.getRentTypeId());
            preparedStatement.setInt(11, villa.getServiceTypeId());
            preparedStatement.executeUpdate();
        }
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
