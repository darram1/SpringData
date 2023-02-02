package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.Interfaces.IAsignaturaRepository;
import es.iesjandula.springdata.Interfaces.IGradoRepository;
import es.iesjandula.springdata.Interfaces.IProfesorRepository;
import es.iesjandula.springdata.models.Asignatura;
import es.iesjandula.springdata.models.Grado;
import es.iesjandula.springdata.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ParseoAsignaturaImpl
{
    @Autowired
    private IAsignaturaRepository iAsignaturaRepository;

    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Autowired
    private IGradoRepository iGradoRepository;



    public void mostrarAsignaturas()
    {
        String asignaturas = "src/main/resources/csv/asignatura.csv";

        List<Asignatura> listaAsignatura = new ArrayList<>();

        File file = new File(asignaturas);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Asignatura asignatura= new Asignatura();

                asignatura.setId(Long.valueOf(stLineaFichero[0]));
                asignatura.setCreditos(Double.valueOf(stLineaFichero[2]));
                asignatura.setCuatrimestre(Integer.valueOf(stLineaFichero[5]));
                asignatura.setCurso(Integer.valueOf(stLineaFichero[4]));
                asignatura.setNombre(stLineaFichero[1]);
                asignatura.setTipo(stLineaFichero[3]);

                Optional<Profesor> optionalProfesor = this.iProfesorRepository.findById(Long.valueOf(stLineaFichero[6]));
                asignatura.setIdProfesorId(optionalProfesor.get());

                Optional<Grado> optionalGrado = this.iGradoRepository.findById(Long.valueOf(stLineaFichero[7]));
                asignatura.setIdProfesorId(optionalProfesor.get());


                listaAsignatura.add(asignatura);

            }
            for(Asignatura asignatura : listaAsignatura)
            {
                this.iAsignaturaRepository.saveAndFlush(asignatura);
                System.out.println(asignatura);
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }

}
