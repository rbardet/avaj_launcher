package execption;

import simulation.SimulationIO;

public class CustomExecption extends Exception {
	public CustomExecption(String err) {
		super(err);
		SimulationIO.OUTPUT.delete();
	}
}