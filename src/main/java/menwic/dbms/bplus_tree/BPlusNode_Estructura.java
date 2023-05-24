package menwic.dbms.bplus_tree;

/**
 *
 * @author lamr4
 */
public class BPlusNode_Estructura {

    private int[] listaIds; //Arreglo: contiene "Id/LlavePrimaria"
    private Object[] listaEstructuras; //Arreglo/ListaEstructuras: contiene "Estructuras" que conforman el nodoEstructura

    private BPlusNode_Estructura[] listaHijos; //Arreglo: referencias/punteros "Estructuras Hijos"
    private boolean esHoja; //Verifica si este nodo es Hoja
    private int numID; //Cantidad de listaIds max (Id/Llave)
    private BPlusNode_Estructura siguienteHoja; //Puntero a siguiente

    //Constructor
    public BPlusNode_Estructura(int orden, boolean esHoja) {
        this.listaIds = new int[orden]; //Cant. de Hijos por Nodo/Arreglo (a su vez sera el ID)
        this.listaEstructuras = new Object[orden]; //Estructuras que almacenaremos
        this.listaHijos = new BPlusNode_Estructura[orden + 1];
        this.esHoja = esHoja;
        this.numID = 0;
        this.siguienteHoja = null;
    }

    public void insertarTupla(int key, Object value) {
        int i = numID - 1;
        while (i >= 0 && listaIds[i] > key) {
            listaIds[i + 1] = listaIds[i];
            listaEstructuras[i + 1] = listaEstructuras[i];
            i--;
        }
        listaIds[i + 1] = key;
        listaEstructuras[i + 1] = value;
        numID++;
    }

    public Object search(int key) {
        int i = 0;
        while (i < numID && key > listaIds[i]) {
            i++;
        }
        if (i < numID && key == listaIds[i]) {
            return listaEstructuras[i];
        } else {
            return null;
        }
    }

    public void split(int splitIndex, BPlusNode_Estructura rightSibling) {
        rightSibling.numID = numID - splitIndex;
        for (int i = 0; i < rightSibling.numID; i++) {
            rightSibling.listaIds[i] = listaIds[splitIndex + i];
            rightSibling.listaEstructuras[i] = listaEstructuras[splitIndex + i];
            listaIds[splitIndex + i] = 0;
            listaEstructuras[splitIndex + i] = null;
        }
        if (!esHoja) {
            for (int i = 0; i < rightSibling.numID + 1; i++) {
                rightSibling.listaHijos[i] = listaHijos[splitIndex + i];
                listaHijos[splitIndex + i] = null;
            }
        }
        numID = splitIndex;
        rightSibling.siguienteHoja = siguienteHoja;
        siguienteHoja = rightSibling;
    }

    public void split(int index, int order) {
        BPlusNode_Estructura right = new BPlusNode_Estructura(order, esHoja);
        BPlusNode_Estructura left = listaHijos[index];
        right.numID = order - 1;
        left.numID = order - 1;
        right.siguienteHoja = left.siguienteHoja;
        left.siguienteHoja = right;
        for (int i = 0; i < order - 1; i++) {
            right.listaIds[i] = left.listaIds[i + order];
            right.listaEstructuras[i] = left.listaEstructuras[i + order];
        }
        if (!left.esHoja) {
            for (int i = 0; i < order; i++) {
                right.listaHijos[i] = left.listaHijos[i + order];
            }
        }
        for (int i = numID; i > index; i--) {
            listaHijos[i + 1] = listaHijos[i];
            listaIds[i] = listaIds[i - 1];
            listaEstructuras[i] = listaEstructuras[i - 1];
        }
        listaHijos[index + 1] = right;
        listaIds[index] = left.listaIds[order - 1];
        listaEstructuras[index] = left.listaEstructuras[order - 1];
        numID++;
    }

    public int[] getListaIds() {
        return listaIds;
    }

    public Object[] getListaEstructuras() {
        return listaEstructuras;
    }

    public BPlusNode_Estructura[] getListaHijos() {
        return listaHijos;
    }

    public boolean getIsLeaf() {
        return esHoja;
    }

    public int getNumID() {
        return numID;
    }

    public BPlusNode_Estructura getSiguienteHoja() {
        return siguienteHoja;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }

    /*  Mostrar Valor que alberga el Nodo
    public void printEstructura() {
        System.out.p rintln("\tNodo: "+this.getEstructura()");
    }*/
}
