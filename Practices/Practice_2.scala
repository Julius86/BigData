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