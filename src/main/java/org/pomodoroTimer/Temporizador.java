package org.pomodoroTimer;


import java.util.Scanner;

public class Temporizador {
    private static volatile boolean pause = false; //Pausa inicia desactivado
    public static void ejecutar (int tiempoSegundos, String mensaje){

        System.out.println(mensaje + " iniciado! (Escribe 'p' para pausar y 'r' para reanudar y escribe 'q' para terminar.)");

        //Menu
        new Thread (() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("p")) {
                    pause = true;
                    System.out.println("⏸ Pausado!");
                } else if (input.equalsIgnoreCase("r")) {
                    pause = false;
                    System.out.println("▶ Reanudando...");
                }
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("⏹ Temporizador detenido. Saliendo...");
                    System.exit(0); // Cierra el programa
                }
            }
        }).start();

        //Bucle de temporizador
        while (tiempoSegundos > 0){
            if (!pause) {
                int minutos = tiempoSegundos / 60;
                int segundos = tiempoSegundos % 60;

                System.out.printf("%s: %02d:%02d%n", mensaje, minutos, segundos);
                tiempoSegundos--;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

