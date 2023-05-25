package menwic.dbms.values;

/**
 *
 * @author lamr4
 */
public class ListaValores {
    //Variables globales
    private NodoValor primero;
    private NodoValor ultimo;
    private int size;

    //COnstructor
    public ListaValores() {
        this.primero = null;
        this.ultimo = null;
    }

    //METODOS PRINCIPALES
    //Verificar si la Lista no tiene Nodos
    public boolean estaVacia() {
        return primero == null;
    }

    //Incersion a la cola
    public void agregarAlFinal(Valor valor) {
        NodoValor nuevoNodo = new NodoValor(valor);

        if (estaVacia()) { //si esta vacia
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
            System.out.println("Se inserto el primer Valor: " + nuevoNodo.getValor().getContenido());
        } else { //Cuando no esta vacia
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo; //Actualizamos el puntero Ultimo
            size++;
            System.out.println("Se inserto el nuevo Valor: " + nuevoNodo.getValor().getContenido());
        }
    }

    //Metodo que busca un NodoValor.getValor, en base a la asociacion con "nombreCampo"
    public NodoValor getNodoValorPorNombreCampo(String nombreCampo) {
        NodoValor actual = primero;

        while (actual != null) { //Recorrer los nodoCampo mientras no sean NULL
            if (actual.getValor().getNombreCampo().equals(nombreCampo)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    //Metodo para actualizar valores de una Tupla
    public String actualizarValor(String nodoCampo, String nuevoValor) {
        NodoValor buscado = getNodoValorPorNombreCampo(nodoCampo);
        if (buscado == null) {
            return "No se enconto el valor";
        }
        buscado.getValor().setContenido(nuevoValor);
        return "Se actualizo exitosamente";
    }

    //Metodo que imprime
    public String recorrerListaValores() {
        NodoValor actual = primero;
        String strTupla = "";

        //Minetras hayan nodos en la Lista
        for (int i = 0; i < size; i++) {
            strTupla += (i + 1) + ". Campo: " + actual.getValor().getNombreCampo() + ", valor: " + actual.getValor().getContenido() + "\n";
            actual = actual.getSiguiente();
        }
        return strTupla;
    }

    //Get
    public Valor[] getValores() {
        Valor[] valor = new Valor[size];
        int contador = 0;
        NodoValor actual = primero;

        while (actual != null) { //Minetras hayan nodos en la Lista
            valor[contador] = actual.getValor();

            actual = actual.getSiguiente();
            contador++;
        }
        return valor;
    }
}
