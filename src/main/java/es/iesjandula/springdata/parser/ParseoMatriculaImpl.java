package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.repositorios.IAlumnoRepository;
import es.iesjandula.springdata.repositorios.IAsignaturaRepository;
import es.iesjandula.springdata.repositorios.ICursoRepository;
import es.iesjandula.springdata.repositorios.IMatriculaRepository;
import es.iesjandula.springdata.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ParseoMatriculaImpl
{
    @Autowired
    private IMatriculaRepository iMatriculaRepository;

    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    @Autowired
    private IAsignaturaRepository iAsignaturaRepository;

    @Autowired
    private ICursoRepository iCursoRepository;

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

                Optional<Alumno> optionalAlumno = this.iAlumnoRepository.findById(Long.valueOf(stLineaFichero[0]));
                matricula.setIdAlumno(optionalAlumno.get());

                Optional<Asignatura> opcAsignatura = this.iAsignaturaRepository.findById(Long.valueOf(stLineaFichero[1]));
                matricula.setIdAsignatura(opcAsignatura.get());


                Optional<Curso> optionalCurso = this.iCursoRepository.findById(Long.valueOf((stLineaFichero[2])));
                matricula.setIdCurso(optionalCurso.get());


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
