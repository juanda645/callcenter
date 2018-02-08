#Prueba desarrollador almundo Juan Daniel Patiño

#Explicaciones generales

Había dos formas de dar la solución:

1.	Usar un servicio especializado que ya resuelven ese tipo de problemas como SQS de Amazon.
2.	Hacer la solución manual en Java.

Se desarrollo la opción 2 ya que lo que se espera evaluar es la habilidad de desarrollo en Java.

#Extras/Plus

1. Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.

R:/
Cuando no hay ningún empleado libre se pone la llamada en espera, esta espera es de 10 segundos ya que es lo máximo que puede durar una llamada, una vez pasado los 10 segundos se vuelve a buscar un empleado libre.

2. Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.

R:/
Con la solución dada soporta más de 10 llamas concurrentes.

Hay una prueba unitaria para demostrar estas soluciones a los extras.
