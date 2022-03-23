package com.iudigital.carcenter.test;

import com.iudigital.carcenter.test.controller.CarController;
//import com.iudigital.carcenter.domain.Car;
import com.iudigital.carcenter.test.util.dominio.Car;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void crear(CarController carController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite la marca: ");
            String marca = sc.nextLine();
            System.out.println("Marca es: " + marca);
            System.out.println("--------------- ");

            System.out.println("Digite el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("el modelo es: " + modelo);
            System.out.println("--------------- ");

            System.out.println("Digite el anho: ");
            String anho = sc.nextLine();
            System.out.println("El año del modelo es: " + anho);
            System.out.println("---------------------");

            System.out.println("Digite el color: ");
            String color = sc.nextLine();
            System.out.println("color: " + color);
            System.out.println("--------------- ");

            System.out.println("Digite tipo de transmision: ");
            String transmission = sc.nextLine();
            System.out.println("transmission es: " + transmission);
            System.out.println("--------------- ");

            Car car = new Car();
            car.setMarca(marca);
            car.setModelo(modelo);
            car.setAnho(anho);
            car.setColor(color);
            car.setTransmission(transmission);
            carController.crear(car);
            System.out.println("Carrro creado con exito: ");
//            obtenerCarros(carController);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CarController carController = new CarController();
        crear(carController);
    }
}
