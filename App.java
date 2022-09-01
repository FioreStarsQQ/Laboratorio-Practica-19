public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
// public static void juegoAdivinarNum(int adivinarNumero, int tamañoDelRango) {
//         int numeroElegido, min = 0, max;
//         max = tamañoDelRango - 1;
//         for (int i = 1; i <= 6; i++) {
//             numeroElegido = Integer.parseInt(
//                     JOptionPane.showInputDialog(null, "Ingrese el numero que supone fue generado por la computadora: ",
//                             "Adivine el número...", JOptionPane.QUESTION_MESSAGE));

//             tamañoDelRango = min + (max - min) / 2;
//             if (numeroElegido == adivinarNumero) {
//                 JOptionPane.showMessageDialog(null, "adivinaste " + adivinarNumero);
//             } else if (numeroElegido < adivinarNumero) {
//                 min = tamañoDelRango + 1;
//                 JOptionPane.showMessageDialog(null,
//                         "min: " +min + "max: " + max
//                                 + " tamaño del rango: " + tamañoDelRango
//                                 + " El numero de la computadora es mayor al elegido " + "compu: " +adivinarNumero);
//             } else {
//                 max = tamañoDelRango - 1;
//                 JOptionPane.showMessageDialog(null,
//                         "min: " + min
//                                 +"max: " +max +" tamaño del rango: "+tamañoDelRango+ " El numero de la computadora es menor al elegido " + "compu: "
//                                 +adivinarNumero);
//             }
//             JOptionPane.showMessageDialog(null, " Fuera, tamaño del rango: "+ tamañoDelRango);
