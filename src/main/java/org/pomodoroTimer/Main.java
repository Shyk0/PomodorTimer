package org.pomodoroTimer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tiempoTrabajo = 25 * 60; // 25 minutos
        int tiempoBreakCorto = 5 * 60; // 5 minutos
        int tiempoBreakLargo = 15 * 60; // 15 minutos
        int ciclos = 0;

        System.out.println("""
                    ####################################################
                    #Hola! Bienvenido a nuestro proyecto POMODOROTIMER!#
                    ####################################################
                
                #############################################################
                #                                                           #
                #Menu:                                                      #
                #                                                           #
                #Presiona 1: si quieres trabajar con el tiempo convencional.#
                #                                                           #
                #***********************************************************#
                #                                                           #
                #Presiona 2: si quieres trabajar con tiempo personalizado.  #
                #                                                           #
                #############################################################
                
              
                """);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingresa el tiempo personalizado en segundos:");
                int tiempoPersonalizado = scanner.nextInt();
                System.out.println("Iniciando Temporizador Personalizado! 🎯");

                while (true) {
                    ciclos++;
                    Temporizador.ejecutar(tiempoPersonalizado, "Tiempo Personalizado");

                    if (ciclos % 4 == 0) {
                        Temporizador.ejecutar(tiempoBreakLargo, "Descanso largo");
                    } else {
                        Temporizador.ejecutar(tiempoBreakCorto, "Descanso corto");
                    }
                }

            case 2:
                System.out.println("Iniciando PomodoroTimer! 💪");
                while (true) {
                    ciclos++;
                    Temporizador.ejecutar(tiempoTrabajo, "Tiempo de estudio");

                    if (ciclos % 4 == 0) {
                        Temporizador.ejecutar(tiempoBreakLargo, "Descanso largo");
                    } else {
                        Temporizador.ejecutar(tiempoBreakCorto, "Descanso corto");
                    }
                }

            default:
                System.out.println("Opción no válida. Reinicia el programa e ingresa 1 o 2.");
        }

        scanner.close();
    }
}
