import java.util.Scanner;

class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public void withdraw(double value) {
        this.balance -= value;
        if (this.balance < 0) {
            System.out.println("Masz za mało pieniędzy żeby wypłacić tę kwotę");
            this.balance += value;
        }
    }

    public void deposit(double value) {
        this.balance += value;

    }

    double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Account account = new Account();

        boolean exit = false;
        while (!exit) {
            System.out.println("Witaj w banku!");
            System.out.println("Co chcesz zrobic?");
            System.out.println("1. Sprawdzic saldo konta");
            System.out.println("2. Wplacic pieniadze");
            System.out.println("3. Wyplacic pieniadze");
            System.out.println("4. Wyjście");
            System.out.println("Wybierz opcje: ");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Saldo twojego konta wynosi: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Wprowadz kwote jaką chcesz wpłacić: ");
                    double payments = scan.nextDouble();
                    if(payments < 0){
                        System.out.println("Nie możesz wpłacić kwoty na minusie");
                        break;
                    } else if (payments == 0) {
                        System.out.println("Nie możesz wpłacić niczego na konto");
                        break;
                    }
                    account.deposit(payments);
                    System.out.println("Saldo po wpłacie: " + account.getBalance());
                    break;
                case 3:
                    System.out.println("Wprowadz kwote jaka chcesz wyplacić: ");
                    double withdraws = scan.nextDouble();
                    if(withdraws < 0){
                        System.out.println("Nie możesz wypłacić kwoty na minusie");
                        break;
                    } else if (withdraws == 0) {
                        System.out.println("Nie możesz wpłacić niczego na konto");
                        break;
                    }
                    account.withdraw(withdraws);
                    System.out.println("Saldo po wypłacie: " + account.getBalance());
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Niepoprawna opcja, wybierz ponownie");
                    break;
            }
        }
        System.out.println("Dziekujemy za skorzystanie z naszych uslug!");
    }
}