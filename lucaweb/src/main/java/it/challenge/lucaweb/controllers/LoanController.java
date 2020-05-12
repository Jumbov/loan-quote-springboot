package it.challenge.lucaweb.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.hansonhsc.loan.quote.InsufficientLendersException;
import com.github.hansonhsc.loan.quote.LoanQuoteParameterValidationException;

import it.challenge.lucaweb.services.LoanService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@org.springframework.web.bind.annotation.RestController
public class LoanController {

	@Autowired
	LoanService loanService;
	
	
	
	//gets the best quote based on the amount requested by the user
	
	@RequestMapping(value = "/loan", method = POST)
	public ResponseEntity<JsonResponseBody> getYourQuote(@RequestParam(value = "amount") @Valid String loanAmount) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), loanService.getLoanQuote(loanAmount)));
			
		} catch (LoanQuoteParameterValidationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e.toString()));
		} catch (InsufficientLendersException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new JsonResponseBody(HttpStatus.PRECONDITION_FAILED.value(), "Insufficient offers from lenders to satisfy the loan. Try a smaller loan amount." + e.toString()));
		}
	
	}
	
	
	
	
	@AllArgsConstructor
    public class JsonResponseBody{
        @Getter @Setter
        private int server;
        @Getter @Setter
        private Object response;
    }
}
