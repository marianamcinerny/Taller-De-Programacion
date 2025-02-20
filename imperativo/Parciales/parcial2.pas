program parcial2;
type
pedido = record
  numCliente : integer;
  dia : integer;
  cantCombos : integer;
  monto : real;
end;

lista = ^nodoL;
nodoL = record
  dato : pedido;
  sig : lista;
end;

arbol = ^nodoA;
nodoA = record
  dato : lista;
  hi : arbol;
  hd : arbol;
end;

procedure incisoA (var a : arbol);
  procedure leerPedido (var p : pedido);
  begin
    write('Ingrese el numero de cliente: '); readln(p.numCliente);
    if (p.numCliente <> 0) then begin
      write('Ingrese el dia: '); readln(p.dia);
      write('Ingrese la cantidad de combos: '); readln(p.cantCombos);
      write('Ingrese el monto: '); readln(p.monto);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; p : pedido);
    procedure cargarLista (var l : lista; p : pedido);
    var
      nuevo : lista;
    begin
      new(nuevo);
      nuevo^.dato := p; nuevo^.sig := l;
      l := nuevo;
    end;
    
  begin
    if (a = nil) then begin
      new(a);
      a^.dato := nil;
      a^.hi := nil; a^.hd := nil;
      cargarLista(a^.dato,p)
    end
    else
      if (p.numCliente = a^.dato^.dato.numCliente) then
        cargarLista(a^.dato,p)
      else
        if (p.numCliente < a^.dato^.dato.numCliente) then
          cargarArbol(a^.hi,p)
        else
          cargarArbol(a^.hd,p);
  end;

var
  p : pedido;
begin
  leerPedido(p);
  while (p.numCliente <> 0) do begin
    cargarArbol(a,p);
    writeln('---------------------------------------------------');
    leerPedido(p);
  end;
end;

procedure incisoB (a : arbol; var lp : lista);
  procedure buscarCliente (a : arbol; num : integer; var lp : lista; var esta : boolean);
    procedure imprimirCompras (l : lista);
    begin
      writeln('Compras del cliente numero ',l^.dato.numCliente,': ');
      while (l <> nil) do begin
        writeln('	- Dia: ',l^.dato.dia,'. Cantidad de combos: ',l^.dato.cantCombos,'. Monto: ',l^.dato.monto:8:2);
        l := l^.sig;
      end;
    end;
    
  begin
    if (a <> nil) then begin
      if (a^.dato^.dato.numCliente = num) then begin
        esta := true;
        imprimirCompras(a^.dato);
        lp := a^.dato;
      end
      else
        if (num < a^.dato^.dato.numCliente) then
          buscarCliente(a^.hi,num,lp,esta)
        else
          buscarCliente(a^.hd,num,lp,esta);
    end;
  end;
  
var
  num : integer;
  esta : boolean;
begin
  write('Ingrese un numero de cliente '); readln(num);
  esta := false;
  buscarCliente(a,num,lp,esta);
  if (esta = false) then
    writeln('El cliente no existe');
end;

procedure incisoC (lp : lista);
  procedure calcularMonto (l : lista; var total : real);
  begin
    if (l <> nil) then begin
      total := total + l^.dato.monto;
      calcularMonto(l^.sig,total);
    end;
  end;
  
var
  total : real;
begin
  if (lp <> nil) then begin
    total := 0;
    calcularMonto(lp,total);
    writeln('Monto total abonado por el cliente ',lp^.dato.numCliente,': ',total:8:2);
  end;
end;

//programa principal
var
  a : arbol;
  lp : lista;
begin
  a := nil;
  lp := nil;
  
  incisoA(a);
  writeln();
  
  incisoB(a,lp);
  writeln();
  
  incisoC(lp);
end.
