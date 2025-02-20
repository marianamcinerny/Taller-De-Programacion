{1. Implementar un programa modularizado para una librería que:
2. Almacene los productos vendidos en una estructura eficiente para la búsqueda por código
de producto. De cada producto deben quedar almacenados la cantidad total de unidades
vendidas y el monto total. De cada venta se lee código de venta, código del producto
vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las ventas finaliza
cuando se lee el código de venta -1.
a. Imprima el contenido del árbol ordenado por código de producto.
b. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.
c. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.
d. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).}

program EJ1P4;
type
venta = record
  codVenta : integer;
  codProducto : integer;
  cantVendidos : integer;
  precio : real;
end;

producto = record
  cod : integer;
  totalVendidos : integer;
  totalMonto : real;
end;

arbol = ^nodo;
nodo = record
  dato : producto;
  hi : arbol;
  hd : arbol;
end;

procedure incisoCero (var a : arbol);
  procedure leerVenta(var v : venta);
  begin
    write('Ingrese el codigo de venta: '); readln(v.codVenta);
    if (v.codVenta <> -1) then begin
      write('Codigo de producto: '); readln(v.codProducto);
      write('Candidad vendidos: '); readln(v.cantVendidos);
      write('Precio unitario: '); readln(v.precio);
      writeln();
    end;
  end;
  
  procedure cargarArbol (var a : arbol; v : venta);
    procedure armarProducto(var p : producto;v : venta);
    begin
      p.cod := v.codProducto;
      p.totalVendidos := v.cantVendidos;
      p.totalMonto := v.cantVendidos * v.precio;
    end;
  var
    p : producto;
  begin
    if (a = nil) then begin
      new (a);
      armarProducto(p,v);
      a^.dato := p; a^.hi := nil; a^.hd := nil;
    end
    else
      if (v.codProducto = a^.dato.cod) then begin
        a^.dato.totalVendidos := a^.dato.totalVendidos + v.cantVendidos;
        a^.dato.totalMonto := a^.dato.totalMonto + (v.cantVendidos * v.precio);
      end
      else
        if (v.codProducto < a^.dato.cod) then
          cargarArbol(a^.hi,v)
        else
          cargarArbol(a^.hd,v);
  end;

var
  v : venta;
begin
  leerVenta(v);
  while (v.codVenta <> -1) do begin
    cargarArbol(a,v);
    leerVenta(v);
  end;
end;

{a. Imprima el contenido del árbol ordenado por código de producto.}
procedure incisoA (a : arbol);
begin
  if (a <> nil) then begin
    incisoA(a^.hi);
    writeln('Codigo de producto: ',a^.dato.cod);
    writeln('Cantidad total de vendidos: ',a^.dato.totalVendidos);
    writeln('Monto total: ',a^.dato.totalMonto:9:2);
    incisoA(a^.hd);
  end;
end;

{b. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.}
procedure incisoB (a : arbol);
  procedure buscarMax (a : arbol; var maxVendidos,maxCodigo : integer);
  begin
    if (a <> nil) then begin
      buscarMax(a^.hi,maxVendidos,maxCodigo);
      if (a^.dato.totalVendidos > maxVendidos) then begin
        maxVendidos := a^.dato.totalVendidos;
        maxCodigo := a^.dato.cod;
      end;
      buscarMax(a^.hd,maxVendidos,maxCodigo)
    end;
  end;

var
  maxVendidos, maxCodigo : integer;
begin
  maxVendidos := 0;
  buscarMax(a,maxVendidos,maxCodigo);
  writeln('El codigo del producto mas vendido es ',maxCodigo);
end;

{c. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.}
procedure incisoC (a : arbol);
  function cantMenores (a : arbol; cod : integer) : integer;
  begin
    if (a = nil) then
      cantMenores := 0
    else
      if (a^.dato.cod < cod) then
        cantMenores := 1 + (cantMenores(a^.hi,cod)) + (cantMenores(a^.hd,cod))
      else
        if (a^.dato.cod >= cod) then
          cantMenores := cantMenores(a^.hi,cod);
  end;
  
var
  cod: integer;
begin
  write('Ingrese un codigo: '); readln(cod);
  writeln('Cantidad de codigos menores que ',cod,': ',cantMenores(a,cod))
end;

{d. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).}
procedure incisoD (a : arbol);
  function calcularMonto (a : arbol; cod1,cod2 : integer) : real;
  begin
    if (a <> nil) then begin
      if (a^.dato.cod > cod1) then begin
        if (a^.dato.cod < cod2) then
          calcularMonto := calcularMonto(a^.hd,cod1,cod2) + calcularMonto(a^.hi,cod1,cod2) + a^.dato.totalMonto
        else
          calcularMonto := calcularMonto(a^.hi,cod1,cod2)
      end
      else
        calcularMonto := calcularMonto(a^.hd,cod1,cod2);
    end
    else
      calcularMonto := 0;
  end;

var
  cod1, cod2 : integer;
begin
  write('Ingrese el primer codigo: '); readln(cod1);
  write('Ingrese el segundo codigo: '); readln(cod2);
  writeln('Monto total entre los dos codigos: ',calcularMonto(a,cod1,cod2):15:2);
end;

//programa ppl
var
  a : arbol;
begin
  a := nil;
  incisoCero(a);
  writeln();
  
  incisoA(a);
  writeln();
  
  incisoB(a);
  writeln();
  
  incisoC(a);
  writeln();
  
  incisoD(a);
  writeln();
end.
