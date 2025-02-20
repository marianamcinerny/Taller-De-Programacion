{4.- Escribir un programa con:
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 0 y
menores a 100.
b. Un módulo recursivo que devuelva el máximo valor del vector.
c. Un módulo recursivo que devuelva la suma de los valores contenidos en el vector.}

program EJ4P2;
const
dimF = 20;
type
vector = array [1..dimF] of integer;

procedure generarVector (var v : vector; var aux : integer);
var
  num : integer;
begin
  num := random(99) + 1;
  if (aux < dimF) then begin
    aux := aux + 1;
    v[aux] := num;
    generarVector(v,aux);
  end;
end;

procedure valorMaximo (v : vector; var max : integer; var aux : integer);
begin
  if (aux < dimF) then begin
    aux := aux + 1;
    if (v[aux] > max) then
      max := v[aux];
    valorMaximo(v,max,aux);
  end;
end;

procedure sumatoria (v : vector; var aux : integer; var suma : integer);
begin
  if (aux < dimF) then begin
    aux := aux + 1;
    suma := suma + v[aux];
    sumatoria(v,aux,suma);
  end;
end;

var
  v : vector;
  aux,suma,max : integer;
begin
  Randomize;
  aux := 0; suma := 0; max := 0;
  generarVector(v,aux);
  aux := 0;
  valorMaximo(v,max,aux);
  writeln('El valor maximo es: ',max);
  aux := 0;
  sumatoria(v,aux,suma);
  writeln('La suma de los valores contenidos en el vector es de: ',suma);
end.












