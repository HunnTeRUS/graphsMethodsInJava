package depthFirstSearch;

public class Edges {
    private int value;

    private Edges edgesDad;
    private Edges edgesLeft;
    private Edges edgesRight;

    public Edges(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Edges getEdgesLeft() {
        return edgesLeft;
    }

    public void setEdgesLeft(Edges edgesLeft) {
        this.edgesLeft = edgesLeft;
        this.edgesLeft.setEdgesDad(this);
    }

    public Edges getEdgesRight() {
        return edgesRight;
    }

    public void setEdgesRight(Edges edgesRight) {
        this.edgesRight = edgesRight;
        this.edgesRight.setEdgesDad(this);
    }

    public Edges getEdgesDad() {
        return edgesDad;
    }

    public void setEdgesDad(Edges edgesDad) {
        this.edgesDad = edgesDad;
    }
}
