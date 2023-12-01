package pb_21130876_proyecto_01;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alope
 */
class Nombres {
    ///////////Atributos////////////////
    static private Random azar = new Random();
    
    static private String [] nom = {"Juan","Luis","Maria","Adolfo","Diana","Raul","Laura",
                     "Viviana","Patricia","Jose","Ulises","Javier","Jorge",
                     "Fernanda","Natalia","Daniela","Alberto","Victor",
                     "Eduardo","Victor","Manuel","Roberto","Adriana",
                     "Sofia","Blanca","Veronica","Beatriz","Bertha","Luis",
                     "Ricardo","Carlos","Karla","Daniela","Armando","Antonio",
                     "Julieta","Julio","Oscar","Mario","Cesar","Lourdes"};
    
    static private String [] ape = {"Ruiz","Lopez","Gomez","Garcia","Perez","Fernandez",
                     "Rangel","Salazar","Vazquez","Enriquez","Ciseña",
                     "Alba","Hernandez","Rocha","Mendez","Pedroza","Herrera",
                     "Marquez","Sanchez","Ramirez","Gonzalez","Martinez",
                     "Montes","Rosales","Arroyo","Tapia","Valenzuela","Romo",
                     "Arias","Salinas","Duran","Robles","Jimenez","Guzman",
                     "Villarreal","Calderon","Morales","Castro","Mendoza"};
    ////////////Metodos//////////////
    static public String nextNombre()
    {
        return nom[azar.nextInt(nom.length)];
    }

    static public String nextApellido()
    {
        return ape[azar.nextInt(ape.length)];
    }

    static public String nextNombreCorto()
    {
        return nextNombre() + " " + nextApellido();
    }

    static public String nextNombreCompleto()
    {
        return nextNombreCorto() + " " + nextApellido();
    }
    
    static public String nextNombreLegal()
    {
        return nextApellido() + " " + nextApellido() + " " + nextNombre();
    }
}
