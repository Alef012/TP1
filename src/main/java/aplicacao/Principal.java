package aplicacao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Produto;

/**
 * @author Felipe Álef
 */
public class
Principal {

    private static ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    private static ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    /*
    A exibeMenu apresenta o menu ao usuário e retorna a opção desejada
     */

    private static int exibeMenu() {
        String menu = "                 *** MENU ***\n"
                + "1-Cadastrar novo cliente.\n"
                + "2- Buscar cliente\n"
                + "3-Cadastrar novo produto\n"
                + "4-Buscar novo produto\n"
                + "5-Cadastrar venda\n"
                + "6-Mostrar produtos em estoque\n"
                + "7-Sair";
        String StrOpcao = JOptionPane.showInputDialog(null, menu);
        int opcao = Integer.parseInt(StrOpcao);
        return opcao;
    }

    private static void cadastrarCliente() {
        int numeroDeCadastro = 0;
        String quantidade = JOptionPane.showInputDialog(null, "Digite o número de clientes a ser cadastrado");
        numeroDeCadastro = Integer.parseInt(quantidade);
        for (int i = 0; i < numeroDeCadastro; i++) {
            Cliente cliente = new Cliente();

            String nome = JOptionPane.showInputDialog(null, "Digite o nome do Cliente " + (i + 1) + " : ");
            String endereco = JOptionPane.showInputDialog(null, "Digite o endereço do Cliente " + (i + 1) + " : ");
            String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do Cliente " + (i + 1) + " : ");

            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setTelefone(telefone);

            listaDeClientes.add(cliente);
        }

    }

    private static Cliente buscaCliente(String nome) {
        int numeroDeAchados = 0;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i).getNome().equalsIgnoreCase(nome)) {
                numeroDeAchados++;
                return listaDeClientes.get(i);
            }
        }
        if (numeroDeAchados == 0) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
        return null;
    }

    private static void cadastrarProduto() {
        int numeroDeCadastro = 0;
        String quantidade = JOptionPane.showInputDialog(null, "Digite o número de produtos a ser cadastrado");
        numeroDeCadastro = Integer.parseInt(quantidade);
        for (int i = 0; i < numeroDeCadastro; i++) {
            Produto produto = new Produto();

            String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto " + (i + 1) + " : ");
            String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do produto " + (i + 1) + " :");
            String valorDaCompra = JOptionPane.showInputDialog(null, "Digite o valor de compra " + (i + 1) + " : ");
            String porLucro = JOptionPane.showInputDialog(null, "Digite a porcentagem de lucro " + (i + 1) + " : ");
            String quantidadeEstoque = JOptionPane.showInputDialog(null, "Digite a quantidade em estoque " + (i + 1) + " : ");

            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setValorDeCompra(Double.parseDouble(valorDaCompra));
            produto.setPorcentagemDeLucro(Double.parseDouble(porLucro));
            produto.setQuantidade(Integer.parseInt(quantidadeEstoque));

            listaDeProdutos.add(produto);
        }

    }

    private static Produto buscaProduto(String nome) {

        int numeroDeAchados = 0;

        for (int i = 0; i < listaDeProdutos.size(); i++) {
            if (listaDeProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
                numeroDeAchados++;
                return listaDeProdutos.get(i);
            }
        }
        if (numeroDeAchados == 0) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;
        }
        return null;
    }

    public static void cadastrarVendas() {
        JOptionPane.showMessageDialog(null, "A seguir será apresentada uma lista de clientes\n"
                + ".Escolha um para registrar a venda;");
        String nomeCliente = JOptionPane.showInputDialog(null, listaDeClientes + "\n\nDigite o Nome do cliente: \n");
        if (listaDeClientes.contains(buscaCliente(nomeCliente))) {
            int sair = 0;
            do {

                String nome = JOptionPane.showInputDialog(null, mostraProdutosEmEstoque()+ "\n\nDigite o nome do produto que deseja registrar venda: \n");
                if (listaDeProdutos.contains(buscaProduto(nome))) {
                    String quantidade = JOptionPane.showInputDialog(null, "Digite a quantidade de produto comprada");
                    buscaProduto(nome).setQuantidade(buscaProduto(nome).getQuantidade() - Integer.parseInt(quantidade));
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um produto da lista");
                }
                int Sair = JOptionPane.showConfirmDialog(null,"Deseja continuar cadastrando ?");
            } while (sair != 0);
        } else {
            JOptionPane.showInputDialog(null, "Digite um cliente da lista!");
        }

    }

    private static String mostraProdutosEmEstoque() {
        String lista = "";
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            lista += listaDeProdutos.get(i).getNomeEestoque();
        }
        JOptionPane.showMessageDialog(null, lista);
        return lista;
    }

    public static void facilitaCorrecao() {
        Cliente c1 = new Cliente("Felipe", "Brasília", "888 1231");
        Cliente c2 = new Cliente("Lucas", "Belo Horizonte", "(61) 888 1232");
        Cliente c3 = new Cliente("Maria", "Recife", "888 1233");
        Cliente c4 = new Cliente("Amanda", "Cuiabá", "888 1234");
        Cliente c5 = new Cliente("Paulo", "Fortaleza", "888 1235");
        Cliente c6 = new Cliente("Mariana", "Florianópolis", "888 1236");
        Cliente c7 = new Cliente("Pedro", "Curitiba", "888 1237");
        Cliente c8 = new Cliente("Mateus", "Porto Alegre", "888 1238");
        Cliente c9 = new Cliente("Igor", "São Paulo", "888 1239");
        Cliente c10 = new Cliente("Luís", "Rio de Janeiro", "888 1210");

        listaDeClientes.add(c1);
        listaDeClientes.add(c2);
        listaDeClientes.add(c3);
        listaDeClientes.add(c4);
        listaDeClientes.add(c5);
        listaDeClientes.add(c6);
        listaDeClientes.add(c7);
        listaDeClientes.add(c8);
        listaDeClientes.add(c9);
        listaDeClientes.add(c10);

        Produto p1 = new Produto("tenis de corrida", "Versátil e ultraconfortável para a academia"
                + ", treinos leves de corrida, caminhada ou mesmo ocasiões casuais", 249.9, 70, 31);
        Produto p2 = new Produto("colchonete de academia", "Fabricado em material resistente e enchimento em espuma", 79.9, 40, 45);
        Produto p3 = new Produto("camisa do vasco da gama", "camisa do gigantesco da colina", 252.99, 100, 55);
        Produto p4 = new Produto("bola society", " Sem Costuras, Garante Menor Absorção De Água E Melhor Toque De Bola.", 148.99, 60, 55);
        Produto p5 = new Produto("chuteira de campo", "Chuteira leve que ajuda muito com a precisão do chute", 224.9, 80, 20);
        Produto p6 = new Produto("mascara de proteção", "Facilidade em colocar no rosto com ajuste de tamanho feche silicone", 20, 90, 500);
        Produto p7 = new Produto("mala 60 litros", "Espaçosa e funcional, a Mala 60 Litros é uma ótima opção para carregar "
                + "os pertences pessoais nos treinos esportivos", 189.9, 80, 78);
        Produto p8 = new Produto("bone aba curva", "onfeccionado em poliéster, o Boné possui aba curva que oferece proteção contra os raios solares", 59.99, 57, 56);
        Produto p9 = new Produto("halter sextavado", "Halter Sextavado Yangfit Emborrachado - 5kg", 144.5, 95, 60);
        Produto p10 = new Produto("saco de pancada profissional", "Confeccionado em lona sintética de alta resistência", 189.98, 77, 88);

        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);
        listaDeProdutos.add(p4);
        listaDeProdutos.add(p5);
        listaDeProdutos.add(p6);
        listaDeProdutos.add(p7);
        listaDeProdutos.add(p8);
        listaDeProdutos.add(p9);
        listaDeProdutos.add(p10);


    }

    public static void main(String[] args) {
        int opcao;
        facilitaCorrecao();
        do {
            opcao = exibeMenu();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    String cliente = JOptionPane.showInputDialog(null, "Digite o nome do cliente a ser buscado");
                    Cliente qualquer = buscaCliente(cliente);
                    if(qualquer == null){
                        break;
                    }
                    JOptionPane.showMessageDialog(null, qualquer);
                   int alteracao = JOptionPane.showConfirmDialog(null,"Gostaria de alterar os dados do cliente ?");
                   if(alteracao == 1 ||alteracao == 2){
                       break;
                   }else {

                       String modificaCliente = JOptionPane.showInputDialog(null, "Digite 1 para modificar o nome;\n"
                               + "Digite 2 para modificar o endereço;\n"
                               + "Digite 3 para modificar o telefone;\n");
                       alteraDadosCliente(Integer.parseInt(modificaCliente), qualquer);
                   }
                    break;
                case 3:
                    cadastrarProduto();
                    break;
                case 4:
                    String produto = JOptionPane.showInputDialog(null, "Digite o nome do produto a ser buscado");
                    buscaProduto(produto);
                    Produto qualquer2 = buscaProduto(produto);
                    if(qualquer2 == null){
                        break;
                    }
                    JOptionPane.showMessageDialog(null, qualquer2);
                    int alteracao2 = JOptionPane.showConfirmDialog(null,"Gostaria de alterar os dados do produto?");
                    if(alteracao2 == 1 ||alteracao2 == 2){
                        break;
                    }else {

                        String modificaProduto = JOptionPane.showInputDialog(null, "Digite 1 para modificar o nome;\n"
                                + "Digite 2 para modificar a descrição;\n"
                                + "Digite 3 para modificar o valor de compra;\n"
                                + "Digite 4 para modificar a porcentagem de lucro;\n"
                                + "Digite 5 para modificar a quantidade em estoque;\n");
                        alteraDadosProduto(Integer.parseInt(modificaProduto), qualquer2);
                    }
                    break;
                case 5:
                    cadastrarVendas();
                    break;
                case 6:
                    mostraProdutosEmEstoque();
                    break;
                case 7:
                    break;
            }

        }
        while (opcao != 7);
    }

    private static void alteraDadosCliente(int opcao, Cliente cliente) {
        //opcao 1 -> modifica nome
        //opcao 2-> modifica endereco
        //opcao 3-> modifica telefone
        switch (opcao) {
            case 1:
                String nome = JOptionPane.showInputDialog(null, "Digite o novo nome para o cliente");
                cliente.setNome(nome);
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                break;
            case 2:
                String endereco = JOptionPane.showInputDialog(null, "Digite o novo endereço para o cliente");
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                cliente.setEndereco(endereco);
                break;
            case 3:
                String telefone = JOptionPane.showInputDialog(null, "Digite o novo telefone para o cliente");
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                cliente.setTelefone(telefone);
                break;
        }
    }
    private static void alteraDadosProduto(int opcao,Produto produto) {
        //opcao 1 -> modifica nome
        //opcao 2-> modifica descrição
        //opcao 3-> modifica valor de compra
        //opcao 4 -> porcentagem de lucro
        //opcao 5 -> Quantidade em estoque
        switch (opcao) {
            case 1:
                String nome = JOptionPane.showInputDialog(null, "Digite o novo nome para o produto");
                produto.setNome(nome);
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                break;
            case 2:
                String descricao = JOptionPane.showInputDialog(null, "Digite uma nova Descrição para o produto: ");
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                produto.setDescricao(descricao);
                break;
            case 3:
                String valorDeCompra = JOptionPane.showInputDialog(null, "Digite o novo valor de compra do produto");
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                produto.setValorDeCompra(Double.parseDouble(valorDeCompra));
                break;
            case 4:
                String porcentagemDeLucro = JOptionPane.showInputDialog(null, "Digite a nova porcentagem de lucro do produto");
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                produto.setPorcentagemDeLucro(Double.parseDouble(porcentagemDeLucro));
                break;
            case 5:
                String quantidade = JOptionPane.showInputDialog(null, "Digite a nova quantidade em estoque do produto");
                JOptionPane.showMessageDialog(null, "O dado foi alterado no sistema!");
                produto.setQuantidade(Integer.parseInt(quantidade));
                break;
            default:
                break;
        }
    }

    }
