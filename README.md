# Conversor de Monedas

## Descripción
Conversor de monedas para el challenge de Alura, que consume API y guarda la salida.

## Tecnologías Utilizadas
- Java 11
- Gson 2.11

## Instalación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
   ```
2. Navegar a la carpeta del proyecto:
   ```bash
   cd nombre_del_repositorio
   ```
3. Agregar la biblioteca Gson: Si usas un proyecto de Maven, añade la siguiente dependencia a tu archivo pom.xml:
   ```xml
   <dependency>
     <groupId>com.google.code.gson</groupId>
     <artifactId>gson</artifactId>
     <version>2.11</version>
   </dependency>
   ```
4. Ejecutar el programa:
  ```bash
java -cp .nombre_del_paquete.Main
  ```
## Uso de la Aplicación
Paso 1: Ejecutar el programa
Se solicita moneda origen y después moneda destino, por último el monto.

Paso 2: Resultado
Muestra el resultado de la conversión y la fecha del mismo. El histórico se guarda en un archivo TXT.
