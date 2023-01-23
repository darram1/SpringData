package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.Interfaces.IMatriculaRepository;
import es.iesjandula.springdata.models.Alumno;
import es.iesjandula.springdata.models.Asignatura;
import es.iesjandula.springdata.models.Curso;
import es.iesjandula.springdata.models.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ParseoMatriculaImpl
{
    @Autowired
    private IMatriculaRepository iMatriculaRepository;

    public void mostrarMatriculas()
    {
        String matriculas = "src/main/resources/csv/matricula.csv";

        List<Matricula> listaMatricula = new ArrayList<>();

        File file = new File(matriculas);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Matricula matricula = new Matricula();

                Alumno alumno = new Alumno();
                alumno.setId(Long.valueOf(stLineaFichero[0]));
                matricula.setIdAlumno(alumno);

                Asignatura asignatura = new Asignatura();
                asignatura.setId(Long.valueOf(stLineaFichero[1]));
                matricula.setIdAsignatura(asignatura);

                Curso curso = new Curso();
                curso.setId(Long.valueOf(stLineaFichero[2]));
                matricula.setIdCurso(curso);


                listaMatricula.add(matricula);

            }
            for(Matricula matricula : listaMatricula)
            {
                this.iMatriculaRepository.saveAndFlush(matricula);
                System.out.println(matricula);
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }


}
