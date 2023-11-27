package ecommerce.model;

public class Ferramenta extends Produto {

	private String material;

	public Ferramenta(int tipo, int id, String nome, float preco, String material) {
		super(tipo, id, nome, preco );
		this.material = material;

	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Material da Ferramenta: " + this.material);

	}
}
