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
    public static String ip_server = "192.168.168.10";
    private static String db = "datos";

    public static void main(String[] args) {

        if (conectar()) {
            Jprincipal jp = new Jprincipal();
            jp.setVisible(true);
            jp.setLocationRelativeTo(null);
        } else {
            System.out.println("error al conectar");
        }
    }

    public static boolean conectar() {
        return true;
    }

}
