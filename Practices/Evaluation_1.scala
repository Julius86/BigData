import org.apache.spark.sql.SparkSession

//1. Comienza una simple sesión Spark.
val spark = SparkSession.builder().getOrCreate()

//2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3. ¿Cuáles son los nombres de las columnas?
df.columns

//4. ¿Cómo es el esquema?
df.printSchema()

//5. Imprime las primeras 5 columnas.
df.drop("Volume", "Adj Close").show()

//6. Usa describe () para aprender sobre el DataFrame.
df.describe()

//7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
//relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).
var HV_Ratio = df.withColumn("HV Ratio", df("High")/df("Volume"))
HV_Ratio.show() //Para mostrar la columna junto al resto del dataframe.

//8. ¿Qué día tuvo el pico mas alto en la columna “Open”?
val daycolumn = df.withColumn("Day", dayofmonth(df("Date"))) //Añadimos columna Day extrayendo los días de Date

val days = daycolumn.groupBy("Day").max() //Creamos un DataFrame "days" y se agrupa con los máximos

val daymerged = days.select($"Day", $"max(Open)").sort(desc("max(Open)")).show() //Mostramos las columnas "day" y "max Open" ordenadas de mayor a menor

//9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de información financiera,
//expliquelo no hay que codificar nada?

//La columna se refiere al valor que tuvo la acción al finalizar el día, es decir, el precio al que se estuvo vendiendo dicha acción en la bolsa de valores.

//10. ¿Cuál es el máximo y mínimo de la columna “Volume”?
df.select(max("Volume"), min("Volume")).show()

//11. Con Sintaxis Scala/Spark $ conteste los siguiente:

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?
df.filter($"Close" < 600).count()

//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
// --------

//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
df.select(corr("High", "Volume")).show()

//d. ¿Cuál es el máximo de la columna “High” por año?
val yearColumn = df.withColumn("Year", year(df("Date"))) //Añadimos columna "year" y extraemos el año de "date"

val yearsMax = yearColumn.groupBy("Year").max() //Creamos dataframe "yearsMax" y agrupamos con los maximos

yearsMax.select($"Year", $"max(High)").show() //Mostramos las columnas "Years" y "max high"

//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?
// --------