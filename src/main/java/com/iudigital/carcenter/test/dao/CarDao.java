package com.iudigital.carcenter.test.dao;

import com.iudigital.carcenter.test.util.ConnectionUtil;
import com.iudigital.carcenter.test.util.dominio.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private static final String CREATE_CARS = "insert into car(marca, modelo, anho, color, transmission) "
            + "values (?, ?, ?, ?, ?)";
    
    private static final String GET_CARS = "select * from car";
    
    
    public void crear(Car car) throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_CARS);
            preparedStatement.setString(1, car.getMarca());
            preparedStatement.setString(2, car.getModelo());
            preparedStatement.setString(3, car.getAnho());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setString(5, car.getTransmission());
        }
        finally{
        if(preparedStatement != null){
            preparedStatement.close();
        }
        
        if(connection != null){
            connection.close();
        }
    }
           
    }
    
    
    public List<Car> obtenerCarros() throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedStatement = null; // con este objeto preparamos la consulta o la conexion
        ResultSet resultSet = null;       
        List<Car> cars = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CARS);
            
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMarca(resultSet.getString("Marca"));
                car.setModelo(resultSet.getString("Modelo"));
                car.setAnho(resultSet.getString("Año"));
                car.setColor(resultSet.getString("color"));
                car.setTransmission(resultSet.getString("transmission"));
                cars.add(car);
            }
            return cars;    
        }finally{
            if(connection != null){
                connection.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
            
        }
        
        
    }
}
