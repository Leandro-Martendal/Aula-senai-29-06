import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Person> students = new ArrayList<Person>();
        boolean exit = true;
        while (exit){
            Scanner scanner = new Scanner(System.in);

            //Abaixo, menu - Below, menu
            System.out.println("Insira a opção desejada:");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Buscar aluno");
            System.out.println("3 - Encerrar");
            int option = scanner.nextInt();
            switch (option){
                case 1 :
                    signStudent(students);
                    break;
                case 2 :
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudent(students, nameToFind);
                    break;
                case 3 :
                    exit = false;
                    break;
            }
        }
    }

    //Cadastrar estudante - Register student
    private static void signStudent(List<Person> students){
        Person student = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante");
        student.name = scanner.next();
        students.add(student);
        System.out.println("Obrigado por digitar o nome completo do " + student.name);
    }

    //Buscar estudante - Search student
    private static void findStudent(List<Person> students, String studentName) {
        boolean finding = true;

        for(int count = 0; count < students.size(); count++){
            Person student = students.get(count);
            if(student.name.equals(studentName)){
                System.out.println("Connsegui encontrar o " + studentName);
                finding = false;
            }
        }
        if(finding == true) {
            System.out.println("Não foi possível encontrar o " + studentName);
        }
    }
}