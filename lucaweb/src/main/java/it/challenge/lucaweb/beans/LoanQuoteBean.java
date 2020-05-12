package it.challenge.lucaweb.beans;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor
@Component
public class LoanQuoteBean {
	
	@Size(min = 1000, max = 15000)
	@Getter @Setter  
	private int loanAmount;
	
	@Getter @Setter  
	private BigDecimal rate;
	
	@Getter @Setter  
	private BigDecimal monthlyRepayment;
	
	@Getter @Setter  
	private BigDecimal totalRepayment;
}
