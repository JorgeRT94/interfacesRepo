
public class Coche {

	int id, potencia;
	String marca, modelo;

	public Coche(int id, String marca, String modelo, int potencia) {
		super();
		this.id = id;
		this.potencia = potencia;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Coche () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", potencia=" + potencia + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}
