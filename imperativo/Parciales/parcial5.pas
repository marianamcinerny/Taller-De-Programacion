program parcial5;
type
envio = record
  codCliente : integer;
  dia : integer;
  codPostal : integer;
  peso : real;
end;

lista = ^nodoL;
nodoL = record
  dato : envio;
  sig : lista;
end;

arbol = ^nodoA;
nodoA = record
  dato : lista;
  hi : arbol;
  hd : arbol;
end;

procedure incisoA (var a : arbol);
  procedure leerEnvio (var e : envio);
  begin
    write('Peso del paquete: '); readln(e.peso);
    if (e.peso <> 0) then begin
      write('Codigo del cliente: '); readln(e.codCliente);
      write('Dia: '); readln(e.dia);
      write('CodigoPostal: '); readln(e.codPostal);
    end;
  end;
  
  procedure cargarArbol (var a : arbol; e : envio);
    procedure cargarLista (var l : lista; e : envio);
    var
      nuevo : lista;
    begin
      new(nuevo);
      nuevo^.dato := e; nuevo^.sig := l;
      l := nuevo;
    end;
    
  begin
    if (a = nil) then begin
      new(a);
      a^.dato := nil;
      a^.hi := nil; a^.hd := nil;
      cargarLista(a^.dato,e);
    end
    else
      if (a^.dato^.dato.codPostal = e.codPostal) then
        cargarLista(a^.dato,e)
      else
        if (e.codPostal < a^.dato^.dato.codPostal) then
          cargarArbol(a^.hi,e)
        else
          cargarArbol(a^.hd,e);
  end;
  
var
  e : envio;
begin
  leerEnvio(e);
  while (e.peso <> 0) do begin
    cargarArbol(a,e);
    writeln('-----------------------------------------------------');
    leerEnvio(e);
  end;
end;

procedure incisoB (a : arbol; var lb : lista);
  procedure retornarEnvios (a : arbol; cod : integer; var lb : lista);
  begin
    if (a <> nil) then begin
      if (a^.dato^.dato.codPostal = cod) then
        lb := a^.dato
      else
        if (cod < a^.dato^.dato.codPostal) then
          retornarEnvios(a^.hi,cod,lb)
        else
          retornarEnvios(a^.hd,cod,lb)
    end;
  end;
  
  procedure imprimirLista (lb : lista);
  begin
    writeln('Envios del codigo postal ',lb^.dato.codPostal,': ');
    while (lb <> nil) do begin
      writeln('	-Cliente: ',lb^.dato.codCliente,'. Dia: ',lb^.dato.dia,'/8/23. Peso: ',lb^.dato.peso:3:2);
      lb := lb^.sig;
    end;
  end;
  
var
  cod : integer;
begin
  write('Ingrese un codigo postal: '); readln(cod);
  retornarEnvios(a,cod,lb);
  if (lb = nil) then
    writeln('No hay envios en ese codigo postal')
  else
    imprimirLista(lb);
end;

procedure incisoC (lb : lista);
  procedure buscarPesos (lb : lista; var pesomin, pesomax : real; var codmin, codmax : integer);
  begin
    if (lb <> nil) then begin
      if (lb^.dato.peso < pesomin) then begin
        pesomin := lb^.dato.peso;
        codmin := lb^.dato.codCliente;
      end;
      if (lb^.dato.peso > pesomax) then begin
        pesomax := lb^.dato.peso;
        codmax := lb^.dato.codCliente;
      end;
      buscarPesos(lb^.sig,pesomin,pesomax,codmin,codmax);
    end;
  end;
  
var
  codmin,codmax : integer;
  pesomin,pesomax : real;
begin
  if (lb <> nil) then begin
    pesomin := 99999; pesomax := 0;
    buscarPesos(lb,pesomin,pesomax,codmin,codmax);
    writeln('Cliente con el paquete mas pesado: ',codmax);
    writeln('Cliente con el paquete mas liviano: ',codmin);
  end;
end;

//programa principal
var
  a : arbol;
  lb : lista;
begin
  a := nil;
  lb := nil;
  
  incisoA(a);
  writeln();
  
  incisoB(a,lb);
  writeln();
  
  incisoC(lb);
end.
