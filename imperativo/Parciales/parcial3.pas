program parcial3;
const
  dimF = 12;
type
compra = record
  codJuego : integer;
  codCliente : integer;
  dia : integer;
  mes : integer;
end;

arbol = ^nodoA;
nodoA = record
  dato : compra;
  hi : arbol;
  hd : arbol;
end;

vector = array [1..dimF] of integer;

lista = ^nodoL;
nodoL = record
  dato : compra;
  sig : lista;
end;

procedure incisoA (var a : arbol; var v : vector);
  procedure leerCompra (var c : compra);
  begin
    write('Ingrese el codigo de cliente: '); readln(c.codCliente);
    if (c.codCliente <> 0) then begin
      write('Ingrese el codigo del videojuego: '); readln(c.codJuego);
      write('Ingrese el dia: '); readln(c.dia);
      write('Ingrese el mes: '); readln(c.mes);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; c : compra);
  begin
    if (a = nil) then begin
      new (a);
      a^.dato := c;
      a^.hi := nil; a^.hd := nil;
    end
    else
      if (c.codCliente <= a^.dato.codCliente) then
        cargarArbol(a^.hi,c)
      else
        cargarArbol(a^.hd,c);
  end;
  
  procedure cargarVector (var v : vector; mes : integer);
  begin
    v[mes] := v[mes] + 1;
  end;

var
  c : compra;
begin
  leerCompra(c);
  while (c.codCliente <> 0) do begin
    cargarArbol(a,c);
    cargarVector(v,c.mes);
    writeln('--------------------------------------');
    leerCompra(c);
  end;
end;

procedure incisoB (a : arbol; var l : lista);
  procedure buscarCliente (a : arbol; cod : integer; var esta : boolean; var l : lista);
    procedure cargarLista(a : arbol; var l : lista);
    var
      nuevo : lista;
    begin
      new(nuevo);
      nuevo^.dato := a^.dato; nuevo^.sig := l;
      l := nuevo;
    end;
    
  begin
    if (a <> nil) then begin
      if (a^.dato.codCliente = cod) then begin
        esta := true;
        cargarLista(a,l);
        buscarCliente(a^.hi,cod,esta,l);
      end
      else
        if (cod < a^.dato.codCliente) then
          buscarCliente(a^.hi,cod,esta,l)
        else
          buscarCliente(a^.hd,cod,esta,l);
    end;
  end;
  
  procedure imprimirLista (l : lista);
  begin
    while (l <> nil) do begin
      writeln('	-Codigo del videojuego: ',l^.dato.codJuego,'. Fecha: ',l^.dato.dia,'/',l^.dato.mes,'/22');
      l := l^.sig;
    end;
  end;
var
  cod : integer;
  esta : boolean;
begin
  esta := false;
  write('Ingrese un codigo de cliente: '); readln(cod);
  buscarCliente(a,cod,esta,l);
  if (esta = false) then
    writeln('El cliente no existe');
  if (l <> nil) then
    imprimirLista(l);
end;

procedure incisoC (var v : vector);
  procedure imprimirVector(v : vector);
  var
    i : integer;
  begin
    for i := 1 to dimF do
      writeln('Mes ',i,'. Cantidad de compras: ',v[i]);
  end;
var
  i,j,pos,item : integer;
begin
  for i := 1 to (dimF - 1) do begin
    pos := i;
    for j := (i + 1) to dimF do
      if (v[j] > v[pos]) then
        pos := j;
    item := v[pos];
    v[pos] := v[i];
    v[i] := item;
  end;
  imprimirVector(v);
end;

procedure iniciarVector(var v : vector);
var
  i : integer;
begin
  for i := 1 to dimF do
    v[i] := 0;
end;

var
  a : arbol;
  v : vector;
  l : lista;
begin
  a := nil; l := nil;
  iniciarVector(v);
  
  incisoA(a,v);
  writeln();
  
  incisoB(a,l);
  writeln();
  
  incisoC(v);
end.
