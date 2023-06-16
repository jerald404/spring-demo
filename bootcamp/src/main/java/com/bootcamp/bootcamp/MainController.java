package com.bootcamp.bootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hacer-algo")
    public String primeraPrueba() {
        return "Hola mundo";
    }

    @GetMapping("/generar-password")
    public String generarPassword() {
        double aleatorio = Math.random() * 1000000;
        long numeroAleatorio = Math.round(aleatorio);
        String password = "AsDf" + numeroAleatorio;
        return password;
    }

    @GetMapping("/transformar-a-codigo-morse/{texto}")
    public String codMorsePrueba(@PathVariable String texto) {
        String codigoTransformado = "";

        for (int i = 0; i < texto.length(); i++) {
            String letra = "" + texto.charAt(i);

            codigoTransformado = convertirLetraACodigoMorse(codigoTransformado, letra);
        }

        return codigoTransformado;
    }

    private static String convertirLetraACodigoMorse(String codigoTransformado, String letra) {
        String tablaAbc[] = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        String tablaCodigoMorse[] = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        for (int j = 0; j < tablaAbc.length; j++) {
            String letraTablaAbc = tablaAbc[j];
            if (letraTablaAbc.equalsIgnoreCase(letra)) {
                String caracterEnCodigoMorse = tablaCodigoMorse[j];
                codigoTransformado += caracterEnCodigoMorse + " ";
            }
        }
        return codigoTransformado;
    }


}
