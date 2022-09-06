import models.Rule;
import models.User;
import java.util.ArrayList;

import java.util.Scanner;

public class Runner {
    public ArrayList<User> userList = new ArrayList<User>();
    public User section;
    public boolean isRunning = true;

    public Runner() {
        this.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (this.isRunning) {
            System.out.println(this.section != null ? "Seção ok!" : "Faça login para continuar");
            System.out.println("1 - Para continuar\n2 - Criar usuario\n3 - fazer login");
            if (this.section != null && this.section.type == Rule.ADMIN) System.out.println("4 - Opção de administrador");
            int option = scanner.nextInt();
            if (option == 2) {
                User newUser = this.createNewUser();
                userList.add(newUser);
            }
            if (option == 3) {
                System.out.println("Digite seu email");
                scanner.nextLine();
                String email = scanner.nextLine();
                System.out.println("Digite sua senha");
                // scanner.nextLine();
                String password = scanner.nextLine();

                for(User user: this.userList) {
                    if (!user.getEmail().equals(email)){
                        System.out.println("Email não confere");
                        continue;
                    }
                    if (!user.getPassword().equals(password)){
                        System.out.println("Senha não confere");
                        continue;
                    }
                    this.section = user;
                    break;
                }
            }
            if (option == 0) this.isRunning = false;
        }
        System.out.println("Sistema encerrado");
    }

    private User createNewUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o email do seu novo usuario");
        String userName = scanner.nextLine();
        System.out.println("Digite o nome do seu novo usuario");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do seu novo usuario");
        String password = scanner.nextLine();

        return new User(userName, email, password);
    }
}
