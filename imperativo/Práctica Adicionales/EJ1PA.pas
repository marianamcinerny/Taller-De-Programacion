{1. El administrador de un edificio de oficinas, cuenta en papel, con la información del pago
de las expensas de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.
c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo,
debe retornar la posición del vector donde se encuentra y en caso contrario debe
retornar 0. Luego el programa debe informar el DNI del propietario o un cartel
indicando que no se encontró la oficina.
d) Un módulo recursivo que retorne el monto total de las expensas.}

program EJ1PA;
const
dimF = 300;
type
oficina = record
  cod : integer;
  dni : integer;
  valor : real;
end;

vector = array [1..dimF] of oficina; //cambiar a 300

{a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.}
procedure incisoA (var v : vector; var dimL : integer);
  procedure leerOficina (var o : oficina);
  begin
    write('Ingrese el codigo de la oficina: '); readln(o.cod);
    if (o.cod <> -1) then begin
      write('Ingrese el DNI del propietario: '); readln(o.dni);
      write('Ingrese el valor de la expensa: '); readln(o.valor);
    end;
  end;
  
var
  o : oficina;
begin
  leerOficina(o);
  while (dimL < dimF)(o.cod <> -1) do begin
    dimL := dimL + 1;
    v[o.cod] := o;
    leerOficina(o);
  end;
end;

{b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.}
procedure incisoB (var v : vector, dimL : integer); //seleccion
var
  i,j,pos : integer; item : o;
begin
  for i := 1 to dimL - 1 do begin
    pos := i;
    for j := i + 1 to dimL do
      if (v[j].cod < v[pos].cod) then
        pos := j;
    item := v[pos];
    v[pos] := v[i];
    v[i] := item;
  end:
end;

{c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo,
debe retornar la posición del vector donde se encuentra y en caso contrario debe
retornar 0. Luego el programa debe informar el DNI del propietario o un cartel
indicando que no se encontró la oficina.}
procedure incisoC (v : vector);

var
  codOfi : integer;
begin
  write('Ingrese un codigo: '); readln(codOfi);
  busquedaDicotomica(v,codOfi);
end;
