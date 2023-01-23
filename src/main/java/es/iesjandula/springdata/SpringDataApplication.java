package es.iesjandula.springdata;


import es.iesjandula.springdata.parser.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    @Autowired
    private ParseoDepartamentoImpl parseoDepartamento ;

    @Autowired
    private ParseoAlumnoImpl parseoAlumno = new ParseoAlumnoImpl();

    @Autowired
    private ParseoCursoImpl parseoCurso = new ParseoCursoImpl();

    @Autowired
    private ParseoAsignaturaImpl parseoAsignatura = new ParseoAsignaturaImpl();

    @Autowired
    private ParseoGradoImpl parseoGrado = new ParseoGradoImpl();

    @Autowired
    private ParseoMatriculaImpl parseoMatricula = new ParseoMatriculaImpl();

    @Autowired
    private ParseoProfesorImpl parseoProfesor = new ParseoProfesorImpl();



    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);

    }

    @Transactional(readOnly = false)
    public void run(String... args)
    {

        this.parseoAlumno.mostrarAlumnos();
        //this.parseoAsignatura.mostrarAsignaturas();
        this.parseoCurso.mostrarCursos();
        this.parseoDepartamento.mostrarDepartamentos();
        this.parseoGrado.mostrarGrados();
        //this.parseoMatricula.mostrarMatriculas();
        //this.parseoProfesor.mostrarProfesores();

    }
}
