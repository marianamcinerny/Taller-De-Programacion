{1.- Implementar un programa que procese la información de los alumnos de la Facultad de
Informática.
a) Implementar un módulo que lea y retorne, en una estructura adecuada, la información de
todos los alumnos. De cada alumno se lee su apellido, número de alumno, año de ingreso,
cantidad de materias aprobadas (a lo sumo 36) y el código de materia junto con la nota
obtenida (sin contar los aplazos) en cada una de las materias aprobadas. La lectura finaliza
cuando se ingresa el número de alumno 11111, el cual debe procesarse.
b) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne la
información con número de alumno y promedio de cada alumno.
c) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne la
información con número de alumno y el código y nota de la materia con mayor nota de cada
alumno.
d) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?}

program EJ1P0;
const
dimF = 36;
type
vector = array [1..dimF] of integer;

alumno = record
  apellido : string;
  num : integer;
  anio : integer;
  cant : integer;
  materias : vector;
end;

lista = ^nodo;
nodo = record
  dato : alumno;
  sig : lista;
end;

procedure incisoA (var l : lista);
  procedure leerAlumno(var a : alumno);
  begin
    write('Apellido del alumno: '); readln(a.apellido);
    write('Numero de alumno: '); readln(a.num);
    write('Anio de ingreso: '); readln(a.anio);
    write('Cantidad de materias aprobadas: '); readln(a.cant);
  end;
  
  procedure generarVector (cant : integer; var v : vector);
  var
    i,nota : integer;
  begin
    for i := 1 to cant do begin
      write('Ingrese la nota obtenida en la materia ',i,': '); readln(nota);
      v[i] := nota;
    end;
  end;
  
  procedure generarLista (var l,pU : lista; a : alumno);
  var
    nuevo : lista;
  begin
    new (nuevo);
    nuevo^.dato := a; nuevo^.sig := nil;
    if (l = nil) then begin
      l := nuevo;
      pU := nuevo;
    end
    else begin
      pU^.sig := nuevo;
      pU := nuevo;
    end;
  end;

var
  a : alumno;
  pU : lista;
begin
  pU := nil;
  repeat
    leerAlumno (a);
    if (a.cant > 0) then
      generarVector(a.cant,a.materias)
    else
      writeln('----------------------------------------');
    generarLista(l,pU,a);
  until (a.num = 11111);
end;

procedure incisoB (l : lista);
  procedure recorrerVector (v : vector; dimL : integer; var prom : real);
  var
    i : integer;
  begin
    for i := 1 to dimL do
      prom := prom + v[i];
  end;
  
var
  prom : real;
begin
  while (l <> nil) do begin
    if (l^.dato.cant = 0) then begin
      writeln('El alumno ',l^.dato.num,' no tiene materias aprobadas');
      writeln('----------------------------------------');
    end
    else begin
      prom := 0;
      recorrerVector(l^.dato.materias,l^.dato.cant,prom);
      prom := prom / l^.dato.cant;
      writeln('El alumno ',l^.dato.num,' tiene promedio ',prom:2:2);
      writeln('----------------------------------------');
    end;
  end;
end;

procedure incisoC (l : lista);
  procedure buscarMax(var max,maxCod : integer; dimL : integer; v : vector);
  var
    i : integer;
  begin
    for i := 1 to dimL do
      if (v[i] > max) then begin
        max := v[i];
        maxCod := i;
      end;
  end;

var
  max,maxCod : integer;
begin
  while (l <> nil) do begin
    if (l^.dato.cant = 0) then
      writeln('El alumno ',l^.dato.num,' no rindio materias, no se puede buscar su nota maxima')
    else begin
      max := 3; 
      buscarMax(max,maxCod,l^.dato.cant,l^.dato.materias);
      writeln('La mayor nota del alumno ',l^.dato.num,' es ',max,' en la materia ',maxCod);
    end;
    l := l^.sig;
  end;
end;

var
  l : lista;
begin
  l := nil;
  incisoA(l);
  incisoB(l);
  incisoC(l);
end.
