

{3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.


b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).}

program ejercicio3;
type
genero = 1..8;

pelicula = record
  cod : integer;
  gen : genero;
  puntaje : real;
end;

peliculaL = record
  cod : integer;
  puntaje : real;
end;

lista = ^nodo;
nodo = record
  dato : peliculaL;
  sig : lista;
end;

vector = array [genero] of lista;
vectorMax = array [genero] of integer;

procedure inicializarVector (var v : vector);
var
  i : genero;
begin
  for i := 1 to 8 do 
    v[i] := nil;
end;

procedure inicializarVectorMax (var vm : vectorMax);
var
  i : genero;
begin
  for i := 1 to 8 do 
    vm[i] := 0;
end;

{a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.}
procedure incisoA (var v : vector);
  procedure leerPelicula (var p : pelicula);
  begin
    write('Ingrese el codigo de pelicula: '); readln(p.cod);
    if (p.cod <> -1) then begin
      write('Ingrese el genero: '); readln(p.gen);
      write('Ingrese el puntaje: '); readln(p.puntaje);
    end;
  end;
  
  procedure cargarVector (var v : vector; p : pelicula);
  var
    nue,aux : lista;
  begin
    new (nue);
    nue^.dato.cod := p.cod; nue^.dato.puntaje := p.puntaje;
    nue^.sig := nil;
    if (v[p.gen] = nil) then
      v[p.gen] := nue
    else begin
      aux := v[p.gen];
      while (aux <> nil) do
        aux := aux^.sig;
      aux^.sig := nue;
    end;
  end;
          
var
  p : pelicula;
begin
  leerPelicula(p);
  while (p.cod <> -1) do begin
    cargarVector(v,p);
    leerPelicula(p);
  end;
end;

{b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..}
procedure incisoB(v : vector; var vm : vectorMax);
  procedure recorroLista(l : lista; var maxPuntaje : real; var codMaxPuntaje : integer);
  begin
    while (l <> nil) do begin
      if (l^.dato.puntaje > maxPuntaje) then begin
        maxPuntaje := l^.dato.puntaje;
        codMaxPuntaje := l^.dato.cod;
      end;
      l := l^.sig;
    end;
  end;
var
 i : genero;
 maxPuntaje : real;
 codMaxPuntaje : integer;
begin
  for i := 1 to 8 do begin
    maxPuntaje := -1; codMaxPuntaje := 0;
    recorroLista(v[i],maxPuntaje,codMaxPuntaje);
    vm[i] := codMaxPuntaje;
  end;
end;

{c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.}
procedure incisoC (var vm : vectorMax);
var
  i,j,pos : genero;
  item : integer;
begin
  for i := 1 to 7 do begin
    pos := i;
    for j := i + 1 to 8 do
      if vm[j] < vm[pos] then
        pos := j;
    item := vm[pos];
    vm[pos] := vm[i];
    vm[i] := item;
  end;
end;

{d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).}
procedure incisoD (v : vector);
  procedure buscarMaxMin (l : lista; var punMax, punMin : real; var codMax, codMin : integer);
  begin
    while (l <> nil) do begin
      if (l^.dato.puntaje > punMax) then begin
        punMax := l^.dato.puntaje;
        codMax := l^.dato.cod;
      end;
      if (l^.dato.puntaje < punMin) then begin
        punMin := l^.dato.puntaje;
        codMax := l^.dato.cod;
      end;
      l := l^.sig;
    end;
  end;

var
  codMax,codMin,i : integer;
  punMax,punMin : real;
begin
  punMax := -1; punMin := 11;
  for i := 1 to 8 do
    buscarMaxMin(v[i],punMax,punMin,codMax,codMin);
  writeln('Codigo de la pelicula con mayor puntaje: ',codMax);
  writeln('Codigo de la pelicula con menor puntaje: ',codMin);
end;

//programa ppl
var
  v : vector;
  vm : vectorMax;
begin
  inicializarVector(v);
  inicializarVectorMax(vm);
  incisoA(v);
  incisoB(v,vm);
  incisoC(vm);
end.
