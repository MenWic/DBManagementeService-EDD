package menwic.dbms.gui.panels;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import menwic.dbms.structure.Estructura;
import menwic.dbms.structure.ListaEstructuras;
import menwic.dbms.structure.NodoEstructura;

import menwic.dbms.structure_fields.Campo;
import menwic.dbms.structure_fields.ListaCampos;

/**
 *
 * @author lamr4
 */
public class JPanelEstructuras extends javax.swing.JPanel {

    private ListaEstructuras listaEstructuras; //lista donde almacenaremos la lista  del FramePrincipal
    private DefaultTableModel tabla; //tabla

    //Constructor
    public JPanelEstructuras(ListaEstructuras listaEstructuras) {
        this.listaEstructuras = listaEstructuras;
        initComponents();

        tabla = new DefaultTableModel(); //Tabla con columnas estaticas
        tabla.addColumn("Estructura / Fila");
        tabla.addColumn("Campo Clave");
        this.JTableTabla.setModel(tabla); //Settear modelo estatico a la tabla del Panel
        mostrarTabla(); //Actualizar jtabla de estructuras
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoDato = new javax.swing.ButtonGroup();
        jPanelContentEstructuras = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jButtonVaciar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jTextFieldTabla = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldClave = new javax.swing.JTextField();
        jTextFieldNumCampos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        JTableTabla = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre de Estructura:");

        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jButtonVaciar.setText("Vaciar");
        jButtonVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVaciarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jTextFieldTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTablaActionPerformed(evt);
            }
        });

        jLabel3.setText("Clave Primaria:");

        jLabel4.setText("Cant. de Campos:");

        jTextFieldNumCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumCamposActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("MENU ESTRUCTURAS");

        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel9.setText("Crear Estructura");

        JTableTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Factura", "NoFactura"}
            },
            new String [] {
                "Tabla/Estructura", "Clave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneTabla.setViewportView(JTableTabla);

        jLabel11.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel11.setText("Lista Estructuras");

        javax.swing.GroupLayout jPanelContentEstructurasLayout = new javax.swing.GroupLayout(jPanelContentEstructuras);
        jPanelContentEstructuras.setLayout(jPanelContentEstructurasLayout);
        jPanelContentEstructurasLayout.setHorizontalGroup(
            jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentEstructurasLayout.createSequentialGroup()
                .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNumCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jLabel9))
                            .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                                .addComponent(jButtonVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentEstructurasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(369, 369, 369))
        );
        jPanelContentEstructurasLayout.setVerticalGroup(
            jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldTabla)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldClave)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNumCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContentEstructurasLayout.createSequentialGroup()
                        .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContentEstructurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(jPanelContentEstructuras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumCamposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumCamposActionPerformed

    private void jTextFieldTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTablaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTablaActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        //PENDIENTE METODO QUE: elimine estructura especifica de la Lista enlazada
        for (int i = 0; i < listaEstructuras.getSize(); i++) {
            listaEstructuras.eliminarFinal();
        }
        mostrarTabla(); //Actualizar tabla visual
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVaciarActionPerformed
        //Metodo que eliminar todos los nodos estructura de la lista desde el ultimo al primero
        for (int i = 0; i < listaEstructuras.getSize()+1; i++) {
            listaEstructuras.eliminarFinal();
        }
        mostrarTabla(); //Actualizar tabla visual
    }//GEN-LAST:event_jButtonVaciarActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        jTextFieldTabla.setEditable(false);
        jTextFieldClave.setEditable(false);
        jTextFieldNumCampos.setEditable(false);
        jButtonCrear.setEnabled(false);

        //Variables para captura de Datos
        String nombreTabla;
        String claveTabla;
        int cantCampos;

        //Captura de datos
        nombreTabla = jTextFieldTabla.getText();
        claveTabla = jTextFieldClave.getText();
        cantCampos = Integer.parseInt(jTextFieldNumCampos.getText());

        Estructura nuevaEstructura = new Estructura(nombreTabla, claveTabla);
        ListaCampos listaCamposInit = new ListaCampos();
        nuevaEstructura.setListaCampos(listaCamposInit); //PROBANDO

        //listaEstructuras.insertarFinal(nuevaEstructura); //Se guarda la estructura en la ListaEstructuras
        JOptionPane.showMessageDialog(null, "Ingrese los datos de los: " + cantCampos + " campos, Por favor");

        try {
            //Deshabilitar los Textfield del subemnu de Crear Estructura
            for (int i = 0; i < cantCampos; i++) {
                String nombreCampo;
                String tipoDato;
                String esCampoRef;
                String estructuraRef;

                nombreCampo = JOptionPane.showInputDialog("Ingrese el nombre del Campo " + (i + 1) + ":");
                tipoDato = JOptionPane.showInputDialog("Ingrese el tipo de dato para del Campo " + (i + 1) + ":");
                esCampoRef = JOptionPane.showInputDialog(null, "El Campo" + (i + 1) + " es referencia de otra Estructura? (S/N):");

                if (("S".equals(esCampoRef)) || ("s".equals(esCampoRef))) { //CAMPO CON REFERENCIA
                    estructuraRef = JOptionPane.showInputDialog("Ingrese el nombre de la Estructura " + " que posee al Campo" + (i + 1) + ":");

                    Campo nuevoCampo = new Campo(nombreCampo, tipoDato); //Creacion Basica de Campo
                    //Agg puntero/referencia del Campo
                    nuevoCampo.setCampoReferencia(listaEstructuras.getNodoEstructuraPorNombre(estructuraRef).getEstructura().getListaCampos().getNodoCampoPorNombreCampo(nombreCampo).getCampo());
                    nuevaEstructura.getListaCampos().insertarFinal(nuevoCampo); //Agg Campo a la ListaCampos de la Estructura
                } else { //CAMPO SIN REFERENCIA
                    Campo nuevoCampo = new Campo(nombreCampo, tipoDato); //Creacion Basica de Campo
                    nuevaEstructura.getListaCampos().insertarFinal(nuevoCampo); //Agg Campo a la ListaCampos de la Estructura
                }
            }

            //una vez creada la escturctura validamos si la llave primaria fue agregada a sus campos
            if (claveEstructuraExiste(nuevaEstructura)) {
                //Agregar Estructura a la Lista (cuando se haya terminado con los campos
                    listaEstructuras.insertarFinal(nuevaEstructura);
                    mostrarTabla(); //Actualizar datos de la tabla visual luego de insertar la nuevaEstructura
                    listaEstructuras.recorrerListaEstructuras();//Imprime Estructuras almacenadas
                } else {
                    JOptionPane.showMessageDialog(null, "No se agrego la llave primaria, la Estructura se deshecho. Intente nuevamente");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error, la Estructura se deshecho. Intente nuevamente");
                e.printStackTrace(); //Imprime el error en consola
            }

            //Habilitar textfields y boton crear luego de crear Tabla
            jTextFieldTabla.setText("");
            jTextFieldTabla.setEditable(true);
            jTextFieldTabla.setText("");
            jTextFieldClave.setEditable(true);
            jTextFieldClave.setText("");
            jTextFieldNumCampos.setEditable(true);
            jTextFieldNumCampos.setText("");
            jButtonCrear.setEnabled(true);
    }//GEN-LAST:event_jButtonCrearActionPerformed

    //Metodo que verifica si el nombre de la clave indicado, es un campo creado de la nueva estructura
    private boolean claveEstructuraExiste(Estructura estructura) { //Busca en listaCampos de la estructura que pasamos

        String nombreClave = estructura.getCampoClave();
        Campo[] camposTabla = estructura.getListaCampos().returnCampos(); //Arreglo de nodos que posee campos de la estructura pasada

        //Recorre cada nodo del arreglo de Campos
        for (Campo campoItem : camposTabla) {
            if (campoItem.getNombreCampo().equals(nombreClave)) {
                return true;
            }
        }
        return false; //si no lo encontro, retorna falso
    }
    private void mostrarTabla() {
        NodoEstructura[] listaNodosEstructura = listaEstructuras.returnNodos();
        this.tabla.setRowCount(0); //Remueve filas

        for (int i = 0; i < listaNodosEstructura.length; i++) {
            String tabla = listaNodosEstructura[i].getEstructura().getNombreTabla();
            String clave = listaNodosEstructura[i].getEstructura().getCampoClave();

            //Pasar valores de fila
            String[] fila = new String[2];
            fila[0] = tabla;
            fila[1] = clave;

            //Agg Fila a tabla
            this.tabla.addRow(fila);
            listaEstructuras.recorrerListaEstructuras();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableTabla;
    private javax.swing.ButtonGroup buttonGroupTipoDato;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonVaciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelContentEstructuras;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JTextField jTextFieldClave;
    private javax.swing.JTextField jTextFieldNumCampos;
    private javax.swing.JTextField jTextFieldTabla;
    // End of variables declaration//GEN-END:variables
}
