public class Tester extends Pracownik {
    private boolean czyAutomatyzujacy;
    private int liczbaScenariuszy;

    // Premia za automatyzację i za dużą liczbę scenariuszy
    private static final double PREMIA_AUTOMATYZACJA = 1500.0;
    private static final int PROG_SCENARIUSZY = 20;
    private static final double PREMIA_SCENARIUSZE = 500.0;

    public Tester(String idPracownika, String imie, String nazwisko,
                  double stawkaBazowa, boolean czyAutomatyzujacy, int liczbaScenariuszy) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.czyAutomatyzujacy = czyAutomatyzujacy;
        this.liczbaScenariuszy = liczbaScenariuszy;
    }

    public boolean isCzyAutomatyzujacy() { return czyAutomatyzujacy; }
    public int getLiczbaScenariuszy() { return liczbaScenariuszy; }

    @Override
    public double obliczKosztMiesieczny() {
        double koszt = getStawkaBazowa();
        if (czyAutomatyzujacy) koszt += PREMIA_AUTOMATYZACJA;
        if (liczbaScenariuszy > PROG_SCENARIUSZY) koszt += PREMIA_SCENARIUSZE;
        return koszt;
    }

    @Override
    public String przedstawSie() {
        String typ = czyAutomatyzujacy ? "automatyzujący" : "manualny";
        return "Tester " + getImie() + " " + getNazwisko() +
                " | Typ: " + typ +
                " | Scenariusze: " + liczbaScenariuszy +
                " | Koszt: " + obliczKosztMiesieczny() + " PLN";
    }

    // Metoda specyficzna dla Testera
    public void uruchomRaportTestow() {
        System.out.println(">>> Raport testów dla " + getImie() + " " + getNazwisko() + ":");
        System.out.println("    Tryb: " + (czyAutomatyzujacy ? "automatyczny" : "manualny"));
        System.out.println("    Liczba scenariuszy: " + liczbaScenariuszy);
        System.out.println("    Status: " + (liczbaScenariuszy > 0 ? "AKTYWNY" : "BRAK SCENARIUSZY"));
    }

    @Override
    public String toString() {
        return super.toString() +
                " [automatyzacja=" + czyAutomatyzujacy +
                ", scenariusze=" + liczbaScenariuszy + "]";
    }
}