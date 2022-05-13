package de.bredex.account.application.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void GET_returns_account_details() throws Exception {
	mvc.perform(get("/api/v1/account").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(HttpStatus.OK.value()))
		.andExpect(jsonPath("$.*", hasSize(3)))
		.andExpect(jsonPath("$[0].firstName", is("Timo")))
		.andExpect(jsonPath("$[0].lastName", is("Rohrberg")))
		.andExpect(jsonPath("$[1].firstName", is("Max")))
		.andExpect(jsonPath("$[1].lastName", is("Mustermann")))
		.andExpect(jsonPath("$[2].firstName", is("Petra")))
		.andExpect(jsonPath("$[2].lastName", is("Musterfrau")));
    }
}
