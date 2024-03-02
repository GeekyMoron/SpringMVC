package com.ltp.gradesubmission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ltp.gradesubmission.Controller.GradeController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GradeSubmissionApplicationTests {

	@Autowired
	GradeController gradeController;

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grades");
		mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful()).andExpect(view().name("grades"))
		.andExpect(model().attributeExists("grade"));
	}

}
