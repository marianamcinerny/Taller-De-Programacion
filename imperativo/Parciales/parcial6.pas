program parcial6;
const
dimF = 15;
type
rangoD = 1..15;
atencion = record
  dni : integer;
  mes : integer;
  codD : rangoD;
end;

//
paciente = record
  dni : integer;
  cantAtenciones : integer;
end;

arbol = ^nodoA;
nodoA = record
  dato : paciente;
  hi : arbol;
  hd : arbol;
end;
//

vector = array [1..dimF] of integer;

procedure incisoA (var a : arbol; var v : vector);
  procedure leerAtencion (var at : atencion);
  begin
    write('Mes: '); readln(at.mes);
    if (at.mes <> 0) then begin
      write('DNI: '); readln(at.dni);
      write('Codigo de diagnostico: '); readln(at.codD);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; at : atencion);
  begin
    if (a = nil) then begin
      new(a);
      a^.dato.dni := at.dni; a^.dato.cantAtenciones := 1;
    end
    else
      if (a^.dato.dni = at.dni) then
        a^.dato.cantAtenciones := a^.dato.cantAtenciones + 1
      else
        if (at.dni < a^.dato.dni) then
          cargarArbol(a^.hi,at)
        else
          cargarArbol(a^.hd,at);
  end;
  
var
 at : atencion;
begin
  leerAtencion(at);
  while (at.mes <> 0) do begin
    cargarArbol(a,at);
    v[at.codD] := v[at.codD] + 1;
    writeln('---------------------------');
    leerAtencion(at);
  end;
end;

procedure incisoB (a : arbol);
  function cantPacientes (a : arbol; num1,num2,x : integer) : integer;
  begin
    if (a = nil) then
      cantPacientes := 0
    else
      if (a^.dato.dni >= num1) then
        if (a^.dato.dni <= num2) then
          if (a^.dato.cantAtenciones > x) then
            cantPacientes := cantPacientes(a^.hi,num1,num2,x) + cantPacientes(a^.hd,num1,num2,x) + 1
        else
          cantPacientes := cantPacientes(a^.hi,num1,num2,x)
      else
        cantPacientes := cantPacientes(a^.hd,num1,num2,x);
  end;
  
var
  num1,num2,x : integer;
begin
  write('Ingrese un numero de dni '); readln(num1);
  write('Ingrese otro numero de dni '); readln(num2);
  write('Ingrese un numero entero: '); readln(x);
  writeln('Cantidad de pacientes con mas de ',x,' atenciones con DNI entre ',num1,' y ',num2,': ',cantPacientes(a,num1,num2,x));
end;

procedure incisoC (v : vector);
  procedure diagCero (v : vector; var cant,aux : integer);
  begin
    if (aux < dimF) then begin
      if (v[aux] = 0) then
        cant := cant + 1;
      aux := aux + 1;
      diagCero(v,cant,aux);
    end;
  end;
  
var
  cant,aux : integer;
begin
  cant := 0; aux := 1;
  diagCero(v,cant,aux);
  writeln('Cantidad de diagnosticos sin atenciones: ',cant);
end;

procedure inicializarVector (var v : vector);
var
  i : integer;
begin
  for i := 1 to dimF do
    v[i] := 0;
end;

var
  a : arbol;
  v : vector;
begin
  a := nil;
  inicializarVector(v);
  
  incisoA(a,v);
  writeln();
  
  incisoB(a);
  writeln();
  
  incisoC(v);
end.
