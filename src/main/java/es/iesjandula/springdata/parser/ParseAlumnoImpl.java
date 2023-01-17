package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.Interfaces.IParseoDepartamento;
import es.iesjandula.springdata.models.Alumno;
import es.iesjandula.springdata.models.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.Scanner;

public class ParseAlumnoImpl implements IParseoDepartamento {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public void parseaFichero(Scanner scanner) {
        scanner.nextLine();

        while (scanner.hasNextLine()){
            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constant.DELIMITADOR_CSV);

            Alumno alumno = new Alumno();

            alumno.setId(Long.valueOf(lineaDelFicheroTroceada[0]));
            alumno.setNombre(lineaDelFicheroTroceada[1]);

            this.alumnoRepository.saveAndFlush(alumno);
        }
    }

}
