package com.ltp.gradesubmission.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ltp.Grade;
import com.ltp.gradesubmission.Repository.GradeRepository;

@Component
@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public Grade getIndex(int index) {
       return  gradeRepository.getIndex(index);
    }

    public List<Grade> getGrade() {
        return gradeRepository.getGrade();
    }

    public void setGrade(List<Grade> grade) {
        gradeRepository.setGrade(grade);
    }

    public Grade calculatGrade(String id) {
        Grade gradeFinal;
        List<Grade> list = gradeRepository.getGrade().stream().filter(g -> g.getId().equals(id)).collect(Collectors.toList());
        if(list.size()==0) {
          gradeFinal = new Grade();
        } else {
            gradeFinal = list.get(0);         
        }
        return gradeFinal;
    }

    public void processData(Grade grades) {
        List<Grade> currentData = gradeRepository.getGrade();
        currentData.removeIf(g -> g.getId().equals(grades.getId()));
        currentData.add(grades);
        gradeRepository.setGrade(currentData);
    }
}
