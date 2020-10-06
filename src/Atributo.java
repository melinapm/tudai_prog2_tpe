

public class Atributo {

	private String nombre;
	private int valor;
	
	public Atributo(String nuevoNombre, int nuevoValor) {
		this.nombre=nuevoNombre;
		this.valor= nuevoValor;
	}
	
	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int nuevoValor) {
		this.valor=nuevoValor;
	}
	
}
