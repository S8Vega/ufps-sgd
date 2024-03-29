insert into rol (nombre) values ('ROLE_ADMINISTRADOR');
insert into rol (nombre) values ('ROLE_DOCENTE');
insert into rol (nombre) values ('ROLE_ADMINISTRATIVO');

insert into departamento (nombre) values ('Legal');
insert into departamento (nombre) values ('Legal');
insert into departamento (nombre) values ('Research and Development');
insert into departamento (nombre) values ('Accounting');
insert into departamento (nombre) values ('Human Resources');

insert into dependencia (nombre, numero) values ('Outdoors', 1);
insert into dependencia (nombre, numero) values ('Electronics', 2);
insert into dependencia (nombre, numero) values ('Baby', 3);
insert into dependencia (nombre, numero) values ('Grocery', 4);
insert into dependencia (nombre, numero) values ('Books', 5);

insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'kdellenbach0', 'ZB4b7NK5ME', 'Klarrisa', 'Dellenbach');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'pjohnsee1', 'q3cnQlf7uri', 'Patrice', 'Johnsee');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'gbiggs2', '4cLB6Glvog', 'Gertrudis', 'Biggs');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'jallcorn3', 'JXWVQTA9EFX', 'Jonas', 'Allcorn');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'hradley4', '6hEb7xjOrR', 'Hymie', 'Radley');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'achurchward5', 'rTXuKNejt', 'Aube', 'Churchward');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'lobrien6', 'udtFtjA', 'Lazar', 'O''Brien');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'spatemore7', 'aTPdyPUEjA', 'Silvio', 'Patemore');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'ryukhnin8', 'NJYpwZ07', 'Ruggiero', 'Yukhnin');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'xashbolt9', 'Qvkdytx', 'Xever', 'Ashbolt');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'csinsona', 'mub5wIfYwqq4', 'Chauncey', 'Sinson');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'pbritchb', 'v9VD7qggBHJo', 'Perice', 'Britch');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'ydilkesc', 'lw16Cr', 'Ynez', 'Dilkes');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'ebeardwoodd', 'c4OM06k', 'Elke', 'Beardwood');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'kwillcocke', 'kAskNCsOd7gu', 'Kendricks', 'Willcock');
insert into usuario (enabled, alias, contrasena, nombre, apellido) values (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'sebastian', 'vega');

insert into usuario_rol (usuario_id, rol_id) values (1, 1);
insert into usuario_rol (usuario_id, rol_id) values (2, 2);
insert into usuario_rol (usuario_id, rol_id) values (3, 3);
insert into usuario_rol (usuario_id, rol_id) values (4, 1);
insert into usuario_rol (usuario_id, rol_id) values (5, 2);
insert into usuario_rol (usuario_id, rol_id) values (6, 3);
insert into usuario_rol (usuario_id, rol_id) values (7, 1);
insert into usuario_rol (usuario_id, rol_id) values (8, 2);
insert into usuario_rol (usuario_id, rol_id) values (9, 3);
insert into usuario_rol (usuario_id, rol_id) values (10, 1);
insert into usuario_rol (usuario_id, rol_id) values (11, 2);
insert into usuario_rol (usuario_id, rol_id) values (12, 3);
insert into usuario_rol (usuario_id, rol_id) values (13, 1);
insert into usuario_rol (usuario_id, rol_id) values (14, 2);
insert into usuario_rol (usuario_id, rol_id) values (15, 3);
insert into usuario_rol (usuario_id, rol_id) values (16, 1);

insert into docente (departamento, usuario_id) values (2, 2);
insert into docente (departamento, usuario_id) values (1, 1);
insert into docente (departamento, usuario_id) values (3, 3);
insert into docente (departamento, usuario_id) values (4, 4);
insert into docente (departamento, usuario_id) values (5, 5);
insert into docente (departamento, usuario_id) values (1, 6);
insert into docente (departamento, usuario_id) values (2, 7);
insert into docente (departamento, usuario_id) values (3, 8);
insert into docente (departamento, usuario_id) values (4, 9);
insert into docente (departamento, usuario_id) values (5, 10);

insert into administrativo (dependencia, usuario_id) values (1, 11);
insert into administrativo (dependencia, usuario_id) values (2, 12);
insert into administrativo (dependencia, usuario_id) values (3, 13);
insert into administrativo (dependencia, usuario_id) values (4, 14);
insert into administrativo (dependencia, usuario_id) values (5, 15);

insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Developer II', 'drive leading-edge methodologies', 'visto', '2020-11-09 20:20:40', 1, 15);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Analog Circuit Design manager', 'aggregate integrated e-commerce', 'enviado', '2020-02-11 10:27:38', 2, 14);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('VP Product Management', 'scale robust systems', 'visto', '2020-08-31 02:25:29', 3, 13);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Computer Systems Analyst II', 'deploy world-class deliverables', 'enviado', '2020-04-06 05:14:32', 4, 12);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Food Chemist', 'harness value-added portals', 'visto', '2019-12-05 09:20:33', 5, 11);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Sales Representative', 'repurpose B2B ROI', 'enviado', '2020-05-28 06:47:44', 6, 10);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Web Designer IV', 'transform turn-key e-tailers', 'enviado', '2020-04-01 05:44:49', 7, 9);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Food Chemist', 'deliver robust bandwidth', 'visto', '2020-01-06 18:11:17', 9, 7);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Staff Accountant IV', 'reinvent B2C interfaces', 'visto', '2020-09-07 21:08:31', 10, 6);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Financial Advisor', 'utilize extensible infomediaries', 'visto', '2019-11-25 03:33:42', 11, 5);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Help Desk Technician', 'scale sexy e-tailers', 'visto', '2020-02-06 03:04:09', 12, 4);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Financial Advisor', 'visualize bricks-and-clicks vortals', 'enviado', '2019-12-19 07:35:53', 13, 3);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Software Consultant', 'transition turn-key users', 'enviado', '2020-08-24 05:39:44', 14, 2);
insert into mensaje (asunto, descripcion, estado, fecha_envio, receptor, remitente) values ('Nurse Practicioner', 'brand value-added functionalities', 'enviado', '2020-08-15 20:00:14', 15, 1);

insert into respuesta (mensaje_anterior, mensaje_siguiente) values (1, 14);
insert into respuesta (mensaje_anterior, mensaje_siguiente) values (2, 13);
insert into respuesta (mensaje_anterior, mensaje_siguiente) values (3, 12);
insert into respuesta (mensaje_anterior, mensaje_siguiente) values (4, 11);
insert into respuesta (mensaje_anterior, mensaje_siguiente) values (5, 10);

insert into documento (nombre, numero_radicado, mensaje) values ('Ronstring', 60, 1);
insert into documento (nombre, numero_radicado, mensaje) values ('Kanlam', 37, 2);
insert into documento (nombre, numero_radicado, mensaje) values ('Mat Lam Tam', 92, 3);
insert into documento (nombre, numero_radicado, mensaje) values ('Keylex', 2, 4);
insert into documento (nombre, numero_radicado, mensaje) values ('Treeflex', 27, 5);
insert into documento (nombre, numero_radicado, mensaje) values ('Alphazap', 75, 6);
insert into documento (nombre, numero_radicado, mensaje) values ('Flexidy', 47, 7);
insert into documento (nombre, numero_radicado, mensaje) values ('Keylex', 33, 8);
insert into documento (nombre, numero_radicado, mensaje) values ('Wrapsafe', 82, 9);
insert into documento (nombre, numero_radicado, mensaje) values ('Fixflex', 95, 10);
insert into documento (nombre, numero_radicado, mensaje) values ('Vagram', 40, 11);
insert into documento (nombre, numero_radicado, mensaje) values ('Wrapsafe', 64, 12);
insert into documento (nombre, numero_radicado, mensaje) values ('Veribet', 57, 13);
insert into documento (nombre, numero_radicado, mensaje) values ('Y-find', 82, 14);
insert into documento (nombre, numero_radicado, mensaje) values ('Sonsing', 79, 1);
insert into documento (nombre, numero_radicado, mensaje) values ('Wrapsafe', 76, 2);
insert into documento (nombre, numero_radicado, mensaje) values ('Zathin', 69, 3);
insert into documento (nombre, numero_radicado, mensaje) values ('Pannier', 57, 4);
insert into documento (nombre, numero_radicado, mensaje) values ('Subin', 4, 5);
insert into documento (nombre, numero_radicado, mensaje) values ('Fixflex', 54, 6);
insert into documento (nombre, numero_radicado, mensaje) values ('Holdlamis', 66, 7);
insert into documento (nombre, numero_radicado, mensaje) values ('Fixflex', 88, 8);
insert into documento (nombre, numero_radicado, mensaje) values ('Span', 57, 9);
insert into documento (nombre, numero_radicado, mensaje) values ('Zaam-Dox', 55, 10);
insert into documento (nombre, numero_radicado, mensaje) values ('Lotlux', 81, 11);
insert into documento (nombre, numero_radicado, mensaje) values ('Tempsoft', 71, 12);
insert into documento (nombre, numero_radicado, mensaje) values ('ippledex', 52, 13);
insert into documento (nombre, numero_radicado, mensaje) values ('Kanlam', 42, 14);
insert into documento (nombre, numero_radicado, mensaje) values ('Otcom', 49, 1);
insert into documento (nombre, numero_radicado, mensaje) values ('Ventosanzap', 55, 2);
insert into documento (nombre, numero_radicado, mensaje) values ('Konklux', 16, 3);
insert into documento (nombre, numero_radicado, mensaje) values ('Zontrax', 7, 4);
insert into documento (nombre, numero_radicado, mensaje) values ('Keylex', 26, 5);
insert into documento (nombre, numero_radicado, mensaje) values ('Zoolab', 37, 6);
insert into documento (nombre, numero_radicado, mensaje) values ('Stronghold', 61, 7);

insert into etiqueta (descripcion) values ('CAD');
insert into etiqueta (descripcion) values ('CNG');
insert into etiqueta (descripcion) values ('WLI');
insert into etiqueta (descripcion) values ('CMake');
insert into etiqueta (descripcion) values ('XFOIL');
insert into etiqueta (descripcion) values ('Capacity Building');
insert into etiqueta (descripcion) values ('XNA');
insert into etiqueta (descripcion) values ('NPDES');
insert into etiqueta (descripcion) values ('Guided Reading');
insert into etiqueta (descripcion) values ('Tcl-Tk');

insert into documento_etiqueta (documento_id, etiqueta_id) values (1, 1);
insert into documento_etiqueta (documento_id, etiqueta_id) values (1, 2);
insert into documento_etiqueta (documento_id, etiqueta_id) values (2, 3);
insert into documento_etiqueta (documento_id, etiqueta_id) values (2, 4);
insert into documento_etiqueta (documento_id, etiqueta_id) values (3, 5);
insert into documento_etiqueta (documento_id, etiqueta_id) values (3, 6);
insert into documento_etiqueta (documento_id, etiqueta_id) values (4, 7);
insert into documento_etiqueta (documento_id, etiqueta_id) values (4, 8);
insert into documento_etiqueta (documento_id, etiqueta_id) values (5, 9);
insert into documento_etiqueta (documento_id, etiqueta_id) values (5, 10);
insert into documento_etiqueta (documento_id, etiqueta_id) values (6, 1);
insert into documento_etiqueta (documento_id, etiqueta_id) values (6, 2);
insert into documento_etiqueta (documento_id, etiqueta_id) values (7, 3);
insert into documento_etiqueta (documento_id, etiqueta_id) values (7, 4);
insert into documento_etiqueta (documento_id, etiqueta_id) values (8, 5);
insert into documento_etiqueta (documento_id, etiqueta_id) values (8, 6);
insert into documento_etiqueta (documento_id, etiqueta_id) values (9, 7);
insert into documento_etiqueta (documento_id, etiqueta_id) values (9, 8);
insert into documento_etiqueta (documento_id, etiqueta_id) values (10, 9);
insert into documento_etiqueta (documento_id, etiqueta_id) values (10, 10);