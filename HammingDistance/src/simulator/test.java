package simulator;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String c = "1111;0000;1100;0011";
		Simulator simulator = new Simulator(c);
		simulator.simulateWords(10);
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println(simulator.getpercentageOk());
	}

}
