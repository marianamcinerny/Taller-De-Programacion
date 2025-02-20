program parcial1;
type
compra = record
  codCliente : integer;
  dia : integer;
  cantProductos : integer;
  monto : real;
end;

lista = ^nodo;
nodo = record
  dato : compra;
  sig : lista;
end;

arbol = ^nodoA;
nodoA = record
  dato : lista;
  hi : arbol;
  hd : arbol;
end;

procedure incisoA (var a : arbol);
  procedure leerCompra (var c : compra);
  begin
    write('Ingrese la cantidad de prodcutos vendidos: '); readln(c.cantProductos);
    if (c.cantProductos <> -1) then begin
      write('Ingrese el codigo de cliente: '); readln(c.codCliente);
      write('Ingrese el dia: '); readln(c.dia);
      write('Ingrese el monto: '); readln(c.monto);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; c : compra);
    procedure cargoLista (var l : lista; c : compra);
    var
      nuevo : lista;
    begin
      new (nuevo);
      nuevo^.dato := c; nuevo^.sig := l;
      l := nuevo;
    end;
    
  begin
    if (a = nil) then begin
      new(a);
      a^.dato := nil;
      a^.hi := nil; a^.hd := nil;
      cargoLista(a^.dato,c);
    end
    else
      if (a^.dato^.dato.codCliente= c.codCliente) then
        cargoLista(a^.dato,c)
      else
        if (c.codCliente < a^.dato^.dato.codCliente) then
          cargarArbol(a^.hi,c)
        else
          cargarArbol(a^.hd,c);
  end;

var
  c : compra;
begin
  leerCompra(c);
  while (c.cantProductos <> -1) do begin
    cargarArbol(a,c);
    writeln('-------------------------------------------');
    leerCompra(c);
  end;
end;

procedure incisoB (a : arbol; var lc : lista);
  procedure buscoCliente(a : arbol; cod : integer; var esta : boolean; var lc : lista);
    procedure retornoCompras (l : lista);
    var
      i : integer;
    begin
      i := 0;
      while (l <> nil) do begin
        i := i + 1;
        writeln('	-Compra ',i,': ',' Dia: ',l^.dato.dia,'. Cantidad de productos: ',l^.dato.cantProductos,'. Monto: ',l^.dato.monto:8:2);
        l := l^.sig;
      end;
    end;
    
  begin
    if (a <> nil) then begin
      if (a^.dato^.dato.codCliente = cod) then begin
        esta := true;
        lc := a^.dato;
        retornoCompras(a^.dato);
      end
      else
        if (cod < a^.dato^.dato.codCliente) then
          buscoCliente(a^.hi,cod,esta,lc)
        else
          buscoCliente(a^.hd,cod,esta,lc);
    end;
  end;

var
  cod : integer;
  esta : boolean;
begin
  esta := false;
  write('Ingrese un codigo de cliente '); readln(cod);
  buscoCliente(a,cod,esta,lc);
  if (esta = false) then
    writeln('El cliente no existe');
end;

procedure incisoC (lc : lista);
  procedure buscarMax (lc : lista; var max : integer; var monto : real);
  begin
    if (lc <> nil) then begin
      if (lc^.dato.cantProductos > max) then begin
        max := lc^.dato.cantProductos;
        monto := lc^.dato.monto;
      end;
      buscarMax(lc^.sig,max,monto);
    end;
  end;
var
  max : integer;
  total : real;
begin
  if (lc <> nil) then begin
    max := 0; total := 0;
    buscarMax (lc,max,total);
    writeln('El monto de la compra con mas productos del cliente ',lc^.dato.codCliente,' es de ',total:8:2)
  end;
end;

var
  a : arbol; lc : lista;
begin
  a := nil;
  lc := nil;
  incisoA(a);
  writeln();
  
  incisoB(a,lc);
  writeln();
  
  incisoC(lc);
end.
