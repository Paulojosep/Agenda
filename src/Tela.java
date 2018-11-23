
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Tela {

    public static char menu() {
        String msg;
        System.out.println("---------------------------");
        System.out.println("--- Escolha Opcao --------");
        System.out.println("---------------------------");
        System.out.println("1. Inserir no Inicio");
        System.out.println("2. Inserir no Final");
        System.out.println("3. Localizar Pessoa");
        System.out.println("4. Excluir Pessoa");
        System.out.println("5. Imprimir a Lista");
        System.out.println("6. Quantidade de Pessoa");
        System.out.println("7. Salvar no arquivo");
        System.out.println("8. Editar arquivo");
        System.out.println("0. Sair");
        System.out.println("------------------------------");
        msg = new Scanner(System.in).next();
        return msg.charAt(0);
    }

    public static void main(String[] args) {
        ArrayList<ListaSimples> arquivo = new ArrayList();

        Scanner leia = new Scanner(System.in);
        ListaSimples lista = new ListaSimples();
        //Pessoas p = new Pessoas();
        Pessoas p = null;
        
        Path caminho = Paths.get("C:/Users/Windows 10/arquivo.txt");

        char opcao;

        try {

            do {
                opcao = menu();
                switch (opcao) {
                    case '1':
                        System.out.println("------ Inserir no inicio da Lista--------");
                        p = new Pessoas();
                        System.out.print("Nome: ");
                        p.setNome(leia.next());
                        //System.out.print("Sexo: ");
                        //p.setSexo(leia.next());
                        System.out.print("Telefone: ");
                        p.setTelefone(leia.nextInt());
                        lista.insere_inicio(p);
                        break;

                    case '2':
                        System.out.println("------ Inserir no Final da Lista--------");
                        p = new Pessoas();
                        System.out.print("Nome: ");
                        p.setNome(leia.next());
                        //System.out.print("Sexo: ");
                        //p.setSexo(leia.next());
                        System.out.print("Telefone: ");
                        p.setTelefone(leia.nextInt());
                        lista.insere_fim(p);
                        break;

                    case '3':
                        if (lista.eVazia()) {
                            System.out.println("Lista Vazia");
                        } else {
                            System.out.println("Localizar pessoa\nDigite o nome: ");
                            String nome = leia.next();
                            if (lista.pesquisarNo(nome) == null) {
                                System.out.println("Não Encontrada na lista");
                            } else {
                                System.out.println("::::: Encontrada :::::");
                                System.out.println(lista.pesquisarNo(nome));
                                System.out.println("::::::::::::::::::::::");
                            }
                        }
                        break;

                    case '4':
                        if (lista.eVazia()) {
                            System.out.println("Lista Vazia");
                        } else {
                            System.out.println("Exclir Pessoa\nDigite o nome: ");
                            String nome = leia.next();
                            if (lista.removerNo(nome)) {
                                System.out.println(nome + "foi removido com sucesso");
                            } else {
                                System.out.println("Nao foi possivel remver " + nome);
                            }
                        }
                        break;

                    case '5':
                        System.out.println("--------------------");
                        System.out.println("Lista: " + lista.impLista());
                        System.out.println("--------------------");
                        break;

                    case '6':
                        System.out.println("A Lista contem: " + lista.getNumero_nos() + " pessoas");
                        break;

                    case '7':
                        System.out.println("--------------------");
                        System.out.println("Salvo");
                        lista.Salvar();
                        System.out.println("---------------------");
                        break;
                    
                    case '8':
                        System.out.println("-------- Editar Arquivo ---------");
                        lista.Editar();
                        
                        break;
                }
            } while (opcao != '0');
            System.exit(0);
        } catch (Exception ERRO) {

        }
    }

}
