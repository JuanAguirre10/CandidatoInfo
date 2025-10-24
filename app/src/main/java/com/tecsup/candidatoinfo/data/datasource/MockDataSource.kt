package com.tecsup.candidatoinfo.data.datasource

import com.tecsup.candidatoinfo.data.model.*

object MockDataSource {

    val candidatos = listOf(
        Candidato(
            id = "1",
            nombreCompleto = "Keiko Sofía Fujimori Higuchi",
            partidoPolitico = "Fuerza Popular",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://e-an.americatv.com.pe/actualidad-81-peruanos-desaprueba-gestion-keiko-fujimori-segun-pulso-peru-n333699-938x528-494125.jpg",
            edad = 49,
            lugarNacimiento = "Lima",
            profesion = "Administración - Boston University",
            numeroDenuncias = 1,
            numeroProyectos = 45
        ),
        Candidato(
            id = "2",
            nombreCompleto = "Rafael Bernardo López Aliaga Cazorla",
            partidoPolitico = "Renovación Popular",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSqoO3rxjNemlUGvhSspSrjF6I00wjMK_BfE4iWACs_4glisijhuxxFbknC-ZxFgf6RRUtGaggc-OD9YaApkNS6hjsDFuES3OlFmZ1gkA",
            edad = 60,
            lugarNacimiento = "Lima",
            profesion = "Ingeniero Industrial - Universidad de Lima",
            numeroDenuncias = 0,
            numeroProyectos = 12
        ),
        Candidato(
            id = "3",
            nombreCompleto = "George Patrick Forsyth Sommer",
            partidoPolitico = "Somos Perú",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFfpGiEvdiwF6-yi44ML82BSqGTYupyTUDug&s",
            edad = 39,
            lugarNacimiento = "Lima",
            profesion = "Futbolista Profesional",
            numeroDenuncias = 1,
            numeroProyectos = 8
        ),
        Candidato(
            id = "4",
            nombreCompleto = "César Acuña Peralta",
            partidoPolitico = "Alianza Para el Progreso",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://portal.andina.pe/EDPMedia/Fotografia/2021/02/09/00000049-candidato-cesar-acuna-cover.jpg",
            edad = 68,
            lugarNacimiento = "Trujillo",
            profesion = "Empresario Educativo",
            numeroDenuncias = 3,
            numeroProyectos = 67
        ),
        Candidato(
            id = "5",
            nombreCompleto = "Hernando de Soto Polar",
            partidoPolitico = "Progresemos",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkoWRRxMKU02dI7s8MxDDFAQb7EAg6doLoEA&s",
            edad = 83,
            lugarNacimiento = "Arequipa",
            profesion = "Economista - Universidad de Ginebra",
            numeroDenuncias = 0,
            numeroProyectos = 5
        ),
        Candidato(
            id = "6",
            nombreCompleto = "Alfonso López Chau Nam",
            partidoPolitico = "Ahora Nación",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7naV15EphvbEJHhay6EkTXwqtMU7JgFvW3Q&s",
            edad = 65,
            lugarNacimiento = "Lima",
            profesion = "Ingeniero - UNI",
            numeroDenuncias = 0,
            numeroProyectos = 15
        ),
        Candidato(
            id = "7",
            nombreCompleto = "Marisol Soledad Pérez Tello",
            partidoPolitico = "Primero la Gente",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://www.radionacional.gob.pe/sites/default/files/noticias/marisol%20perez%20tello_2.jpg",
            edad = 56,
            lugarNacimiento = "Lima",
            profesion = "Abogada - PUCP",
            numeroDenuncias = 0,
            numeroProyectos = 32
        ),
        Candidato(
            id = "8",
            nombreCompleto = "Martín Alberto Vizcarra Cornejo",
            partidoPolitico = "Perú Primero",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7txmdpP06-FTC1PUM4w0qZrg4mjjoxJDusA&s",
            edad = 61,
            lugarNacimiento = "Lima",
            profesion = "Ingeniero Civil - UNI",
            numeroDenuncias = 2,
            numeroProyectos = 89
        ),
        Candidato(
            id = "9",
            nombreCompleto = "Verónika Mendoza Frisch",
            partidoPolitico = "Juntos por el Perú",
            cargo = "Congresista - Cusco",
            fotoUrl = "https://radiosanmartin.pe/wp-content/uploads/2020/10/veronica-mp.jpg",
            edad = 44,
            lugarNacimiento = "Cusco",
            profesion = "Psicóloga - UNSAAC",
            numeroDenuncias = 0,
            numeroProyectos = 28
        ),
        Candidato(
            id = "10",
            nombreCompleto = "Daniel Urresti Elera",
            partidoPolitico = "Podemos Perú",
            cargo = "Congresista - Lima",
            fotoUrl = "https://www.larepublica.ec/wp-content/uploads/2014/07/Daniel-Urresti.jpg",
            edad = 63,
            lugarNacimiento = "Lima",
            profesion = "General EP - COEDE",
            numeroDenuncias = 2,
            numeroProyectos = 18
        ),
        Candidato(
            id = "11",
            nombreCompleto = "Julio Guzmán Cáceres",
            partidoPolitico = "Partido Morado",
            cargo = "Congresista - Lima",
            fotoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJyz1mQlX8YgotIAlQjrHseKuZDTN_evJ7eg&s",
            edad = 54,
            lugarNacimiento = "Lima",
            profesion = "Economista - PUCP",
            numeroDenuncias = 0,
            numeroProyectos = 22
        ),
        Candidato(
            id = "12",
            nombreCompleto = "Yonhy Lescano Ancieta",
            partidoPolitico = "Acción Popular",
            cargo = "Congresista - Cusco",
            fotoUrl = "https://portal.andina.pe/EDPMedia/Fotografia/2021/02/04/00000050-candidato-yohny-lescano-cover.jpg",
            edad = 67,
            lugarNacimiento = "Cusco",
            profesion = "Abogado - UNSAAC",
            numeroDenuncias = 1,
            numeroProyectos = 56
        ),
        Candidato(
            id = "13",
            nombreCompleto = "Patricia Chirinos Venegas",
            partidoPolitico = "Avanza País",
            cargo = "Congresista - Arequipa",
            fotoUrl = "https://comunicaciones.congreso.gob.pe/wpuploads/2023/10/51340115585_0d0632ffbd_k-1.jpg",
            edad = 52,
            lugarNacimiento = "Arequipa",
            profesion = "Empresaria - UNSA",
            numeroDenuncias = 0,
            numeroProyectos = 14
        ),
        Candidato(
            id = "14",
            nombreCompleto = "Roberto Sánchez Palomino",
            partidoPolitico = "Alianza Nacional",
            cargo = "Congresista - Lima",
            fotoUrl = "https://ahoradigital.net/wp-content/uploads/2022/11/Roberto-Sanchez-Palomino-1.jpeg",
            edad = 58,
            lugarNacimiento = "Lima",
            profesion = "Ingeniero Industrial - UNI",
            numeroDenuncias = 0,
            numeroProyectos = 9
        ),
        Candidato(
            id = "15",
            nombreCompleto = "María Elena Foronda Farro",
            partidoPolitico = "Frente Popular",
            cargo = "Congresista - Arequipa",
            fotoUrl = "https://www.revistaideele.com/wp-content/uploads/2020/10/foronda-el-comercio.jpeg                        ",
            edad = 49,
            lugarNacimiento = "Arequipa",
            profesion = "Economista - UNSA",
            numeroDenuncias = 0,
            numeroProyectos = 11
        )
    )

    val denuncias = listOf(
        Denuncia(
            id = "D1",
            candidatoId = "1",
            titulo = "Caso Odebrecht - Lavado de activos",
            descripcion = "Investigación fiscal por presunto lavado de activos y organización criminal relacionado con aportes ilícitos de Odebrecht a campañas de 2011 y 2016. El caso incluye presuntos aportes no declarados por US$1.2 millones. Actualmente con comparecencia restringida.",
            tipo = "Penal",
            estado = "En investigación",
            fechaDenuncia = "26-10-2018",
            fechaResolucion = null,
            entidadInvestigadora = "Fiscalía Especializada en Lavado de Activos",
            linkFuenteOficial = "https://www.gob.pe/institucion/mpfn/noticias/332603-caso-odebrecht-equipo-especial-del-ministerio-publico-detecto-56-empresas-off-shore-en-diversos-paises?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.ALTA
        ),
        Denuncia(
            id = "D2",
            candidatoId = "3",
            titulo = "Contratación irregular en La Victoria",
            descripcion = "Contraloría investiga presuntas contrataciones irregulares durante gestión como alcalde, relacionadas con personal sin perfil adecuado. Caso en etapa preliminar administrativa.",
            tipo = "Administrativa",
            estado = "En proceso",
            fechaDenuncia = "15-06-2021",
            fechaResolucion = null,
            entidadInvestigadora = "Contraloría General",
            linkFuenteOficial = "https://www.gob.pe/institucion/contraloria/noticias/1268784-contraloria-detecto-contratacion-irregular-de-personal-asistencial-y-administrativo-en-hospital-regional-de-ica",
            gravedad = GravedadDenuncia.MEDIA
        ),
        Denuncia(
            id = "D3",
            candidatoId = "4",
            titulo = "Plagio en tesis doctoral",
            descripcion = "Universidad Complutense de Madrid anuló doctorado en 2015 por plagio detectado. SUNEDU inició investigaciones sobre plagios en publicaciones académicas.",
            tipo = "Administrativa",
            estado = "Sentenciada",
            fechaDenuncia = "10-03-2015",
            fechaResolucion = "15-07-2015",
            entidadInvestigadora = "Universidad Complutense / SUNEDU",
            linkFuenteOficial = "https://canaln.pe/actualidad/cesar-acuna-universidad-complutense-madrid-investiga-plagio-su-tesis-doctoral-n216667?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.MEDIA
        ),
        Denuncia(
            id = "D4",
            candidatoId = "4",
            titulo = "Corrupción en obra pública La Libertad",
            descripcion = "Fiscalía investiga irregularidades en licitaciones durante gestión como gobernador regional, relacionadas con pagos irregulares a empresas contratistas.",
            tipo = "Penal",
            estado = "En investigación",
            fechaDenuncia = "22-08-2019",
            fechaResolucion = null,
            entidadInvestigadora = "Fiscalía Anticorrupción La Libertad",
            linkFuenteOficial = "https://www.gob.pe/institucion/mpfn/noticias/1231073-fiscalia-anticorrupcion-de-la-libertad-incauta-documentos-sobre-licitacion-de-obra-del-hospital-santa-isabel-a-favor-de-grupo-pergola?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.ALTA
        ),
        Denuncia(
            id = "D5",
            candidatoId = "4",
            titulo = "Compra de voluntades - Caso Richard Swing",
            descripcion = "Investigación preliminar por presunta entrega de dinero a congresistas para evitar vacancia en 2020. Caso involucra transferencias y testimonios de legisladores.",
            tipo = "Penal",
            estado = "Archivada",
            fechaDenuncia = "05-09-2020",
            fechaResolucion = "12-03-2021",
            entidadInvestigadora = "Fiscalía de la Nación",
            linkFuenteOficial = "https://www.gob.pe/institucion/mpfn/noticias/595058-fiscalia-de-la-nacion-sustento-denuncia-constitucional-contra-expresidente-martin-vizcarra-cornejo-por-el-caso-richard-cisneros?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.BAJA
        ),
        Denuncia(
            id = "D6",
            candidatoId = "8",
            titulo = "Vacunagate - Vacunación irregular",
            descripcion = "Inhabilitación por 10 años por Congreso por vacunarse irregularmente contra COVID-19 durante ensayos clínicos, aprovechando cargo presidencial. Generó indignación nacional.",
            tipo = "Administrativa",
            estado = "Sentenciada",
            fechaDenuncia = "10-02-2021",
            fechaResolucion = "23-09-2021",
            entidadInvestigadora = "Congreso de la República",
            linkFuenteOficial = "https://saludconlupa.com/noticias/vacunagate-expresidente-vizcarra-fue-inhabilitado-por-diez-anos-de-ejercer-cargos-publicos/?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.ALTA
        ),
        Denuncia(
            id = "D7",
            candidatoId = "8",
            titulo = "Caso Lomas de Ilo - Corrupción",
            descripcion = "Investigación por presuntos actos de corrupción en proyecto Lomas de Ilo durante gestión como gobernador regional. Se investigan pagos irregulares y favorecimiento a empresas.",
            tipo = "Penal",
            estado = "En investigación",
            fechaDenuncia = "18-07-2019",
            fechaResolucion = null,
            entidadInvestigadora = "Fiscalía Especializada en Corrupción",
            linkFuenteOficial = "https://www.gob.pe/institucion/contraloria/noticias/687564-perjuicio-de-s-557-mil-por-irregular-adquisicion-de-equipos-para-proyecto-lomas-de-ilo?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.ALTA
        ),
        Denuncia(
            id = "D8",
            candidatoId = "10",
            titulo = "Caso Hugo Bustíos - Homicidio",
            descripcion = "Proceso judicial por homicidio del periodista Hugo Bustíos en 1988 durante operativo militar en Ayacucho. Caso emblemático de violaciones de derechos humanos.",
            tipo = "Penal",
            estado = "En proceso",
            fechaDenuncia = "15-11-2007",
            fechaResolucion = null,
            entidadInvestigadora = "Poder Judicial",
            linkFuenteOficial = "https://andina.pe/agencia/noticia-poder-judicial-sentencia-a-daniel-urresti-a-12-anos-prision-crimen-hugo-bustios-936386.aspx",
            gravedad = GravedadDenuncia.ALTA
        ),
        Denuncia(
            id = "D9",
            candidatoId = "10",
            titulo = "Denuncia por agresión",
            descripcion = "Denuncia por presunta agresión física durante altercado en sede partidaria. Caso archivado por falta de pruebas suficientes.",
            tipo = "Penal",
            estado = "Archivada",
            fechaDenuncia = "20-05-2018",
            fechaResolucion = "10-12-2018",
            entidadInvestigadora = "Fiscalía Provincial",
            linkFuenteOficial = "https://comisedh.org.pe/blog/2021/12/28/se-apelara-archivamiento-de-denuncia/?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.BAJA
        ),
        Denuncia(
            id = "D10",
            candidatoId = "12",
            titulo = "Denuncia por acoso político",
            descripcion = "Denuncia por presunto acoso político a excandidata regional. Caso en etapa de investigación preliminar por la Fiscalía.",
            tipo = "Penal",
            estado = "En investigación",
            fechaDenuncia = "08-03-2022",
            fechaResolucion = null,
            entidadInvestigadora = "Fiscalía Provincial Cusco",
            linkFuenteOficial = "https://rpp.pe/politica/congreso/yonhy-lescano-fiscalia-abrio-investigacion-contra-los-que-resulten-responsables-del-presunto-acoso-sexual-a-periodista-noticia-1183882?utm_source=chatgpt.com",
            gravedad = GravedadDenuncia.MEDIA
        )
    )

    val propuestas = listOf(
        Propuesta(
            id = "P1",
            candidatoId = "1",
            titulo = "Reactivación económica mediante inversión privada",
            descripcion = "Plan centrado en incentivar inversión privada mediante reducción de trabas burocráticas, simplificación tributaria y creación de zonas económicas especiales en regiones.",
            categoria = "Economía",
            fechaPresentacion = "15-03-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://andina.pe/agencia/noticia-cuna-mas-incrementa-130-numero-beneficiarios-del-programa-social-1037227.aspx"
        ),
        Propuesta(
            id = "P2",
            candidatoId = "1",
            titulo = "Programa Cuna Más ampliado",
            descripcion = "Ampliación de programa social para incluir cuidado infantil gratuito para madres trabajadoras en sectores vulnerables, con meta de 500,000 niños adicionales.",
            categoria = "Social",
            fechaPresentacion = "22-04-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://www.radionacional.gob.pe/noticias/locales/presupuesto-2024-asignado-a-programa-cuna-mas-permitira-ampliacion-de-cobertura"
        ),
        Propuesta(
            id = "P3",
            candidatoId = "2",
            titulo = "Tren Eléctrico Lima-Callao",
            descripcion = "Construcción de líneas de tren eléctrico conectando Lima y Callao con tecnología moderna, reduciendo tiempos de viaje y contaminación. Inversión estimada US$8,000 millones.",
            categoria = "Infraestructura",
            fechaPresentacion = "10-02-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://www.gob.pe/institucion/munilima/noticias/1190407-alcalde-de-lima-logra-historica-donancion-de-trenes-para-transformar-el-transporte-de-lima"
        ),
        Propuesta(
            id = "P4",
            candidatoId = "2",
            titulo = "Mano dura contra delincuencia",
            descripcion = "Plan de seguridad con aumento de efectivos policiales, construcción de nuevos penales y endurecimiento de penas para delitos graves.",
            categoria = "Seguridad",
            fechaPresentacion = "18-03-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://www.gob.pe/institucion/munilima/noticias/1229648-alcalde-de-lima-busca-ponerle-fin-al-terrorismo-urbano"
        ),
        Propuesta(
            id = "P5",
            candidatoId = "4",
            titulo = "Un millón de viviendas para clase media",
            descripcion = "Programa de construcción de un millón de viviendas accesibles para familias con créditos subsidiados y tasas preferenciales del 4% anual.",
            categoria = "Vivienda",
            fechaPresentacion = "05-01-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://peru21.pe/politica/cesar-acuna-habria-usado-testaferro-para-adquirir-un-inmueble-de-mas-de-un-millon-de-dolares/"
        ),
        Propuesta(
            id = "P6",
            candidatoId = "4",
            titulo = "Internet gratis en colegios públicos",
            descripcion = "Implementación de internet de alta velocidad gratuito en todos los colegios públicos del país, con equipamiento de tablets para estudiantes de primaria y secundaria.",
            categoria = "Educación",
            fechaPresentacion = "20-02-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://www.gob.pe/institucion/mtc/noticias/1068182-mtc-puso-en-marcha-internet-de-banda-ancha-en-colegios-de-localidades-rurales-de-la-libertad"
        ),
        Propuesta(
            id = "P7",
            candidatoId = "5",
            titulo = "Formalización de propiedad informal",
            descripcion = "Plan masivo de titulación de propiedades informales en todo el país, otorgando títulos de propiedad a 2 millones de familias para acceder al sistema financiero formal.",
            categoria = "Economía",
            fechaPresentacion = "12-01-2021",
            estado = "Presentado",
            linkFuenteOficial = "https://www.lincolninst.edu/es/publications/articles/la-influencia-el-misterio-del-capital-hernando-soto/"
        ),
        Propuesta(
            id = "P8",
            candidatoId = "7",
            titulo = "Reforma del sistema de justicia",
            descripcion = "Reforma integral del Poder Judicial con juzgados anticorrupción especializados, expedientes digitales y reducción de plazos procesales mediante inteligencia artificial.",
            categoria = "Justicia",
            fechaPresentacion = "08-06-2024",
            estado = "Presentado",
            linkFuenteOficial = "https://elperuano.pe/noticia/44282-el-gobierno-promovera-reforma-en-sistema-judicial"
        ),
        Propuesta(
            id = "P9",
            candidatoId = "8",
            titulo = "Reforma política con referéndum",
            descripcion = "Convocatoria a referéndum para aprobar reformas constitucionales incluyendo bicameralidad, inmunidad parlamentaria y reforma del sistema electoral.",
            categoria = "Reforma Política",
            fechaPresentacion = "15-08-2019",
            estado = "Aprobado",
            linkFuenteOficial = "https://www.gob.pe/institucion/presidencia/noticias/19373-presidente-vizcarra-entrego-tres-proyectos-de-reforma-politica-al-congreso-de-la-republica-y-pide-que-se-debatan-con-prioridad"
        )
    )

    fun getDenunciasByCandidato(candidatoId: String) =
        denuncias.filter { it.candidatoId == candidatoId }

    fun getPropuestasByCandidato(candidatoId: String) =
        propuestas.filter { it.candidatoId == candidatoId }

    fun getDenunciaById(denunciaId: String) =
        denuncias.find { it.id == denunciaId }

    fun getPropuestaById(propuestaId: String) =
        propuestas.find { it.id == propuestaId }
}