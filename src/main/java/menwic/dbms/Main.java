/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package menwic.dbms;

import java.io.File;
import javax.swing.JPanel;
import menwic.dbms.file_handler.FileHandler;
import menwic.dbms.gui.JFrameFormPrincipal;
import menwic.dbms.gui.panels.*;
import menwic.dbms.structure.Estructura;

import menwic.dbms.structure.ListaEstructuras;
import menwic.dbms.structure_fields.ListaCampos;

import menwic.dbms.structure_fields.Campo;
import menwic.dbms.tuple.ListaTuplas;
import menwic.dbms.values.ListaValores;

/**
 *
 * @author lamr4
 */
public class Main {

    public static void main(String[] args) {
        
        ListaEstructuras listaEstructuras = new ListaEstructuras(); //Lista Principal que almacena las Estructuras
        //JPanelEstructuras pEstructuras = new JPanelEstructuras(listaEstructuras);
        //JPanelTuplas pTuplas = new JPanelTuplas(listaEstructuras);

        JFrameFormPrincipal principal = new JFrameFormPrincipal(listaEstructuras);
        principal.setVisible(true);

        //Variables para: CaputraDatos -> Metodos 
        String nombreEstructura = ""; //nombre de Estructura
        String nombreCampoClave = ""; //nombre de Campo que sera Clave Primaria

        String nombreCampoUser = ""; //Nombre de Campo ingresado (se iran ingresando Campos unoXuno a un Form mediante un ciclo iterador)
        String tipoDatoUser = ""; //Especifica el tipo de Dato para el campo que se esta creando
        String nombreEstructuraRef = ""; //OPC nombreEstructura de la cual un Campo es la referencia

        //------------------------------------------------------------------------------------------------------------------------
        //Estructura Cliente
        nombreEstructura = "cliente";
        nombreCampoClave = "Nit";

        Estructura structCliente = new Estructura(nombreEstructura, nombreCampoClave);
        ListaCampos listaCamposCliente = new ListaCampos();
        ListaTuplas listaTuplasCliente = new ListaTuplas();
        ListaValores listaValoresCliente = new ListaValores();

        //Campos de Cliente (Hacer mediante un for/while)
        nombreCampoUser = "Nit";
        tipoDatoUser = "int";
        Campo campo0 = new Campo(nombreCampoUser, tipoDatoUser); //Referencia usada en Estructura Colegio
        listaCamposCliente.agregarAlFinal(campo0);

        nombreCampoUser = "Nombre";
        tipoDatoUser = "varchar";
        Campo campo1 = new Campo(nombreCampoUser, tipoDatoUser);
        listaCamposCliente.agregarAlFinal(campo1);

        nombreCampoUser = "Apellido";
        tipoDatoUser = "varchar";
        Campo campo2 = new Campo(nombreCampoUser, tipoDatoUser);
        listaCamposCliente.agregarAlFinal(campo2);

        structCliente.setListaCampos(listaCamposCliente); //Agregamos/Setteamos la listaCampos de la Estructura

        //Tuplas y Valores de Cliente
        /*
            pendiente
         */
        listaEstructuras.insertar(structCliente); //Agregamos la Estructura creada a la Lista Principal

        //Estructura Factura
        nombreEstructura = "factura";
        nombreCampoClave = "NoFactura";

        Estructura structFactura = new Estructura(nombreEstructura, nombreCampoClave);
        ListaCampos listaCamposFactura = new ListaCampos();
        ListaTuplas listaTuplas = new ListaTuplas();
        ListaValores listaValores = new ListaValores();

        //Campos de Factura (Hacer mediante un for/while)
        nombreCampoUser = "NoFactura";
        tipoDatoUser = "int";
        Campo campo00 = new Campo(nombreCampoUser, tipoDatoUser); //Referencia usada en Estructura Colegio
        listaCamposFactura.agregarAlFinal(campo00);

        nombreCampoUser = "Nit";
        tipoDatoUser = "int";
        nombreEstructuraRef = "cliente";

        Campo campo11 = new Campo(nombreCampoUser, tipoDatoUser);
        if (nombreEstructuraRef != "") { //Si el field nombreEstructura no esta vacio (o verificar si esta enabled el check), crear con ref a otro campo
            campo11.setReferencia(listaEstructuras.getNodoEstructuraPorNombre(nombreEstructuraRef).getEstructura().getListaCampos().getNodoCampoPorNombre(nombreCampoUser).getCampo());
            nombreEstructuraRef = "";
        }
        listaCamposFactura.agregarAlFinal(campo11);

        nombreCampoUser = "Fecha";
        tipoDatoUser = "varchar";
        Campo campo22 = new Campo(nombreCampoUser, tipoDatoUser);

        listaCamposFactura.agregarAlFinal(campo22);

        nombreCampoUser = "Lugar";
        tipoDatoUser = "varchar";
        Campo campo33 = new Campo(nombreCampoUser, tipoDatoUser);

        listaCamposFactura.agregarAlFinal(campo33);

        nombreCampoUser = "Valor";
        tipoDatoUser = "double";
        Campo campo44 = new Campo(nombreCampoUser, tipoDatoUser);

        listaCamposFactura.agregarAlFinal(campo44);

        structFactura.setListaCampos(listaCamposFactura); //Agregamos/Setteamos la listaCampos de la Estructura

        //Tuplas y Valores de Cliente
        /*
            pendiente
         */
        listaEstructuras.insertar(structFactura); //Agregamos la Estructura creada a la Lista Principal

        System.out.println(listaEstructuras.getNodoEstructuraPorNombre("factura").getEstructura().getListaCampos().recorrerListaCampos());

        //------------------------------------------------------------------------------------------------------------------------
    }
}
