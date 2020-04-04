package depthFirstSearch;

import java.util.Stack;

public class DeptFirstSearchMain {

    private Stack<Edges> stack;

    private Edges EdgesAtual;

    private int valorBusca;

    private String response;

    public static void main(String[] args) {
        //vertexs in the graph
        Edges edges0 = new Edges(0);
        Edges edges1 = new Edges(1);
        Edges edges2 = new Edges(2);
        Edges edges3 = new Edges(3);
        Edges edges4 = new Edges(4);
        Edges edges5 = new Edges(5);
        Edges edges6 = new Edges(6);

        //Ramifications
        edges0.setEdgesLeft(edges1);
        edges0.setEdgesRight(edges2);

        edges1.setEdgesLeft(edges3);
        edges1.setEdgesRight(edges4);

        edges2.setEdgesLeft(edges5);
        edges2.setEdgesRight(edges6);

        //Number to find
        DeptFirstSearchMain dfsm = new DeptFirstSearchMain(4);

        dfsm.buscar(edges0);
    }

    public DeptFirstSearchMain(int valorBusca) {

        this.stack = new Stack<Edges>();
        this.valorBusca = valorBusca;
    }

    public boolean isResultadoBusca(Edges edges) {
        return edges.getValue() == valorBusca;
    }

    public boolean buscar(Edges edges) {
        this.stack.add(edges);
        if (isResultadoBusca(edges)) {
            //Show the trail
            exibirResultado(edges);
            return true;
        } else {
            //expand left and right trails
            if (edges.getEdgesLeft() != null && this.buscar(edges.getEdgesLeft())) {
                //Has on left
                return true;
            }
            if (edges.getEdgesRight() != null && this.buscar(edges.getEdgesRight())) {
                //Has on right
                return true;
            }
        }
        this.stack.pop();
        return false;
    }

    public void exibirResultado(Edges edge) {
        String returnText = "";

        Edges edgeValue = edge;

        returnText += edge.getValue();

        while (edgeValue.getEdgesDad() != null) {
            edgeValue = edgeValue.getEdgesDad();
            returnText = edgeValue.getValue() + " " + returnText;
        }

        this.response = returnText;

        if (response != null || response != "")
            System.out.println("Trail: " + this.response);
        else
            System.out.println("Edgest Found a valid trail");
    }

}
