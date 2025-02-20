{3. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio,
día y mes del préstamo y cantidad de días prestados. Implementar un programa con:

a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).

b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.

c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.

d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.

e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.

f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.

g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.

h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.

i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).

j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}

program EJ2P4;

type
prestamo = record
  isbn : integer;
  numSocio : integer;
  dia : integer;
  mes : integer;
  cantDias : integer;
end;

arbol1 = ^nodo1;
nodo1 = record
  dato : prestamo;
  hi : arbol1;
  hd : arbol1;
end;

lista = ^nodo;
nodo = record
  dato : prestamo;
  sig : lista;
end;

arbol2 = ^nodo2;
nodo2 = record
  dato : lista;
  hi : arbol2;
  hd : arbol2;
end;

isbn = record
  numIsbn : integer;
  cant : integer;
end;

arbolfyg = ^nodo3;
nodo3 = record
  dato : isbn;
  hi : arbolfyg;
  hd : arbolfyg;
end;

{a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).}
procedure incisoA (var a1 : arbol1; var a2 : arbol2);
  procedure leerPrestamo (var p : prestamo);
  begin
    write('Ingrese el ISBN : '); readln(p.isbn);
    if (p.isbn <> -1) then begin
      write('Ingrese el numero de socio: '); readln(p.numSocio);
      write('Ingrese el dia: '); readln(p.dia);
      write('Ingrese el mes: '); readln(p.mes);
      write('Ingrese la cantidad de dias que fue prestado: '); readln(p.cantDias);
    end;
  end;
  
  procedure cargarArbol1 (var a1 : arbol1; p : prestamo);
  begin
    if (a1 = nil) then begin
      new (a1);
      a1^.dato := p; a1^.hi := nil; a1^.hd := nil
    end
    else
      if (p.isbn <= a1^.dato.isbn) then
        cargarArbol1(a1^.hi,p)
      else
        cargarArbol1(a1^.hd,p);
  end;
  
  procedure cargarArbol2 (var a2 : arbol2; p : prestamo);
    procedure cargarLista (var l : lista; p : prestamo);
    var
      nuevo : lista;
    begin
      new (nuevo);
      nuevo^.dato := p; nuevo^.sig := l;
      l := nuevo;
      end;
    
  begin
    if (a2 = nil) then begin
      new (a2);
      a2^.dato := nil;
      a2^.hi := nil; a2^.hd := nil;
      cargarLista(a2^.dato,p);
    end
    else
      if (a2^.dato^.dato.isbn = p.isbn) then
        cargarLista(a2^.dato,p)
      else
        if (p.isbn < a2^.dato^.dato.isbn) then
          cargarArbol2(a2^.hi,p)
        else
          cargarArbol2(a2^.hd,p);
  end;

var
  p : prestamo;
begin
  leerPrestamo(p);
  while (p.isbn <> -1) do begin
    cargarArbol1(a1,p);
    cargarArbol2(a2,p);
    writeln();
    leerPrestamo(p);
  end;
end;

{b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.}
procedure incisoB (a1 : arbol1);
  function isbnMax (a1 : arbol1) : integer;
  begin
    if (a1^.hd = nil) then
      isbnMax := a1^.dato.isbn
    else
      isbnMax := isbnMax(a1^.hd)
  end;
  
begin
  writeln('El isbn mas grande es el ',isbnMax(a1));
end;

{c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.}
procedure incisoC (a2 : arbol2);
  function isbnMin (a2 : arbol2) : integer;
  begin
    if (a2^.hi = nil) then
      isbnMin := a2^.dato^.dato.isbn
    else
      isbnMin := isbnMin(a2^.hi)
  end;

begin
  writeln('El isbn mas pequenio es el ',isbnMin(a2));
end;

{d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.}
procedure incisoD (a1 : arbol1);
  function cantPrestamos (a1 : arbol1; num : integer) : integer;
  begin
    if (a1 <> nil) then begin
      if (a1^.dato.numSocio <> num) then
        cantPrestamos := cantPrestamos(a1^.hi,num) + cantPrestamos(a1^.hd,num)
      else
        cantPrestamos := cantPrestamos(a1^.hi,num) + cantPrestamos(a1^.hd,num) + 1;
    end
    else
      cantPrestamos := 0;
  end;
  
var
  num : integer;
begin
  write('Ingrese un numero de socio (a1): '); readln(num);
  writeln('El socio ',num,' realizo ',cantPrestamos(a1,num),' prestamos');
end;

{e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.}
procedure incisoE (a2 : arbol2);
  procedure cantPrestamos2 (a2 : arbol2; num : integer; var cant : integer);
    procedure contarEnLista (l : lista; num : integer; var cant : integer);
    begin
      while (l <> nil) do begin
        if (l^.dato.numSocio = num) then
          cant := cant + 1;
          l := l^.sig;
      end;
    end;
    
  begin
    if (a2 <> nil) then begin
      contarEnLista(a2^.dato,num,cant);
      cantPrestamos2(a2^.hi,num,cant);
      cantPrestamos2(a2^.hd,num,cant);
    end;
  end;
var
  num,cant : integer;
begin
  cant := 0;
  write('Ingrese un numero de socio (a2): '); readln(num);
  cantPrestamos2(a2,num,cant);
  writeln('El socio hizo ',cant,' prestamos');
end;

{f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}
procedure incisoF (a1 : arbol1; var af : arbolfyg);
  procedure cargarArbolF (var af : arbolfyg; isbn : integer);
  begin
    if (af = nil) then begin
      new (af);
      af^.dato.numIsbn := isbn; af^.dato.cant := 1;
      af^.hi := nil; af^.hd := nil;
    end
    else
      if (af^.dato.numIsbn = isbn) then
        af^.dato.cant := af^.dato.cant + 1
      else
        if (isbn < af^.dato.numIsbn) then
          cargarArbolF(af^.hi,isbn)
        else
          cargarArbolF(af^.hd,isbn)
  end;

begin
  if (a1 <> nil) then begin
    incisoF(a1^.hi,af);
    incisoF(a1^.hd,af);
    cargarArbolF(af,a1^.dato.isbn);
  end;
end;

{g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}
procedure incisoG (a2 : arbol2; var ag : arbolfyg);
  procedure recorroLista (l : lista; var ag : arbolfyg);
    procedure cargoArbolG(isbn : integer; var ag : arbolfyg);
    begin
      if (ag = nil) then begin
        new(ag);
        ag^.dato.numIsbn := isbn; ag^.dato.cant := 1;
        ag^.hi := nil; ag^.hd := nil;
      end
      else
        if (ag^.dato.numIsbn = isbn) then
          ag^.dato.cant := ag^.dato.cant + 1
        else
          if (isbn < ag^.dato.numIsbn) then
            cargoArbolG(isbn,ag^.hi)
          else
            cargoArbolG(isbn,ag^.hd);
    end;
  begin
    while (l <>  nil) do begin
      cargoArbolG(l^.dato.isbn,ag);
      l := l^.sig;
    end;
  end;
begin
  if (a2 <> nil) then begin
    incisoG(a2^.hi,ag);
    recorroLista(a2^.dato,ag);
    incisoG(a2^.hd,ag);
  end;
end;

{h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido. No entiendo 
asi que imprimo los dos arboles anteriores.}
procedure incisoH (af : arbolfyg; ag : arbolfyg);
  procedure imprimirArbolF (af : arbolfyg);
  begin
    if (af <> nil) then begin
      imprimirArbolF(af^.hi);
      writeln('Isbn: ',af^.dato.numIsbn,'. Cantidad de veces que se pidio: ',af^.dato.cant);
      imprimirArbolF(af^.hd);
    end;
  end;
  
  procedure imprimirArbolG (ag : arbolfyg);
  begin
    if (ag <> nil) then begin
      imprimirArbolG(ag^.hi);
      writeln('Isbn: ',ag^.dato.numIsbn,'. Cantidad de veces que se pidio: ',ag^.dato.cant);
      imprimirArbolG(ag^.hd);
    end;
  end;
  
begin
  writeln('Contenido del arbol F: ');
  imprimirArbolF(af);
  writeln();
  writeln('Contenido del arbol G: ');
  imprimirArbolG(ag);
end;

{i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}
procedure incisoI (a1 : arbol1);
  {procedure recorrerA1 (a1 : arbol1; num1,num2 : integer; var cant : integer);
  begin
    if (a1 <> nil) then begin
      if (a1^.dato.isbn >= num1) then
        if (a1^.dato.isbn <= num2) then begin
          cant := cant + 1;
          recorrerA1(a1^.hi,num1,num2,cant);
          recorrerA1(a1^.hd,num1,num2,cant);
        end
        else
          recorrerA1(a1^.hi,num1,num2,cant)
      else
        recorrerA1(a1^.hd,num1,num2,cant);
    end;
  end;}
  
  function sumaEntreValores (a1 : arbol1; num1,num2 : integer) : integer;
  begin
    if (a1 = nil) then
      sumaEntreValores := 0
    else
      if (a1^.dato.isbn >= num1) then
        if (a1^.dato.isbn <= num2) then
          sumaEntreValores := sumaEntreValores(a1^.hi,num1,num2) + sumaEntreValores(a1^.hd,num1,num2) + 1
        else
          sumaEntreValores := sumaEntreValores(a1^.hi,num1,num2)
      else
        sumaEntreValores := sumaEntreValores(a1^.hd,num1,num2);
  end;
  
var
  num1, num2{,cant} : integer;
begin
  {cant := 0;}
  write('Ingrese un numero: '); readln(num1);
  write('Ingrese otro numero: '); readln(num2);
  //si lo quiero hacer con un procedimiento
  {recorrerA1(a1,num1,num2,cant);
  writeln('Entre los ISBN ',num1,' y ',num2,' se hicieron ',cant,' prestamos');}
  //si lo quiero hacer con una fincion
  writeln('Entre los ISBN ',num1,' y ',num2,' se hicieron ',sumaEntreValores(a1,num1,num2),' prestamos');
end;

{j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}
procedure incisoJ (a2 : arbol2);
  procedure recorrerA2 (a2 : arbol2; num1, num2 : integer; var cant : integer);
    procedure sumo (l : lista; var cant : integer);
    begin
      while (l <> nil) do begin
        cant := cant + 1;
        l := l^.sig;
      end;
    end;
    
  begin
    if (a2 <> nil) then begin
      if (a2^.dato^.dato.isbn >= num1) then
        if (a2^.dato^.dato.isbn <= num2) then begin
          sumo(a2^.dato,cant);
          recorrerA2(a2^.hi,num1,num2,cant);
          recorrerA2(a2^.hd,num1,num2,cant);
        end
        else
          recorrerA2(a2^.hi,num1,num2,cant)
      else
        recorrerA2(a2^.hd,num1,num2,cant);
    end;
  end;
  
var
  num1,num2,cant : integer;
begin
  cant := 0;
  write('Ingrese un numero: '); readln(num1);
  write('Ingrese otro numero: '); readln(num2);
  recorrerA2(a2,num1,num2,cant);
  writeln('Entre los ISBN ',num1,' y ',num2,' se hicieron ',cant,' prestamos');
end;

//programa principal
var
  a1 : arbol1;
  a2 : arbol2;
  af,ag : arbolfyg;
begin
  a1 := nil;
  a2 := nil;
  af := nil;
  ag := nil;
  
  incisoA(a1,a2);
  writeln();
  
  incisoB(a1);
  writeln();
  
  incisoC(a2);
  writeln();
  
  incisoD(a1);
  writeln();
  
  incisoE(a2);
  writeln();
  
  incisoF(a1,af);
  writeln();
  
  incisoG(a2,ag);
  writeln();
  
  incisoH(af,ag);
  writeln();
  
  incisoI(a1);
  writeln();
  
  incisoJ(a2);
  writeln();
end.
