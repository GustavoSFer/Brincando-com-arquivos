package Application;

import java.io.BufferedReader;
import java.io.FileReader;
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

    String path = "C:\\contato\\out.csv";
    // Salvar no arquivo .csv todos os produtos digitados
    // try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
    //
    // for (int i = 0; i < qtdProduto; i++) {
    // System.out.print("Informe o nome do " + (i + 1) + "ª produto: ");
    // String nome = sc.next();
    //
    // System.out.print("Informe o preço do " + (i + 1) + "ª produto: ");
    // double preco = sc.nextDouble();
    // System.out.print("Informe a quantidade em estoque do " + (i + 1) + "ª produto: ");
    // int qtdEstoque = sc.nextInt();
    //
    // bw.write(nome + "," + preco + "," + qtdEstoque);
    // bw.newLine();
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    // Realizando a escrita das informaçoes na saida do sistema.
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();
      while (line != null) {
        String[] produtoLinha = line.split(",");
        // Colocando apenas para saber de como imprimir para ver como esta ficando
        // System.out.println(Arrays.toString(produtoLinha));
        String nomeProduto = produtoLinha[0];
        Double precoProduto = Double.parseDouble(produtoLinha[1]);
        Integer qtd = Integer.parseInt(produtoLinha[2]);

        Produto produto = new Produto(nomeProduto, precoProduto, qtd);
        produtos.add(produto);
        line = br.readLine();
      }

      System.out.println("\n== LISTA DE PRODUTOS ==\n");
      for (Produto p : produtos) {
        System.out.println("Produto: " + p.getNome() + ", R$: " + p.getPreco() + ", Quantidade: "
            + p.getQtd() + " Valor total: " + p.getPriceTotal());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    sc.close();
  }

}
