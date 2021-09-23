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