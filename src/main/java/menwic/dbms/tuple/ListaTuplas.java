package menwic.dbms.tuple;

/**
 *
 * @author lamr4
 */
public class ListaTuplas {

    //Variables globales
    private NodoTupla primero;
    private NodoTupla ultimo;
    private int size;

    //Constructor
    public ListaTuplas() {
        this.primero = null;
        this.ultimo = null;
    }

    //Verificar si la Lista no tiene Nodos
    public boolean estaVacia() {
        return primero == null;
    }

    //Incersion a la cola
    public void agregarAlFinal(Tupla tupla) {
        NodoTupla nuevoNodo = new NodoTupla(tupla);

        if (estaVacia()) { //si esta vacia
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
            System.out.println("Se inserto la primera Tupla de Clave: " + nuevoNodo.getTupla().getClave());
        } else { //Cuando no esta vacia
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo; //Actualizamos el puntero Ultimo
            size++;
            System.out.println("Se inserto la nueva Tupla de Clave: " + nuevoNodo.getTupla().getClave());
        }
    }

    //Metodo que busca un NodoTupla, mediante Clave (este metodo se usa para buscar la tupla a eliminar)
    public NodoTupla getNodoTuplaPorNombreClave(String clave) {
        NodoTupla actual = primero;

        while (actual != null) { //Recorrer los nodoCampo mientras no sean NULL
            if (actual.getTupla().getClave().equals(clave)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    //Metodo para actualizar valores de una Tupla
    //claveCampo, busca la tupla que tenga la clave especificada, se encuentra y....
    public String actualizarTupla(String claveTupla, String nuevoValor) {
        NodoTupla buscado = getNodoTuplaPorNombreClave(claveTupla); //???
        if (buscado == null) {
            return "No se enconto el valor";
        }
        buscado.getTupla().getListaValores().actualizarValor(claveTupla, nuevoValor);
        return "Se actualizo exitosamente";
    }

    //Metodo que imprime
    public String recorrerListaTuplas() {
        String strTupla = "Lista Tuplas = {\n";
        NodoTupla actual = primero;

        //Minetras hayan nodos en la Lista
        for (int i = 0; i < size; i++) {
            strTupla += "\n" + (i + 1) + ") Tupla = [\n" + actual.getTupla().getListaValores().recorrerListaValores();
            actual = actual.getSiguiente();
            strTupla += "]";
        }
        strTupla += "}";
        return strTupla;
    }

    //Get
    public Tupla[] getTuplas() {
        Tupla[] tuplas = new Tupla[size];
        int contador = 0;
        NodoTupla actual = primero;

        while (actual != null) { //Minetras hayan nodos en la Lista
            tuplas[contador] = actual.getTupla();

            actual = actual.getSiguiente();
            contador++;
        }
        return tuplas;
    }
}
