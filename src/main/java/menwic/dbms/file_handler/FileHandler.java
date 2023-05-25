package menwic.dbms.file_handler;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import menwic.dbms.structure.*;
import menwic.dbms.structure_fields.*;
import menwic.dbms.gui.JFrameFormPrincipal;
import menwic.dbms.tools.CreadorDeTupla;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 *
 * @author lamr4
 */
public class FileHandler {

    //Declaracion de Lista que albergara Estructuras (NodosHoja de un Arbol B+)
    private final ListaEstructuras listaEstructuras;
    private final CreadorDeTupla creadorDeTupla;

    //Constructor
    public FileHandler(ListaEstructuras listaEstructuras) {
        this.listaEstructuras = listaEstructuras;
        this.creadorDeTupla = new CreadorDeTupla(listaEstructuras);
    }

    //Metodo que leer XML de Estructuras
    public void leerEstructuras(File archivo) {
        try {
            DocumentBuilderFactory fabricante = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder constructor = fabricante.newDocumentBuilder();
            Document doc = constructor.parse(archivo);

            //Lista de etiquetas principales: Nodos Estructura
            NodeList listaNodosEstructura = doc.getElementsByTagName("estructura"); //Almacenamiento de Estructura's en listaNodosEstructura

            for (int i = 0; i < listaNodosEstructura.getLength(); i++) { //Reccorrer listaNodosEstructura que alberga Estructuras leidas
                Node nodoActual = listaNodosEstructura.item(i);

                if (nodoActual.getNodeType() == Node.ELEMENT_NODE) { //Si la etiqueta es del mismo tipo a "estructura"
                    Estructura nuevaEstructura = new Estructura(); //Instanciamos nueva Estructura
                    ListaCampos listaCampos = new ListaCampos(); //Creamos la ListaCampos de la Estructura
                    //Nodos Hijo (Estructuras)
                    NodeList nodosHijos = nodoActual.getChildNodes(); //Tags que se encuentran entre las etiq de cada <estructura>
                    String clave = null; //Clave de la Estructura

                    for (int j = 0; j < nodosHijos.getLength(); j++) {
                        Node nodoHijo = nodosHijos.item(j);

                        if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
                            String nombreNodo = nodoHijo.getNodeName();
                            String valorNodo = nodoHijo.getTextContent().replace(" ", ""); //Guardar valor sin espacios

                            switch (nombreNodo) {
                                case "tabla":
                                    nuevaEstructura.setNombreTabla(valorNodo);
                                    break;

                                case "clave":
                                    clave = valorNodo;
                                    //Se settea al nuevaEstructura despues
                                    break;

                                case "relacion":

                                    //Pendiente
                                    //Hasta aqui
                                    break;

                                default:
                                    Campo nuevoCampo = new Campo(nombreNodo, valorNodo);
                                    listaCampos.insertarFinal(nuevoCampo);
                                    //throw new AssertionError();
                                    break;
                            }
                        }
                    }

                    if (clave != null) {
                        NodoCampo nodoCampoClave = listaCampos.getNodoCampoPorNombreCampo(clave); //Tipo Campo

                        if (nodoCampoClave != null) {
                            nuevaEstructura.setCampoClave(clave); //Agregamos Clave leida al objeto Estructura
                            nuevaEstructura.setListaCampos(listaCampos); //Agregamos listaCampos leida al objeto Estructura
                            listaEstructuras.insertarFinal(nuevaEstructura);
                            System.out.println("Estructura creada y almacenada en listaEstructuras");
                        } else {
                            System.out.println("Dato(s) incompleto(s), corrige y vuelve a intentar");
                        }
                    }//FinIf
                }//FinIf
            }//FinFor
        } catch (ParserConfigurationException | SAXException | IOException e) {
            Logger.getLogger(JFrameFormPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }

        listaEstructuras.recorrerListaEstructuras();
    }
    //Metodo que lee dat de Tuplas
    public void leerEntradas(File archivo) {
        try {
            String nombreTabla = "";
            String tuplaString;
            DocumentBuilderFactory fabricante = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder constructor = fabricante.newDocumentBuilder();
            Document doc = constructor.parse(archivo);
            Node raiz = doc.getDocumentElement();

            NodeList nodosTabla = raiz.getChildNodes();

            //iteramos dentro de los nodos padre que seran las estiquetas entrada
            for (int i = 0; i < nodosTabla.getLength(); i++) {
                tuplaString = "";//reiniciamos la query
                //el nodo padreActual es la estiqueta entrada
                Node nodoTabla = nodosTabla.item(i);

                //hacemos el proceso si y solo si la etiqueta es un elemento del documento
                if (nodoTabla.getNodeType() == Node.ELEMENT_NODE) {
                    //como se trata de una etiqueta tabla entonces el nombre de la tabla sera el nombre de la etiqueta
                    nombreTabla = nodoTabla.getNodeName();

                    //obtenemos todos los datos contenidos en el nodo tabla
                    NodeList nodosDatos = nodoTabla.getChildNodes();

                    //por cada uno de los datos
                    for (int j = 0; j < nodosDatos.getLength(); j++) {
                        Node nodoDato = nodosDatos.item(j);
                        // si el nodo es un elemento del nodoTabla entonces hacemos el proceso
                        if (nodoDato.getNodeType() == Node.ELEMENT_NODE) {
                            //obtenemos el nombre del nodo>nombre del atributo en la tabla
                            String nombreNodo = nodoDato.getNodeName();
                            //obtenemos el valor del atributo
                            String valorNodo = nodoDato.getTextContent().replace(" ", "");
                            //concatenamos al string tuplaString la parte de la query
                            //si estamos en la ultima lectrua entonces no concatenamos con coma
                            if (j == (nodosDatos.getLength() - 2)) {
                                tuplaString += nombreNodo + ":" + valorNodo;
                            } else {
                                tuplaString += nombreNodo + ":" + valorNodo + ",";
                            }
                        }
                    }

                    //una vez construimos la query entonces mandamos ha insertarFinal la tupla
                    String insertarTupla = this.creadorDeTupla.insertarTupla(nombreTabla, tuplaString);
                    JOptionPane.showMessageDialog(null,
                            insertarTupla, "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }//FinFor 
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
