package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service;

import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Vehicle;

import java.util.List;

public interface IVehicle {
    void delete(String controlPlate, List<Vehicle> vehicleList);
}
