package bicolorableGraphs;

import java.util.ArrayList;
import java.util.List;

public class bicolorMainClass {
    public static List<Integer> verticesPintados = new ArrayList<Integer>();

    public static void main(String[] args) {
        List<Edges> lista = getValores();

        /*
            - Check if the incident is already in the list, if it is, it only sets the painted value of that object in the list as N1

            - If not, it sets the emerging as painted and adds it to the list

            - Checks whether the incident of the previous object is painted, if it is, it paints the emerging of the current value

            - If it is not painted, it means that the emerging from the previous object is painted and then, it does nothing and only moves on to the next
         */

        for(int i = 0; i<lista.size(); i++) {
            if (i - 1 < 0) {
                lista.get(i).setPintadoOuNao(lista.get(i).getN1());
                verticesPintados.add(lista.get(i).getN1());
            }

            else {
                if(hasInList(lista.get(i).getN1())) {
                    lista.get(i).setPintadoOuNao(lista.get(i).getN1());
                }
                else if(!hasInList(lista.get(i).getN1())) {
                    lista.get(i).setPintadoOuNao(lista.get(i).getN2());
                    if(hasInList(lista.get(i).getN2()) == false)
                        verticesPintados.add(lista.get(i).getN2());
                }

                else if(itspainted(lista.get(i-1)) == lista.get(i-1).getN1()){
                    lista.get(i).setPintadoOuNao(lista.get(i).getN2());
                    if(hasInList(lista.get(i).getN2()) == false)
                        verticesPintados.add(lista.get(i).getN2());
                }

                else if(itspainted(lista.get(i-1)) == lista.get(i).getN1()){
                    continue;
                }
            }
        }

        for(int i = 0; i<verticesPintados.size(); i++) {
            System.out.println("Black: " + verticesPintados.get(i));
        }
    }

    public static List<Edges> getValores(){
        List<Edges> listaEdges = new ArrayList<>();

        listaEdges.add(new Edges(0, 1, 0));
        listaEdges.add(new Edges(0, 3, 0));
        listaEdges.add(new Edges(0, 5, 0));
        listaEdges.add(new Edges(1, 2, 0));
        listaEdges.add(new Edges(1, 4, 0));
        listaEdges.add(new Edges(1, 6, 0));
        listaEdges.add(new Edges(2, 5, 0));
        listaEdges.add(new Edges(2, 7, 0));
        listaEdges.add(new Edges(3, 4, 0));
        listaEdges.add(new Edges(3, 8, 0));
        listaEdges.add(new Edges(3, 6, 0));
        listaEdges.add(new Edges(4, 5, 0));
        listaEdges.add(new Edges(4, 7, 0));
        listaEdges.add(new Edges(6, 7, 0));
        listaEdges.add(new Edges(7, 8, 0));

        return listaEdges;
    }

    public static int itspainted(Edges aresta){
        if(aresta.getPintadoOuNao() == aresta.getN1())
            return aresta.getN1();

        else if (aresta.getPintadoOuNao() == aresta.getN2())
            return aresta.getN2();

        return 0;
    }

    public static boolean hasInList(int valor){
        for(int i=0; i<verticesPintados.size(); i++) {
            if(verticesPintados.get(i) == valor)
                return true;
        }
        return false;
    }
}
