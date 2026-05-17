import java.util.Objects;

public class Pracownik {
    private String idPracownika;
    private String imie;
    private String nazwisko;
    private double stawkaBazowa;

    public Pracownik(String idPracownika, String imie, String nazwisko, double stawkaBazowa) {
        this.idPracownika = idPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stawkaBazowa = stawkaBazowa;
    }

    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public double getStawkaBazowa() { return stawkaBazowa; }

    public final String pobierzIdPracownika() {
        return idPracownika;
    }

    public double obliczKosztMiesieczny() {
        return stawkaBazowa;
    }

    public String przedstawSie() {
        return "Pracownik: " + imie + " " + nazwisko + " (ID: " + idPracownika + ")";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [id=" + idPracownika +
                ", imie=" + imie +
                ", nazwisko=" + nazwisko +
                ", kosztMiesieczny=" + obliczKosztMiesieczny() + " PLN]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pracownik)) return false;
        Pracownik other = (Pracownik) obj;
        return Objects.equals(idPracownika, other.idPracownika);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPracownika);
    }
}