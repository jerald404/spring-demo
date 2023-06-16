package com.bootcamp.bootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusquedaController {

    @GetMapping("/hacer-algo2.0")
    public String segundaPrueba() {
        return "Hola mundo";
    }

    @GetMapping("/busqueda-usuario/{busqueda}")
    public String[] obtenerPalabrasAutocompletar(@PathVariable String busqueda) {
        String frasesTipicasDeBusqueda[] = {"java bootcamp", "python curso",
                "java lts", "node js", "typescript tutorial", "azure"};

        String resultadoDeLaBusqueda[] = new String[10];
        int contador = 0;

        for (String frase : frasesTipicasDeBusqueda) {
            if (frase.toLowerCase().contains(busqueda.toLowerCase())) {
                resultadoDeLaBusqueda[contador] = frase;
                contador++;
            }
        }

        return resultadoDeLaBusqueda;

    }

}
