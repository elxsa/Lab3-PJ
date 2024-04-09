package pb2;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirare;
    private static double incasari;

    public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirare) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirare = dataExpirare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(LocalDate dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public static double getIncasari() {
        return incasari;
    }

    public static void actualizeazaIncasari(double suma) {
        incasari += suma;
    }

    @Override
    public String toString() {
        return denumire + ", " + pret + ", " + cantitate + ", " + dataExpirare;
    }
}

public class MainPb2 {
    private static List<Produs> listaProduse = new ArrayList<>();

    public static void main(String[] args) {
        citesteProduse("produse.csv");

        Scanner scanner = new Scanner(System.in);
        boolean continuare = true;
        while (continuare) {
            System.out.println("\n===== MENIU =====");
            System.out.println("1. Afisare produse");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Vanzare produs");
            System.out.println("4. Afisare produse cu pret minim");
            System.out.println("5. Salvare produse cu cantitate sub o valoare");
            System.out.println("6. Iesire");
            System.out.print("Alegeti o opțiune: ");
            int optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    afisareProduse();
                    break;
                case 2:
                    afisareProduseExpirate();
                    break;
                case 3:
                    vanzareProdus();
                    break;
                case 4:
                    afisareProduseCuPretMinim();
                    break;
                case 5:
                    salvareProduseCantitateSubValoare();
                    break;
                case 6:
                    continuare = false;
                    break;
                default:
                    System.out.println("Optiunea aleasa este gresita!");
            }
        }
    }
    private static void citesteProduse(String numeFisier) {
        try (Scanner scanner = new Scanner(new File(numeFisier))) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                String[] componente = linie.split(",");
                String denumire = componente[0];
                double pret = Double.parseDouble(componente[1]);
                int cantitate = Integer.parseInt(componente[2]);
                LocalDate dataExpirare = LocalDate.parse(componente[3]);
                listaProduse.add(new Produs(denumire, pret, cantitate, dataExpirare));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul " + numeFisier + " NU a fost gasit!");
        }
    }
    private static void afisareProduse() {
        if (listaProduse.isEmpty()) {
            System.out.println("Nu exista produse in lista.");
            return;
        }
        System.out.println("Produse:");
        for (Produs produs : listaProduse) {
            System.out.println(produs);
        }
    }
    private static void afisareProduseExpirate() {
        LocalDate dataCurenta = LocalDate.now();
        System.out.println("Produse expirate:");
        for (Produs produs : listaProduse) {
            if (produs.getDataExpirare().isBefore(dataCurenta)) {
                System.out.println(produs);
            }
        }
    }
    private static void vanzareProdus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti denumirea produsului: ");
        String denumire = scanner.nextLine();

        for (Produs produs : listaProduse) {
            if (produs.getDenumire().equalsIgnoreCase(denumire)) {
                System.out.print("Introduceti cantitatea vanduta: ");
                int cantitateVanduta = scanner.nextInt();
                if (cantitateVanduta <= produs.getCantitate()) {
                    double sumaVanzare = cantitateVanduta * produs.getPret();
                    Produs.actualizeazaIncasari(sumaVanzare);
                    produs.setCantitate(produs.getCantitate() - cantitateVanduta);
                        System.out.println("Produsul a fost vandut cu succes.");
                    if (produs.getCantitate() == 0) {
                        listaProduse.remove(produs);
                        System.out.println("Produsul a fost eliminat din lista, deoarece stocul a ajuns la zero.");
                    }
                } else {
                    System.out.println("Nu exista suficientă cantitate pe stoc pentru a vinde acest produs!");
                }
                return;
            }
        }
        System.out.println("Produsul NU a fost gasit in lista!");
    }

    private static void afisareProduseCuPretMinim() {
        if (listaProduse.isEmpty()) {
            System.out.println("NU exista produse in lista!");
            return;
        }
        double pretMinim = listaProduse.get(0).getPret();
        for (Produs produs : listaProduse) {
            if (produs.getPret() < pretMinim) {
                pretMinim = produs.getPret();
            }
        }
        System.out.println("Produse cu pret minim (" + pretMinim + "):");
        for (Produs produs : listaProduse) {
            if (produs.getPret() == pretMinim) {
                System.out.println(produs);
            }
        }
    }
    private static void salvareProduseCantitateSubValoare() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti cantitatea minima: ");
        int cantitateMinima = scanner.nextInt();

        try (PrintWriter writer = new PrintWriter(new FileWriter("produse_sub_cantitate.txt"))) {
            for (Produs produs : listaProduse) {
                if (produs.getCantitate() < cantitateMinima) {
                    writer.println(produs);
                }
            }
            System.out.println("Produsele cu cantitate sub " + cantitateMinima + " au fost salvate in fisierul produse_sub_cantitate.txt.");
        } catch (IOException e) {
            System.err.println("Eroare la salvarea produselor in fisier: " + e.getMessage());
        }
    }
}