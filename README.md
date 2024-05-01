RO: Programare Java - laborator 3, cerințe de rezolvat: 



1. Funcţia f(x) = ax^2 + bx + c are ca grafic o parabolă cu cu vârful de coordonate. Se cere să se definească o clasă Parabola ai cărei membri vor fi:

- 3 variabile de tip int care reprezintă coeficienţii a, b şi c;

- un constructor cu 3 parametrii de tip int;

- o metodă care calculează și returnează vârful parabolei;

- se va redefini metoda toString() din clasa Object, astfel încât să returneze un String de forma f(x) = ax^2 + bx + c, caracteristicile a, b și c ale parabolei se vor înlocui cu valorile efective, iar metoda va fi utilizată pentru afișarea parabolei sub forma unei funcții;

- o metodă care primește ca și parametru de intrare o parabolă și returneză coordonatele mijlocului segmentului de dreptă care uneşte vârful parabolei curente cu varful parabolei transmisă ca și parametru de intrare;

- o metodă statică ce primeşte ca parametri de intrare două parabole şi calculează coordonatele mijlocului segmentului de dreptă care uneşte vârfurile celor două parabole;

-  o metodă care primește ca și parametru de intrare o parabolă și returneză lungimea segmentului de dreptă care unește vârful parabolei curente cu varful parabolei transmisă ca și parametru de intrare, se va utiliza metoda statică Math.hypot;

- o metodă statică care primește ca și parametri de intrare două parabole și calculează lungimea segmentului de dreapta ce unește vârfurile celor două parabole, se va utiliza metoda statică Math.hypot.

Fișierul de intrare in.txt conține mai multe linii, pe fiecare linie aflându-se coeficienții unei parabole. Să se citească informația din fișierul de intrare și pentru fiecare linie să se creeze câte un obiect de tip Parabola care se va adăuga unei colecții de tip List. Colecția va fi apoi traversată și pentru fiecare element se va afișa parabola sub forma unei funcții și apoi vârful parabolei. Pentru două parabole din colecție se va afișa mijlocul segmentului care le unește vârfurile și lungimea segmentului care le unește vârfurile apelând metodele dezvoltate în clasa Parabola.

2. Să se scrie un program care citește din fișierul produse.csv informații referitoare la produsele dintr-un magazin. Pe fiecare linie se află: denumirea produsului, preţul (număr real) cantitatea (număr întreg), data expirării (LocalDate). Cele patru elemente sunt separate prin caracterul "," (zahar, 1.5, 50, 2024-02-25). Pentru fiecare rând citit se va crea un obiect de tip Produs care se va adăuga unei colecții de obiecte de tip List. Se va defini o clasă Produs care va conține: variabile membre private corespunzătoare celor trei elemente care descriu un produs, cel puţin un constructor, gettere si settere în funcție de necesități şi redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișarea produselor. Să se realizeze un program care va dispune de un meniu și va implementa următoarele cerințe:

- afișarea tuturor produselor din colecția List;

- afișarea produselor expirate;

- vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.

Dacă produsul ajunge la cantitate zero, se elimina din listă. În clasa Produs se va declara o variabilă statica încasări care se va actualiza la fiecare vânzare a unui produs, luând în considerare prețul produsului vândut şi cantitatea vândută.

- afișarea produselor cu prețul minim (pot fi mai multe cu același preț);

- salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură într-un fișier de ieșire.

EN: Java Programming - Lab 3, tasks to be solved:

1. The function f(x) = ax^2 + bx + c has a graph of a parabola with vertex coordinates. Define a class Parabola whose members will be:

- 3 int variables representing the coefficients a, b, and c;

- a constructor with 3 int parameters;

- a method that calculates and returns the vertex of the parabola;

- override the toString() method from the Object class to return a String in the form f(x) = ax^2 + bx + c, where the characteristics a, b, and c of the parabola will be replaced with the actual values, and the method will be used to display the parabola as a function;

- a method that receives another parabola as a parameter and returns the coordinates of the midpoint of the line segment connecting the vertex of the current parabola with the vertex of the parabola passed as a parameter;

- a static method that receives two parabolas as parameters and calculates the length of the line segment connecting the vertices of the two parabolas;

- a method that receives another parabola as a parameter and returns the length of the line segment connecting the vertex of the current parabola with the vertex of the parabola passed as a parameter, using the static method Math.hypot;

- a static method that receives two parabolas as parameters and calculates the length of the line segment connecting the vertices of the two parabolas, using the static method Math.hypot.

The input file in.txt contains multiple lines, with each line containing the coefficients of a parabola. Read the information from the input file and for each line, create an object of type Parabola which will be added to a List collection. Traverse the collection and for each element, display the parabola as a function and then display the vertex of the parabola. For two parabolas from the collection, display the midpoint of the line segment connecting their vertices and the length of the line segment connecting their vertices by calling the methods developed in the Parabola class.

2. Write a program that reads information about products from the file products.csv related to the products in a store. Each line contains: the product name, price (real number), quantity (integer), expiration date (LocalDate). The four elements are separated by the character "," (sugar, 1.5, 50, 2024-02-25). For each read line, create an object of type Product which will be added to a collection of List objects. Define a class Product that will contain: private member variables corresponding to the three elements describing a product, at least one constructor, getters, and setters as needed, and override the toString() method from the Object class, a method that will be used to display the products. Implement a program that will have a menu and will implement the following requirements:

- display all products from the List collection;

- display expired products;

- sell a product, which can only be done if there is enough quantity in stock. If the product reaches zero quantity, remove it from the list. In the Product class, declare a static variable sales which will be updated with each sale of a product, taking into account the price of the sold product and the quantity sold.

- display products with the minimum price (there can be multiple with the same price);

- save products with a quantity less than a value read from the keyboard to an output file.
