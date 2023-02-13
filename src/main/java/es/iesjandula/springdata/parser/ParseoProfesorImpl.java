package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.repositorios.IDepartamentoRepository;
import es.iesjandula.springdata.repositorios.IProfesorRepository;
import es.iesjandula.springdata.models.Departamento;
import es.iesjandula.springdata.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static es.iesjandula.springdata.utils.Utils.convertStringToDateFormatddMMyyyy;

@Service
public class ParseoProfesorImpl
{
    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Autowired
    private IDepartamentoRepository iDepartamentoRepository;

    public void mostrarProfesores()
    {
        String profesores = "src/main/resources/csv/profesor.csv";

        List<Profesor> listaProfesores = new ArrayList<>();
        File file = new File(profesores);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Profesor profesor = new Profesor();

                profesor.setId(Long.valueOf(stLineaFichero[0]));
                profesor.setNif(stLineaFichero[1]);
                profesor.setNombre(stLineaFichero[2]);
                profesor.setApellido1(stLineaFichero[3]);
                profesor.setApellido2(stLineaFichero[4]);
                profesor.setCiudad(stLineaFichero[5]);
                profesor.setDireccion(stLineaFichero[6]);
                profesor.setTelefono(stLineaFichero[7]);
                profesor.setFechaNacimiento(convertStringToDateFormatddMMyyyy(stLineaFichero[8]));
                profesor.setSexo(stLineaFichero[9]);

                Optional<Departamento> optionalDepartamento = this.iDepartamentoRepository.findById(Long.valueOf(stLineaFichero[6]));
                profesor.setIdDepartamento(optionalDepartamento.get());

                listaProfesores.add(profesor);


            }
            for(Profesor profesor : listaProfesores)
            {
                this.iProfesorRepository.saveAndFlush(profesor);
                System.out.println(profesor);
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }


    }


}
