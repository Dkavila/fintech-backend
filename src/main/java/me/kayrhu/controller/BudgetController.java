package me.kayrhu.controller;

import lombok.RequiredArgsConstructor;
import me.kayrhu.dao.BudgetDAO;
import me.kayrhu.model.BudgetModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetController {
    BudgetDAO repository;

    @GetMapping("/budgetAll/{id}")
    public List<BudgetModel> getAllBudgets(@PathVariable int id){
        return repository.getAllBudgets(id);
    }

    @GetMapping("/budget/{id}")
    public BudgetModel getBudget(@PathVariable int id){
        return repository.getBudget(id);
    }

    @PostMapping("/budget")
    public BudgetModel insertBudget(@RequestBody BudgetModel budget){
        return repository.insertBudget(budget);
    }

    @DeleteMapping("/budget/{id}")
    public void deleteBudget(@PathVariable int id){
        repository.deleteBudget(id);
    }

    @PatchMapping("/budget")
    public BudgetModel updateBudget(@RequestBody BudgetModel budget){
        return repository.updateBudget(budget);
    }
}
