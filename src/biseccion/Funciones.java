package biseccion;

import org.nfunk.jep.JEP;

/**
 *
 * @author Dair Salas Grandeth
 */
public class Funciones {
    
    private String funcion;
    private double resultado;
    private double varlorX;
    private String error;
    JEP jep;

    public Funciones() {
        this.funcion = "";
        this.resultado = 0.0;
        this.varlorX = 0.0;
        this.error = "";  
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public void setVarlorX(double varlorX) {
        this.varlorX = varlorX;
    }

    public double getResultado() {
        return resultado;
    }

    public String getError() {
        return error;
    }

    public boolean evaluada() {
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.varlorX);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();
        this.error = (this.jep.hasError())? "Existe un error" : "No hay error";
        
       return !jep.hasError();        
    }
    
}
