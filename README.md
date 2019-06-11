# Identyfikatory, klucze główne, sekwencje

W tym zadaniu będziemy tworzyli generatory wartości identyfikatorów, w uproszczeniu możemy używać zamiennie terminu- kluczy głównych.
Zapoznaj się z prezentacją ``Identyfikatory_klucze_glowne_sekwencje.pdf``, znajdująca się w katalogu projektu.

Następnie stwórz następujące generatory:

1) Stwórz generator wartości typu TABLE, użyj go dla encji Autor i Bookstore.
Skonfiguruj go następująco:
nazwa tabeli z generatorem: "tabela_generator_wartosci",
początkowa wartość dla generatora = 50,
zakres wartości alokowanych dla pojedynczej sesji = 100,
nazwa kolumny, która wskazuje na dany generator: "tabele",
nazwa generatora: "id_tabela_autor",
nazwa kolumny z wartościami dla generatora: "wartosc_id".
Wykonaj program i zaobserwuj, co się zmieniło w bazie danych.
Zauważ, jak zostały użyte przez bazę danych te wartości, które podalismy w opisie generatora.


2) Stwórz generator wartości typu SEQUENCE, użyj go dla encji Book.
Skonfiguruj go następująco:
nazwa generatora - "moja_sekwencja",
nazwa sekwencji - superSekwencja,
początkowa wartość dla generatora = 10,
rozmiar rezerowany dla pojedynczej sesji = 5.
Wykonaj program i zaobserwuj, co się zmieniło w bazie danych.
Zauważ, jak zostały użyte przez bazę danych te wartości, które podalismy w opisie generatora.

