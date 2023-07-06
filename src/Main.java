import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
   public static List<Person> students = new ArrayList<Person>();

    public static void main(String[] args) {

        boolean exit = true;
        while (exit){

            //Abaixo, menu - Below, menu
            System.out.println("Insira a opção desejada:");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Buscar aluno");
            System.out.println("3 - Remover aluno");
            System.out.println("4 - Editar aluno");
            System.out.println("5 - Encerrar");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    signStudent(students);
                    break;
                case 2:
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudent(students, nameToFind);
                    break;

                case 3:
                    delStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    exit = false;
                    break;
            }
        }
    }

    //Cadastrar estudante - Register student
    private static void signStudent(List<Person> students){
        Person student = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante:");
        student.name = scanner.next();
        students.add(student);
        System.out.println("Obrigado por digitar o nome completo do " + student.name + ".");
    }

    //Buscar estudante - Search student
    private static Integer findStudent(List<Person> students, String studentName){
        boolean finding = true;
        Integer position = null;

        for(int count = 0; count < students.size(); count++){
            Person student = students.get(count);
            if(student.name.equals(studentName)){
                position = count;
                System.out.println("Consegui encontrar o " + studentName + ".");
                finding = false;
            }
        }
        if(finding == true) {
            System.out.println("Não foi possível encontrar o " + studentName + ".");
        }
    return position;
    }
    //Deletar estudante - Remove student
    private static void delStudent() {
                    System.out.println("Qual estudante gostaria de remover?");
                    String name = scanner.next();
                    Integer position = findStudent(students, name);
                    if(position != null){
                        students.remove(position.intValue());
                        System.out.println("Estudante removido com sucesso.");
                    }
    }

    //Editar estudante - Edit student
    private static void editStudent(){
        System.out.println("Qual o nome que deseja editar?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if(position != null){
            Person p1 = students.get(position.intValue());
            System.out.println("Qual é o novo nome?");
            name = scanner.next();
            //studants.get(position.intValue()).name = name;
            p1.name = name;
        }
    }
}