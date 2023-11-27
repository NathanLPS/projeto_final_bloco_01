package ecommerce.repository;

import ecommerce.model.Produto;

public interface Repository {
	
	//Crud
	public void cadastrar (Produto produto);
	public void listarTodas();
	public void consultarProduto(int id);
	public void deletarproduto(int id);
	public void atualizarProduto(Produto produto);

}
