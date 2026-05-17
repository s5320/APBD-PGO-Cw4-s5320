public class Programista extends Pracownik {
    private String glownyJezyk;
    private int liczbaRepozytoriow;

    private static final double BONUS_ZA_REPO = 200.0;

    public Programista(String idPracownika, String imie, String nazwisko,
                       double stawkaBazowa, String glownyJezyk, int liczbaRepozytoriow) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.glownyJezyk = glownyJezyk;
        this.liczbaRepozytoriow = liczbaRepozytoriow;
    }

    public String getGlownyJezyk() { return glownyJezyk; }
    public int getLiczbaRepozytoriow() { return liczbaRepozytoriow; }

    @Override
    public double obliczKosztMiesieczny() {
        int dodatkowe = Math.max(0, liczbaRepozytoriow - 2);
        return getStawkaBazowa() + dodatkowe * BONUS_ZA_REPO;
    }

    @Override
    public String przedstawSie() {
        return "Programista " + getImie() + " " + getNazwisko() +
                " | Język: " + glownyJezyk +
                " | Repozytoria: " + liczbaRepozytoriow +
                " | Koszt: " + obliczKosztMiesieczny() + " PLN";
    }

    public void wypiszTechnologie() {
        System.out.println(">>> Technologie programisty " + getImie() + " " + getNazwisko() + ":");
        System.out.println("    Główny język: " + glownyJezyk);
        System.out.println("    Liczba repozytoriów: " + liczbaRepozytoriow);
    }

    @Override
    public String toString() {
        return super.toString() + " [język=" + glownyJezyk + ", repozytoria=" + liczbaRepozytoriow + "]";
    }
}