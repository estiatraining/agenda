/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Exceptions;

/**
 *
 * @author Destroyer
 */
public class LogicException  extends Exception{
    /**
     * 
     * @param msg
     */
    public LogicException(String msg) {
        super(msg);
    }

    /**
     * 
     * @param arg0
     */
    public LogicException(Throwable arg0) {
        super(arg0);

    }

    /**
     * 
     * @param arg0
     * @param arg1
     */
    public LogicException(String arg0, Throwable arg1) {
        super(arg0, arg1);

    }     
}
