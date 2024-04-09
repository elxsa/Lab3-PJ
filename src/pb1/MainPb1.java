package pb1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public double[] calculVarf() {
        double xVarf = -((double) b / (2 * a));
        double yVarf = -((double) (b * b - 4 * a * c) / (4 * a));
        return new double[]{xVarf, yVarf};
    }

    public static double[] mijSegm(Parabola p1, Parabola p2) {
        double[] varf1 = p1.calculVarf();
        double[] varf2 = p2.calculVarf();
        double xMij = (varf1[0] + varf2[0]) / 2;
        double yMij = (varf1[1] + varf2[1]) / 2;
        return new double[]{xMij, yMij};
    }

    public static double lungSegm(Parabola p1, Parabola p2) {
        double[] varf1 = p1.calculVarf();
        double[] varf2 = p2.calculVarf();
        return Math.hypot(varf1[0] - varf2[0], varf1[1] - varf2[1]);
    }
}

public class MainPb1 {
    public static void main(String[] args) {
        List<Parabola> parabole = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("in.txt"));
            while (scanner.hasNextLine()) {
                String[] coeficienti = scanner.nextLine().split(" ");
                int a = Integer.parseInt(coeficienti[0]);
                int b = Integer.parseInt(coeficienti[1]);
                int c = Integer.parseInt(coeficienti[2]);
                Parabola parabola = new Parabola(a, b, c);
                parabole.add(parabola);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Parabola parabola : parabole) {
            System.out.println("Parabola: " + parabola);
            double[] varf = parabola.calculVarf();
            System.out.println("Varful parabolei: (" + varf[0] + ", " + varf[1] + ")");
            System.out.println();
        }

        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);
            double[] mijloc = Parabola.mijSegm(p1, p2);
            double lungime = Parabola.lungSegm(p1, p2);
            System.out.println("Mijlocul segmentului care uneste varfurile celor doua parabole: (" + mijloc[0] + ", " + mijloc[1] + ")");
            System.out.println("Lungimea segmentului care uneste varfurile celor doua parabole: " + lungime);
        }
    }
}
