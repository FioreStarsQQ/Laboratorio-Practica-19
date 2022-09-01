
// Realizar el siguiente programa en Java
// VIDEOJUEGO MAYOR-MENOR
// Crear un juego iterativo donde la PC genera un número entero entre 0 y 99, y el
// usuario debe adivinar dicho número. El programa ayudará indicando si el número
// generado es mayor o menor al ingresado. Si adivina el jugador, entonces gana,
// indicando en cuántos turnos lo hizo, de lo contrario pierde el jugador y el
// programa muestra cuál era el número buscado. Se le da al jugador 6
// oportunidades para adivinar.
// El juego debe describir las reglas: "se genera un aleatorio entre 0 y 99, y el
// jugador tiene 6 oportunidades para encontrarlo…"
// Luego el programa debe preguntar si desea empezar a jugar.
// Se juega hasta que el usuario ya no desea empezar un nuevo juego.
// Hacer que el programa verifique que el número que ingrese en cada intento
// siempre esté entre 0 y 99.

import javax.swing.*;

public class Juego {
    public static void main(String[] args) {
        int numGenerado, continuar = 0;
        imprimirReglasJuego();
        // preguntaContinuarJugando("¿Desea empezar el juego?", "Inicio");
        continuar = preguntaContinuarJugando("¿Desea empezar el juego?", "VIDEOJUEGO MAYOR-MENOR");// empezar?
        while (continuar == 1) {
            continuar = 0;
            numGenerado = numAleatorio(0, 99);// generar el numero secreto
            juegoAdivinarNum(numGenerado);// jugar un juego
            continuar = preguntaContinuarJugando("¿Desea empezar de nuevo este juego?", "Inténtalo otra vez...");// continuar?
        }
    }
    // Muestra las reglas del juego
    public static void imprimirReglasJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido(a), este juego se trata de adivinar el número generado aleatoriamente por la computadora, el número oscila entre 0 y 99."
                        + "\nUsted debe ingresar un número por turno, tendrá hasta 6 turnos, al mismo tiempo que se le irá indicando si está cerca de dar con el número.",
                "VIDEOJUEGO MAYOR-MENOR: Reglas del Juego", JOptionPane.INFORMATION_MESSAGE);
    }
    // Pregunta si desea continuar jugando
    public static int preguntaContinuarJugando(String ingresePregunta, String crearTitulo) {
        if (JOptionPane.showConfirmDialog(null, ingresePregunta, crearTitulo,
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            return 1;
        }
        return 0;
    }
    // Crea un numero aleatorio entre un rango que va a ser ingresado
    public static int numAleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min + 1)) + min);
    }
    // Juego
    public static void juegoAdivinarNum(int adivinarNumero) {
        int numeroElegido = 100;
        for (int i = 1; i <= 6 && numeroElegido != adivinarNumero; i++) {
            // Bucle que verificara si el numero elegido es válido para el turno
            do {
                numeroElegido = ingresarNum(i, 6);
            } while (numeroElegido < 0 || numeroElegido > 99);
            // Condionales que brindan ayuda para adivinar el número
            if (numeroElegido == adivinarNumero) {
                JOptionPane.showMessageDialog(null, "¡FELICIDADES! Lo adivinaste era el número " 
                + adivinarNumero+"\nLo has logrado en "+i+" intentos.");
            } else if (numeroElegido < adivinarNumero) {
                JOptionPane.showMessageDialog(null,
                        "El número de la computadora es mayor a " + numeroElegido + "\n"
                                + numeroCerca10(numeroElegido, adivinarNumero, i, 6));
            } else {
                JOptionPane.showMessageDialog(null, "El número de la computadora es menor a "
                        + numeroElegido + "\n" + numeroCerca10(numeroElegido, adivinarNumero, i, 6));
            }
        }
    }
    // Permite ingresar un numero y avisar si es la última oportunidad
    public static int ingresarNum(int min, int max) {
        if (min < max) {
            return Integer.parseInt(JOptionPane.showInputDialog(null,
                            ">>> Intento N° " + min + "\n¿Qué número crees ha sido elegido?",
                            "Adivine el número...", JOptionPane.QUESTION_MESSAGE));
        }
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                ">>> Intento N° " + min + "\nEsta es tu última oportunidad piénsalo bien...\n\n¿En qué número has pensado?",
                "Adivine el número...", JOptionPane.QUESTION_MESSAGE));
    }
    // Avisa si el numero ingresado esta cerca al numero que pretende adivinar (radio 10 nums)
    public static String numeroCerca10(int numConocido, int numDesconocido, int min, int max) {
        if (numConocido != numDesconocido) {
            if (Math.abs(numDesconocido - numConocido) <= 10 && min < max) {
                return "Estas cerca de adivinarlo...";
            } else if (min == max) {
                return ("Estabas cerca de adivinarlo, el número que tenías que adivinar era " + numDesconocido);
            }
        }
        return "";
    }
}