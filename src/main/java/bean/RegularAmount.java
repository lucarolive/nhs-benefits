package bean;

import javax.validation.constraints.NotNull;

import annotation.Frequency;
import validator.FrequencyAmount;

@FrequencyAmount
public class RegularAmount {
	
	@NotNull
	private Frequency frequency;
	
	@NotNull
	private String amount;
	
	public Frequency getFrequency() {
		return frequency;
	}
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public RegularAmount(@NotNull Frequency frequency,
			@NotNull String amount) {
		super();
		this.frequency = frequency;
		this.amount = amount;
	}
	
	
}
