package uy.com.sofka.dojoreactividadejercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class DojoReactividadEjercicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(DojoReactividadEjercicio2Application.class, args);

    List<String> malasPalabras = List.of("malo1","malo2","malo3","malo4","malo5","malo6","malo7","malo8","malo9","malo10");

    while (true){
      System.out.println("Ingrese un mensaje");

      Scanner scanner = new Scanner(System.in);
      String mensaje = scanner.nextLine();
      String[] palabrasMensaje = mensaje.split(" ");

      List<String> listaPalabrasMensaje = Arrays.asList(palabrasMensaje);
      Flux<String> fluxPalabrasMensaje = Flux.fromIterable(listaPalabrasMensaje);

      Flux<String> mensajeCorregido = fluxPalabrasMensaje.map(palabra->{
        if(malasPalabras.contains(palabra)) 
          return "****";
        return palabra;
      });

      mensajeCorregido.subscribe(palabra->System.out.print("> " + palabra));
      System.out.println();
    }
	}

}
