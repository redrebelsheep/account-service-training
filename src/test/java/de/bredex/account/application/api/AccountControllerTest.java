package de.bredex.account.application.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void GET_returns_accounts() throws Exception {
	createAccount("Timo", "Rohrberg");
	createAccount("Max", "Mustermann");
	createAccount("Petra", "Musterfrau");

	mvc.perform(get("/api/v1/account").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.*", hasSize(3)))
		.andExpect(jsonPath("$[0].number", is("10001"))).andExpect(jsonPath("$[0].firstName", is("Timo")))
		.andExpect(jsonPath("$[0].lastName", is("Rohrberg"))).andExpect(jsonPath("$[1].number", is("10002")))
		.andExpect(jsonPath("$[1].firstName", is("Max"))).andExpect(jsonPath("$[1].lastName", is("Mustermann")))
		.andExpect(jsonPath("$[2].number", is("10003"))).andExpect(jsonPath("$[2].firstName", is("Petra")))
		.andExpect(jsonPath("$[2].lastName", is("Musterfrau")));
    }

    @Test
    public void POST_creates_new_account() throws Exception {
	createAccount("Timo", "Rohrberg").andExpect(status().is(HttpStatus.CREATED.value())).andExpect(jsonPath("$.firstName", is("Timo")))
		.andExpect(jsonPath("$.lastName", is("Rohrberg")));
    }

    private ResultActions createAccount(String firstName, String lastName) throws Exception {
	AccountDto account = new AccountDto(firstName, lastName);
	byte[] input = mapper.writeValueAsBytes(account);

	return mvc
		.perform(post("/api/v1/account").contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON).content(input));
    }
}
