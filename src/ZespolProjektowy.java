import java.util.ArrayList;

public class ZespolProjektowy {
    private String nazwaProjektu;
    private ArrayList<Pracownik> pracownicy;

    public ZespolProjektowy(String nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
        this.pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void wypiszSkladZespolu() {
        System.out.println("=== Skład zespołu: " + nazwaProjektu + " ===");
        for (Pracownik p : pracownicy) {
            System.out.println("  " + p.przedstawSie());
        }
        System.out.println("Razem: " + pracownicy.size() + " pracownik(ów)");
        System.out.println();
    }

    public double policzLacznyKoszt() {
        double suma = 0;
        for (Pracownik p : pracownicy) {
            suma += p.obliczKosztMiesieczny();
        }
        return suma;
    }

    public Pracownik znajdzPoId(String idPracownika) {
        for (Pracownik p : pracownicy) {
            if (p.pobierzIdPracownika().equals(idPracownika)) {
                return p;
            }
        }
        return null;
    }

    public void wypiszProgramistow() {
        System.out.println("--- Programiści w zespole ---");
        for (Pracownik p : pracownicy) {
            if (p instanceof Programista) {
                Programista prog = (Programista) p;
                System.out.println("  " + prog.getImie() + " " + prog.getNazwisko() +
                        " [" + prog.getGlownyJezyk() + "]");
            }
        }
    }

    public void wypiszTesterowAutomatyzujacych() {
        System.out.println("--- Testerzy automatyzujący ---");
        for (Pracownik p : pracownicy) {
            if (p instanceof Tester) {
                Tester t = (Tester) p;
                if (t.isCzyAutomatyzujacy()) {
                    System.out.println("  " + t.getImie() + " " + t.getNazwisko() +
                            " [scenariusze: " + t.getLiczbaScenariuszy() + "]");
                }
            }
        }
    }
}