{5.- Implementar un módulo que realice una búsqueda dicotómica en un vector, utilizando el
siguiente encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se
encuentra en el vector.}

program EJ5P2;
const
dimF = 10;
type
vector = array [1..dimF] of integer;

procedure generarVector(var v : vector; var dimL : integer);
var
  num : integer;
begin
  while (dimL < dimF) do begin
    dimL := dimL + 1;
    num := random(20);
    v[dimL] := num;
  end;
end;

procedure ordenarVector(var v : vector; dimL : integer);
var
  i,j,pos,item : integer;
begin
  for i := 1  to dimL - 1 do begin
    pos := i;
    for j := i + 1 to dimL do
      if (v[j] < v[pos]) then
        pos := j;
    item := v[pos];
    v[pos] := v[i];
    v[i] := item;
  end;
end;

procedure imprimirVector(v : vector; dimL : integer);
var
  i : integer;
begin
  for i := 1 to dimL do
    write(v[i],' | ');
end;

procedure busquedaDicotomica (v: vector; ini,fin,dato : integer; var pos: integer);
var
  medio : integer;
begin
 if  (ini > fin) then pos := -1
 else begin
 
  medio := (ini + fin) div 2;
  if (dato <> v[medio]) then begin
    if (dato < v[medio]) then
      fin := medio - 1
    else
      ini := medio + 1;
    busquedaDicotomica(v,ini,fin,dato,pos);
  end
  else
     pos := medio;
 end;
    
end;

var
  v : vector;
  dimL,dato,pos,ini,fin : integer;
begin
  Randomize;
  dimL := 0;
  generarVector(v,dimL);
  ordenarVector(v,dimL);
  imprimirVector(v,dimL);
  writeln();
  writeln();
  write('Ingrese el dato a buscar: '); readln(dato);
  ini := 1; fin := dimL; pos := 0;
  busquedaDicotomica(v,ini,fin,dato,pos);
  if (pos = -1) then
    writeln('El dato no se encuentra en el vector')
  else
    writeln('El dato se encuentra en la posicion ',(pos));
end.
