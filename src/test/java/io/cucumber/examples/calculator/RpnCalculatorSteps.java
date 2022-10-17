package io.cucumber.examples.calculator;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnCalculatorSteps implements En {

	private RpnCalculator calc;

	public RpnCalculatorSteps() {
		Given("^a calculator I just turned on$", () -> {
			calc = new RpnCalculator();
		});

		When("I add {int} and {int}", (Integer arg1, Integer arg2) -> {
			calc.push(arg1);
			calc.push(arg2);
			calc.push("+");
		});

		Then("the result is {double}", (Double expected) -> assertThat(calc.value()).isEqualTo(expected));

		Before("not @foo", (Scenario scenario) -> {
			scenario.log("Runs before scenarios *not* tagged with @foo");
		});

		After((Scenario scenario) -> scenario.log("After all"));

	}

}
