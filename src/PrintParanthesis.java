//Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
//To Update: this paranthesis should put in array list
public class PrintParanthesis {
	PrintParanthesis() { }
	
	static void create_valid_Par(int n) {
	 char leftPar = '(';
	 char rightPar = ')';
	 char par[] = new char[2*n];
	 for (int i = 0; i < n; i++) {
		 par[i] = leftPar;
	 }
	 for (int j = n; j < 2*n; j++) {
		 par[j] = rightPar;
	 }
	 swap_par( 1 , par);
	}
	 
	private static void swap_par(int k, char par[]) {
		for ( int i = k; i < par.length - 2; i++) {
			for ( int j = i+1; j < par.length - 1; j++) {
				char tmp = par[j];
				par[j] = par[j+1];
				par[j+1] = tmp;	
			}
			for (int m = 0; m < par.length; m++) {
			System.out.println("valid paranthesis: "+par[m]);
			}
		}
	}

	public static void main(String[] args) {
		create_valid_Par(4);
		
	}

}
