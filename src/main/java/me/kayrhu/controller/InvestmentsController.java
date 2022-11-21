package me.kayrhu.controller;

import lombok.RequiredArgsConstructor;
import me.kayrhu.dao.InvestmentsDAO;
import me.kayrhu.model.InvestmentsModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvestmentsController {
    InvestmentsDAO repository;

    @GetMapping("/investmentAll/{id}")
    public List<InvestmentsModel> getAllInvestments(@PathVariable int id){
        return repository.getAllInvestments(id);
    }

    @GetMapping("/investment/{id}")
    public InvestmentsModel getInvestment(@PathVariable int id){
        return repository.getInvestment(id);
    }

    @PostMapping("/investment")
    public InvestmentsModel insertInvestment(@RequestBody InvestmentsModel investment){
        return repository.insertInvestment(investment);
    }

    @DeleteMapping("/investment/{id}")
    public void deleteInvestment(@PathVariable int id){
        repository.deleteInvestment(id);
    }

    @PatchMapping("/investment")
    public InvestmentsModel updateInvestment(@RequestBody InvestmentsModel investment){
        return repository.updateInvestment(investment);
    }
}
