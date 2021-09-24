# Big Data Unit_1:

In the branch named _"Unit 1"_ we have the following practices:

## Index

[Practice_2](https://github.com/Julius86/BigData/blob/Unit_1/Practices/Practice_2.scala)

[Practice_3](https://github.com/Julius86/BigData/blob/Unit_1/Practices/Practice_3.scala)

[Practice_4](https://github.com/Julius86/BigData/blob/Unit_1/Practices/Practice_4.scala)


# Practice 2

1. Develop an algorithm in Scala that calculates a circle radius.
2. Develop an algorithm in Scala that tells if a number is prime.
3. Given the variable var bird = "tweet", use a string interpolation to
   print "Estoy ecribiendo un tweet"
4. Given the variable var mensaje = "Hola Luke yo soy tu padre!" use slice to extract the
    secuence "Luke"
5. What is the difference between value (val) and variable (var) in scala?
6. Given the tuple (2,4,5,1,2,3,3.1416,23) return the number 3.1416

## Code

```r
import org.apache.spark.sql.SparkSession
import scala.util.control.Breaks._
val spark = SparkSession.builder().getOrCreate()

//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo

final val pi = 3.1415927 
val perimeter = 20

val radius = perimeter/pi

//2. Desarrollar un algoritmo en scala que me diga si un número es primo

val primenum = 15

//Se utilizó primenum+1 para que el rango del array llegara al valor del número elegido.
//Y se empezó de 2 debido a que el 1 es divisor de todos los números. 
for(i <- Array.range(2, primenum+1)){ 
    //Debido a que todos los números primos pueden ser divididos por sí mismos aquí es donde se corta el programa.
    if(i == primenum){ 
    println("Currently being divided by: " + i + ". This is a prime number: " + primenum)
    break
    }
    //En caso de ser dividido entre cualquier otro número exactamente, el programa se corta prematuramente.
    else if(primenum % i == 0){ 
    println("Currently being divided by: " + i + ". This is NOT a prime number: " + primenum)
    break
    }
    //Sólo se muestra qué números se están utilizando para dividir al número elegido.
    else{ 
    println("Currently being divided by: " + i + ".")
    }
}

//3. Dada la variable  var bird = "tweet", utiliza interpolación de strings para
//    imprimir "Estoy ecribiendo un tweet"

var bird = "tweet"
val writing = "Estoy escribiendo un "
val tweeting = writing + bird 

println(tweeting)

//4. Dada la variable var mensaje = "Hola Luke yo soy tu padre!" utiliza slice para extraer la
//    secuencia "Luke"

var mensaje = "Hola Luke yo soy tu padre!"
var slicedmsg = mensaje.slice(5, 9)

//5. Cúal es la diferencia entre value (val) y una variable (var) en scala?

// ### Value (val) es un valor que no puede ser reasignado una vez que tienen ya un valor asignado 
//     mientras que variable (var) es un valor que puede ser reasignado siempre y cuando se utilice
//     el mismo tipo de dato. ###

//6. Dada la tupla (2, 4, 5, 1, 2, 3, 3.1416, 23) regresa el número 3.1416

val tupla = (2, 4, 5, 1, 2, 3, 3.1416, 23)
println(tupla._7)
```
# Practice 3

1. Create a list named "lista" with the elements "rojo", "blanco", "negro"
2. Add 5 more elements to "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
3. Drag the elements from "lista" "verde", "amarillo", "azul"
4. Create a number array with range from 1-1000 in steps of 5 and 5
5. Which are the unique elements from the list Lista(1,3,3,4,6,7,3,7), use group conversion
6. Create a mutable map named nombres that contains the following:
     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
   6 a . Print all map keys
   6 b . Add the following values to the map ("Miguel", 23)

## Code
```r
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
//Librería usada para realizar el ejercicio 4.
import scala.collection.mutable.ArrayBuffer 

//1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"

var lista = List("rojo", "blanco", "negro")

//2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"

var agregar1 = "verde" :: lista
var agregar2 = "amarillo" :: agregar1
var agregar3 = "azul" :: agregar2
var agregar4 = "naranja" :: agregar3
var agregar5 = "perla" :: agregar4

//3. Traer los elementos de "lista" "verde", "amarillo", "azul"

//Usamos slice, en donde tomamos un rango acorde a la posición de los elementos en la lista.
//La posición 2 no se tomará, pero la posición 5 sí será incluida, por lo que el rango nos mostrará 3, 4 y 5.
agregar5.slice(2,5)

//4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5

val arreglo1 = ArrayBuffer[Int](0) //Se utilizó una librería la cual permite a los arreglos expandirse.
for(i <- Array.range(1, 1001)){ //Se define i como un arreglo de rango 1 a 1001 debido a que comienza en 0 y terminará en 1000
    if(i%5 == 0){ //Si el valor de i es divisible entre 5 y no queda residio se agrega al array
        arreglo1 += i //Aquí se agrega al arraybuffer
        println("Agregando " + i + " al arreglo.") //aquí se imprime el número que se agrega al arreglo.
    }
    else{ //En caso de no ser divisible entre 5 exactamente no se hace nada y se itera nuevamente.
    }
}

//5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
//Ez alternative
List(1,3,3,4,6,7,3,7).distinct
//MLG Pro Alternative (no, not really)
val Lista = List(1,3,3,4,6,7,3,7)  
val mlgproway = Lista.toSet

//6. Crea una mapa mutable llamado nombres que contenga los siguiente
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
//   6 a . Imprime todas la llaves del mapa
//   6 b . Agrega el siguiente valor al mapa("Miguel", 23)

val nombres = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", 27))

//For print
for (llaves <- nombres.keys){
    println(llaves)
}
//Ez show
nombres.keys

//Add value to map
nombres += ("Miguel" -> 23)
```

# Practice 4

Given the pseudocode from the Fibbonacci succesion in the following link, implement with Scala the Algorithm 1, 2, 3, 4 and 5.

## Code

```r
//Dado el pseudocódigo de la sucesión de Fibonacci en el enlace proporcionado, 
//implementar con Scala el Algoritmo 1, Algoritmo 2, Algoritmo 3, Algoritmo 4, Algoritmo 5
import scala.math
import scala.math.pow
import scala.math.sqrt

// Algoritmo 1

def fiboA1(n: Int): Int = {

    if (n < 2)
        return n
    else {
        return fiboA1(n - 1) + fiboA1(n - 2)
    }

}
fiboA1(8)

//Algoritmo 2

var i: Double = ((1 + Math.sqrt(5)) / 2)
var j: Double = 0

def fiboA2(n: Double): Double = {

    if (n < 2)
        return n
    else {
        j = ((Math.pow(i, n) - Math.pow((1 - i), n)) / Math.sqrt(5))
        return j
    }
}

fiboA2(8)

// Algortimo 3

var a: Int = 0
var b: Int = 1
var c: Int = 0

def fiboA3(n: Int): Int = {
    a = 0
    b = 1
    c = 0

    for (k <- Range(0, n)){
        c = b + a
        a = b
        b = c 
    }

    return a
}

fiboA3(8)  

// Algortimo 4

var a: Int = 0
var b: Int = 1

def fiboA4(n: Int): Int = {
    a = 0
    b = 1

    for (k <- Range(0, n)){
        b = b + a
        a = b - a
    }

    return a
}

fiboA4(8) 

// Algortimo 5

def fiboA5(n: Int): Int = {
    if (n < 2)
        return n
    else {
        var vector = new Array[Int](n + 1)
        vector(0) = 0
        vector(1) = 1
        for (k <- Range(2, n + 1)){
            vector(k) = vector(k -  1) + vector(k - 2)
        }
        return vector(n)
    }
}

fiboA5(8)
```


# **Collaborators:**

Guzman Pascacio Jhomara del Rosario

Lopez Medrano Julio Antonio


