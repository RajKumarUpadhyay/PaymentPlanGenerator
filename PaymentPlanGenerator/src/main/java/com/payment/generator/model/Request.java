package com.payment.generator.model;

import org.springframework.http.HttpStatus;

import com.payment.generator.exception.ApiException;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Request {
	
    private double loanAmount;
    private double nominalRate;
    private int duration;
    private String startDate;

    public Request() {
    }

    public Request(final double loanAmount, final double nominalRate, final int duration, final String startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.duration = duration;
        this.startDate = startDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getNominalRate() {
        return nominalRate;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void validate() {
        if (this.loanAmount <= 0)
            throw new ApiException("The loan amount is required and cannot be a negative number.",
                    HttpStatus.BAD_REQUEST);

        if (this.nominalRate <= 0)
            throw new ApiException("The nominal rate is required and cannot be a negative number.",
                    HttpStatus.BAD_REQUEST);

        if (this.duration <= 0)
            throw new ApiException("The duration is required and cannot be a negative number.", HttpStatus.BAD_REQUEST);

        if (this.startDate == null || this.startDate.isEmpty())
            throw new ApiException("Please provide the start date.", HttpStatus.BAD_REQUEST);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		long temp;
		temp = Double.doubleToLongBits(loanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nominalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Request other = (Request) obj;
		if (duration != other.duration)
			return false;
		if (Double.doubleToLongBits(loanAmount) != Double.doubleToLongBits(other.loanAmount))
			return false;
		if (Double.doubleToLongBits(nominalRate) != Double.doubleToLongBits(other.nominalRate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
}
