/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pb_21130876_proyecto_01;

/**
 *
 * Luis Ernesto Barranco Núñez
 * 21130876
 */
class Inversor {
    ////////////////ATRIBUTOS//////////////////////
    
    private String inversionista;//nombre del inversionista
    private double Ci;//capital inicial
    private double Cf;//capital final
    private double n;//periodo de tiempo
    
    

    /////////////////METODOS////////////////////
    
    
    //constructores
    //default
    public Inversor(){
        inversionista = "Pedro Perez";
        Ci = 0;
        Cf = 0;
        n = 0;    
    }
    //parametrizado
    public Inversor(String inversionista, double Ci,double Cf,double n){
        this.inversionista = inversionista;
        this.Ci = Ci;
        this.Cf = Cf;
        this.n = n;    
    }
    
    
    //generamos get y set

    public String getInversionista() {
        return inversionista;
    }

    public void setInversionista(String inversionista) {
        this.inversionista = inversionista;
    }

    public double getCi() {
        return Ci;
    }

    public void setCi(double Ci) {
        this.Ci = Ci;
    }

    public double getCf() {
        return Cf;
    }

    public void setCf(double Cf) {
        this.Cf = Cf;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
    
    
    
    //modificamos el toString
    public String toString(){
        return "Inversionista: " + inversionista+
               "\nCapital inicial: " + Ci+
               "\nCapital final: " + Cf+
               "\nperiodo de tiempo: " +n;
    }
    
    
    //operaciones
    public double Calcular_t(){
        return ((Math.pow((Cf/Ci), 1/n))-1)*100;
    }
    
    public double Calcular_intereses(){
        return Cf-Ci;
    }
    
    
    
}
