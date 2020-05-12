package it.challenge.lucaweb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hansonhsc.loan.quote.InsufficientLendersException;
import com.github.hansonhsc.loan.quote.LoanBusiness;
import com.github.hansonhsc.loan.quote.LoanQuote;
import com.github.hansonhsc.loan.quote.LoanQuoteParameterValidationException;

import it.challenge.lucaweb.beans.LoanQuoteBean;


@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanQuoteBean q;
	
	@Override
	public LoanQuoteBean getLoanQuote(String loanAmount) throws LoanQuoteParameterValidationException, InsufficientLendersException {
		
		LoanBusiness business = new LoanBusiness();
		LoanQuote lq = business.getQuote(loanAmount, null);
		q = wrapLoanQuote(lq);
		
		return q;
	}
	
	
	private LoanQuoteBean wrapLoanQuote(LoanQuote lq) {
		
		q.setLoanAmount(lq.getLoanAmount());
		q.setMonthlyRepayment(lq.getMonthlyRepayment());
		q.setRate(lq.getRate());
		q.setTotalRepayment(lq.getTotalRepayment());
		
		return q;
	}

}
