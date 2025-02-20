{2. Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee
código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de
producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendida.
Nota: El módulo debe retornar los dos árboles.
b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.
c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.}

program EJ2P3;
type
fechaR = record
  dia : integer;
  mes : integer;
  anio : integer;
end;

ventas1 = record
  cod, cantidad : integer;
  fecha : fechaR;
end;

ventas2 = record
  cod, cantidad : integer;
end;

arbol1 = ^nodo1;
nodo1 = record
  dato : ventas1;
  hi : arbol1;
  hd : arbol1;
end;

arbol2 = ^nodo2;
nodo2 = record
  dato : ventas2;
  hi : arbol2;
  hd : arbol2;
end;

//----INCISO A----
procedure incisoA (var a1 : arbol1; var a2 : arbol2);
  procedure leerVenta(var v1 : ventas1);
    procedure leerFecha (var f : fechaR);
    begin
      write('Ingrese el dia: '); readln(f.dia);
      write('Ingrese el mes: '); readln(f.mes);
      write('Ingrese el anio: '); readln(f.anio)
    end;
    
  begin
    write('Ingrese el codigo del producto: '); readln(v1.cod);
    if (v1.cod <> 0) then begin
      write('Ingrese la cantidad vendida: '); readln(v1.cantidad);
      leerFecha(v1.fecha);
    end;
  end;
  
  procedure cargarArbol1 (var a1 : arbol1; v1 : ventas1);
  begin
    if (a1 = nil) then begin
      new (a1);
      a1^.dato := v1;
      a1^.hi := nil; a1^.hd := nil;
    end
    else
      if (v1.cod <= a1^.dato.cod) then
        cargarArbol1(a1^.hi,v1)
      else
        cargarArbol1(a1^.hd,v1);
  end;
  
  procedure cargarArbol2 (var a2 : arbol2; v1 : ventas1);
    procedure equivalenciaVenta (v1 : ventas1; var v2 : ventas2);
    begin
      v2.cod := v1.cod;
      v2.cantidad := v1.cantidad;
    end;

  var
    v2 : ventas2;
  begin
    if (a2 = nil) then begin
      new(a2);
      equivalenciaVenta(v1,v2);
      a2^.dato := v2; a2^.hi := nil; a2^.hd := nil;
    end
    else
     if (a2^.dato.cod = v1.cod) then
        a2^.dato.cantidad := a2^.dato.cantidad + v1.cantidad
      else
        if (a2^.dato.cod < v1.cod) then
          cargarArbol2(a2^.hi,v1)
        else
          cargarArbol2(a2^.hd,v1)
  end;
  
var
  v1 : ventas1;
begin
  leerVenta(v1);
  while (v1.cod <> 0) do begin
    cargarArbol1 (a1,v1);
    cargarArbol2 (a2,v1);
    leerVenta(v1);
  end;
end;

//----INCISO B----
function incisoB (a1 : arbol1; cod : integer) : integer;
begin
  if (a1 = nil) then
    incisoB := 0
  else
    if (a1^.dato.cod = cod) then
      incisoB := a1^.dato.cantidad + incisoB(a1^.hi,cod) + incisoB(a1^.hd,cod)
    else
      if (cod > a1^.dato.cod) then
        incisoB := incisoB(a1^.hd,cod)
      else
        incisoB := incisoB(a1^.hi,cod);
end;

//----INCISO C----
function incisoC (a2 : arbol2; cod : integer) : integer;
begin
  if (a2 <> nil) then begin
    if (a2^.dato.cod = cod) then
      incisoC := a2^.dato.cantidad
    else
      if (a2^.dato.cod < cod) then
        incisoC := incisoC(a2^.hi,cod)
      else
        incisoC := incisoC(a2^.hd,cod)
  end;
end;

var
  a1 : arbol1; a2 : arbol2;
  cod: integer;
begin
  a1 := nil;
  a2 := nil;
  incisoA(a1,a2);
  writeln;
  writeln('Inciso B');
  write('Ingrese un codigo: '); readln(cod);
  writeln('Cantidad de productos vendidos con el codigo ',cod,': ',incisoB(a1,cod));
  writeln;
  writeln('inciso C');
  write('Ingrese un codigo: '); readln(cod);
  writeln('Cantidad de productos vendidos con el codigo ',cod,': ',incisoC(a2,cod));
end.
