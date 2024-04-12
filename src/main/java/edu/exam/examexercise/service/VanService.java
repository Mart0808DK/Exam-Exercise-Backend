package edu.exam.examexercise.service;

import edu.exam.examexercise.entity.Van;
import edu.exam.examexercise.repository.VanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanService {
    private VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    public List<Van> getAll() {
        return vanRepository.findAll();
    }
}
