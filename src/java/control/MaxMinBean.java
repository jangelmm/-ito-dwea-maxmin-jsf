package control;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named("maxmin")
@SessionScoped
public class MaxMinBean implements Serializable {

    private int a, b, c;
    private int limiteInicial, limiteFinal;
    private Integer maximo, minimo;

    public MaxMinBean() {}

    // Getters y Setters
    public int getA() { return a; }
    public void setA(int a) { this.a = a; }
    public int getB() { return b; }
    public void setB(int b) { this.b = b; }
    public int getC() { return c; }
    public void setC(int c) { this.c = c; }
    public int getLimiteInicial() { return limiteInicial; }
    public void setLimiteInicial(int limiteInicial) { this.limiteInicial = limiteInicial; }
    public int getLimiteFinal() { return limiteFinal; }
    public void setLimiteFinal(int limiteFinal) { this.limiteFinal = limiteFinal; }
    public Integer getMaximo() { return maximo; }
    public Integer getMinimo() { return minimo; }

    public String calcular() {
        // Validación básica por si el usuario invierte los límites
        int inicio = Math.min(limiteInicial, limiteFinal);
        int fin = Math.max(limiteInicial, limiteFinal);

        this.maximo = Integer.MIN_VALUE;
        this.minimo = Integer.MAX_VALUE;

        // Evaluación de f(x) = ax^2 + bx + c
        for (int x = inicio; x <= fin; x++) {
            int y = (this.a * x * x) + (this.b * x) + this.c;
            if (y > this.maximo) this.maximo = y;
            if (y < this.minimo) this.minimo = y;
        }

        return "resultado"; // Navega a resultado.xhtml
    }

    public String reiniciar() {
        this.a = 0; this.b = 0; this.c = 0;
        this.limiteInicial = 0; this.limiteFinal = 0;
        this.maximo = null; this.minimo = null;
        return "index"; // Regresa a la configuración
    }
}