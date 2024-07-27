
package ClasesAbstractas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;

    public Menu() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Menu Principal -----");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Catedratico");
            System.out.println("3. Inscribir Alumno en Curso");
            System.out.println("4. Asignar Curso a Catedratico");
            System.out.println("5. Mostrar Alumnos");
            System.out.println("6. Mostrar Catedraticos");
            System.out.println("7. Eliminar Alumno");
            System.out.println("8. Eliminar Catedratico");
            System.out.println("9. Eliminar Curso");
            System.out.println("10. Actualizar Curso");
            System.out.println("11. Salir");
            System.out.print("Elige una opcion: ");
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarAlumno(scanner);
                        break;
                    case 2:
                        registrarCatedratico(scanner);
                        break;
                    case 3:
                        inscribirAlumnoEnCurso(scanner);
                        break;
                    case 4:
                        asignarCursoACatedratico(scanner);
                        break;
                    case 5:
                        mostrarAlumnos();
                        break;
                    case 6:
                        mostrarCatedraticos();
                        break;
                    case 7:
                        eliminarAlumno(scanner);
                        break;
                    case 8:
                        eliminarCatedratico(scanner);
                        break;
                    case 9:
                        eliminarCurso(scanner);
                        break;
                    case 10:
                        actualizarCurso(scanner);
                        break;
                    case 11:
                        System.out.println("Saliendo del programa...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    private void registrarAlumno(Scanner scanner) {
        System.out.print("Nombre del Alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Alumno: ");
        String id = scanner.nextLine();
        System.out.print("Carrera del Alumno: ");
        String carrera = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, id, carrera);
        alumnos.add(alumno);
        System.out.println("Alumno registrado exitosamente.\n");
    }

    private void registrarCatedratico(Scanner scanner) {
        System.out.print("Nombre del Catedrático: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Catedrático: ");
        String id = scanner.nextLine();
        System.out.print("Profesión del Catedrático: ");
        String profesion = scanner.nextLine();

        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
        System.out.println("Catedrático registrado exitosamente.\n");
    }

    private void inscribirAlumnoEnCurso(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        try {
            int numAlumno = scanner.nextInt() - 1;
            scanner.nextLine();

            System.out.print("Nombre del Curso: ");
            String nombreCurso = scanner.nextLine();
            System.out.print("Código del Curso: ");
            String codigoCurso = scanner.nextLine();

            Curso curso = new Curso(nombreCurso, codigoCurso);
            alumnos.get(numAlumno).inscribirCurso(curso);
            cursos.add(curso);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número de alumno no válido.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            scanner.next(); // Limpiar el buffer
        }
    }

    private void asignarCursoACatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        try {
            int numCatedratico = scanner.nextInt() - 1;
            scanner.nextLine();

            System.out.print("Nombre del Curso: ");
            String nombreCurso = scanner.nextLine();
            System.out.print("Código del Curso: ");
            String codigoCurso = scanner.nextLine();

            Curso curso = new Curso(nombreCurso, codigoCurso);
            catedraticos.get(numCatedratico).asignarCurso(curso);
            cursos.add(curso);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número de catedrático no válido.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            scanner.next(); // Limpiar el buffer
        }
    }

    private void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
        } else {
            System.out.println("Lista de Alumnos:");
            for (Alumno alumno : alumnos) {
                alumno.mostrarDetalles();
                System.out.println();
            }
        }
    }

    private void mostrarCatedraticos() {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
        } else {
            System.out.println("Lista de Catedráticos:");
            for (Catedratico catedratico : catedraticos) {
                catedratico.mostrarDetalles();
                System.out.println();
            }
        }
    }

    private void eliminarAlumno(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno a eliminar: ");
        try {
            int numAlumno = scanner.nextInt() - 1;
            scanner.nextLine();

            if (numAlumno >= 0 && numAlumno < alumnos.size()) {
                alumnos.remove(numAlumno);
                System.out.println("Alumno eliminado exitosamente.\n");
            } else {
                System.out.println("Número de alumno no válido.\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            scanner.next(); // Limpiar el buffer
        }
    }

    private void eliminarCatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático a eliminar: ");
        try {
            int numCatedratico = scanner.nextInt() - 1;
            scanner.nextLine();

            if (numCatedratico >= 0 && numCatedratico < catedraticos.size()) {
                catedraticos.remove(numCatedratico);
                System.out.println("Catedrático eliminado exitosamente.\n");
            } else {
                System.out.println("Número de catedrático no válido.\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            scanner.next(); // Limpiar el buffer
        }
    }

    private void eliminarCurso(Scanner scanner) {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.\n");
            return;
        }
        System.out.println("Lista de Cursos:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + 1 + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Elige el número del Curso a eliminar: ");
        try {
            int numCurso = scanner.nextInt() - 1;
            scanner.nextLine();

            if (numCurso >= 0 && numCurso < cursos.size()) {
                cursos.remove(numCurso);
                System.out.println("Curso eliminado exitosamente.\n");
            } else {
                System.out.println("Número de curso no válido.\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            scanner.next(); // Limpiar el buffer
        }
    }

    private void actualizarCurso(Scanner scanner) {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.\n");
            return;
        }
        System.out.println("Lista de Cursos:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + 1 + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Elige el número del Curso a actualizar: ");
        try {
            int numCurso = scanner.nextInt() - 1;
            scanner.nextLine();

            if (numCurso >= 0 && numCurso < cursos.size()) {
                System.out.print("Nuevo nombre del Curso: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Nuevo código del Curso: ");
                String nuevoCodigo = scanner.nextLine();

                Curso curso = cursos.get(numCurso);
                curso.setNombre(nuevoNombre);
                curso.setCodigo(nuevoCodigo);
                System.out.println("Curso actualizado exitosamente.\n");
            } else {
                System.out.println("Número de curso no válido.\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            scanner.next(); // Limpiar el buffer
        }
    }
}

