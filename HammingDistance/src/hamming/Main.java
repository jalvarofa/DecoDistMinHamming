package hamming;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matrix = "1111;0000;1100;0011";
		HammingDistance test = new HammingDistance(matrix);
		test.show();
		System.out.println(test.decoderAuto("0001"));
		System.out.println("Numero de palabras: "+test.calculateNumWords(matrix));
		System.out.println("Distancia minima de Hamming del codigo C: "+test.getMinimumDistance());
	}

}
