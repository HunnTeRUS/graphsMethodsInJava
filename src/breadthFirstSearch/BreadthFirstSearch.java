package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private Queue<Edges> queue;
    private String response;
    private int searchValue;

    public BreadthFirstSearch(int searchValue) {
        this.queue = new LinkedList<Edges>();
        this.searchValue = searchValue;
    }

    public static void main(String[] args) {
        Edges edges0 = new Edges(0);
        Edges edges1 = new Edges(1);
        Edges edges2 = new Edges(2);
        Edges edges3 = new Edges(3);
        Edges edges4 = new Edges(4);

        edges0.setEdgesLeft(edges1);
        edges0.setEdgesRight(edges3);

        edges1.setEdgesLeft(edges2);

        edges3.setEdgesLeft(edges2);
        edges3.setEdgesRight(edges4);

        BreadthFirstSearch bep = new BreadthFirstSearch(2);

        bep.searchResultsByEdge(edges0);
    }

    public boolean isResultValue(Edges edge) {
        return edge.getValue() == searchValue;
    }


    public boolean searchResultsByEdge(Edges edge) {

        if (isResultValue(edge)) {
            showResult(edge);
            return true;
        } else {
            //If is'nt result
            //Add edges to the queue
            if (edge.getEdgesLeft() != null) {
                this.queue.add(edge.getEdgesLeft());
            }
            if (edge.getEdgesRight() != null) {
                this.queue.add(edge.getEdgesRight());
            }

            Edges edgeEnd = this.queue.poll();

            if (edgeEnd != null && searchResultsByEdge(edgeEnd)) {
                return true;
            }
        }

        return false;
    }

    public void showResult(Edges edge) {
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
