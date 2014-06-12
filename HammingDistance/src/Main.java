
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matrix = "2110;1101";
		HammingDistance test = new HammingDistance(matrix);
		test.show();
		System.out.println("Numero de palabras: "+test.calculateNumWords(matrix));
		System.out.println("Distancia minima de Hamming del codigo C: "+test.getMinimumDistance());
	}

}
