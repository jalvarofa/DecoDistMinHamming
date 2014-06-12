
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2110;1101";
		HammingDistance test = new HammingDistance(s, 2);
		test.show();
		System.out.println(test.numWords(s));
		System.out.println(test.getMinimumDistance());
	}

}
