# PracticaLaboratorio02ServletsJSPJPA

## Se pide desarrollar una aplicación JEE que permita gestionar requerimientos de compras de varias empresas. 

### HTML

### Index.html

![img](/imagenes/i1.png)

Para esta práctica se trabaja con dos empresas como son Avon y Yanbal, las cuales tiene sus usuarios con roles de “usuario” y “administrador” según los requerimientos.  

Se usa una Base de Datos MySQL para el almacenamiento de la información que se genera dentro de la aplicación así como de forma manual, el entorno de desarrollo EclipseJEE para crear el proyecto con todos sus elementos necesarios, el servidor Tomcat para la ejecución Web del proyecto, Servlets que hacen la función de controladores para cada requerimiento funcional, JPA para conectar la Base de Datos con el proyecto, JSP para mostrar, enviar y recibir la información obtenida de los controladores así como de otros JSP y las interfaces DAO que contiene los métodos abstractos dependiendo de si estos son genéricos (GenericDAO) o son específicos para cada clase del Modelo. 

## La aplicación deberá manejar dos roles “Usuario” y “Administrador” 

![img](/imagenes/i2.png)

Los usuarios presentes en la Base de Datos constan con los roles “u” y “a”, los cuales indican que un usuario es normal y otro administrador respectivamente. Esto se encuentra dentro del modelo Usuario y la tabla usuario.  

## Un “usuario” y “administrador” puede iniciar sesión usando su correo y contraseña. 

### JSP 

### iniciar_sesion.html 

![img](/imagenes/i3.png)

### Controlador 

### IniciarSesionController.java 

![img](/imagenes/i4.png)

El usuario normal o administrador ingresa a su perfil correspondiente a su rol, al desplegarse su perfil se mostrarán las diferentes funcionalidades que este puede realizar según los requisitos especificados. Para iniciar sesión se pide el nick de usuario correspondiente y su contraseña, cuando se envían estos datos se usa al controlador IniciarSesionController que recibirá a estos y, con ayuda de una consulta, obtendrá al usuario con su rol respectivo, creando la sesión con el Servlet y redirigiendo al perfil JSP correspondiente.  

### A. Una vez iniciado sesión el “usuario” podrá: 

### JSP  

### PerfilUser.jsp 

![img](/imagenes/i5.png)

La página de perfil que se presenta contiene la información básica del usuario y los botones para realizar cada uno de los requerimientos funcionales especificados. 

### a. Registrar sus requerimientos de compra 

### Controlador 

### RegistrarCompraController.java 

![img](/imagenes/i6.png)

Una vez presionamos en “Registrar Compra” esta se dirige al controlador y ejecuta RegistrarCompraController.java podemos observarlo en la parte superior, el cual recibe los parámetros del usuario como referencia del usuario actual, posteriormente se manda a buscar la última cabecera creada para así mismo tenerla como referencia para los detalles. Seguido mandamos a traer el listado de las categorías con el método implementado en la clase JPACategoriaDAO. Dentro del try-catch se llama una lista de los productos actuales que se ejecuta en la clase JPAProductoDAO, tomando los productos que no estén con un estado de eliminado, posteriormente se ejecuta un bucle for para la generar una nueva lista con productos ligados con su categoría, finalmente se envían los parámetros requeridos mediante el request.setAttribute. 

### JSP  

### registrar_Compra.jsp 

![img](/imagenes/i7.png)

El controlador anterior nos redirecciona a la página para agregar compras, en esta podemos realizar filtrados de los productos de acuerdo con su categoría, también tenemos la información de los productos registrados en la base de datos MySql, seguido tenemos el apartado para seleccionar un producto y agregar la cantidad a ser comprada y por último un botón de finalización de compra el cual nos redirecciona a la página principal del usuario. 

### Controlador 

### TEST.java 

![img](/imagenes/i8.png)

Dentro de la clase TEST obtenemos los parámetros enviados de la página para agregar una compra, los obtenemos mediante request.getParameter y convertimos los datos obtenidos al tipo de dato que requerimos. 

![img](/imagenes/i9.png)

Dentro del primer if se controla el filtrado general de la categoría, es decir, para mostrar todas las categorías disponibles, se realiza el mismo procedimiento que en el controlador anterior se manda a llamar un listado de los productos para posteriormente realizar una lista con los productos con su categoría agregada. 

![img](/imagenes/i10.png)

Para agregar un detalle mandamos a buscar al usuario de la sesión actual para obtener todos sus atributos, seguido creamos un objeto cabecera donde mandamos el id de la cabecera actual , el estado y el objeto usuario, luego instanciamos un nuevo detalle con los parámetros de cantidad, el objeto producto y la cabecera creada anteriormente, se le añade el detalle a la cabecera y la cabecera al usuario en sesión, finalmente se enviar el objeto usuario al método “update” que está en la clase JPAGenericDAO.  

![img](/imagenes/i11.png)

Finalmente, se envían los datos al JSP correspondiente para la visualización de los mismos. 

### Controlador 

### BuscarUsuario.java 

![img](/imagenes/i12.png)

Dentro del método doPost simplemente se obtiene todos los datos del usuario y se lo redirecciona a la página principal. 

### b. Modificar sus requerimientos de compra 

### Controlador 

### ModificarCompraController.java 

![img](/imagenes/i13.png)

En este servlet se controla el listado de las cabeceras a ser listadas en la página jsp, como observamos en la imagen superior tenemos el llamado de un método “listarPorUsuario” que recibe como parámetro el id del usuario actual en sesión, este devuelve un listado de todas las cabeceras relacionadas con ese id de usuario para su posterior envió a la página jsp. 

### JSP 

### modificar_Compra.jsp 

![img](/imagenes/i14.png)

Podemos observar que tenemos un listado de todas las compras realizadas por el usuario en sesión, a su vez podemos ver el detalle de la una compra en específico. 

### Controlador 

### ModificarDetalleController.java 

![img](/imagenes/i15.png)

Una vez obtenemos los parámetros que necesitamos procedemos a invocar los diferentes métodos del JPA que nos ayudan en la obtención de información según sea requerida, en este caso invocamos un método para traer una lista de todos los detalles según la cabecera enviada, así mismo mandamos a traer una lista de productos para posteriormente mandar a buscar un detalle con el id del producto recibido. 

### JSP 

### modificar_Detalle.jsp 

![img](/imagenes/i16.png)

Podemos observar que tenemos una tabla donde muestra todos los detalles de la compra seleccionada con su respectivo producto, categoría y cantidad registrada en la compra del mismo.   

### Controlador 

### ModificarDetalleController2.java 

![img](/imagenes/i17.png)

Una vez seleccionado el producto y especificado la cantidad a ser modificado se envían esos parámetros al controlador de “ModificarDetalleController2” donde se invocan a los diferentes métodos para traer la información necesaria y mandar a modificar el detalle con la información actualizada, en este caso para realizar dicho proceso se invoca al método de “update” dentro de la clase JPADetalleDAO que recibe como parámetro un objeto del tipo detalle.  

![img](/imagenes/i18.png)

Una vez realizado la actualización de información del detalle se procede a traer nuevamente al listado de los productos en referencia con los detalles y cabecera correspondientes. 

### c. Eliminar sus requerimientos de compra  

### Controlador 

### EliminarCompraController.java 

![img](/imagenes/i19.png)

Entrando al controlador para eliminar una compra, tenemos la obtención de los parámetros enviados por el jsp del menú principal, posterior realizamos la búsqueda de las cabeceras asociadas con el usuario en sesión como se lo realizo anteriormente y finalmente se envía el listado a la página donde se presenta el listado. 

### JSP 

### eliminar_Compra.jsp 

![img](/imagenes/i20.png)

Podemos observar que nos presenta una lista de las compras realizadas y dentro de la tabla la opción de ver el detalle del pedido realizado y también, la eliminación del pedido. 

### Controlador 

### EliminarCompraController2.java 

![img](/imagenes/i21.png)

Dentro del controlador “EliminarCompraController2” nos permite realizar la actualización del estado de una compra realizada cambiando el estado por “D” que hace referencia a una compra eliminada, para ello primero creamos un objeto cabecera y lo seteamos con un estado “D” para posteriormente enviar al método “update” que está dentro de JPACabeceraDAO para la actualización de información de la cabecera.

### d. Listar sus requerimientos de compra 

### Controlador 

### ListarCompraController.java 

![img](/imagenes/i22.png)

De la misma manera que los anteriores controladores, primero obtenemos los parámetros enviados e invocamos a los diferentes métodos para traer una lista de las compras realizadas con el ligero cambio de que esta lista tiene todas las compras que se encuentran en espera, aceptadas o rechazadas. Obtenido dicha lista procedemos a recorrerla en un bulce para modificar el nombre de su estado, es decir que si esta con “e” ponerlo “Espera” esto para una mejor visualización en la página, una vez recorrido todo el bucle se envía la nueva lista a la página asignada. 

### JSP 

### listar_compra.jsp 

![img](/imagenes/i23.png)

Observamos que la pagina nos presenta todas las compras realizadas por el usuario visualizando si están en estado de espera, aceptada o rechazada y con la opción de ver el detalle de la compra realizada. 

### B. Una vez iniciado sesión el “administrador” podrá: 

### JSP 

### perfilAdmin.jsp 

![img](/imagenes/i24.png)

La página de perfil que se presenta contiene la información básica del usuario, el nombre de la empresa a la que pertenece ese administrador y los botones para realizar cada uno de los requerimientos funcionales especificados. 

### a. Registrar productos de la empresa a la que pertenece  

### JSP 

### registrar_producto.jsp 

![img](/imagenes/i25.png)

### Controlador 

### RegistrarProductosController.java 

![img](/imagenes/i26.png)

Para Registrar productos se accede desde el botón con el mismo nombre en su página de perfil, dentro de esta se usa un formulario que contiene los campos de Nombre, Cantidad y Categoría, los cuales se envían al controlador de RegistrarProductosController donde se guarda la nueva información, se añade a la categoría y también a la empresa, finalmente se actualiza la empresa y Base de Datos. Se redirige al mismo JSP registrar_producto para poder realizar esta función nuevamente. 

### b. Modificar productos de la empresa a la que pertenece 

### JSP 

### modificar_productos.jsp 

![img](/imagenes/i27.png)

### Controladores 

### ListarProductosController.java 

![img](/imagenes/i28.png)

### uscarProductosController.java 

![img](/imagenes/i29.png)

### ModificarProductosController.java 

![img](/imagenes/i30.png)

Para Modificar productos se ingresa desde el botón con el mismo nombre en la página de perfil, primeramente, se llama al Controlador ListarProductosController para obtener una lista de productos pertenecientes a la empresa por la cual inicia sesión el administrador, y con esto se redirige a la página JSP modificar_producto que presenta en una tabla la lista de productos obtenidos y las opciones para modificar y eliminar. 

Al seleccionar la opción de Modificar se envía la información del producto presente en esa fila y se llama al controlador de BuscarProductosController, que devolverá ese producto y rellenará los campos del formulario presente en la parte inferior de la tabla, en este podremos modificar el nombre, cantidad y categoría del producto. Para que se actualice la nueva información del formulario, se selecciona el botón de Modificar Producto que llama al controlador de ModificarProductosController, donde se guardan los nuevos datos enviados y se actualiza en la Base de Datos. Se redirige a la misma página de modificar_producto.jsp. 

### c. Eliminar productos de la empresa a la que pertenece 

### Controlador 

### EliminarProductoController.java 

![img](/imagenes/i31.png)

Para Eliminar productos se ingresa con el botón de Modificar Productos de la página de perfil, esta función se presenta en el mismo JSP que el de Modificar, pues es la segunda opción que se tiene a parte de modificar en la tabla de los productos que se presentan en esta. 

Al seleccionar la opción de Eliminar se envía el ID del producto presente en esa fila y se llama al controlador EliminarProductoController, que encuentra al producto y cambia su estado a “e”, que se controla por medio de código para dar a entender que este estado es de Eliminado, por lo que no se borra de la Base de datos, este igualmente redirige a la misma página JSP de modificar_producto. 

### d. Buscar productos de la empresa a la que pertenece 

### JSP 

### buscar_productos.jsp 

![img](/imagenes/i32.png)

### Controlador 

### BuscarProductosController.jsp (Formulario Búsqueda por Categoría) 

![img](/imagenes/i33.png)

### BuscarProductosController.jsp (Formulario Búsqueda por Nombre) 

![img](/imagenes/i34.png)

Para Buscar productos se accede desde la opción con el mismo nombre dentro de la página de perfil, esta página presenta dos formularios que nos permite buscar productos por su categoría o buscar un solo producto por medio de su nombre, en este se debe respetar las mayúsculas y minúsculas.  

Al seleccionar cualquier opción de búsqueda se llama al controlador BuscarProductosController que recibe, además de la información del formulario, un identificador que reconoce si se llamó al controlador desde el formulario de Búsqueda por categoría o del formulario de Búsqueda por nombre, según esto se devuelve una Lista de productos o solo un producto respectivamente. Esta información se muestra en unas tablas que se encuentran en la parte inferior de los formularios. 

### e. Listar productos de la empresa a la que pertenece 

Este requerimiento no se presenta como una opción seleccionable, si no que está implícito en la opción de Modificar Producto ya que esta lista los productos de la empresa en la que te encuentras iniciado sesión, pero no toma en cuenta los Productos “Eliminados”, que están con estado igual a “e”. También se puede observar una lista de productos antes de Iniciar Sesión, en el apartado de Empresas se muestran todos los productos que tiene cada empresa, en esta se muestran todos los productos sin tener en cuenta su variable de estado. 

### f. Listar los requerimientos de compra de los “usuarios” de la empresa a la que pertenece 

### JSP 

### listar_pedidos.jsp 

![img](/imagenes/i35.png)

### Controladores 

### ListarUsuariosController.java 

![img](/imagenes/i36.png)

![img](/imagenes/i37.png)

### ListarCabecerasController.java 

[img](/imagenes/i38.png)

[img](/imagenes/i39.png)

Para este requerimiento se presentan dos opciones donde, por medio de la opción Listar Pedidos se pueden observar los pedidos Aceptados y Rechazados de los usuarios normales pertenecientes a esa empresa. 

Primeramente, se llama al controlador ListarUsuariosController que devuelve todos los usuarios normales pertenecientes a esa empresa, estos se muestran en una tabla que tiene la opción de Listar, con esta se llama al controlador ListarCabecerasController que devuelve una lista de cabeceras y con esta dentro del JSP listar_pedidos se buscan sus detalles para mostrarlos seguidamente según la cantidad de pedidos Aceptados y Rechazados que tenga ese usuario. Se debe tener en cuenta que estos dos controladores se usan en la opción de Administrar Pedidos, que se explicara a continuación. 

### g. Aprobar o Rechazar los requerimientos de compra de los “usuarios” de la empresa a la que pertenece 

### JSP 

### administrar_pedidos.jsp 

[img](/imagenes/i40.png)

### Controladores 

### ListarUsuariosController.java 

[img](/imagenes/i41.png)

### ListarCabecerasController.java 

[img](/imagenes/i42.png)

### ListarDetallesController.java 

[img](/imagenes/i43.png)

### ControlarPedidosController.java 

[img](/imagenes/i44.png)

Para este requerimiento se tiene la opción de Administrar Pedidos en el perfil, esta trabaja de la misma manera que la opción de Listar Pedidos con la diferencia que en este se listan los pedidos de los usuarios que aún están en el estado de Espera, esto porque aquí se Aceptan o Rechazan los pedidos realizados.  

Igualmente se tiene que llamar al controlador ListarUsuariosController, así mismo estos usuarios se muestran en una tabla con una opción Listar que llama al controlador ListarCabecerasController, al obtener las cabeceras se presentan tres opciones adicionales en la tabla, una para ver los detalles de ese pedido, otra para Aceptar ese pedido y otra para Rechazar el pedido. Al seleccionar la opción de Ver Detalles se llama al controlador ListarDetallesController, que devuelve una lista de detalles de la cabecera correspondiente que se muestran debajo de la tabla de cabeceras, si se selecciona la opción de Aceptar o Denegar se llama al controlador ControlarPedidosController que recibe, además de los datos de la cabecera correspondiente, un identificador según el botón y con esto modifica el estado de las Cabeceras. No es necesario listar los detalles para Aceptar o Rechazar un pedido, esto solo es para mostrar que productos se están pidiendo. Como se usan los mismos controladores que en la opción de Listar Pedidos, se envía un identificador sencillo a cada controlador para saber que la información que se obtiene es de una página en concreto. 

## Se pide manejar sesiones y filtros para que exista seguridad en el sistema. La parte privada ha sido descrita en los requisitos funcionales, y la parte publica será el index.html para acceder al sistema. 

### Filter 

[img](/imagenes/i45.png)

[img](/imagenes/i46.png)

### CerrarSesion.java 

[img](/imagenes/i47.png)

Se controlan las sesiones con un Filter, el cual niega el acceso a los JSP funcionales del sistema, los cuales son opciones presentes en el perfil del usuario. Además, en cada perfil se presenta la opción de Cerrar Sesión que destruye la sesión creada al hacer Login. La parte publica está presente el Index.html, login.html y el JSP listar_empresas, los cuales no se ven regulados por el Inicio de Sesión ni el Filtro. 

## JPA y DAO 

Para realizar la conexión a la base de datos se trabaja con JPA, el cual en conjunto con los métodos que se hayan especificado tanto en las Interfaces específicas, como en la Interfaz Generic, permitirá que se hagan consultas a la Base de Datos por medio de sentencias SQL. Se debe tener en cuenta que JPA facilita la instancia de objetos y atributos, por lo que no es necesario volver a instanciar un objeto para poder obtener su información. Para realizar la conexión se debe modificar el archivo persistence.xml añadiendo el Driver, URL, usuario y contraseña, además se debe especificar el trato de las tablas que se generen al momento de ejecutar el proyecto.

[img](/imagenes/i48.png)

### Interfaces DAO 

GenericDAO, la interfaz que contiene los métodos para buscar, crear, actualizar o eliminar la información de cada una de las interfaces específicas. Estos métodos se repetirán para cada interfaz sin importar que otros métodos específicos estos tengan. 

EmpresaDAO, interfaz que representa la información de la empresa, no contiene métodos específicos. 

UsuarioDAO, interfaz que representa la información del usuario, contiene tres métodos específicos que son:  

login(String usuario, String contrasena): Usuario -> Método usado al momento de iniciar sesión en el controlador IniciarSesionController, recibe el nick de usuario y la contraseña para devolver al objeto Usuario respectivo. 

### JPAUsuarioDAO 

[img](/imagenes/i49.png)

empresaId(int usuario_id): int -> Método usado para obtener el Id de empresa usado al momento de iniciar sesión en el controlador IniciarSesionController. Para hacer la consulta recibe el Id del Usuario.  

### JPAUsuarioDAO 

[img](/imagenes/i50.png)

buscarSoloUsuario(int empresa_id): List<Usuario> -> Método usado para obtener una lista de usuarios normales pertenecientes a una empresa. Usado al momento de listar los pedidos, sus cabeceras y detalles con los controladores ListarUsuariosController, ListarCabecerasController y ListarDetallesController. 

### JPAUsuarioDAO 

[img](/imagenes/i51.png)

buscarUsuario(int usuario_id): Usuario -> Método utilizado para obtener un objeto usuario con referencia del id de un usuario relacionado. Usado en el controlador TEST. 

### JDBCUsuarioDAO 

[img](/imagenes/i52.png)

CategoriaDAO, interfaz que representa la información de las categorías, contiene un método especifico que es: 

read2(String cat_nombre): Categoria -> Método que devuelve un objeto categoria en relación a un nombre de categoría. Usado en el controlador TEST. 

### JPACategoriaDAO 

[img](/imagenes/i53.png)

ProductoDAO, interfaz que representa la información del producto, contiene nueve métodos específicos que son: 

categoriaId(int producto_id): int -> Método para obtener el Id de una Categoría, usado en los controladores de RegistrarCompraController y TEST, además es usado en algunos JSP para mostrar el nombre de la categoría. 

### JPAProductoDAO 

[img](/imagenes/i54.png)

findEmpresa(int empresa_id): List<Producto> -> Método que devuelve una lista de productos según la empresa con la que está relacionado el usuario que Inicio Sesion. Usado en controladores como ModificarProductosController, BuscarProductosController, ListarProductosController y ListarEmpresas. 

### JPAProductoDAO 

[img](/imagenes/i55.png)

buscarPorCategoria(int categoria_id, int empresa_id): List<Producto> -> Método que devuelve una lista de productos según la categoría a la que pertenecen y la empresa con la que el usuario está relacionado. Usado en el controlador de BuscarProductosController. 

### JPAProductoDAO 

[img](/imagenes/i56.png)

buscarPorNombre(String pro_nombre, int empresa_id): Producto -> Método que devuelve un objeto producto según su nombre y la empresa con la que el usuario está relacionado. Usado en el controlador de BuscarProductosController. 

### JPAProductoDAO 

[img](/imagenes/i57.png)

buscarSoloPorNombre(String pro_nombre): Producto -> Método que devuelve un objeto producto según el nombre de un producto que está relacionado. Usado en el controlador TEST. 

### JPAProductoDAO 

[img](/imagenes/i58.png)

TEST(int producto_id): Producto -> Método que devuelve un objeto producto según el id de un producto que está relacionado. Usado en los controladores ListarCompraController2, ListarCompraController3, ModificarDetalleController y ModificarDetalleController2.  

### JPAProductoDAO 

[img](/imagenes/i59.png)

buscarPorCategoria2(int categoria_id): List<Producto> -> Método que devuelve una lista de productos según el id de una categoría y un estado diferente de “e” que esté relacionado. Usado en el controlado TEST. 

### JPAProductoDAO 

[img](/imagenes/i60.png)

obtenerCategoriaId(int producto_id): int -> Método que devuelve un entero id de una categoría según el id de un producto que esté relacionado. Usado en el controlado TEST. 

### JPAProductoDAO 

[img](/imagenes/i61.png)

CabeceraDAO, interfaz que representa la información de la cabecera, contiene cinco métodos específicos que son: 

listarPorUsuario(int usuario_id): List<Cabecera> -> Método para obtener una lista de cabeceras según el usuario del que se desea obtener la información. Usado en los controladores de ListarCabecerasController y ListarDetalleController. Devuelven cabeceras que tienen como estado “Espera”. 

### JPACabeceraDAO 

[img](/imagenes/i62.png)

ultimoCreado(): int -> Método que devuelve un valor entero del máximo de una cabecera. Usado en los controladores de TEST y RegistrarCompraController. 

### JPACabeceraDAO 

[img](/imagenes/i63.png)

listarRevisadas(int usuario_id): List<Cabecera> -> Método para obtener una lista de cabeceras según el usuario del que se desea obtener la información. Usado en el controlador de ListarCabecerasController. Devuelven cabeceras que tiene como estado “Aceptado” y “Rechazado”. 

### JPACabeceraDAO 

[img](/imagenes/i64.png)

listarSinDelete(int usuario_id): List<Cabecera> -> Método que devuelve una lista de cabecera según el id de un usuario que esté relacionado. Usado en el controlado ListarCompraController. 

### JPACabeceraDAO 

[img](/imagenes/i65.png)

DetalleDAO, interfaz que representa la información del detalle, contiene cinco métodos específicos que son: 

buscarPorCabecera(int cabecera_id): List<Detalle> -> Método para obtener una lista de detalles según la cabecera de la cual se lista. Usado en el controlador de ListarDetallesController y en algunos JSP para listar de forma rápida. 

### JPADetalleDAO 

[img](/imagenes/i66.png)

obtenerProductoId(Detalle detalle): int -> Método que devuelve un entero id de un producto según el id de un detalle que esté relacionado. Usado en los controladores ListarCompraController2, ListarCompraController3, ModificarDetalleController y ModificarDetalleController2. 

### JPADetalleDAO 

[img](/imagenes/i67.png)

test2(int producto_id, int cabecera_id): Detalle -> Método que devuelve un objeto detalle según el id de un producto y el id de una cabecera que estén relacionados. Usado en el controlado ModificarDetalleController2. 

### JPADetalleDAO 

[img](/imagenes/i68.png)

DAOFactory, esta clase abstracta nos permite obtener cada uno de los DAOs correspondientes para poder llamar a sus métodos, tanto genéricos como específicos. 

## JPADAOFactory 

[img](/imagenes/i69.png)

## Modelos JPA 

### Usuario.java 

[img](/imagenes/i70.png)

En el modelo de usuario tenemos @entity que indica que es una entidad, el @Table en donde se especifica el nombre de la tabla, @GeneratedValue que nos indica la generación de la clave y el “GenerationType.IDENTITY” nos dice que aumentara el contador auto incrementado gestionado por la base de datos, el @Column para la creación de una columna y “nullable” para permitir nulos. 

@OneToMany = decimos que un usuario puede tener una o varias cabeceras 

@ManyToOne = nos dice que muchos usuarios pertenecen a una empresa 

@JoinColumn = se establece la clave foránea de empresa 

### Producto.java 

[img](/imagenes/i71.png)

En el modelo de producto tenemos @entity que indica que es una entidad, el @Table en donde se especifica el nombre de la tabla, @GeneratedValue que nos indica la generacion de la clave y el “GenerationType.IDENTITY” nos dice que aumentara el contador auto incrementado gestionado por la base de datos, el @Column para la creacion de una columna y “nullable” para permitir nulos. 

@ManyToOne = nos dice que muchos productos pertenecen a una categoría 

@JoinColumn = se establece la clave foránea de categoría. 

@ManyToOne = nos dice que muchos productos pertenecen a una empresa 

@JoinColumn = se establece la clave foránea de empresa. 

@OneToOne = nos dice que un producto pertenece a un detalle. 

### Empresa.java

[img](/imagenes/i72.png)

En el modelo de empresa tenemos @entity que indica que es una entidad, el @Table en donde se especifica el nombre de la tabla, @GeneratedValue que nos indica la generacion de la clave y el “GenerationType.IDENTITY” nos dice que aumentara el contador auto incrementado gestionado por la base de datos, el @Column para la creacion de una columna y “nullable” para permitir nulos. 

@OneToOne = nos dice que una empresa tiene uno o varios usuarios. 

@OneToOne = nos dice que una empresa tiene uno o varios productos. 

### Categoria.java

[img](/imagenes/i73.png)

En el modelo de categoria tenemos @entity que indica que es una entidad, el @Table en donde se especifica el nombre de la tabla, @GeneratedValue que nos indica la generacion de la clave y el “GenerationType.IDENTITY” nos dice que aumentara el contador auto incrementado gestionado por la base de datos, el @Column para la creacion de una columna y “nullable” para permitir nulos. 

@OneToMany = nos dice que una categoría tiene uno o varios productos. 

### Cabecera.java 

[img](/imagenes/i74.png)

En el modelo de pedcabecera tenemos @entity que indica que es una entidad, el @Table en donde se especifica el nombre de la tabla, @GeneratedValue que nos indica la generacion de la clave y el “GenerationType.IDENTITY” nos dice que aumentara el contador auto incrementado gestionado por la base de datos, el @Column para la creacion de una columna y “nullable” para permitir nulos. 

@OneToMany = nos dice que una cabecera tiene uno o varios detalles. 

@ManyToOne = nos dice que muchas cabeceras pertenecen a un usuario. 

@JoinColumn = se establece la clave foránea de usuario. 

### Detalle.java 

[img](/imagenes/i75.png)

En el modelo de peddetalle tenemos @entity que indica que es una entidad, el @Table en donde se especifica el nombre de la tabla, @GeneratedValue que nos indica la generacion de la clave y el “GenerationType.IDENTITY” nos dice que aumentara el contador auto incrementado gestionado por la base de datos, el @Column para la creacion de una columna y “nullable” para permitir nulos. 

@OneToOne = nos dice que un detalle tiene un producto. 

@JoinColumn = se establece la clave foránea de producto. 

@ManyToOne = nos dice que muchos detalles pertenecen a una cabecera. 

@JoinColumn = se establece la clave foránea de cabecera. 