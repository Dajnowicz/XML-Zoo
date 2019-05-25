# XML (2 pkt.)
###### Kompilacja w Putty
- #### Sposób budowy pliku XML, tzn. sposób użycia elementów i atrybutów, to czy plik przechodzi walidację itp. (1 pkt.). 
```bash
xmllint zoo1.xml --noout
```

- #### Ilość, różnorodność i sensowność wprowadzonych danych, tzn. danych nie powinno być ani za mało oraz powinny związane z tematem projektu (1 pkt.). Jeżeli stworzysz arkusz CSS danych nie może być za dużo, aby to estetcznie wyglądało (np. ok. 5 osób, ok. 5 innych danych itd.).

Zoo podzielone na sekcje zarzadu, miejsca oraz zwierzat. Zwierzeta grupowane na kontynenty, a kazde poszegolne posiada wlasne dane. 

# CSS (3 pkt.)
###### Kompilacja w Przegladarce
- #### Estetyka wyglądu pliku XML przy użyciu pliku CSS (0,5 pkt.).

Oddzielone informacje o zarzadzie, miejscu oraz zwierzetach. Pogrupowane w ladnie wygladajace kolumny uwydatniajace dane. 

- #### Wykorzystanie rzeczy, które pojwiły się na zajęciach. Inny styl formatowania to nie nowa rzecz (0,25 pkt za każdą różną, max. 1,5 pkt.).

```css
display: block;
margin-right: 10%;
content: "Ulica: ";
miasto:before
text-align: center;
margin-top: 20px;
zwierze[plec='Mezczyzna']
content: url
.
.
.
```

- #### Za użycie rzeczy, które nie zostały podane na zajęciach, np. automatyczna numeracja danych.	(0,25 pkt za każdą różną, max. 1 pkt.).

``` 
display: block;
margin-right: 10%;
transition: transform .2s;
opacity: 1.0;
filter: alpha(opacity=100);
transform: scale(1.1);
Azja:hover
zwierze[wCiazy='Tak'] > imie:after
```


# DTD (4 pkt.)

###### Kompilacja w Putty
- #### Praktyczne użycie własności elementów (0,25 pkt. za każdy różny, max. 1,5 pkt.), np. element opcjonalny, element pusty, jeden element, jeden lub więcej elementów itd.

``` dtd
<!ELEMENT miejsce (informacja*, adres)>
<!ELEMENT zarzad (prezes?)>
<!ELEMENT Azja (zwierze+)>
<!ENTITY % mk "(Mezczyzna|Kobieta)">
<!ELEMENT zoo (miejsce, zarzad, zwierzeta)>
<!ELEMENT choroby EMPTY>
```

- #### Praktyczne użycie własności atrybutów (0,25 pkt. za każdy różny, max. 1,5 pkt.), np. atrybut obowiązkowy, atrybut z domyślną wartością, wartość unikotowa itd.

``` dtd
<!ENTITY % pc "#PCDATA">
<!ENTITY % r "#REQUIRED">
<!ENTITY % i "#IMPLIED">
<!ENTITY % f "#FIXED">
<!ENTITY % cd "CDATA">
<!ENTITY % mk "(Mezczyzna|Kobieta)">
```


- #### Praktyczne użycie własności encji parametrych wewnętrznych (0,25 pkt. za każdą, max. 0,5 pkt.), seksji warunkowej (0,5 pkt.).

``` dtd
<!ENTITY % zwierzeta "(Azja, Europa,Polnocna_Ameryka,Antarktyka,Poludniowa_Ameryka,Australia,Afryka)">
<!ENTITY % zwierze "(imie, waga,wiek,kolor,okres_ciazy?,gromada,choroby)">

<!ENTITY % NoweZoo "INCLUDE">
<!ENTITY % StareZoo "IGNORE">
```

- #### Powinien walidować dokument.

```bash
xmllint --valid zoo.xml --noout
```

# XML-Schema (6 pkt.)
###### Kompilacja w Putty

- #### Praktyczne użycie własności (0,25 pkt. za każdą różny, max. 4,5 pkt.), np. restrykcje, wzorzec, lista, grupy, elementów, wartości unikatowe, grupy elementów itd.

``` xml
1. xsd:complexType
2. xsd:sequence
3. xsd:choice
4. xsd:all
5. use="required"
6. maxOccurs="3"
7. use="optional"
8. xsd:simpleContent
9. xsd:extension
10. xsd:minLength value="3" 
11. xsd:maxLength value="30" 
12. xsd:pattern value="\d{5}"
13. xsd:minInclusive value="1"
14. xsd:maxInclusive value="100"
15. xsd:pattern value="[0-9]{1,2}"
16. xsd:totalDigits value="3"
17. xsd:union memberTypes="brak liczby"
18. xsd:enumeration value="Pomarańczowy"

```

- #### Praktyczne użycie typów wbudowanych (0,25 pkt. za każdy różny, max. 1,5 pkt.), np. Integer, String itd.

```xsd
xsd:date
xsd:string
xsd:integer
xsd:short
xsd:nonNegativeInteger
xsd:positiveInteger
```


- #### Powinien walidować dokument.

```bash
xmllint --schema XSD.xsd zoo1.xml --noout
```

# XSLT (5 pkt.) 

###### Kompilacja w Windows Visual

- #### Utworzenie przydatnego arkusza przekszatłcającego na inny plik XML, HTML lub xHTML (w przypadku XML max. 0,5 pkt. w przypadku HTML/xHTML max. 1,5 pkt.). Przy ocenianiu pod uwagę zostanie wzięta estetyka utworzonego pliku (wygląd, użycie CSS w przypadku HTML itp.) oraz to czy przechodzi walidację (w przypadku HTML lub xHTML: walidator).

Stworzenie XHTML. Wyciagniecie roznych informacji za pomoca XPath, nastepnie stworzenie tabelki ze zwierzetami.


- #### Praktyczne użycie elementów (0,25 pkt. za każdy różny, max. 2 pkt.), tj. sortowanie, instrukcja warunkowa, pętla, wybór.

```xm
1. xsl:for-each select
2. xsl:sort select
3. xsl:if test select 
4. xsl:choose
5. xsl:when test
6. xsl:otherwise
7. xsl:template match
8. xsl:value of select
9. xsl:text

```


- #### Praktyczne wykorzystanie funkcji i wyrażeń XPath (0,25 pkt. za każdy różny, max. 1,5 pkt.).

```xm
1. count()
2. sum()
3. div()
4. precdfing-sibling::zwierze[1]
5. string-length()
6. starts-wth()
```

# DOM/SAX (5 pkt.)
###### Kompilacja w Putty przez folder Dom 
```batch
javac Zoo.java
java Zoo zoo.xml XSD.xsd 
vi new_zoo.xml
```


- #### Stworzenie przydatnego programu, który będzie wykonywał operację na pliku XML z użyciem DOM i/lub insterfejsu SAX i/lub StAX (max. 1 pkt.).

Dodanie nowego kontynentu i zwierzecia do XML.

Parsowanie XML i otrzymanie wynikow konkretnych zwierzat wraz ze statystyka.

- #### Wykorzystnie metod, która wykorzystuje model DOM (np. biblioteka Xerces) i/lub SAX i/lub StAX (0,25 pkt. za każdy różny, max. 4 pkt.).

Wykorzystanie 16 róznych metod:

```java
Modyfikacja
1. CreateElement()
2. SetAttribute()
3. setTextContent()
4. AppendChild()
5. getFirstChild()
6. insertBefore()
7. GetLastChild()

Parsowanie

8. getDocumentElement()
9. getNode()
10. getElementsByTagName()
11. getLength()
12. getNodeType()
13. getTextContent()
14. item()
15. getParentNode()
16. valueOf()
```

