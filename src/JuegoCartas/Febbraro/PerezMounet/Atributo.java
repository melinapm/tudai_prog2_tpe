package JuegoCartas.Febbraro.PerezMounet;


public class Atributo {

	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor) {
		this.nombre=nombre;
		this.valor= valor;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int valor) {
		this.valor=valor;
	}
	
}
