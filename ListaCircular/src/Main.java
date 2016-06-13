import java.util.Random;

public class Main {
	
	private static final String[] pessoas = {
			"Lucas Kauer", "Castiçal", "Cruela", "Cartenha", "Juliãna", "Monekids", "Guilherme Autista",
			"Tiago Autista", "Tiagão", "Agnaldo", "Rodrigo Remor", "Monica (sem) Py", "Cantu", "Alexandra",
			"Filipe", "Mariãna", "Jesus", "Gabriel Mostarda", "André", "Marcelino Pão e Vinho", "Pedro",
			"Messias", "Osias", "Marcos", "Vinicius", "Joãozinho e suas 2016 caixas", "Márcia Chultes"
			};

	private static final Random aleatorio = new Random();
	
	public static void main(String[] argv) 
	{
		Lista<String> r;
		r = josephus(8, 3);
	    System.out.printf("X %s foi x único que sobreviveu\n", r.buscar(r.getTamanho()-1).getDado());
	}
 
	private static Lista<String> josephus(int N, int M) {
		return josephus(N, M, 1);
	}
	
	private static Lista<String> josephus(int N, int M, int comeco)
	{
	    if (N < 1 || M < 1 || comeco < 1) return null;

	    Lista<String> pessoinhas = new Lista<String>();
	    for (int i = 0; i < N; i++) {
	    	
	    	boolean podeInserir = false;
	    	while (!podeInserir) {
		    	String pessoa = pessoas[aleatorio.nextInt(pessoas.length)];
	    		podeInserir = pessoinhas.buscar(pessoa) == null;
	    		
	    		if (podeInserir) pessoinhas.inserirNoFim(pessoa);
	    		else pessoa = pessoas[aleatorio.nextInt(pessoas.length)];
	    	}
	    }
	    
	    Lista<String> r = new Lista<String>();
	    for (int j = N, i = (comeco - 2) % N; j > 0; j--) {
		    pessoinhas.exibirLista();
	        i = (i + M) % N--;
	        r.inserirNoFim(pessoinhas.remover(i--));
	    }
	    return r;
	}
}
