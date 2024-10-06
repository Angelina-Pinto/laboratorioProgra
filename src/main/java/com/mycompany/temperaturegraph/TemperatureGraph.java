/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.temperaturegraph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class TemperatureGraph {
   

    public static String cadenaAsteriscos(int cantidadAsteriscos, double temperatura) {
       StringBuilder asteriscos = new StringBuilder();  

       for (int i = 0; i < Math.abs(cantidadAsteriscos); i++) {
           asteriscos.append("*");
       }

       // Si la temperatura es negativa, asteriscos antes de la línea vertical
       if (temperatura < 0) {
           return temperatura + "    " + asteriscos + "|";
       } else {
           // Si la temperatura es positiva, asteriscos después de la línea vertical
           return temperatura + "                           |" + asteriscos;
       }
   }

   public static void main(String[] args) {
       List<Double> listatemperatura = new ArrayList<>();
       double asteriscos = 0;
       int cantidad_asteriscos = 0;
       String rutaArchivo = "C:/Users/Dell/OneDrive/Documentos/NetBeansProjects/temperatureGraph/src/main/java/com/mycompany/temperaturegraph/data.dat";
       
       // Leer el archivo de temperaturas
       try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
           String linea;
           while ((linea = br.readLine()) != null) {
               // Divide la línea en partes usando la coma como delimitador
               String[] temperatura = linea.split(",");
               
               // Procesa cada valor de temperatura
               for (String valor : temperatura) {
                   // Convierte la cadena de temperatura a un número decimal
                   double valorTemperatura = Double.parseDouble(valor.trim());
                   listatemperatura.add(valorTemperatura);  // Agregar a la lista
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

       // Mostrar las temperaturas y los asteriscos
       System.out.println("Temperaturas para 24 horas:");
       for (double temperatura : listatemperatura) {
           // Dividir la temperatura entre 3 y redondear el resultado
           asteriscos = temperatura / 3;
           cantidad_asteriscos = (int) Math.round(asteriscos);  // Redondeo a entero

           // Imprimir la temperatura con la cadena de asteriscos adecuada
           System.out.println(cadenaAsteriscos(cantidad_asteriscos, temperatura));
       }
   }
}