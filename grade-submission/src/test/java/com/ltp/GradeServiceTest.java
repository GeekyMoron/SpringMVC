package com.ltp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Array;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import com.ltp.gradesubmission.Repository.GradeRepository;
import com.ltp.gradesubmission.Service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
    
    // we will create mock for graderepo as it is going to be needed by gradeService
    @Mock
    GradeRepository gradeRepository;

    // we will add injectMocks such that spring could pick it up against autowired thing.
    @InjectMocks
    GradeService gradeService;

    @Test
    public void getGradesTest() {
        Grade grade = new Grade("Harry","posions","a");
        when(gradeRepository.getGrade()).thenReturn(List.of(grade));
        List<Grade> data = gradeService.getGrade();
        Assert.assertEquals(1, data.size());
        Assert.assertEquals("Harry", data.get(0).getName());
    }

    @Test
    public void CalculateGradeTest() {
        Grade grade = new Grade("Harry","posions","a");
        when(gradeRepository.getGrade()).thenReturn(List.of(grade));
        Grade ans = gradeService.calculatGrade(grade.getId());
        Assert.assertEquals(ans.getId(), grade.getId());
        verify(gradeRepository, times(1)).getGrade();
    }
}
