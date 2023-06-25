package rw.rca.next.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @GetMapping("/")
    public List<String> getEmployees() {
        List<String> employees = new ArrayList<>();
        employees.add("Kamara");
        employees.add("Ntagungira");

        return employees;
    }
}
