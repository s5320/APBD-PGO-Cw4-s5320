public class Main {
    public static void main(String[] args) {
        ZespolProjektowy zespol = new ZespolProjektowy("Campus App");

        // Referencje typu Pracownik wskazujące na obiekty potomne – polimorfizm
        Pracownik p1 = new Programista("E-101", "Anna",  "Maj",    12000.0, "Java",   4);
        Pracownik p2 = new Tester     ("E-201", "Piotr", "Lis",     9800.0, true,    25);
        Pracownik p3 = new Programista("E-102", "Karol", "Wojcik", 11500.0, "Kotlin", 3);

        zespol.dodajPracownika(p1);
        zespol.dodajPracownika(p2);
        zespol.dodajPracownika(p3);

        // Skład i łączny koszt
        zespol.wypiszSkladZespolu();
        System.out.printf("Łączny koszt zespołu: %.2f PLN%n%n", zespol.policzLacznyKoszt());

        // Polimorficzne wywołanie przedstawSie()
        System.out.println("== Przedstawienie pracowników ==");
        System.out.println(p1.przedstawSie());
        System.out.println(p2.przedstawSie());
        System.out.println(p3.przedstawSie());
        System.out.println();

        // instanceof + rzutowanie – dostęp do metody specyficznej
        if (p1 instanceof Programista) {
            Programista programista = (Programista) p1;
            programista.wypiszTechnologie();
        }
        System.out.println();

        // Metoda specyficzna Testera
        if (p2 instanceof Tester) {
            Tester tester = (Tester) p2;
            tester.uruchomRaportTestow();
        }
        System.out.println();

        // Filtrowanie – programiści i testerzy automatyzujący
        zespol.wypiszProgramistow();
        System.out.println();
        zespol.wypiszTesterowAutomatyzujacych();
        System.out.println();

        // Wyszukiwanie po ID
        Pracownik znaleziony = zespol.znajdzPoId("E-102");
        System.out.println("Znaleziony po ID E-102: " + znaleziony);
        System.out.println();

        // equals() – porównanie po idPracownika (różne dane osobowe, ten sam ID)
        Pracownik duplikat = new Tester("E-201", "Inne", "Dane", 9000.0, false, 10);
        System.out.println("p2.equals(duplikat z ID E-201): " + p2.equals(duplikat)); // true
        System.out.println("p1.equals(p3):                  " + p1.equals(p3));       // false
        System.out.println();

        // toString()
        System.out.println("== toString() ==");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}