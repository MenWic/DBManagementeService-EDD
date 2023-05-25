package menwic.dbms.structure_fields;

/**
 *
 * @author lamr4
 */
public class ListaCampos {

    //Atributos globales principales
    private NodoCampo primero;
    private NodoCampo ultimo;
    private int size = 0;

    //Constructor
    public ListaCampos() {
        this.primero = null;
        this.ultimo = null;
    }

    //Metodos Principales
    //Verificar si la Lista no tiene Nodos
    public boolean estaVacia() {
        return primero == null;
    }

    //Incersion a la cola
    public void insertarFinal(Campo campo) {
        NodoCampo nuevoNodo = new NodoCampo(campo);

        if (estaVacia()) { //si esta vacia
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
            System.out.println("Se inserto el primer Campo: " + nuevoNodo.getCampo().getNombreCampo() + " a la Lista");
        } else { //Cuando no esta vacia
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo; //Actualizamos el puntero Ultimo
            size++;
            System.out.println("Se inserto el nuevo Campo: " + nuevoNodo.getCampo().getNombreCampo() + " a la Lista");
        }
    }

    //Metodo que busca un Nodo que posea el nombre indicado (Usar al buscar referencia en alguna Estructura creada)
    public NodoCampo getNodoCampoPorNombreCampo(String nombre) {
        NodoCampo actual = primero;

        while (actual != null) { //Recorrer los nodoCampo mientras no sean NULL
            if (actual.getCampo().getNombreCampo().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    //Metodo que imprime
    public String recorrerListaCampos() {
        String strListaCampos = "";
        NodoCampo actual = primero;

        //Minetras hayan nodos en la Lista
        while (actual != null) {
            if (actual.getCampo().getCampoReferencia() == null) { //Si la referencia es null / no hay
                strListaCampos += "NombreCampo: " + actual.getCampo().getNombreCampo() + ", TipoDato: " + actual.getCampo().getTipoDato() + ", Referencia: " + "null\n";
            } else {
                strListaCampos += "NombreCampo: " + actual.getCampo().getNombreCampo() + ", TipoDato: " + actual.getCampo().getTipoDato() + ", Referencia: " + actual.getCampo().getCampoReferencia().getNombreCampo() + "\n";
            }
            actual = actual.getSiguiente();
        }
        return strListaCampos;
    }

    public Campo[] returnCampos() {
        Campo[] campos = new Campo[size];
        int contador = 0;
        NodoCampo actual = primero;

        while (actual != null) { //Minetras hayan nodos en la Lista
            campos[contador] = actual.getCampo();

            actual = actual.getSiguiente();
            contador++;
        }
        return campos;
    }
}
