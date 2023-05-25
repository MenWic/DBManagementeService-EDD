package menwic.dbms.tools;

import javax.swing.JOptionPane;
import menwic.dbms.structure.ListaEstructuras;
import menwic.dbms.structure.NodoEstructura;
import menwic.dbms.structure_fields.Campo;
import menwic.dbms.structure_fields.NodoCampo;
import menwic.dbms.tuple.Tupla;
import menwic.dbms.values.Valor;

/**
 *
 * @author lamr4
 */
public class CreadorDeTupla {

    //Variables Globales
    private final ListaEstructuras listaEstructuras;

    //Constructor
    public CreadorDeTupla(ListaEstructuras listaEstructuras) {
        this.listaEstructuras = listaEstructuras;
    }

    //Metodos FUncionales IMPORTANTES para asociacion entre campos y valores que conforma una Tupla
    //Metodo para insertar tuplas a una Estructura
    public String insertarTupla(String nombreTablaString, String tuplaString) {
        try {
            //evaluar que los txt no esten vacios
            if (nombreTablaString.isBlank() || tuplaString.isBlank()) { //Si esta vacio o en blanco
                return "Parametros vacios.";
            }
            //buscamos el nombre de la tabla en la lista de esctructuras
            NodoEstructura tablaEncontrada = this.listaEstructuras.getNodoEstructuraPorNombre(nombreTablaString);

            //evaluar si existe la tabla
            if (tablaEncontrada == null) {
                return "Tabla " + nombreTablaString + " no encontrada.";
            }
            //si llego aqui entonces la tabla existe y debemos deconstuir la entrada dle usuario
            Campo[] listaCampos = this.obtenerCamposDeEntrada(tuplaString);
            /*una vez obtenido los campos podemos evaluar si cada uno de ellos existe dentro dela tabla
            * si la respuesta es false entonces lanzamos un error indicando que un campo no existe 
             */
            if (!this.saberSiExistenCamposEnTabla(tablaEncontrada, listaCampos)) {
                return "Campo no encontrado en la tabla.";
            }
            /*vemos si los campos ingresados estan completos
            * si llega aqui entonces la entrada es correcta y podemos mandar ha construir la lista de valores y finalmente crear una tupla
             */
            Valor[] valores = this.obtenerValoresDeEntrada(tuplaString);
            //mandamos ha buscar el valor de la llave primaria dentro de los valores
            String obtenerLlavePrimaria = this.obtenerClaveTabla(valores, tablaEncontrada);
            //creamos la tupla y la adjuntamos ha la lista
            Tupla tupla = new Tupla(valores, obtenerLlavePrimaria);
            //ahora anadimos la nueva tupla a la lista de tuplas de la tabla encontrada
            tablaEncontrada.getEstructura().getListaTuplas().agregarAlFinal(tupla);
            //mandmaos un mensaje de exito
            return "Se agrego la tupla" + tuplaString + " con exito.";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * Destruye el string de entrada por comas y obtiene los campos contenidos
     * en ella
     *
     * @param entrada
     * @return
     */
    private Campo[] obtenerCamposDeEntrada(String entrada) {
        //seperamaos la entrada por comas
        String[] camposString = entrada.split(",");
        //la lista de campos tendra un size de acuedo a cuantas comas hayan
        Campo[] campos = new Campo[camposString.length];
        //recoreemos cada uno de los strings obteneidos al hacer el split y separamos por :
        for (int x = 0; x < campos.length; x++) {
            String[] campoString = camposString[x].split(":");
            //el primer parametro del array es el nombre de campo y el segundo parametro es el valor del campo
            String nombreCampo = campoString[0];
            String valorCampo = campoString[1];

            Campo campo = new Campo(nombreCampo, "");
            campos[x] = campo;
        }

        return campos;
    }

    /**
     * Evalua si cada uno de los campos enviados existe dentro de la tabla
     *
     * @param nodoTabla
     * @param campos
     * @return
     */
    private boolean saberSiExistenCamposEnTabla(NodoEstructura nodoTabla, Campo[] campos) {
        for (Campo campo : campos) {//por cada uno de los campos en el array hacemos validacion
            //dentro de tabla>campos mandamos a buscar el nombre del campo
            NodoCampo nodoCampo = nodoTabla.getEstructura().getListaCampos().getNodoCampoPorNombre(campo.getNombreCampo());
            //si el campo buscado es false entonces enviamos false como respuesta
            if (nodoCampo == null) {
                return false;
            }
        }

        return true;
    }

    /**
     * /* Obtiene valores de Tuppla creada en textfield
     *
     * @param entrada
     * @return
     */
    private Valor[] obtenerValoresDeEntrada(String entrada) {
        String[] camposString = entrada.split(","); //seperamaos la entrada por comas

        //la lista de campos tendra un size de acuedo a cuantas comas hayan
        Valor[] valores = new Valor[camposString.length];

        //recoreemos cada uno de los strings obteneidos al hacer el split y separamos por :        
        for (int x = 0; x < valores.length; x++) {
            String[] campoString = camposString[x].split(":");
            String nombreCampo = campoString[0]; //el primer parametro del array es el nombre de campo y el segundo parametro es el valor del campo
            String valorCampo = campoString[1];
            
            Valor valor = new Valor(valorCampo, nombreCampo);
            valores[x] = valor;
        }
        return valores;
    }
    
    /**
     * Obtiene la clave de la tabla en formato String 
     * 
     * @param valores
     * @param nodoTabla
     * @return
     * @throws Exception 
     */
    private String obtenerClaveTabla(Valor[] valores, NodoEstructura nodoTabla) throws Exception {
        String primaria = nodoTabla.getEstructura().getCampoClave();
        for (Valor valorItem : valores) {//exploramos todos los valores y comparamos si el nombre de su columna conincide con el nombre de la llave primaria
            if (valorItem.getNombreCampo().equals(primaria)) {
                return valorItem.getContenido();
            }
        }
        throw new Exception("Llave primaria no encontrada");
    }
}
