package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.repositorios.IDepartamentoRepository;
import es.iesjandula.springdata.models.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ParseoDepartamentoImpl
{
    @Autowired
    private IDepartamentoRepository iDepartamentoRepository;

    public void mostrarDepartamentos()
    {
        String departamentos = "src/main/resources/csv/departamento.csv";

        List<Departamento> listaDepartamento = new ArrayList<>();

        File file = new File(departamentos);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Departamento departamento = new Departamento();

                departamento.setId(Long.valueOf(stLineaFichero[0]));
                departamento.setNombre(stLineaFichero[1]);

                listaDepartamento.add(departamento);

            }
            for(Departamento departamento : listaDepartamento)
            {
                this.iDepartamentoRepository.saveAndFlush(departamento);
                System.out.println(departamento);
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }

}
