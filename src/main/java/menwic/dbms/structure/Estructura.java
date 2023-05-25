package menwic.dbms.structure;

import menwic.dbms.structure_fields.ListaCampos;
import menwic.dbms.tuple.ListaTuplas;

/**
 *
 * @author lamr4
 */
public class Estructura { //Ordenar en base a su nombre en Arbol B+ Principal

    private String nombreTabla; //Nombre de Tabla/Estructura
    private String campoClave; //Nombre del campo que sera PrimaryKey
    private ListaCampos listaCampos; //ListaEnlazada que contiene el nombre de listaCampos/cols que tendra la Estructura/Tabla
    private ListaTuplas listaTuplas; //xd
    //private BPlusTree_Estructuras arbolPrincipal; //Arbol en el que se albergaran Tuplas

    //Constructor (Verificar: si construimos sin parametros, y luego seteamos los atributos del Objeto)
    public Estructura(String nombreTabla, String campoClave) { //, ListaCampos listaCampos
        this.nombreTabla = nombreTabla;
        this.campoClave = campoClave;
        this.listaCampos = new ListaCampos();
        this.listaTuplas = new ListaTuplas();
    }

    //Constructor usado en electura de Archivo Estructura.xml, para crear posteriormente sus campos
    public Estructura() {
    }

    //Getters y Setters
    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getCampoClave() {
        return campoClave;
    }

    public void setCampoClave(String campoClave) {
        this.campoClave = campoClave;
    }

    public ListaCampos getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(ListaCampos listaCampos) {
        this.listaCampos = listaCampos;
    }

    public ListaTuplas getListaTuplas() {
        return listaTuplas;
    }

    public void setListaTuplas(ListaTuplas listaTuplas) {
        this.listaTuplas = listaTuplas;
    }
}
