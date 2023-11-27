package ecommerce.model;

public class Material extends Produto {

	private float peso;

	public Material(int tipo, int id, String nome, float preco, float peso) {
		super(tipo, id, nome, preco);
		this.peso = peso;

	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Quantidade em kg: " + this.peso);
	}
}
