# Proyecto inventory-management 

## Análisis del proyecto

### Resumen del Proyecto

El proyecto "inventory-management" es una aplicación web desarrollada con Spring Boot y Maven que proporciona funcionalidades para la gestión de un sistema de inventario. Permite el manejo de proveedores, almacenes y usuarios, incluyendo autenticación y control de acceso.

### Puntos Positivos 

1. Estructura y Organización: El proyecto muestra una estructura de carpetas y paquetes bien definida, lo que facilita la comprensión y el mantenimiento del código.
    
2. Uso de Buenas Prácticas: La implementación de patrones de diseño y la documentación de la API (mediante Swagger) son prácticas que mejoran la calidad del proyecto.
    
3. Operaciones CRUD Básicas: El proyecto cubre las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para las principales entidades, lo que establece una funcionalidad mínima viable.

### Puntos Negativos 

1. Falta de Documentación: Existe una carencia de documentación detallada sobre la instalación, configuración y despliegue del proyecto, lo que puede dificultar la onboarding de nuevos desarrolladores.

2. Funcionalidades Limitadas: Más allá de las operaciones CRUD básicas, el proyecto carece de funcionalidades más avanzadas, como la generación de informes, la gestión de inventario o las notificaciones.

3. Ausencia de Pruebas Automatizadas: No se evidencia la presencia de pruebas automatizadas (unitarias, de integración y de aceptación), lo que puede afectar la calidad y la confiabilidad del código a largo plazo.

### Oportunidades de Mejora 

1. Mejorar la Documentación: Mejorar la guía de configuración y despliegue del proyecto, así como documentar las características y sobre todo el uso de la aplicación.

2. Ampliar las Funcionalidades: Implementar funcionalidades más avanzadas, como la generación de informes, la gestión de inventario, notificaciones, etc., para satisfacer mejor las necesidades del negocio.

3. Implementar Pruebas Automatizadas: Agregar pruebas unitarias, de integración y de aceptación para garantizar la calidad y la estabilidad del código a largo plazo.

4. Mejorar la Experiencia de Usuario: Optimizar la interfaz de usuario y la usabilidad de la aplicación para brindar una mejor experiencia a los usuarios finales.

### Métricas Identificables

1. Cobertura de Pruebas: Medir el porcentaje de líneas de código cubiertas por pruebas automatizadas.

2. Complejidad Ciclomática: Evaluar la complejidad del código para identificar áreas que requieran refactorización.


3. Tiempo de Respuesta de Operaciones CRUD: Medir el rendimiento de las operaciones de creación, lectura, actualización y eliminación.
    
4. Número de Incidentes Reportados y Resueltos: Monitorear la estabilidad y fiabilidad de la aplicación.

### Oportunidades de Mejora Relacionadas con SPACE 

1. Satisfaction: Realizar encuestas periódicas a los desarrolladores para medir su satisfacción con el proceso de revisión de código y su percepción general sobre la productividad.
        Analizar la distribución de las revisiones de código entre los desarrolladores para detectar si alguno está sobrecargado.

2. Performance: Medir la velocidad de las revisiones de código, tanto a nivel individual como de equipo, para identificar cuellos de botella y áreas de mejora.
        Establecer métricas de rendimiento para otras tareas clave, como la velocidad de implementación y la resolución de incidentes.

3. Activity: Rastrear métricas de actividad individuales, como el número de commits, tiempo de codificación y revisiones de código completadas.
        Analizar los patrones de actividad para identificar oportunidades de mejora en la asignación de tareas y la distribución de la carga de trabajo.
4. Communication and Collaboration: Evaluar la calidad y la profundidad de las revisiones de código como indicador de la colaboración y la comunicación entre los desarrolladores.
        Implementar métricas que capturen la eficacia de la colaboración entre equipos y el impacto en la entrega del producto.

5. Efficiency and Flow: Medir el impacto de las revisiones de código en la eficiencia y el flujo de trabajo de los desarrolladores, tanto a nivel individual como del sistema.Identificar y mitigar los cuellos de botella y las interrupciones que afectan el flujo de trabajo.Optimizar los procesos de revisión de código para minimizar los retrasos y mantener un flujo de trabajo eficiente.

### Oportunidades de Mejora Relacionadas con DevEx 

#### Oportunidades de Mejora Relacionadas con Feedback Loops

* Acelerar los Procesos de Compilación y Pruebas: Identificar y optimizar los procesos de compilación y ejecución de pruebas para reducir los tiempos de espera de los desarrolladores.
    
* Agilizar los Procesos de Revisión de Código: Establecer un flujo más eficiente para la revisión de código, minimizando los tiempos de espera por aprobaciones.
    
* Mejorar la Comunicación y Coordinación del Equipo: Optimizar los procesos de interacción entre los miembros del equipo, evitando demoras en la transferencia de información y tareas.

#### Oportunidades de Mejora Relacionadas con Cognitive Load 

* Mejorar la Documentación: Crear documentación clara y exhaustiva sobre la arquitectura, flujos de trabajo y estructura del código, para facilitar la comprensión del sistema por parte de los desarrolladores.

* Simplificar el Entorno de Desarrollo: Proporcionar herramientas y configuraciones predefinidas que minimicen los pasos necesarios para configurar el entorno de desarrollo y despliegue.

* Estandarizar las Prácticas de Codificación: Establecer pautas y convenciones de codificación claras, lo que ayudará a reducir la carga cognitiva al trabajar con el código.

#### Oportunidades de Mejora Relacionadas con Flow State

* Minimizar Interrupciones y Distracciones: Agrupar las reuniones, evitar asignaciones de trabajo imprevistas y gestionar las solicitudes de ayuda de manera organizada para preservar los períodos de concentración de los desarrolladores.

## Herramienta AI

### GitHub Copilot

GitHub Copilot es una herramienta de asistencia de código desarrollada por Anthropic y Salesforce en colaboración con GitHub. Se integra directamente con los editores de código, como Visual Studio Code, y utiliza modelos de lenguaje de inteligencia artificial entrenados en un gran conjunto de código de código abierto para sugerir automáticamente código y completar tareas de programación a medida que el usuario escribe.

Algunas de las principales características de GitHub Copilot incluyen:

* Sugerencias de código contextual: Copilot analiza el código que estás escribiendo y te sugiere completar la línea o proponer la siguiente instrucción de manera inteligente y adaptada al contexto.
    
* Generación de código boilerplate: Copilot puede generar rápidamente código común, como definiciones de funciones, estructuras de datos, etc.
    
* Refactorización y optimización de código: Copilot puede analizar tu código y sugerir maneras de mejorarlo, como encontrar duplicados, simplificar lógica compleja, etc.

* Soporte para múltiples lenguajes: Copilot funciona con una amplia gama de lenguajes de programación, incluyendo Python, JavaScript, TypeScript, Ruby, Go, y más.

* Aprendizaje continuo: A medida que Copilot se usa, aprende de los patrones de codificación del usuario y mejora sus sugerencias con el tiempo.


### Uso de GitHub Copilot para refactorizar código

El método que se desea refactorizar es actualmente muy extenso, lo que incrementa su complejidad.

Este método se encuentra en la clase `Item` y consta de `n` líneas.

Para refactorizarlo con la ayuda de GitHub Copilot, seguiremos los siguientes pasos:

1. Seleccionamos el método que queremos refactorizar y presionamos **Ctrl + I**. A continuación, aceptamos la sugerencia.
    ![imagen de la sugerencia de refactorización](/img/Copilot/Refactorización/Pt1.png)

2. Aparecerá una ventana en la que podremos aceptar o rechazar los cambios propuestos por GitHub Copilot. Si aceptamos estos cambios, Copilot mantendrá lo que hemos escrito, mientras que si los rechazamos, el código permanecerá como estaba inicialmente.
    ![imagen de la ventana de confirmación](/img/Copilot/Refactorización/Pt2.png)

El método, que originalmente era uno solo y bastante complejo de entender, ahora está dividido en 4 partes, como se muestra a continuación.

![imagen del método refactorizado](/img/Copilot/Refactorización/Pt3.png)

### Uso de GitHub Copilot para Documentar Código

En este caso, vamos a documentar los cuatro métodos que se generaron anteriormente.

Para hacer esto, utilizaremos GitHub Copilot de la misma manera que lo hicimos para la refactorización. Usaremos el atajo de teclado **Ctrl + I** y le pediremos a Copilot que genere documentación para los cuatro métodos.

![Imagen de la selección de código](/img/Copilot/Documentación/Pt1.png)

En este proceso, Copilot nos pedirá que confirmemos los cambios cuatro veces, ya que se están realizando modificaciones en cuatro partes diferentes del código.

Finalmente, la documentación generada por Copilot se verá así:

![Imagen de la documentación](/img/Copilot/Documentación/Pt2.png)
