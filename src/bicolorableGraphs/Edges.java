package bicolorableGraphs;

public class Edges {
    public int n1;

    public int n2;

    public int pintadoOuNao;

    public Edges(){}

    public Edges(int n1, int n2, int pintadoOuNao){
        this.n1 = n1;
        this.n2 = n2;
        this.pintadoOuNao = pintadoOuNao;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getPintadoOuNao() {
        return pintadoOuNao;
    }

    public void setPintadoOuNao(int pintadoOuNao) {
        this.pintadoOuNao = pintadoOuNao;
    }
}
