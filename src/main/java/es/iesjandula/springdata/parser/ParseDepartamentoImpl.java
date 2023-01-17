package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.Interfaces.IParseoAlumno;
import es.iesjandula.springdata.Interfaces.IParseoDepartamento;
import es.iesjandula.springdata.models.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.Scanner;

public class ParseDepartamentoImpl implements IParseoAlumno {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public void parseaFichero(Scanner scanner) {
        scanner.nextLine();

        while (scanner.hasNextLine()){
            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constant.DELIMITADOR_CSV);

            Departamento departamento = new Departamento();

            departamento.setId(Long.valueOf(lineaDelFicheroTroceada[0]));
            departamento.setNombre(lineaDelFicheroTroceada[1]);

            this.departamentoRepository.saveAndFlush(departamento);
        }
    }

}
