{3.- Escribir un programa que:
a. Implemente un módulo recursivo que genere una lista de números enteros “random”
mayores a 0 y menores a 100. Finalizar con el número 0.
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista.
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista.
d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se
encuentra en la lista o falso en caso contrario.}

program EJ3P2;
type
lista = ^nodo;
nodo = record
  dato : integer;
  sig : lista;
end;

procedure generarLista (var l : lista);
var
  num : integer;
  nuevo : lista;
begin
  num := random(100);
  if (num <> 0) then begin
    new (nuevo);
    nuevo^.dato := num; nuevo^.sig := nil;
    l := nuevo;
    generarLista(l^.sig);
  end;
end;

procedure buscarValorMaximo (l : lista; var max : integer);
begin
  if (l <> nil) then begin
    if (l^.dato > max) then
      max := l^.dato;
    buscarValorMaximo(l^.sig,max);
  end;
end;

procedure buscarValorMinimo (l : lista; var min : integer);
begin
  if (l <> nil) then begin
    if (l^.dato < min) then
      min := l^.dato;
    buscarValorMinimo(l^.sig,min);
  end;
end;

var
  l : lista;
  min,max : integer;
begin
  Randomize;
  l := nil;
  min := 100;
  max := -1;
  generarLista(l);
  buscarValorMaximo(l,max);
  buscarValorMinimo(l,min);
  writeln('Valor maximo: ',max);
  writeln('Valor minimo: ',min);
end.
  
  
  
  
  
  
  
  
  
  
  
