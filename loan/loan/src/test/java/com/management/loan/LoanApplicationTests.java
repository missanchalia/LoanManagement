package com.management.loan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoanApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllLoan() {
        String baseUrl = "http://localhost:" + port + "/loans";
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions based on the response content or headers if needed
    }
    
    @Test
    public void testGetLoanById() {
        int loanId = 1; // Replace with a valid loan ID from your test data
        String url = "http://localhost:" + port + "/loans/" + loanId;
        ResponseEntity<Loan[]> response = restTemplate.getForEntity(url, Loan[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Loan[] loans = response.getBody();
        assertNotNull(loans);
        // Add assertions to validate the response content or structure.
    }

    @Test
    public void testGetCustomerById() {
        String customerId = "C1"; // Replace with a valid customer ID from your test data
        String url = "http://localhost:" + port + "/loans/customerId/" + customerId;
        ResponseEntity<Loan[]> response = restTemplate.getForEntity(url, Loan[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Loan[] loans = response.getBody();
        assertNotNull(loans);
        // Add assertions to validate the response content or structure.
    }
    
    @Test
    void contextLoads() {
        // Your other tests
    }
}
