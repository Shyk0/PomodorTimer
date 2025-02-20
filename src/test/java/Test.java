package org.pomodoroTimer;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        int tiempoSegundos = 25*60; //25 minutos a segundos
        int ciclos = 4;

        System.out.println("Iniciando bloque de estudios! Suerte!");

        while (ciclos < 1){
            int minutos = tiempoSegundos / 60;//Convierte en minutos
            int segundos = tiempoSegundos % 60;//Convierte en segundos

            System.out.printf("Tiempo restante: %02d:%02d%n", minutos, segundos);
            tiempoSegundos--; //Resta 1 por cada iteracion
            try{
                Thread.sleep(1000);//Espera un segundo
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            ciclos++;
        }
        System.out.println("Tiempo terminado!");
        Toolkit.getDefaultToolkit().beep();//Sonido
    }
}