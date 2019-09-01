package com.payment.generator.model;

import java.math.BigDecimal;

import com.payment.generator.utils.PaymentUtils;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Response {
    private BigDecimal borrowerPaymentAmount;
    private String date;
    private BigDecimal initialOutstandingPrincipal;
    private BigDecimal interest;
    private BigDecimal principal;
    private BigDecimal remainingOutstandingPrincipal;

    public Response(final PaymentUtils paymentPerMonth) {
        this.borrowerPaymentAmount = paymentPerMonth.getBorrowerPaymentAmount();
        this.date = paymentPerMonth.getDate();
        this.initialOutstandingPrincipal = paymentPerMonth.getInitialOutstandingPrincipal();
        this.interest = paymentPerMonth.getInterest();
        this.principal = paymentPerMonth.getPrincipal();
        this.remainingOutstandingPrincipal = paymentPerMonth.getRemainingOutstandingPrincipal();
    }

    public BigDecimal getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrowerPaymentAmount == null) ? 0 : borrowerPaymentAmount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((initialOutstandingPrincipal == null) ? 0 : initialOutstandingPrincipal.hashCode());
		result = prime * result + ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + ((principal == null) ? 0 : principal.hashCode());
		result = prime * result
				+ ((remainingOutstandingPrincipal == null) ? 0 : remainingOutstandingPrincipal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (borrowerPaymentAmount == null) {
			if (other.borrowerPaymentAmount != null)
				return false;
		} else if (!borrowerPaymentAmount.equals(other.borrowerPaymentAmount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (initialOutstandingPrincipal == null) {
			if (other.initialOutstandingPrincipal != null)
				return false;
		} else if (!initialOutstandingPrincipal.equals(other.initialOutstandingPrincipal))
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (principal == null) {
			if (other.principal != null)
				return false;
		} else if (!principal.equals(other.principal))
			return false;
		if (remainingOutstandingPrincipal == null) {
			if (other.remainingOutstandingPrincipal != null)
				return false;
		} else if (!remainingOutstandingPrincipal.equals(other.remainingOutstandingPrincipal))
			return false;
		return true;
	}
}
