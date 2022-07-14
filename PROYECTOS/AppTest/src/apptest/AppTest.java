/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptest;

/**
 *
 * @author SisCoTic_4
 */
public class AppTest {

    public static String version = "1.0";
    public static String ip = "192.168.168.10";
    public static String db = "datos";
    
    
    public static void main(String[] args) {
        Jprincipal jp = new Jprincipal();
        jp.setVisible(true);
        jp.setLocationRelativeTo(null);
    }
   
}
