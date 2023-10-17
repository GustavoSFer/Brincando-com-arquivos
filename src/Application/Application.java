package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entities.Produto;

public class Application {

  public static void main(String[] args) {
    List<Produto> produtos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.print("Informe quantos produtos deseja cadastrar: ");
    int qtdProduto = sc.nextInt();

    for (int i = 0; i < qtdProduto; i++) {
      System.out.print("Informe o nome do " + (i + 1) + "ª produto: ");
      String nome = sc.nextLine();
      System.out.print("Informe o preço do " + (i + 1) + "ª produto: ");
      double preco = sc.nextDouble();
      System.out.print("Informe a quantidade em estoque do " + (i + 1) + "ª produto: ");
      int qtdEstoque = sc.nextInt();

      Produto produto = new Produto(nome, preco, qtdEstoque);
      produtos.add(produto);
    }
    sc.close();
  }

}
