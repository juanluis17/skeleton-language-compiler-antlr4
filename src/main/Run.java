/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import traductor.TraductorVisitor2Pasada;



/**
 *
 * @author juanluis
 */
public class Run {

    public static void main(String[] args) throws Exception {
        System.out.println("");
        File file = new File("input.txt");
        traductor.TraductorVisitor2Pasada compiler=new TraductorVisitor2Pasada();
        //Este método contiene las sentencias para ejecutar el compilador. 
        compiler.compile(file);

    }

}
