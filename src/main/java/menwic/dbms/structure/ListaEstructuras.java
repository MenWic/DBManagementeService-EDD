package menwic.dbms.structure;

/**
 *
 * @author lamr4
 */
public class ListaEstructuras {

    //Atributos de cada Instancia ListaEstructuras
    private NodoEstructura primero;
    private NodoEstructura ultimo;
    private int size = 0; //Contador de nodos

    //Constructor
    public ListaEstructuras() {
        this.primero = null;
        this.ultimo = null;
    }

    //Getters y Setters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoEstructura getPrimero() {
        return primero;
    }

    //METODOS PRINCIPALES
    //Verificar si la Lista no tiene Nodos
    public boolean estaVacia() {
        return primero == null;
    }

    //Incersion al final de la Lista
    public void insertarFinal(Estructura estructura) {
        NodoEstructura nuevoNodo = new NodoEstructura(estructura);

        if (estaVacia()) { //si esta vacia
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
            System.out.println("Se inserto la primer Estructura: " + nuevoNodo.getEstructura().getNombreTabla() + " a la Lista");
        } else { //Cuando no esta vacia
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo; //Actualizamos el puntero Ultimo
            size++;
            System.out.println("Se inserto la nueva Estructura: " + nuevoNodo.getEstructura().getNombreTabla() + " a la Lista");
        }
    }

    //Eliminar el ultimo nodo (MODIFICAR A: buscar nodoEstructuraPorNombre (este debe recorrer la listaEstrucuras y comparar), luego eliminar las referencias a ese nodo)
    public void eliminarFinal() {
        if (!estaVacia()) {
            if (primero == ultimo) { //Si solo hay un elemento en la Lista (Pero siemre habran 2 creo)
                primero = null;
                ultimo = null;
                size--;
                System.out.println("Se elimino el unico NodoEstructura");
            } else {
                NodoEstructura actual = primero;

                while (actual.getSiguiente() != ultimo) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
                ultimo = actual;
                size--;
                System.out.println("Se elimino el ultimo NodoEstructura");
            }
        }
        System.out.println("La Lista esta vacia, no se puede eliminar nada");
    }

    //Metodo que busca un Nodo que posea el nombre indicado (Usar al buscar referencia en alguna Estructura creada)
    public NodoEstructura getNodoEstructuraPorNombre(String nombreTabla) {
        NodoEstructura actual = primero;

        while (actual != null) { //Recorrer los nodoCampo mientras no sean NULL
            if (actual.getEstructura().getNombreTabla().equals(nombreTabla)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null; //No se encontro la Estructura con el nombre indicado
    }

    //Metodo que imprime (Void: eliminarFinal return y pasar string -> println)
    public String recorrerListaEstructuras() {
        String strListaEstructuras = "";
        NodoEstructura actual = primero;

        while (actual != null) { //Minetras hayan nodos en la Lista
            strListaEstructuras += "\nNombreTabla = " + actual.getEstructura().getNombreTabla() + "\nClave = " + actual.getEstructura().getCampoClave() + "\nListaCampos = {\n" + actual.getEstructura().getListaCampos().recorrerListaCampos() + "}\n";
            actual = actual.getSiguiente();
        }
        System.out.println(strListaEstructuras);
        return strListaEstructuras;
    }

    //Metodo que recibe un String para buscar en las estructuras si es igual al nombre de la estructura
    public boolean encontroEstructura(String nombreEstructuraRef) {
        NodoEstructura actual = primero;
        boolean bandera = false;

        while (actual != null) {
            if (actual.getEstructura().getNombreTabla().equals(nombreEstructuraRef)) {
                bandera = true;
            }
            actual = actual.getSiguiente();
        }
        return bandera;
    }

    //Metodo que imprime (Void: eliminarFinal return y pasar string -> println)
    public NodoEstructura[] returnNodos() {
        NodoEstructura[] nodos = new NodoEstructura[size];
        int contador = 0;
        NodoEstructura actual = primero;

        while (actual != null) { //Minetras hayan nodos en la Lista
            nodos[contador] = actual;

            actual = actual.getSiguiente();
            contador++;
        }
        return nodos;
    }
}
