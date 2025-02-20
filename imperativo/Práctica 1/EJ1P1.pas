{1.- Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce
el día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g).}

program ejercicio1;
const
  dimF = 50;
type
dias = 0..31;
rangoVentas = 1..99;
ventas = record
  dia : integer;
  cod : integer;
  cant : integer;
  end;
  
  vector = array [1..dimF] of ventas;
  
  ventaL = record
    cod : integer;
    cant : integer;
  end;
  
  lista = ^nodo;
  nodo = record
    dato : ventaL;
    sig : lista;
  end;

{Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce
el día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).}
procedure cargarVector (var vec : vector; var dimL : integer);
  procedure leerVenta (var v : ventas);
  begin
    writeln('Ingrese el dia: '); v.dia := random(32);
    if (v.dia <> 0) then begin
      writeln('Ingrese el codigo de venta: '); v.cod := random(15) + 1;
      writeln('Ingrese la cantidad vendida: '); v.cant := random(99) + 1;
      writeln('---------------------------------------------------------------');
    end;
  end;
var
  v : ventas;
begin
  leerVenta(v);
  while ((dimL < dimF) and (v.dia <> 0)) do begin 
    dimL := dimL + 1;
    vec[dimL] := v;
    leerVenta(v);
  end;
end;

{b. Un módulo que muestre el contenido del vector resultante del punto a).}
{d. Un módulo que muestre el contenido del vector resultante del punto c).}
{f. Un módulo que muestre el contenido del vector resultante del punto e).}
{h. Un módulo que muestre la información obtenida en el punto g).}
procedure imprimirVector (v : vector; dimL : integer);
var
  i : integer;
begin
  for i := 1 to dimL do begin
    writeln('Venta ',i,': ');
    writeln('	Fecha: ',v[i].dia);
    writeln('	Codigo: ',v[i].cod);
    writeln('	Cantidad: ',v[i].cant);
    writeln('---------------------------------------------------------------');
  end;
end;

{c. Un módulo que ordene el vector de ventas por código.}
procedure ordenarPorCodigo (var v : vector; dimL : integer); //insercion
var
  i,j : integer;
  actual : ventas;
begin
  for i := 2 to dimL do begin
    actual := v[i];
    j := i-1;
    while (j > 0) and (v[j].cod > actual.cod) do begin
      v[j+1] := v[j];
      j := j - 1;
    end;
    v[j+1] := actual;
  end;
end;
  
{e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.}
procedure eliminar (var v : vector; var dimL : integer); // no me anda
var
  i,pi,pf,valor1,valor2,aBorrar : integer;
begin
  pi := 1;
  write('Ingrese el primer valor: '); readln(valor1);
  write('Ingrese el segundo valor: '); readln(valor2);
  // busco la posicion inicial
  while (pi <= dimL) and (v[pi].cod < valor1) do
    pi := pi + 1;
  // busco la posicion final
  pf := pi;
  while (pf <= dimL) and (v[pf].cod <= valor2) do
    pf := pf + 1;
  
  aBorrar := pf - pi;
  //elimino
  if (aBorrar > 0) then 
    for i := pf to dimL do begin
      v[pi] := v[i];
      pi := pi + 1;
    end;
  dimL := dimL - aBorrar;
end;  

{g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.}
procedure incisoG (var l : lista; v : vector; dimL : integer); //cantidad todal de productos vendidos con cod par?
// o registro nuevo?
  function cumple(cod : integer) : boolean;
  begin
    cumple := ((cod mod 2) = 0);
  end;
  
  procedure cargarLista (var l,pU : lista; v : ventaL);
  var
    nuevo : lista;
  begin
    new(nuevo);
    nuevo^.dato := v; nuevo^.sig := nil;
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
  i : integer;
  pU : lista;
  vL : ventaL;
begin
  for i := 1 to dimL do 
    if cumple(v[i].cod) then begin
      vL.cod := v[i].cod;
      vL.cant := v[i].cant;
      cargarLista(l,pU,vL);
    end;
end;

procedure imprimirLista(l : lista);
begin
  if (l = nil) then
    writeln('No hay codigos pares')
  else
    while(l <> nil) do begin
      writeln ('Codigo de venta: ',l^.dato.cod);
      writeln ('	Cantidad de ventas: ',l^.dato.cant);
      writeln('---------------------------------------------------------------');
      l := l^.sig;
    end;
end;

var
 l : lista;
 v : vector;
 dimL: integer;
begin
  Randomize;
  l := nil;
  dimL := 0;
  cargarVector(v,dimL);
  writeln();
  writeln('se imprime el primer vector: ');
  imprimirVector(v,dimL);
  ordenarPorCodigo(v,dimL);
  writeln();
  writeln('se imprime el segundo vector: ');
  imprimirVector(v,dimL);
  eliminar(v,dimL);
  writeln();
  writeln('se imprime el vector eliminado: ');
  imprimirVector(v,dimL);
  incisoG(l,v,dimL);
  writeln();
  writeln('se imprime la lista: ');
  imprimirLista(l);
end.

