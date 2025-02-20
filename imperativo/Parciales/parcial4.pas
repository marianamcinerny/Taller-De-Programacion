program parcial4;
const
dimF = 12;
type
compra = record
  codCliente : integer;
  mes : integer;
  monto : real;
end;

vector = array [1..dimF] of real;

compraR = record
  codCliente : integer;
  v : vector;
end;

arbol = ^nodoA;
nodoA = record
  dato : compraR;
  hi : arbol;
  hd : arbol;
end;

procedure incisoA (var a : arbol);
  procedure leerCompra (var c : compra);
  begin
    write('Ingrese el codigo de cliente: '); readln(c.codCliente);
    if (c.codCliente <> 0) then begin
      write('Ingrese el mes de la compra: '); readln(c.mes);
      write('Ingrese el monto: '); readln(c.monto);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; c : compra);
    procedure inicializarVector (var v : vector);
    var
      i : integer;
    begin
      for i := 1 to dimF do
        v[i] := 0;
    end;
  begin
    if (a = nil) then begin
      new(a);
      a^.dato.codCliente := c.codCliente;
      inicializarVector(a^.dato.v);
      a^.hi := nil; a^.hd := nil;
      a^.dato.v[c.mes] := a^.dato.v[c.mes] + c.monto;
    end
    else
      if (a^.dato.codCliente = c.codCliente) then
        a^.dato.v[c.mes] := a^.dato.v[c.mes] + c.monto
      else
        if (c.codCliente < a^.dato.codCliente) then
          cargarArbol(a^.hi,c)
        else
          cargarArbol(a^.hd,c);
  end;
  
var
  c : compra;
begin
  leerCompra(c);
  while (c.codCliente <> 0) do begin
    cargarArbol(a,c);
    writeln('--------------------------------------');
    leerCompra(c);
  end;
end;

procedure incisoB (a : arbol);
  procedure buscarCliente (a : arbol; cod : integer; var esta : boolean; var maxMes : integer; var maxMonto : real);
    procedure buscarMax (v : vector; var maxMes : integer; var maxMonto : real);
    var
      i : integer;
    begin
      for i := 1 to dimF do
        if (v[i] > maxMonto) then begin
          maxMonto := v[i];
          maxMes := i;
        end;
    end;
  begin
    if (a <> nil) then begin
      if (a^.dato.codCliente = cod) then begin
        esta := true;
        buscarMax (a^.dato.v,maxMes,maxMonto);
      end
      else
        if (cod < a^.dato.codCliente) then
          buscarCliente(a^.hi,cod,esta,maxMes,maxMonto)
        else
          buscarCliente(a^.hd,cod,esta,maxMes,maxMonto);
    end;
  end;
  
var
  cod,maxMes : integer;
  esta : boolean;
  maxMonto : real;
begin
  esta := false;
  write('Ingrese el codigo de un cliente: '); readln(cod);
  maxMonto := 0;
  buscarCliente(a,cod,esta,maxMes,maxMonto);
  if (esta = false) then
    writeln('Ese cliente no existe')
  else
    writeln('Mes en el que mas gasto: ',maxMes);
end;

procedure incisoC (a : arbol);
  procedure cantAhorro (a : arbol; mes : integer; var cant : integer);
  begin
    if (a <> nil) then begin
      cantAhorro(a^.hi,mes,cant);
      if (a^.dato.v[mes] = 0) then
        cant := cant + 1;
      cantAhorro(a^.hd,mes,cant);
    end;
  end;
  
var
  mes,cant : integer;
begin
  cant := 0;
  write('Ingrese un numero de mes: '); readln(mes);
  cantAhorro(a,mes,cant);
  writeln('Cantidad de clientes que no gastaron en ese mes: ',cant);
end;

//programa ppl
var
  a : arbol;
begin
  a := nil;
  
  incisoA(a);
  writeln();
  
  incisoB(a);
  writeln();
  
  incisoC(a);
end.
