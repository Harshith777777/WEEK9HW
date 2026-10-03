import java.util.*;

abstract class Ticket {
    int count;
    static final double FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getAmount() {
        return count * (getPrice() + FEE);
    }

    abstract String getSeat();
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }

    String getSeat() {
        return "REGULAR";
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }

    String getSeat() {
        return "PREMIUM";
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }

    String getSeat() {
        return "RECLINER";
    }
}

public class week9q1hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                tickets[i] = new Regular(count);
            } else if (seat.equals("PREMIUM")) {
                tickets[i] = new Premium(count);
            } else {
                tickets[i] = new Recliner(count);
            }
        }

        double total = 0;

        for (Ticket t : tickets) {
            double amount = t.getAmount();
            System.out.printf("%s: %.2f%n", t.getSeat(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}