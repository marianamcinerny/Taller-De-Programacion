{2.- Realizar un programa que lea números hasta leer el valor 0 e imprima, para cada número
leído, sus dígitos en el orden en que aparecen en el número. Debe implementarse un módulo
recursivo que reciba el número e imprima lo pedido. Ejemplo si se lee el valor 256, se debe
imprimir 2 5 6}

program EJ2P2;
procedure imprimirRecursivo (num : integer);
var
  aux : integer;
begin
  if (num <> 0) then begin
    aux := num mod 10;
    num := num div 10;
    imprimirRecursivo(num);
    write(aux, ' ');
  end;
end;

var
  num : integer;
begin
  write('Ingrese un numero: '); readln(num);
  while(num <> 0) do begin
    imprimirRecursivo(num);
    writeln();
    write('Ingrese un numero: '); readln(num);
  end;
end.
