package com.ltp.gradesubmission.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.ltp.Grade;
import com.ltp.gradesubmission.Service.GradeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



// if we will initialise the dependent object in controller class as GradeService gradeService = new GradeService() then the code becomes tighly coupled, so for loose coupling.
// dependancy injection is performed from spring component.
@Controller
public class GradeController {
    @Autowired
    //autowired can be used with constructer also
    GradeService gradeService;
    @GetMapping("/grades")
    public String sayHello(Model model) {
        model.addAttribute("grade", gradeService.getGrade());
        return "grades";
    }

    @GetMapping("/form")
    public String getform(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.calculatGrade(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String handleSubmit(@Valid Grade grades, BindingResult result) {
        if(result.hasErrors())
        return "form";
        else {
            gradeService.processData(grades);
            return "redirect:/grades";
        }
    }
    
}