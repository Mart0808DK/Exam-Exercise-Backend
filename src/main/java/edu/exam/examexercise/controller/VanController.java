package edu.exam.examexercise.controller;

import edu.exam.examexercise.entity.Van;
import edu.exam.examexercise.service.VanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vans")
public class VanController {
    private VanService vanService;

    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

    @GetMapping
    public ResponseEntity<List<Van>> findAll() {
        var vans = this.vanService.getAll();
        if (vans != null) {
            return ResponseEntity.ok(vans);
        }
        return ResponseEntity.noContent().build();
    }
}
