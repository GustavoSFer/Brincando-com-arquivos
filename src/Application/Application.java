package Application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import Entities.Produto;

public class Application {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    List<Produto> produtos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.print("Informe quantos produtos deseja cadastrar: ");
    int qtdProduto = sc.nextInt();

    for (int i = 0; i < qtdProduto; i++) {
      System.out.print("Informe o nome do " + (i + 1) + "ª produto: ");
      String nome = sc.next();

      System.out.print("Informe o preço do " + (i + 1) + "ª produto: ");
      double preco = sc.nextDouble();
      System.out.print("Informe a quantidade em estoque do " + (i + 1) + "ª produto: ");
      int qtdEstoque = sc.nextInt();

      Produto produto = new Produto(nome, preco, qtdEstoque);
      produtos.add(produto);
    }
    String path = "C:\\contato\\out.csv";
    // Salvar no arquivo .csv todos os produtos digitados
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
      for (Produto produto : produtos) {
        System.out.println(produto.getNome());
        bw.write(produto.getNome() + "," + produto.getPreco() + "," + produto.getQtd());
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    sc.close();
  }

}
