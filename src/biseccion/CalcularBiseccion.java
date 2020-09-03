package biseccion;

/**
 *
 * @author Dair Salas Grandeth
 */
public class CalcularBiseccion {

    private double a;
    private double b;
    private String f;
    private String cad;

    public CalcularBiseccion(String f, double a, double b) {
        this.f = f;
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public double f(double x) {
        Funciones fun = new Funciones();
        fun.setFuncion(f);
        fun.setVarlorX(x);
        fun.evaluada();
        return fun.getResultado();
    }
    
    public String getCadenaIteraciones() {
        return cad;
    }
    
    public String cortar(String c) {
        return (c.length() > 6) ? c.substring(0, 6) : c;
    }

    public void calcular(int cont) {
        int incremento = 1;
        System.out.println("**** Empezar método para calcular biceccion*****\n" + f(a) * f(b) + "*** fín ***");
        /*
        Paso 1: Elija valores iniciales inferior, xl, y superior, xu, que encierren la raíz, de forma
        tal que la función cambie de signo en el intervalo. Esto se verifi ca comprobando
        que f(xl) f(xu) < 0.
         */
        
        String msg = "cont"
                + "\ta"
                + "\tb"
                + "\tf(a)"
                + "\tf(b)"
                + "\txi"
                + "\tf(xi)"
                + "\t|xi-(xi-1)|\n";
        if (f(a) * f(b) < 0) {
            
            double xri = 0;
            double xr = 0;
            
            while (incremento <= cont) {
                msg += incremento + "\t";

                /*
                Paso 2: Una aproximación de la raíz xr se determina mediante:
                xr = xl + xu / 2
                 */
                
                
                xri = xr;
                xr = (a + b) / 2;
                
                //msg += cortar(a+"") + "+" + cortar(b+"") + "/" + 2 + "\t"; // xr = xl + xu / 2
                
                msg += cortar(a+"") + "\t"; // a
                
                msg += cortar(b+"") + "\t"; // b
                
                msg += cortar(f(a)+"") + "\t"; // f(a)
                
                msg += cortar(f(b)+"") + "\t"; // f(b)
                
                msg += cortar(xr+"") + "\t"; // xi
                
                msg += cortar(f(xr)+"") + "\t"; // f(xi)
                
                if (incremento > 1) {
                    msg += cortar(Math.abs(xr-xri)+"") + "\t"; // |xi - xi-1|
                }

                /*
                Paso 3: Realice las siguientes evaluaciones para determinar en qué subintervalo está la raíz:
                */
                
                /*
                a) Si f(xl)f(xr) < 0, entonces la raíz se encuentra dentro del subintervalo inferior
                o izquierdo. Por lo tanto, haga xu = xr y vuelva al paso 2.
                 */
                if (f(a) * f(xr) < 0) {
                    b = xr;
                }
                
                /*
                b) Si f(xl)f(xr) > 0, entonces la raíz se encuentra dentro del subintervalo superioo derecho.
                Por lo tanto, haga xl = xr y vuelva al paso 2.
                */
                else if (f(a)*f(xr) > 0) {
                    a = xr;
                }
                
                /*
                c) Si f(xl)f(xr) = 0, la raíz es igual a xr; termina el cálculo.
                */
                else {
                    Alerts.print("Raíz encontrada :>>>" + xr + " :: >> " + incremento + " iteraciones");
                    break;
                }
                msg += "\n";
                incremento++;
            }
            
            cad = msg;

        } else {
            Alerts.print("Busque otros intervalos");
        }

    }

}
