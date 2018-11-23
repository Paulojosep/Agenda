public class No {
    public Pessoas p;
    int valor;
    public No prox;
    
    public No(Pessoas pe){
        this.p = pe;
        this.prox = null;
        
    }

    public Pessoas getP() {
        return p;
    }

    public void setP(Pessoas p) {
        this.p = p;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
    

}
