package rw.rca.SpringSecurityTemplate.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @GetMapping("/")
    public List<String> getEmployees() {
        List<String> employees = new ArrayList<>();
        employees.add("Kamara");
        employees.add("Ntagungira");

        return employees;
    }
}
