/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EVENTOS;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Digno
 */
public class EvenTabla {
    /**
     * <H1>CREAR TABLA</H1>
     * Crea la tabla y le pone titulo
     * @param tbltabla mi tabla
     * @param tmodel el model
     * @param titulos los titulos
     */
    public void crear_titulo_tabla(JTable tbltabla,DefaultTableModel tmodel,String titulos[]){
        String titulo="crear_titulo_tabla";
        try {
            tmodel.setColumnIdentifiers(titulos);
            tbltabla.setModel(tmodel);
        } catch (Exception e) {
            System.out.println("Error:"+e+"\n"+titulo);
        }
    }
    /**
     * ANCHO DE COLUMNA
     * @param tbltabla
     * @param ancho 
     */
    public void ancho_tabla(JTable tbltabla,int ancho[]){
        if(tbltabla.getColumnCount()<=ancho.length){
            JViewport scroll=(JViewport) tbltabla.getParent();
            int iancho=scroll.getWidth();
            TableColumnModel modelocolumna=tbltabla.getColumnModel();
            TableColumn columnatabla;
            for (int i = 0; i < tbltabla.getColumnCount(); i++) {
                columnatabla = modelocolumna.getColumn(i);
                int anchoColumna=(ancho[i]*iancho)/100;
                columnatabla.setPreferredWidth(anchoColumna);
            }
        }else{
            JOptionPane.showMessageDialog(tbltabla,"no es igual");
        }
    }
    /**
     * <H2>Cargar Tabla</H2>
     * @param tbltabla
     * @param tmodel
     * @param dato Datos a cargar en string
     */
    public void cargar_tabla(JTable tbltabla,DefaultTableModel tmodel,String dato[]){
        String titulo="cargar_tabla";
        try {
            tmodel.addRow(dato);
            tbltabla.setModel(tmodel);
        } catch (Exception e) {
            System.out.println("Error:"+e+"\n"+titulo);
        }
    }
}
