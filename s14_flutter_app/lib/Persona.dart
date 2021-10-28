class Persona
{
  late String nombre;
  late String apellido;


  Persona(this.nombre, this.apellido);

  @override
  String toString() {
    return 'Persona{nombre: $nombre, apellido: $apellido}';
  }
}