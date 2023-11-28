package ecommerce;

import java.io.IOException;
import java.util.Scanner;

import ecommerce.controller.Controller;
import ecommerce.model.Ferramenta;
import ecommerce.model.Material;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		Controller produtos = new Controller();

		int opcao;
		int id, tipo, peso;
		String nome, material;
		float preco;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                   Tonhão Materiais                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar produto                    ");
			System.out.println("            2 - Listar todas os Produtos             ");
			System.out.println("            3 - Buscar produto por ID                ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Deletar Produto                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nTonhão Materiais- Sua contrução é aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Cadastrar Produto\n\n");

					System.out.println("Digite o o tipo de Produto (1-Ferramenta 2-Material");
					tipo = leia.nextInt();
					System.out.println("Nome do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					System.out.println("Digite o preço do produto: ");
					preco = leia.nextFloat();
					switch (tipo) {
						case 1 -> {

							System.out.print("Digite o material da ferramenta (Madeira, Metal) ");
							leia.skip("\\R?");
							material = leia.nextLine();
							produtos.cadastrar(new Ferramenta(produtos.gerarId(), tipo, nome, preco, material));

						}
						case 2 -> {
							System.out.print("Digite o Peso: ");
							peso = leia.nextInt();
							produtos.cadastrar(new Material(produtos.gerarId(), tipo, nome, preco, peso));
						
						}
				}
						keyPress();
				break;

			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				produtos.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println("Buscar Produto por ID\n\n");
				System.out.print("Digite o ID do produto: ");
				id = leia.nextInt();
				produtos.consultarProduto(id);
				keyPress();

				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");
				System.out.print("Digite o ID do produto: ");
				id = leia.nextInt();

				if (produtos.buscarNaCollection(id).isPresent()) {
					System.out.println("Digite os novos dados do produto: \n");

					System.out.print("Digite o nome do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.print("Digite o preço do produto: ");
					preco = leia.nextFloat();

					tipo = produtos.retornaTipo(id);

					switch (tipo) {
					case 1:
						System.out.print("Digite o material da ferramenta (Madeira, Metal): ");
						leia.skip("\\R?");
						material = leia.nextLine();
						produtos.atualizarProduto(new Ferramenta(id, tipo, nome, preco, material));
						break;
					case 2:
						System.out.print("Digite o Peso: ");
						leia.skip("\\R?");
						peso = leia.nextInt();
						produtos.atualizarProduto(new Material(id, tipo, nome, preco, peso));
						break;

					}
				}

				keyPress();
				break;
			case 5:
				System.out.println("Deletar Produto\n\n");
				System.out.print("Digite o ID do produto: ");
				id = leia.nextInt();
				produtos.consultarProduto(id);
				leia.skip("\\R?");
				produtos.deletarproduto(id);

				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println("\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
