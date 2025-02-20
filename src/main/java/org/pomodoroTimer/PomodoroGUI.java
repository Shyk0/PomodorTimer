package org.pomodoroTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PomodoroGUI extends JFrame {
    private int tiempoRestante = 25 * 60;
    private boolean isPaused = false;
    private boolean isNightMode = false; // Track mode state
    private JLabel etiquetaTiempo;
    private Timer timer;
    private JPanel panelBotones;

    public PomodoroGUI() {
        setTitle("Pomodoro Timer");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Timer label
        etiquetaTiempo = new JLabel(formatTime(tiempoRestante), SwingConstants.CENTER);
        etiquetaTiempo.setFont(new Font("Arial", Font.BOLD, 40));
        add(etiquetaTiempo, BorderLayout.CENTER);

        // Button panel
        panelBotones = new JPanel();
        JButton iniciarBoton = new JButton("Start");
        JButton pausarBoton = new JButton("Pause");
        JButton reanudarBoton = new JButton("Resume");
        JButton salirBoton = new JButton("Salir");
        JButton toggleModeButton = new JButton("Toggle Night/Day");

        // Button actions
        iniciarBoton.addActionListener(e -> {
            if (!timer.isRunning()) {
                timer.start();
            }
        });

        pausarBoton.addActionListener(e -> isPaused = true);
        reanudarBoton.addActionListener(e -> isPaused = false);
        salirBoton.addActionListener(e -> System.exit(0));
        // Toggle Night/Day Mode
        toggleModeButton.addActionListener(e -> switchMode());

        panelBotones.add(iniciarBoton);
        panelBotones.add(pausarBoton);
        panelBotones.add(reanudarBoton);
        panelBotones.add(toggleModeButton);
        panelBotones.add(salirBoton);
        add(panelBotones, BorderLayout.SOUTH);

        // Timer logic
        timer = new Timer(1000, e -> {
            if (!isPaused && tiempoRestante > 0) {
                tiempoRestante--;
                etiquetaTiempo.setText(formatTime(tiempoRestante));
            } else if (tiempoRestante == 0) {
                timer.stop();
                etiquetaTiempo.setText("Time's up!");
            }
        });

        setVisible(true);
    }

    // Convert seconds to MM:SS format
    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }

    // Function to switch between night and day mode
    private void switchMode() {
        if (isNightMode) {
            getContentPane().setBackground(Color.LIGHT_GRAY);
            etiquetaTiempo.setForeground(Color.BLACK);
            panelBotones.setBackground(Color.LIGHT_GRAY);
        } else {
            getContentPane().setBackground(Color.DARK_GRAY);
            etiquetaTiempo.setForeground(Color.WHITE);
            panelBotones.setBackground(Color.DARK_GRAY);
        }
        isNightMode = !isNightMode;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PomodoroGUI::new);
    }
}
