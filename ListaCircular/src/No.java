
public class No<T> {
	
	private T dado;
	private No<T> anterior, proximo;
	
	public No(T dado, No<T> anterior, No<T> proximo) {
		this.setDado(dado);
		this.setAnterior(anterior);
		this.setProximo(proximo);
	}
	
	public boolean temAnterior()
	{
		return this.getAnterior() != null;
	}
	
	public boolean temProximo()
	{
		return this.getProximo() != null;
	}
	
	public T getDado() {
		return this.dado;
	}
	
	public void setDado(T dado) {
		this.dado = dado;
	}

	public No<T> getAnterior() {
		return this.anterior;
	}

	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	
	public No<T> getProximo() {
		return this.proximo;
	}
	
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {						 
		if (this.getDado() == null) return "<EMPTY>";
		else return this.getDado().toString();
	}
}
