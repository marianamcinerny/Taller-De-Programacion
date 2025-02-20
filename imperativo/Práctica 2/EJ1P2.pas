{1.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto, los
almacene en un vector con dimensión física igual a 10 y retorne el vector.
b. Un módulo que reciba el vector generado en a) e imprima el contenido del vector.
c. Un módulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.
d. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne la cantidad de caracteres leídos. El programa debe informar el valor retornado.
e. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne una lista con los caracteres leídos.
f. Un módulo recursivo que reciba la lista generada en e) e imprima los valores de la lista en el
mismo orden que están almacenados.
g. Implemente un módulo recursivo que reciba la lista generada en e) e imprima los valores de
la lista en orden inverso al que están almacenados.}


program EJ1P2;
const
dimF = 10;

type
vector = array [1..dimF] of char;

  lista = ^nodo;
  nodo = record
    dato : char;
    sig : lista;
  end;


{a. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto, los
almacene en un vector con dimensión física igual a 10 y retorne el vector.}
procedure incisoA (var v : vector; var dimL : integer);
var
  c : char;
begin
  write('Ingrese un caracter: ');readln (c);
  if (dimL < dimF) and (c <> '.')then begin
    dimL := dimL + 1;
    v[dimL] := c;
    incisoA(v,dimL);
  end;
end;

{b. Un módulo que reciba el vector generado en a) e imprima el contenido del vector.}
procedure incisoB (v : vector; dimL : integer);
var
  i : integer;
begin
  for i := 1 to dimL do
    write(v[i],('|'));
end;

{c. Un módulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.}
procedure incisoC (v : vector ; dimL : integer; var aux : integer); //imprime en orden
begin
  if (aux < dimL) then begin
    aux := aux + 1;
    write(v[aux],'|');
    incisoC(v,dimL,aux);
  end;
end;

{d. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne la cantidad de caracteres leídos. El programa debe informar el valor retornado.}
procedure incisoD (var cant : integer);
var
  c : char;
begin
  write('Ingrese un caracter: ');readln(c);
  if (c <> '.') then begin
    cant := cant + 1;
    incisoD(cant);
  end;
end;

{e. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne una lista con los caracteres leídos.}
procedure incisoE (var l : lista);
var
  c : char;
  nuevo : lista;
begin
  write('Ingrese un caracter: '); readln (c);
  if (c <> '.') then begin
    new (nuevo);
    nuevo^.dato := c; nuevo^.sig := nil;
    l := nuevo;
    incisoE(l^.sig);
  end;
end;
  
{f. Un módulo recursivo que reciba la lista generada en e) e imprima los valores de la lista en el
mismo orden que están almacenados.}
procedure incisoF (l : lista);
begin
  if (l <> nil) then begin
    write(l^.dato,'|');
    l := l^.sig;
    incisoF(l);
  end;
end;

{g. Implemente un módulo recursivo que reciba la lista generada en e) e imprima los valores de
la lista en orden inverso al que están almacenados.}
procedure incisoG (l : lista);
begin
  if (l <> nil) then begin
    incisoG(l^.sig);
    write(l^.dato,'|');
  end;
end;

var
  l : lista;
  v : vector;
  dimL,aux,cant : integer;
begin
  dimL := 0; aux := 0; cant := 0;
  l := nil;
  incisoA(v,dimL);
  writeln();
  writeln('Vector impreso normal:');
  incisoB(v,dimL);
  writeln();
  writeln();
  writeln('Vector impreso recursivamente:');
  incisoC(v,dimL,aux);
  writeln();
  writeln();
  incisoD(cant);
  writeln('cantidad leida: ',cant);
  writeln();
  incisoE(l);
  writeln();
  writeln('Lista impresa recursivamente en orden:');
  incisoF(l);
  writeln();
  writeln();
  writeln('Lista impresa tecursivamente en orden inverso: ');
  incisoG(l);
end.
