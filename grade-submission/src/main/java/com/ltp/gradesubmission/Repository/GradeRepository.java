package com.ltp.gradesubmission.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.Grade;

// you could used compoonent also, just it is more generic.
//@Component
@Repository
public class GradeRepository {
    // only repository can access data store or data base so it acts as DAO
    private List<Grade> grade = new ArrayList<Grade>();

    public Grade getIndex(int index) {
       return  grade.get(index);
    }

    public List<Grade> getGrade() {
        return this.grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

}