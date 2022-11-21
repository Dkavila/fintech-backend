package me.kayrhu.controller;

import lombok.RequiredArgsConstructor;
import me.kayrhu.dao.FinancialObjectiveDAO;
import me.kayrhu.model.FinancialObjectiveModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FinancialObjectiveController {
    FinancialObjectiveDAO repository;

    @GetMapping("/objectiveAll/{id}")
    public List<FinancialObjectiveModel> getAllObjectives(@PathVariable int id){
        return repository.getAllFinancialObjectives(id);
    }

    @GetMapping("/objective/{id}")
    public FinancialObjectiveModel getObjective(@PathVariable int id){
        return repository.getFinancialObjective(id);
    }

    @PostMapping("/objective")
    public FinancialObjectiveModel insertObjective(@RequestBody FinancialObjectiveModel objective){
        return repository.insertFinancialObjective(objective);
    }

    @DeleteMapping("/objective/{id}")
    public void deleteObjective(@PathVariable int id){
        repository.deleteFinancialObjective(id);
    }

    @PatchMapping("/objective")
    public FinancialObjectiveModel updateObjective(@RequestBody FinancialObjectiveModel objective){
        return repository.updateFinancialObjective(objective);
    }
}
