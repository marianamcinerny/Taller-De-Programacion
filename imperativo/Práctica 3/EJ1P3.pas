{1. Escribir un programa que:
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol
binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza
con el número de socio 0 y el árbol debe quedar ordenado por número de socio.
b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como
parámetro y que :
i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.
ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un
módulo recursivo que retorne dicho socio.
iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que
retorne dicho valor.
iv. Aumente en 1 la edad de todos los socios.
v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a
un módulo recursivo que reciba el valor leído y retorne verdadero o falso.
vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a
un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha
cantidad.
viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del
inciso vii e invocar a un módulo recursivo que retorne la suma de las edades de los socios.
ix. Informe los números de socio en orden creciente.
x. Informe los números de socio pares en orden decreciente.}

program EJ1P3.pas;
type
str20 = string[20];

socio = record
  num,edad : integer;
  nom : str20;
end;

arbol = ^nodo;
nodo = record
  dato : socio;
  hi : arbol;
  hd : arbol;
end;

{a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol
binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza
con el número de socio 0 y el árbol debe quedar ordenado por número de socio.}
procedure incisoA(var a : arbol);
  procedure leerSocio (var s : socio);
  begin
    write('Ingrese el numero de socio: '); readln(s.num);
    if (s.num <> 0) then begin
      write('Ingrese el nombre del socio: '); readln(s.nom);
      write('Ingrese la edad del socio: '); readln(s.edad);
    end;
    writeln('-------------------------------------------------');
  end;
  
  procedure agregarArbol (var a : arbol; s : socio);
  begin
    if (a = nil) then begin
      new(a);
      a^.dato := s; a^.hi := nil; a^.hd := nil;
    end
    else
      if (s.num < a^.dato.num) then
        agregarArbol(a^.hi,s)
      else
        agregarArbol(a^.hd,s);
  end;
  
var
  s : socio;
begin
  leerSocio(s);
  while (s.num <> 0) do begin
    agregarArbol(a,s);
    leerSocio(s);
  end;
end;

{b.i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.}
procedure incisoBI (a : arbol);
  function socioNumMax (a : arbol) : integer;
  begin
    if (a = nil) then
      socioNumMax := -1
    else
      if (a^.HD = nil) then
        socioNumMax := a^.dato.num
    else
      socioNumMax := socioNumMax(a^.HD);
  end;

var
  max : integer;
begin
  max := socioNumMax(a);
  if (max = -1) then
    writeln('Club sin socios')
  else
    writeln('Numero de socio mas grande: ',socioNumMax(a));
end;

{b.ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un
módulo recursivo que retorne dicho socio.}
procedure incisoBII (a : arbol);
  function socioMin (a : arbol) : arbol;
  begin
    if (a = nil) then
      socioMin := nil
    else
      if (a^.HI = nil) then
        socioMin := a
      else
        socioMin := socioMin(a^.HI);
  end;

var
  aux : arbol;
begin
  aux := socioMin(a);
  if (aux  = nil) then
    writeln('Club sin socios')
  else
    writeln('Socio con el numero mas chico: ',aux^.dato.num,'. Nombre: ',aux^.dato.nom,'. Edad: ',aux^.dato.edad);
end;

{b.iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que
retorne dicho valor.}
procedure incisoBIII (a : arbol);
  procedure actualizarMaximo (num,edad : integer; var maxEdad,maxNum : integer);
  begin
    if (edad >= maxEdad) then begin
      maxEdad := edad;
      maxNum := num;
    end;
  end;
  
  procedure socioMayor (a : arbol; var maxEdad,maxNum : integer);
  begin
    if (a <> nil) then begin
      actualizarMaximo(a^.dato.num,a^.dato.edad,maxEdad,maxNum);
      socioMayor(a^.hi,maxEdad,maxNum);
      socioMayor(a^.hd,maxEdad,maxNum);
    end;
  end;
var
  maxEdad, maxNum : integer;
begin
  maxEdad := -1;
  socioMayor(a,maxEdad,maxNum);
  if (maxEdad = -1) then
    writeln('Club sin socios')
  else
    writeln('Numero del socio con mayor edad: ',maxNum);
end;

{b.iv. Aumente en 1 la edad de todos los socios.}
procedure incisoBIV (a : arbol);
begin
  if (a <> nil) then begin
    incisoBIV(a^.hi);
    a^.dato.edad := a^.dato.edad + 1;
    incisoBIV(a^.hd);
  end;
end;

    
{b.v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a
un módulo recursivo que reciba el valor leído y retorne verdadero o falso.}
procedure incisoBV (a : arbol);
  function buscarNum (a : arbol; num : integer) : boolean;
  begin
    if (a = nil) then
      buscarNum := false
    else 
      if (a^.dato.num = num) then
        buscarNum := true
      else
        if (num <= a^.dato.num) then
          buscarNum := buscarNum(a^.hi,num)
        else
          buscarNum := buscarNum(a^.hd,num);
  end;

var
  num : integer;
begin
  write('Ingrese un numero de socio: '); readln(num);
  if (buscarNum(a,num)) then
    writeln('El numero ',num,' corresponde a un socio')
  else
    writeln('El numero ',num,' no le corresponde a ningun socio');
end;    

{b.vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a
un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.}
procedure incisoVI(a : arbol);
  function existenciaNombre (a : arbol; n : str20) : boolean;
  begin
    if (a = nil) then
      existenciaNombre := false
    else 
      if (a^.dato.nom = n) then
        existenciaNombre := true
      {else begin
        existenciaNombre := existenciaNombre(a^.hi,n);
        existenciaNombre := existenciaNombre(a^.hd,n);
      end;}
      else
        existenciaNombre := existenciaNombre(a^.hi, n) or existenciaNombre(a^.hd, n);
  end;

var
  nom : str20;
begin
  write('Ingrese un nombre: '); readln(nom);
  if (existenciaNombre(a,nom)) then
    writeln('El nombre ',nom,' le corresponde a un socio')
  else
    writeln('Ese nombre ',nom,' no le corresponde a ningun socio');
end;

{b.vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha
cantidad.}
function sociosTotal (a : arbol) : integer;
begin
  if (a = nil) then
    sociosTotal := 0
  else
    sociosTotal := 1 + sociosTotal(a^.hi) + sociosTotal(a^.hd);
end;

procedure incisoVII (a : arbol);
begin
  if (sociosTotal(a) = 0) then
    writeln('Club sin socios')
  else
    writeln('Socios total del club: ',sociosTotal(a));  
end;

{b.viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del
inciso vii e invocar a un módulo recursivo que retorne la suma de las edades de los socios.}
procedure incisoVIII(a : arbol);
  function sumaEdades (a : arbol) : integer;
  begin
    if (a = nil) then
      sumaEdades := 0
    else
      sumaEdades := a^.dato.edad + sumaEdades(a^.hi) + sumaEdades(a^.hd)
  end;

var
  promedio: real;
begin
  promedio := sumaEdades(a) / sociosTotal(a);
  if (promedio = 0) then
    writeln('Club sin socios')
  else
    writeln('El promedio de edad es: ',promedio:2:2);
end;

{b.ix. Informe los números de socio en orden creciente.}
procedure incisoIX (a : arbol);
  procedure informarNumeros (a : arbol);
  begin
    if (a <> nil) then begin
      informarNumeros(a^.hi);
      write(a^.dato.num,' | ');
      informarNumeros(a^.hd);
    end;
  end;
  
begin
  if (a = nil) then
    writeln('Club sin socios')
  else begin
    writeln('Numeros de socio en orden creciente: ');
    informarNumeros(a);
  end;
end;

{b.x. Informe los números de socio pares en orden decreciente.}
procedure incisoX(a : arbol);
  procedure informarPares (a : arbol);
  begin
    if (a <> nil) then begin
      informarPares(a^.hd);
      if ((a^.dato.num mod 2) = 0) then
        write(a^.dato.num,' | ');
      informarPares(a^.hi);
    end;
  end;

begin
  if (a = nil) then
    writeln('Club sin socios')
  else begin
    writeln('Numeros de socio pares en orden decreciente: ');
    informarPares(a);
  end;
end;

var
  a : arbol;
begin
  a := nil;
  incisoA(a);
  writeln();
  
  incisoBI(a);
  writeln();
  
  incisoBII(a);
  writeln();
  
  incisoBIII(a);
  writeln();
  
  incisoBIV(a);
  writeln();
  
  incisoBV(a);
  writeln();
  
  incisoVI(a);
  writeln();
  
  incisoVII(a);
  writeln();
  
  incisoVIII(a);
  writeln();
  
  incisoIX(a);
  writeln();
  
  incisoX(a);
  writeln();
end.
