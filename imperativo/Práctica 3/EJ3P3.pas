{3.Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación y los almacene en
una estructura de datos. De cada alumno se lee legajo, DNI, año de ingreso y los códigos y
notas de los finales rendidos. La estructura generada debe ser eficiente para la búsqueda por
número de legajo. La lectura de los alumnos finaliza con legajo 0 y para cada alumno el ingreso
de las materias finaliza con el código de materia -1.
b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.
c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.
d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.
e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.
f. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del
alumno con mayor promedio.
g. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.}

program EJ3P3;
type
materia = record
  cod, nota : integer;
end;

lista = ^nodoL;
nodoL = record
  dato : materia;
  sig : lista;
end;

alumno = record
  legajo : integer;
  dni : integer;
  anio : integer;
  finales : lista;
end;

arbol = ^nodo;
nodo = record
  dato : alumno;
  hi : arbol;
  hd : arbol;
end;

{a. Un módulo que lea información de alumnos de Taller de Programación y los almacene en
una estructura de datos. De cada alumno se lee legajo, DNI, año de ingreso y los códigos y
notas de los finales rendidos. La estructura generada debe ser eficiente para la búsqueda por
número de legajo. La lectura de los alumnos finaliza con legajo 0 y para cada alumno el ingreso
de las materias finaliza con el código de materia -1.}
procedure incisoA (var a : arbol);
  procedure leerFinal (var f : materia);
  begin
    write('Ingrese el codigo de la materia: '); readln(f.cod);
    if (f.cod <> -1) then
      write('Nota obtenida: '); readln(f.nota);
  end;
  
  procedure cargarLista (var l : lista);
  var
    f : materia;
    nuevo : lista;
  begin
    leerFinal(f);
    while (f.cod <> -1) do begin
      new(nuevo);
      nuevo^.dato := f; nuevo^.sig := nil;
      if (l = nil) then
        l := nuevo
      else begin
        nuevo^.sig := l;
        l := nuevo;
      end;
      leerFinal(f);
    end;
  end;
  
  procedure leerAlumno (var a : alumno);
  begin
    write('Ingrese el legajo del alumno: '); readln(a.legajo);
    if (a.legajo <> 0) then begin
      write('Ingrese el dni del alumno: '); readln(a.dni);
      write('Ingrese el anio de ingreso: '); readln(a.anio);
      a.finales := nil;
      cargarLista(a.finales);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; alu : alumno);
  begin
    if (a = nil) then begin
      new(a);
      a^.dato := alu; a^.hi := nil; a^.hd := nil;
    end
    else
      if (alu.legajo < a^.dato.legajo) then
        cargarArbol(a^.hi,alu)
      else
        cargarArbol(a^.hd,alu);
  end;
var
 alu : alumno;
begin
  leerAlumno(alu);
  while (alu.legajo <> 0) do begin
    cargarArbol(a,alu);
    leerAlumno(alu);
  end;
end;

{b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.}
procedure incisoB (a : arbol; valor : integer);
begin
  if (a <> nil) then
    if (a^.dato.legajo < valor) then begin
      writeln(a^.dato.dni);
      writeln(a^.dato.anio);
    end
    else 
      if (a^.dato.legajo > valor) then
        incisoB(a^.hi,valor);
end;

{c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.}
function maxLegajo (a : arbol) : integer;
begin
  if (a^.hd = nil) then
    maxLegajo := a^.dato.legajo
  else
    maxLegajo := maxLegajo(a^.hd);
end;

{d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.}
procedure maxDNI (a : arbol; var maxd : integer);
begin
  if (a <> nil) then begin
    maxDNI(a^.hi,maxd);
    if (a^.dato.dni > maxd) then
      maxd := a^.dato.dni;
    maxDNI(a^.hd,maxd);
  end;
end;

{e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar}
procedure incisoE (a : arbol; var cant : integer);
begin
  if (a <> nil ) then begin
    incisoE(a^.hi,cant);
    if ((a^.dato.legajo mod 2) <> 0) then
      cant := cant + 1;
    incisoE(a^.hd,cant);
  end;
end;

{f. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del
alumno con mayor promedio.}
function promedio (l : lista) : real;
  var
    cant,aux : integer;
  begin
    cant := 0; aux := 0;
    while (l <> nil) do begin
      aux := aux + l^.dato.nota;
      cant := cant + 1;
      l := l^.sig;
    end;
    promedio := aux / cant;
  end;
  
procedure incisoF (a : arbol);
  procedure buscarMax (a : arbol; var maxleg : integer; var maxprom : real);
  begin
    if (a <> nil) then begin
      buscarMax (a^.hi,maxleg,maxprom);
      if (promedio(a^.dato.finales) > maxprom) then begin
        maxprom := promedio(a^.dato.finales);
        maxleg := a^.dato.legajo
      end;
      buscarMax (a^.hd,maxleg,maxprom);
    end;
  end;
  
var
  maxleg,maxprom: integer;
begin
  maxleg := 0; maxprom := 0;
  buscarMax(a,maxleg,maxprom);
  writeln('El legajo del alumno con mayor promedio: ',maxleg,'. Su promedio es ',maxprom);
end;

{g. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.}
procedure incisoG (a : arbol; valor : integer);
begin
  if (a <> nil) then begin
    incisoG(a^.hi,valor);
    if (promedio(a^.dato.finales) > valor) then begin
      writeln(a^.dato.legajo);
      writeln(promedio(a^.dato.finales));
    end;
    incisoG(a^.hd,valor);
  end;
end;

var
  a : arbol;
  valor,maxd,cant : integer;
begin
  a := nil;
  incisoA(a);
  writeln;
  
  writeln('Ingrese un valor: '); readln(valor);
  writeln('DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a ',valor,': ');
  incisoB(a,valor);
  
  writeln;
  writeln('El legajo mas grande: ',maxLegajo(a));
  
  writeln;
  maxd := 0;
  maxDNI(a,maxd);
  writeln('El dni mas grande: ',maxd);
  
  writeln;
  cant := 0;
  incisoE(a,cant);
  writeln('Cantidad de alumnos con legajo impar: ',cant);
  
  writeln;
  incisoF(a);
  
  writeln;
  write('Ingerse un valor: '); readln(valor);
  incisoG(a,valor);
end.
