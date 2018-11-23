
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class ListaSimples {
    Scanner leia = new Scanner(System.in);

     private No  primeiro, ultimo;
     private int numero_nos;

    public ListaSimples() {
        primeiro = null;
        ultimo = null;
        numero_nos = 0;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getNumero_nos() {
        return numero_nos;
    }

    public void setNumero_nos(int numero_nos) {
        this.numero_nos = numero_nos;
    }
    
    

    void insere_inicio(Pessoas p) {
        No novoNo = new No(p);
        if (this.eVazia()) {
            this.ultimo = novoNo;
        }
        novoNo.setProx(this.primeiro);
        this.primeiro = novoNo;
        this.numero_nos++;

    }

    public boolean eVazia() {
        return this.primeiro == null;
    }

    public void insere_fim(Pessoas p) {
        No novoNo = new No(p);
        if (this.eVazia()) {
            this.primeiro = novoNo;
        } else {
            this.ultimo.prox = novoNo;
        }
        this.ultimo = novoNo;
        this.numero_nos++;
    }

    public boolean removerNo(String nome) {
        No atual = primeiro;
        No ant = null;
        if (eVazia()) {
            return false;
        } else {
            while ((atual != null) && (!atual.getP().getNome().equals(nome))) {
                ant = atual;
                atual = atual.prox;
            }
            if (atual == this.primeiro) {
                if (this.primeiro == this.ultimo) {
                    this.ultimo = null;
                }
                this.primeiro = this.primeiro.prox;
            } else {
                if (atual == this.ultimo) {
                    this.ultimo = ant;
                }
                ant.setProx(atual.getProx());
            }
        }
        this.numero_nos--;
        return true;
    }

    public String pesquisarNo(String nome) {
        String msg = "";
        No atual = primeiro;
        while ((atual != null) && (!atual.getP().getNome().equals(nome))) {
            atual = atual.getProx();
        }
        return msg = "Nome: " + atual.getP().getNome() + "\n"
                //+ "Sexo: " + atual.getP().getSexo() + "\n"
                + "Telefone: " + atual.getP().getTelefone();
    }

    public String impLista() throws IOException {
        String msg = "";
        if (eVazia()) {
            System.out.println("Lista Vazia");
        }else {
            No temp_no = this.primeiro;
            while (temp_no != null) {
                msg += temp_no.getP().getNome() + " -> ";
                temp_no = temp_no.getProx();
            }
        }
        return msg;
    }
    
    public String impLista2() {
        No atual = primeiro;
         
        String msg = "";
            No ar = primeiro;
            while (ar != null) {
                msg += "Nome: "+ ar.getP().getNome() + " Telefone: " + ar.getP().getTelefone() + " -> ";
                ar = ar.getProx();
            }
        return msg;
    }
    
    public void Salvar() throws IOException{
        Path caminho = Paths.get("C:/Users/Windows 10/arquivo.txt");
        
        int i = 0; 
        byte[] PilhaEmByte = impLista2().getBytes();
        Files.write(caminho, PilhaEmByte);
    }
    
    public void Editar() throws IOException{
        No remove = primeiro;
        Path caminho = Paths.get("C:/Users/Windows 10/arquivo.txt");
        byte[] text = Files.readAllBytes(caminho);
        String texto = new String(text);
        System.out.println(texto);
        System.out.println("-------------------------");
        System.out.println("Deseja altera 1 - SIM  2 - Nao");
        int ler = leia.nextInt();
        
        if(ler == 1){
            
        }
            
    }
}
