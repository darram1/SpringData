package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.repositorios.IAlumnoRepository;
import es.iesjandula.springdata.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static es.iesjandula.springdata.utils.Utils.convertStringToDateFormatddMMyyyy;

@Service
public class ParseoAlumnoImpl
{
    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    public void mostrarAlumnos()
    {
        String alumnos = "src/main/resources/csv/alumno.csv";
        List<Alumno> listaAlumnos = new ArrayList<>();
        File file = new File(alumnos);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Alumno alumno = new Alumno();

                alumno.setId(Long.valueOf(stLineaFichero[0]));
                alumno.setNif(stLineaFichero[1]);
                alumno.setNombre(stLineaFichero[2]);
                alumno.setApellido1(stLineaFichero[3]);
                alumno.setApellido2(stLineaFichero[4]);
                alumno.setCiudad(stLineaFichero[5]);
                alumno.setDireccion(stLineaFichero[6]);
                alumno.setTelefono(stLineaFichero[7]);
                alumno.setFechaNacimiento(convertStringToDateFormatddMMyyyy(stLineaFichero[8]));
                alumno.setSexo(stLineaFichero[9]);

                listaAlumnos.add(alumno);


            }
            for(Alumno alumno : listaAlumnos)
            {
                this.iAlumnoRepository.saveAndFlush(alumno);
                System.out.println(alumno);
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }


}
