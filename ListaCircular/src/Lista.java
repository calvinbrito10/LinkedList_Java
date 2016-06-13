import java.util.Arrays;

public class Lista<T> {

	private No<T> inicio;
	
	private int tamanho;
	
    public Lista() { }
    
    public void inserirNoFim(T dado) {
    	No<T> temp = new No<T>(dado, inicio, null); 

    	if (!aListaEstaVazia()) {
 
           No<T> aux = inicio; 
           while (aux != null) {
        	   if (!aux.temProximo()) break;
        	   else aux = aux.getProximo();
           }
           temp.setAnterior(aux);
           aux.setProximo(temp);
    	} else { inicializarLista(temp); }
        
        this.setTamanho(this.getTamanho()+1);
    }

    public void inserirNoComeco(T dado) {        
    	No<T> temp = new No<T>(dado, null, inicio); 
        
    	if (!aListaEstaVazia()) inicio = temp;
    	else inicializarLista(temp);
    	
        this.setTamanho(this.getTamanho()+1);
    }
    
    private void inicializarLista(No<T> nodo) {
    	inicio = nodo;
    }
    
    public T remover(int pos) {			
        No<T> temp = buscar(pos);
        
        if (temp == null) return null;
        else remover(temp);
        

        return temp.getDado();
    }
    
    
    public void remover(No<T> nodo) {
    	if (nodo == null || inicio == null) {
    		System.out.println("Elemento foi não encontrado");
    		return;
    	}
    	
        if (nodo.getDado() == inicio.getDado()) {
        	inicio = nodo.getProximo();
        	nodo.setAnterior(null);
        } else {
        	if (nodo.temAnterior()) nodo.getAnterior().setProximo(nodo.getProximo());
        	if (nodo.temProximo()) nodo.getProximo().setAnterior(nodo.getAnterior());
        }
        nodo.setAnterior(null);
        nodo.setProximo(null);
        
        this.setTamanho(this.getTamanho()-1);
    }

    public No<T> buscar(T dado) {
    	No<T> temp = inicio;
        
    	while (temp != null) {
    		if (temp.getDado() == dado) break;
    		else if (!temp.temProximo()) break;
    		else temp = temp.getProximo();
        }
        
        if (temp != null && temp.getDado() == dado) return temp;
        else return null;
    }
    
    public No<T> buscar(int posicao) {
        No<T> temp = inicio;
        
        if (aListaEstaVazia()) return null;
        
        for (int i = 0; i < posicao; i++) {
        	if (!temp.temProximo()) break;
        	else temp = temp.getProximo();
		}
        
        if (temp != null) return temp;
        else return null;
    }
    
    public void exibirLista() {
        No<T> temp = inicio;
        
        StringBuilder biulder = new StringBuilder();
        while (temp != null) {
        	biulder.append(String.format("%s@", temp.toString()));
            temp = temp.getProximo();
        }
        String[] array = biulder.toString().split("@");
        System.out.println(Arrays.toString(array));
    }
    
    private boolean aListaEstaVazia() {
    	return inicio == null;
    }

	public int getTamanho() {
		return tamanho;
	}

	private void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
