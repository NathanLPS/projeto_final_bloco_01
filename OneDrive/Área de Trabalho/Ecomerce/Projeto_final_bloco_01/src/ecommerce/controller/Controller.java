package ecommerce.controller;

import ecommerce.model.Produto;
import java.util.ArrayList;
import java.util.Optional;
import ecommerce.repository.Repository;

public class Controller implements Repository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto cadastrado com sucesso!");

	}

	@Override
	public void listarTodas() {
		for (var produto : listaProdutos)
			produto.visualizar();

	}

	@Override
	public void consultarProduto(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.println("Produto não encontrado!");

	}

	@Override
	public void deletarproduto(int id) {
		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			if (listaProdutos.remove(produto.get()) == true) {
				System.out.println("Produto deletado com sucesso!");
			}
		} else {
			System.out.println("Produto não encontrado!");
		}
	}

	@Override
	public void atualizarProduto(Produto produto) {
		Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
		} else {
			System.out.println("Produto não encontrado!");
		}
	}

	public Optional<Produto> buscarNaCollection(int id) {
		for (var x : listaProdutos) {
			if (x.getId() == id) {
				return Optional.of(x);
			}
		}
		return Optional.empty();
	}

	public int gerarId() {
		return ++id;
	}

	public int retornaTipo(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		return produto.get().getTipo();
	}

}
