package com.iudigital.carcenter.test.controller;

import com.iudigital.carcenter.test.dao.CarDao;
import com.iudigital.carcenter.test.util.dominio.Car;
import java.sql.SQLException;
import java.util.List;

public class CarController {

    private CarDao carDao;
    
    public CarController(){
        carDao = new CarDao();
    }
    
    public void crear(Car car) throws SQLException{
        carDao.crear(car);
    }
    
    public List<Car> obetenerCarros() throws SQLException{
        return carDao.obtenerCarros();
    }
}
