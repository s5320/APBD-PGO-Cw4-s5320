# PGO – Ćwiczenie 4: Model Zespołu Projektowego

Projekt zaliczeniowy z przedmiotu **Programowanie Generyczne i Obiektowe (PGO)** na PJATK.  
Ćwiczenie demonstruje podstawowe mechanizmy programowania obiektowego w Javie: dziedziczenie, polimorfizm, enkapsulację i kolekcje generyczne.

## Opis zadania

Zadanie polega na zbudowaniu prostego modelu zespołu projektowego z wykorzystaniem hierarchii klas i polimorfizmu. Program umożliwia:

- tworzenie pracowników różnych typów (programista, tester),
- przechowywanie wszystkich pracowników w jednej liście (`ArrayList<Pracownik>`),
- polimorficzne wywoływanie metod opisujących i kosztujących,
- obliczenie łącznego miesięcznego kosztu zespołu,
- filtrowanie pracowników po typie z użyciem `instanceof`,
- porównywanie obiektów przez nadpisane `equals()`.

## Struktura projektu

```
src/
├── Pracownik.java          // klasa nadrzędna
├── Programista.java        // klasa potomna – programista
├── Tester.java             // klasa potomna – tester
├── ZespolProjektowy.java   // menedżer zespołu z ArrayList<Pracownik>
└── Main.java               // punkt wejścia, scenariusz użycia
```

## Hierarchia klas

```
Pracownik
├── Programista
└── Tester
```

### Pracownik

Klasa nadrzędna skupiająca cechy wspólne wszystkich pracowników.

| Element | Opis |
|---|---|
| `idPracownika`, `imie`, `nazwisko`, `stawkaBazowa` | pola prywatne |
| `pobierzIdPracownika()` | metoda `final` – nie można jej nadpisać |
| `obliczKosztMiesieczny()` | wirtualna – nadpisywana w klasach potomnych |
| `przedstawSie()` | wirtualna – nadpisywana w klasach potomnych |
| `equals()` | porównuje obiekty po `idPracownika` |
| `toString()` | czytelny opis obiektu |

### Programista

Rozszerza `Pracownik` o pola `glownyJezyk` i `liczbaRepozytoriow`.  
Koszt miesięczny: stawka bazowa + 200 PLN za każde repozytorium powyżej 2.  
Metoda specyficzna: `wypiszTechnologie()`.

### Tester

Rozszerza `Pracownik` o pola `czyAutomatyzujacy` i `liczbaScenariuszy`.  
Koszt miesięczny: stawka bazowa + 1500 PLN za automatyzację + 500 PLN przy ponad 20 scenariuszach.  
Metoda specyficzna: `uruchomRaportTestow()`.

### ZespolProjektowy

Przechowuje listę pracowników i udostępnia metody:

- `dodajPracownika(Pracownik)` – dodaje pracownika do listy,
- `wypiszSkladZespolu()` – wypisuje wszystkich pracowników polimorficznie,
- `policzLacznyKoszt()` – sumuje koszty miesięczne całego zespołu,
- `znajdzPoId(String)` – wyszukuje pracownika po ID,
- `wypiszProgramistow()` – filtruje programistów z użyciem `instanceof`,
- `wypiszTesterowAutomatyzujacych()` – filtruje testerów automatyzujących.

## Przykład użycia

```java
ZespolProjektowy zespol = new ZespolProjektowy("Campus App");

Pracownik p1 = new Programista("E-101", "Anna",  "Maj",    12000.0, "Java",   4);
Pracownik p2 = new Tester     ("E-201", "Piotr", "Lis",     9800.0, true,    25);
Pracownik p3 = new Programista("E-102", "Karol", "Wojcik", 11500.0, "Kotlin", 3);

zespol.dodajPracownika(p1);
zespol.dodajPracownika(p2);
zespol.dodajPracownika(p3);

zespol.wypiszSkladZespolu();
System.out.printf("Łączny koszt: %.2f PLN%n", zespol.policzLacznyKoszt());

// instanceof + rzutowanie
if (p1 instanceof Programista programista) {
    programista.wypiszTechnologie();
}

// equals() porównuje po ID, nie po danych osobowych
System.out.println(p2.equals(new Tester("E-201", "Inne", "Dane", 9000.0, false, 10))); // true
```

## Omówione koncepcje OOP

| Koncepcja | Gdzie zastosowana |
|---|---|
| Dziedziczenie | `Programista extends Pracownik`, `Tester extends Pracownik` |
| Polimorfizm | referencje `Pracownik p = new Programista(...)`, wywołania `przedstawSie()` i `obliczKosztMiesieczny()` |
| Enkapsulacja | pola `private`, dostęp przez gettery |
| `@Override` | `obliczKosztMiesieczny()`, `przedstawSie()`, `equals()`, `toString()` |
| `final` | `pobierzIdPracownika()` – gwarancja niezmienności ID |
| Kolekcje generyczne | `ArrayList<Pracownik>` w `ZespolProjektowy` |
| `instanceof` + rzutowanie | filtrowanie i dostęp do metod specyficznych |

(PGO) – PJATK  
Zestaw: Ćwiczenie 4
