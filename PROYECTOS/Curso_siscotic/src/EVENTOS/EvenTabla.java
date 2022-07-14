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
    /**
     * <H2>Calcula el sultotal de la tabla</H2>
     * @param tbltabla tu tabla
     * @param tmodel model
     * @param col_cantidad la posicion de la cantidad
     * @param col_precio la posicion del precio 
     * @param col_subtotal la posicion del subtotal
     */
    public void calcular_subtotal(JTable tbltabla,DefaultTableModel tmodel,int col_cantidad,int col_precio,int col_subtotal){
        double Ditem_subtotal=0;
        if(tbltabla.getRowCount()>0){//cuenta la cantidad de fila mayor a cero
            for (int row = 0; row < tbltabla.getRowCount(); row++) {//recorre toda la tabla
                String Sitem_cantidad=tbltabla.getModel().getValueAt(row, col_cantidad).toString();
                String Sitem_precio=tbltabla.getModel().getValueAt(row, col_precio).toString();
                double Ditem_cantidad=Double.parseDouble(Sitem_cantidad);
                double Ditem_precio=Double.parseDouble(Sitem_precio);
                Ditem_subtotal=Ditem_cantidad*Ditem_precio;//multiplica la cantidad por precio
                tmodel.setValueAt(Ditem_subtotal, row, col_subtotal);//carga el valor en la columna subtotal
            }
        }
    }
    /**
     * <H2>Retorna la suma de la columna subtotal </H2>
     * @param tbltabla
     * @param col_subtotal la posicion de la columna
     * @return la suma del subtotal de la columna
     */
     public double getDouble_sumar_subtotal(JTable tbltabla,int col_subtotal){
        double Ditem_total=0;
        if(tbltabla.getRowCount()>0){//cuenta la cantidad de fila mayor a cero
            for (int row = 0; row < tbltabla.getRowCount(); row++) {//recorre toda la tabla
                String Sitem_subtotal=tbltabla.getModel().getValueAt(row, col_subtotal).toString();
                double Ditem_subtotal=Double.parseDouble(Sitem_subtotal);
                Ditem_total=Ditem_total+Ditem_subtotal;
            }
        }
        return Ditem_total;
    }
	public void eliminar_fila(){
		
	}
}
