package com.straumann.patient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientApplicationTests {

	@Autowired
	private MockMvc mvc;

	ResultActions action;

	@When("the client calls \\/patients")
	public void the_client_calls_getCategory() throws Exception {
		action = mvc.perform(get("/patients").contentType(MediaType.APPLICATION_JSON));
	}

	@Then("the client receives status code of {int} for category")
	public void the_client_receives_status_code_of_for_category(Integer int1) throws Exception {
		action.andExpect(status().isOk());
	}
}
