{4. Una facultad nos ha encargado procesar la información de sus alumnos de la carrera XXX.
Esta carrera tiene 30 materias. Implementar un programa con:
a. Un módulo que lea la información de los finales rendidos por los alumnos y los
almacene en dos estructuras de datos.
i. Una estructura que para cada alumno se almacenen sólo código y nota de las
materias aprobadas (4 a 10). De cada final rendido se lee el código del alumno, el
código de materia y la nota (valor entre 1 y 10). La lectura de los finales finaliza con
nota -1. La estructura debe ser eficiente para buscar por código de alumno.
ii. Otra estructura que almacene para cada materia, su código y todos los finales
rendidos en esa materia (código de alumno y nota).
b. Un módulo que reciba la estructura generada en i. y un código de alumno y retorne los
códigos y promedios de los alumnos cuyos códigos sean mayor al ingresado.
c. Un módulo que reciba la estructura generada en i., dos códigos de alumnos y un valor
entero, y retorne la cantidad de alumnos con cantidad de finales aprobados igual al
valor ingresado para aquellos alumnos cuyos códigos están comprendidos entre los
dos códigos de alumnos ingresados.}

program EJ3P4;
type
notaRango = -1..10;
finales = record
  codAlumno : integer;
  codMateria : integer;
  nota : notaRango;
end;

lista = ^nodoL;
nodoL = record
  dato : finales;
  sig : lista;
end;

vector = array [1..30] of lista;

arbol = ^nodoA;
nodoA = record
  dato : lista;
  hi : arbol;
  hd : arbol;
end;

procedure inicializarVector (var v : vector);
var
  i : integer;
begin
  for i := 1 to 30 do
    v[i] := nil;
end;

{a. Un módulo que lea la información de los finales rendidos por los alumnos y los
almacene en dos estructuras de datos.
i. Una estructura que para cada alumno se almacenen sólo código y nota de las
materias aprobadas (4 a 10). De cada final rendido se lee el código del alumno, el
código de materia y la nota (valor entre 1 y 10). La lectura de los finales finaliza con
nota -1. La estructura debe ser eficiente para buscar por código de alumno.
ii. Otra estructura que almacene para cada materia, su código y todos los finales
rendidos en esa materia (código de alumno y nota).}
procedure incisoA (var a : arbol; var v : vector);
  procedure leerFinal (var f : finales);
  begin
    write('Ingrese la nota: '); readln(f.nota);
    if (f.nota <> -1) then begin
      write('Ingrese el codigo de la materia: '); readln(f.codMateria);
      write('Ingrese el codigo del alumno: '); readln(f.codAlumno);
    end;
  end;
  
  procedure cargarLista (var l : lista; f : finales);
  var
    nuevo : lista;
  begin
    new(nuevo);
    nuevo^.dato := f; nuevo^.sig := l;
    l := nuevo;
  end;
    
  procedure cargarArbol (var a : arbol; f : finales); 
  begin
    if (a = nil) then begin
      new (a);
      a^.dato := nil;
      cargarLista(a^.dato,f);
      a^.hi := nil; a^.hd := nil;
    end
    else
      if (a^.dato^.dato.codAlumno = f.codAlumno) then
        cargarLista(a^.dato,f)
      else
        if (f.codAlumno < a^.dato^.dato.codAlumno) then
          cargarArbol(a^.hi,f)
        else
          cargarArbol(a^.hd,f);
  end;
  
  procedure cargarVector (var v : vector; f : finales);
  begin
    cargarLista(v[f.codMateria],f)
  end;
  
var
  f : finales;
begin
  leerFinal(f);
  while (f.nota <> -1) do begin
    if (f.nota >= 4) then
      cargarArbol(a,f);
    cargarVector(v,f);
    writeln('-------------------------------------------------------');
    leerFinal(f);
  end;
end;

{b. Un módulo que reciba la estructura generada en i. y un código de alumno y retorne los
códigos y promedios de los alumnos cuyos códigos sean mayor al ingresado.}
procedure incisoB (a : arbol);
  procedure recorrerArbol (a : arbol; cod : integer);
    procedure retornarPromedio (l : lista);
    var
      prom : real;
      cant : integer;
      cod : integer;
    begin
      cant := 0; prom := 0;
      cod := l^.dato.codAlumno;
      while (l <> nil) do begin
        cant := cant + 1;
        prom := prom + l^.dato.nota;
        l := l^.sig;
      end;
      prom := prom / cant;
      writeln('		-Alumno: ',cod,'. Promedio: ',prom:2:2);
    end;
  begin
    if (a <> nil) then begin
      if (a^.dato^.dato.codAlumno > cod) then begin
        retornarPromedio(a^.dato);
        recorrerArbol(a^.hi,cod);
        recorrerArbol(a^.hd,cod);
      end
      else
        recorrerArbol(a^.hd,cod);
    end;
  end;
var
  cod : integer;
begin
  write('Ingrese un codigo de alumno: '); readln(cod);
  writeln('Promedios de los alumnos con un codigo mayor a ',cod,': ');
  recorrerArbol(a,cod);
end;

{c. Un módulo que reciba la estructura generada en i., dos códigos de alumnos y un valor
entero, y retorne la cantidad de alumnos con cantidad de finales aprobados igual al
valor ingresado para aquellos alumnos cuyos códigos están comprendidos entre los
dos códigos de alumnos ingresados.}
procedure incisoC (a : arbol);
  procedure check (a : arbol; cod1,cod2,valor : integer; var cant : integer);
    function cumple (l : lista; valor : integer) : boolean;
    var
      cant : integer;
    begin
      cant := 0;
      while (l <> nil) do begin
        cant := cant + 1;
        l := l^.sig;
      end;
      cumple := (cant = valor);
    end;
    
  begin
    if (a <> nil) then begin
      if (a^.dato^.dato.codAlumno >= cod1) then
        if (a^.dato^.dato.codAlumno <= cod2) then begin
          if (cumple(a^.dato,valor)) then
            cant := cant + 1;
          check(a^.hi,cod1,cod2,valor,cant);
          check(a^.hd,cod1,cod2,valor,cant);
        end
        else
          check(a^.hi,cod1,cod2,valor,cant)
      else
        check(a^.hd,cod1,cod2,valor,cant);
    end;
  end;
var
  cod1,cod2,valor,cant : integer;
begin
  write('Ingrese un codigo de alumno: '); readln(cod1);
  write('Ingrese otro codigo de alumno: '); readln(cod2);
  write('Ingrese un valor entero: '); readln(valor);
  cant := 0;
  check(a,cod1,cod2,valor,cant);
  writeln('La cantidad de alumnos entre esos codigos que tienen ',valor,' materias aprobadas son ',cant);
end;

{procedure imprimirArbol(a : arbol);
  procedure imprimirLista(l : lista);
  begin
    writeln('Alumno ',l^.dato.codAlumno,': ');
    while (l <> nil) do begin
      writeln('	-Materia: ',l^.dato.codMateria,'. Nota: ',l^.dato.nota);
      l := l^.sig;
    end;
  end;
  
begin
  if (a<>nil) then begin
    imprimirArbol(a^.hi);
    imprimirLista(a^.dato);
    imprimirArbol(a^.hd);
  end;
end;

procedure imprimirVector(v : vector);
  procedure imprimirListaVec(l : lista);
  begin
    writeln ('Historial de la materia ',l^.dato.codMateria,': ');
    while (l <> nil) do begin
      writeln('	-Alumno ',l^.dato.codAlumno,'. Nota: ',l^.dato.nota);
      l := l^.sig;
    end;
  end;
var
  i : integer;
begin
  for i := 1 to 30 do begin
    if (v[i] <> nil) then
      imprimirListaVec(v[i])
    else
      writeln('La materia ',i,' no se rindio nunca');
  end;
end;}

// programa ppl
var
  v : vector;
  a : arbol;
begin
  a := nil;
  inicializarVector(v);
  incisoA(a,v);
  writeln();
  
  {imprimirArbol(a);
  writeln();
  writeln('Imprimo el vector: ');
  imprimirVector(v);
  writeln();}
  
  incisoB(a);
  writeln();
  
  incisoC(a);
  writeln();
end.
