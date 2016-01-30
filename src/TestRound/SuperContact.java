package TestRound;

import tools.Reader;

public class SuperContact {

	public static void main(String[] args) {
		Reader r = new Reader("input_2.txt");
		try {
			System.out.println(r.readWord());
			System.out.println(r.readWord());
			System.out.println(r.readWord());
			System.out.println(r.readWord());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
