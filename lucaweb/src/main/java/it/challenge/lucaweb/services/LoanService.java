package it.challenge.lucaweb.services;

import com.github.hansonhsc.loan.quote.InsufficientLendersException;
import com.github.hansonhsc.loan.quote.LoanQuoteParameterValidationException;

import it.challenge.lucaweb.beans.LoanQuoteBean;

public interface LoanService {

	LoanQuoteBean getLoanQuote(String loanAmount) throws LoanQuoteParameterValidationException, InsufficientLendersException;	
	
}
