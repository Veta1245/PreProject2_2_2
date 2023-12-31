package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.carDAO.CarDaoImpl;
import web.models.Car;

import java.util.List;

@Controller
public class CarController {


    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(defaultValue = "5") Integer count, ModelMap model) {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> newListCars = carDao.carList(count);
        model.addAttribute("cars", newListCars);
        return "cars";
    }
}
