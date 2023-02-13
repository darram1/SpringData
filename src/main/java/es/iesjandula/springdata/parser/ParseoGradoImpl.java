package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.repositorios.IGradoRepository;
import es.iesjandula.springdata.models.Grado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ParseoGradoImpl
{
    @Autowired
    private IGradoRepository iGradoRepository;

    public void mostrarGrados()
    {
        String grados = "src/main/resources/csv/grado.csv";

        List<Grado> listaGrado = new ArrayList<>();

        File file = new File(grados);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Grado grado = new Grado();

                grado.setId(Long.valueOf(stLineaFichero[0]));
                grado.setNombre(stLineaFichero[1]);

                listaGrado.add(grado);

            }
            for (Grado grado : listaGrado)
            {
                this.iGradoRepository.saveAndFlush(grado);
                System.out.println(grado);
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }

}
