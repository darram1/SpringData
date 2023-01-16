package es.iesjandula.springdata.parser;

import es.iesjandula.springdata.Interfaces.IParseoDepartamento;
import es.iesjandula.springdata.models.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.Scanner;

public class ParseDepartamentoImpl implements IParseoDepartamento {

    @Autowired
    private Departamento departamento;

    @Override
    public void parseaFichero(Scanner scanner) {
        scanner.nextLine();

        while (scanner.hasNextLine()){
            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constant.DELIMITADOR_CSV);

            Departamento departamento
        }
    }

}
