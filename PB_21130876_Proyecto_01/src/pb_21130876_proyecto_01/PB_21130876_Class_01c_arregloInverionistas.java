/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pb_21130876_proyecto_01;

import java.text.DecimalFormat;
import javax.swing.JTable;

/**
 *
 * Luis Ernesto Barranco Núñez
 * 21130876
 */
class Inversionistas {
    ////////////////////ATRIBUTOS////////////////////
    private Inversor [] Inversionista = null;
    private DecimalFormat df = new DecimalFormat("###,###.00");
    
    /////////////////METODOS//////////////////////////
    
    //constructores
    //default
    public Inversionistas(){
        Inversionista = new Inversor[4];
    }
    //parametrizado
    public Inversionistas(JTable tabla){
        Inversionista = new Inversor[tabla.getRowCount()];
        
        for(int r = 0;r<tabla.getRowCount();r++){
            Inversor n = new Inversor();
            
            n.setInversionista(tabla.getValueAt(r, 0)+"");//guardamos el nombre
            n.setCi(Double.parseDouble(tabla.getValueAt(r,1)+"")); //guardamos el capital inicial
            n.setN(Double.parseDouble(tabla.getValueAt(r,2)+"")); //guardamos el periodo de tiempo
            n.setCf(Double.parseDouble(tabla.getValueAt(r,5)+"")); //guardamos el capital final
        
            this.setInversor(n,r);
        }
    }
    
    
    //get y set
    public Inversor getInversor(int posicion){
        if(posicion >=0 && posicion <= Inversionista.length-1){
            return Inversionista[posicion];
        }else{
            return new Inversor();
        }
    }
    
    public void setInversor(Inversor a, int posicion){
        if(posicion >=0 && posicion <= Inversionista.length-1){
            Inversionista[posicion] = a;
        }
    }
    
    //operaciones||funciones
    
    //operaciones del arreglo
    public void mostrar(JTable tabla_inversores, JTable totales){
        double totalCi = 0;
        double totalCf = 0;
        double totalN = 0;
        double totalt = 0;
        double totalInteres = 0;
        //calculamos la tasa de interes y el interes generado
        for(int r = 0; r < tabla_inversores.getRowCount();r++){
            tabla_inversores.setValueAt(Inversionista[r].getInversionista(),r,0);//obtenemos el nombre
            tabla_inversores.setValueAt(Inversionista[r].getCi(),r,1);//obtenemos el capital inicial
            tabla_inversores.setValueAt(Inversionista[r].getCf(),r,5);//obtenemos el capital final
            tabla_inversores.setValueAt(Inversionista[r].getN(),r,2);//obtenemos el periodo de tiempo
            
            tabla_inversores.setValueAt(df.format(Inversionista[r].Calcular_t()),r,3);
            tabla_inversores.setValueAt(df.format(Inversionista[r].Calcular_intereses()),r,4);
            
            totalCi = totalCi + Inversionista[r].getCi();
            totalN = totalN + Inversionista[r].getN();
            
            totalt = totalt + Inversionista[r].Calcular_t();
            totalInteres = totalInteres + Inversionista[r].Calcular_intereses();
            
            totalCf = totalCf + Inversionista[r].getCf();
        }
        totales.setValueAt(df.format(totalCi),0,1);
        totales.setValueAt(df.format(totalN/tabla_inversores.getRowCount()),0,2);
        totales.setValueAt(df.format(totalt/tabla_inversores.getRowCount()),0,3);
        totales.setValueAt(df.format(totalInteres),0,4);
        totales.setValueAt(df.format(totalCf),0,5);
        
    
    }
    
    //mayor tasa de interes
    public Inversor MayorInteres(){
        Inversor Mayor = Inversionista[0];
        
        for(int i = 1 ; i < Inversionista.length;i++){
            if(Inversionista[i].Calcular_t() > Mayor.Calcular_t() ){
                Mayor = Inversionista[i];
            }
        }
        
        return Mayor;
    }
    
    //menor tasa de interes
    public Inversor MenorInteres(){
        Inversor Menor = Inversionista[0];
        
        for(int i = 1 ; i < Inversionista.length;i++){
            if(Inversionista[i].Calcular_t() < Menor.Calcular_t() ){
                Menor = Inversionista[i];
            }
        }
        
        return Menor;
    }
    
    //orden alfabetico
    public void OrdenAlfabetico(){
        for(int i=0; i < Inversionista.length-1; i++)
            for(int j=i+1; j < Inversionista.length; j++)
                if(Inversionista[i].getInversionista().compareToIgnoreCase(Inversionista[j].getInversionista()) > 0 ){
                    Inversor aux = Inversionista[i];
                    Inversionista[i] = Inversionista[j];
                    Inversionista[j] = aux;
                }
    }
    
    //orden descendente por tasa de interes
    public void OrdenTasaInteres(){
        for(int i=0; i < Inversionista.length-1; i++)
            for(int j=i+1; j < Inversionista.length; j++)
                if(Inversionista[i].Calcular_t()<Inversionista[j].Calcular_t()){
                    Inversor aux = Inversionista[i];
                    Inversionista[i] = Inversionista[j];
                    Inversionista[j] = aux;
                }
    }
}
