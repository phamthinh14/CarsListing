package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CatergoryRepository catergoryRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("catergorys", catergoryRepository.findAll());
        return "homepage";
    }

    @RequestMapping("/addcater")
    public String carterForm(Model model) {

        model.addAttribute("cartergory", new Catergory());

        return "carterform";
    }

    @PostMapping("/processcater")
    public String processCaterForm(@Valid Catergory catergory, BindingResult result, Model model) {
        if (result.hasErrors()) {
//            model.addAttribute("cars", carRepository.findAll());
            return "carterform";
        }
        catergoryRepository.save(catergory);
        return "redirect:/";
    }

    @GetMapping("/addcar")
    public String courseForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("cartergorys", catergoryRepository.findAll());
        return "carform";
    }

    @PostMapping("/processcar")
    public String processForm(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cartergorys", catergoryRepository.findAll());
            return "carform";
        }
        carRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCarDetail(@PathVariable("id") long id, Model model) {
        model.addAttribute("catergory", catergoryRepository.findById(id).get());
//        model.addAttribute("car", carRepository.findById(id).get());
        return "cardetail";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("cartergorys", catergoryRepository.findAll());


        return "changecarinfo";
    }

    @PostMapping("/update/changecar/{id}")
    public String changeCarForm(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
//            model.addAttribute("cartergorys", catergoryRepository.findAll());
            return "changecarinfo";
        }
        carRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delCar(@PathVariable("id") long id) {
        catergoryRepository.deleteById(id);
        return "redirect:/";
    }


}
