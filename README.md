# CandidatoInfo ⚖️

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-purple.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.5.4-blue.svg)](https://developer.android.com/jetpack/compose)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-green.svg)](https://developer.android.com)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-36-green.svg)](https://developer.android.com)
[![MVVM](https://img.shields.io/badge/Architecture-MVVM-orange.svg)](https://developer.android.com/topic/architecture)
[![Material 3](https://img.shields.io/badge/Material-Design%203-blue.svg)](https://m3.material.io/)

Aplicación móvil Android nativa para consultar información verificada sobre candidatos políticos en Perú, facilitando el voto informado mediante acceso transparente a propuestas legislativas, denuncias judiciales y trayectoria completa de candidatos a elecciones 2026.

## 📋 Tabla de Contenidos

- [Características](#-características-principales)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [Arquitectura](#-arquitectura)
- [Stack Tecnológico](#-stack-tecnológico)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Instalación](#-instalación-y-configuración)
- [Funcionalidades Detalladas](#-funcionalidades-detalladas)
- [Gestión de Estado](#-gestión-de-estado)
- [Navegación](#-sistema-de-navegación)
- [Modelos de Datos](#-modelos-de-datos)
- [Equipo](#-equipo-de-desarrollo)
- [Cronograma](#-cronograma-de-desarrollo)
- [Fuentes de Datos](#-fuentes-de-datos)
- [Testing](#-testing)
- [Próximas Mejoras](#-próximas-mejoras)
- [Licencia](#-licencia)

## 🌟 Características Principales

### Búsqueda y Filtrado Inteligente
- ✅ **Búsqueda en tiempo real** por nombre completo, partido político o región
- ✅ **Debouncing de 300ms** para optimizar consultas y mejorar rendimiento
- ✅ **Filtros por cargo**: Congreso, Presidencia o Todos
- ✅ **Filtros por región**: Lima, Cusco, Arequipa, Trujillo y más
- ✅ **Combinación de filtros**: Aplica múltiples filtros simultáneamente
- ✅ **Estados visuales claros**: Loading, Empty, Error con mensajes descriptivos

### Perfil Detallado del Candidato
- ✅ **Información personal completa**: Edad, profesión, lugar de nacimiento, partido político
- ✅ **Indicadores rápidos**: Número de proyectos presentados y denuncias activas
- ✅ **Sistema de tabs** para organizar información:
  - **Info**: Datos personales y estadísticas visuales
  - **Proyectos**: Propuestas legislativas categorizadas con enlaces oficiales
  - **Denuncias**: Registro completo con estado procesal y gravedad

### Visualización de Propuestas Legislativas
- ✅ **Categorización inteligente**: Economía, Salud, Educación, Social, Seguridad
- ✅ **Estado de cada propuesta**: Presentado, En debate, Aprobado, Archivado
- ✅ **Fecha de presentación** para contexto temporal
- ✅ **Enlaces a fuentes oficiales** para verificación (Congreso de la República)
- ✅ **Descripción completa** de cada propuesta con detalles técnicos

### Registro de Denuncias Judiciales
- ✅ **Clasificación por gravedad**: ALTA (rojo), MEDIA (amarillo), BAJA (gris)
- ✅ **Estado procesal actualizado**: En investigación, Archivada, Sentenciada, Desestimada
- ✅ **Información detallada**:
  - Tipo de denuncia (Corrupción, Lavado de activos, etc.)
  - Entidad investigadora (Fiscalía, Poder Judicial, etc.)
  - Fechas clave (denuncia y resolución)
  - Descripción completa del caso
- ✅ **Enlaces a fuentes oficiales** (Poder Judicial, Fiscalía)
- ✅ **Pantalla dedicada** para cada denuncia con toda la información

### Comparador de Candidatos
- ✅ **Selección múltiple**: Hasta 3 candidatos simultáneamente
- ✅ **Modo selección visual**: Cards con checkmark cuando están seleccionados
- ✅ **FAB flotante**: Muestra cantidad seleccionada y permite ir al comparador
- ✅ **Tabla comparativa** con datos clave side-by-side:
  - Nombre, partido, edad, profesión
  - Número de proyectos (destaca al mejor)
  - Número de denuncias (destaca al más limpio)
- ✅ **Gráficos interactivos**:
  - Barras de progreso para proyectos legislativos
  - Barras de progreso para denuncias (código de colores)
- ✅ **Compartir comparación** vía Intent (WhatsApp, Telegram, Twitter, etc.)

### Experiencia de Usuario Premium
- ✅ **Splash Screen animado** con Lottie (bandera peruana ondeando)
- ✅ **Pull to Refresh** con SwipeRefresh para actualizar datos
- ✅ **Material Design 3** completo con tokens de color y tipografía
- ✅ **Animaciones suaves** en transiciones y navegación
- ✅ **Estados visuales claros**: Loading indicators, empty states, error screens
- ✅ **Feedback visual inmediato** en todas las interacciones
- ✅ **Responsive design** adaptado a diferentes tamaños de pantalla
- ✅ **Iconos extendidos** de Material Icons para mejor comunicación visual

### Diseño y UI/UX
- ✅ **Paleta de colores institucional**:
  - Azul primario (#2563EB) para elementos principales
  - Verde (#10B981) para indicadores positivos (proyectos, sin denuncias)
  - Rojo (#EF4444) para alertas y denuncias
  - Amarillo (#F59E0B) para advertencias
- ✅ **Tipografía consistente** con jerarquía clara
- ✅ **Espaciado coherente** siguiendo principios de Material Design
- ✅ **Cards elevadas** con sombras sutiles para separación visual
- ✅ **Bordes redondeados** (12dp) para aspecto moderno
- ✅ **Accesibilidad**: Contraste suficiente, tamaños de texto legibles

## 📱 Capturas de Pantalla

<table>
  <tr>
    <td><img src="screenshots/home.png" width="250"/><br/><b>Pantalla Principal</b><br/>Lista de candidatos con búsqueda y filtros</td>
    <td><img src="screenshots/detail.png" width="250"/><br/><b>Detalle del Candidato</b><br/>Información completa con tabs</td>
    <td><img src="screenshots/projects.png" width="250"/><br/><b>Propuestas</b><br/>Proyectos legislativos categorizados</td>
  </tr>
  <tr>
    <td><img src="screenshots/compare_mode.png" width="250"/><br/><b>Modo Selección</b><br/>Seleccionar candidatos para comparar</td>
    <td><img src="screenshots/compare.png" width="250"/><br/><b>Comparador</b><br/>Comparación visual con gráficos</td>
    <td><b>Características:</b><br/>• Búsqueda instantánea<br/>• Filtros múltiples<br/>• Pull to refresh<br/>• Material Design 3</td>
  </tr>
</table>

## 🏗️ Arquitectura

### Patrón MVVM (Model-View-ViewModel)

La aplicación implementa el patrón **MVVM (Model-View-ViewModel)** de forma estricta, siguiendo las recomendaciones oficiales de Google para arquitectura Android moderna. Este patrón separa claramente las responsabilidades y facilita el testing, mantenimiento y escalabilidad.

```
┌─────────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                       │
│  ┌──────────────────────────────────────────────────────┐  │
│  │                UI (Jetpack Compose)                   │  │
│  │  • HomeScreen.kt       - Lista de candidatos         │  │
│  │  • DetailScreen.kt     - Perfil del candidato        │  │
│  │  • CompareScreen.kt    - Comparador visual           │  │
│  │  • DenunciaDetailScreen.kt - Detalle de denuncia     │  │
│  │  • SplashScreen.kt     - Pantalla inicial animada    │  │
│  └──────────────────────────────────────────────────────┘  │
│                      ↕ observes StateFlow                   │
│  ┌──────────────────────────────────────────────────────┐  │
│  │                    ViewModels                         │  │
│  │  • HomeViewModel      - Búsqueda, filtros, estado    │  │
│  │  • DetailViewModel    - Carga de candidato/datos     │  │
│  │  • CompareViewModel   - Selección múltiple           │  │
│  └──────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
                           ↕
┌─────────────────────────────────────────────────────────────┐
│                      DOMAIN LAYER                           │
│  ┌──────────────────────────────────────────────────────┐  │
│  │              Repository Interface                     │  │
│  │  • CandidatoRepository - Define contrato de datos    │  │
│  │    - getCandidatos()                                  │  │
│  │    - getCandidatoById(id)                            │  │
│  │    - searchCandidatos(query)                         │  │
│  │    - filterByCargo(cargo)                            │  │
│  │    - filterByRegion(region)                          │  │
│  │    - getDenunciasByCandidato(id)                     │  │
│  │    - getPropuestasByCandidato(id)                    │  │
│  └──────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
                           ↕
┌─────────────────────────────────────────────────────────────┐
│                       DATA LAYER                            │
│  ┌──────────────────────────────────────────────────────┐  │
│  │          Repository Implementation                    │  │
│  │  • CandidatoRepositoryImpl - Lógica de acceso datos  │  │
│  └──────────────────────────────────────────────────────┘  │
│                           ↕                                 │
│  ┌──────────────────────────────────────────────────────┐  │
│  │                 Data Sources                          │  │
│  │  • MockDataSource      - Datos simulados (actual)    │  │
│  │  • FavoritesManager    - DataStore Preferences       │  │
│  │  [Futuro: ApiService   - Retrofit para APIs reales]  │  │
│  └──────────────────────────────────────────────────────┘  │
│                           ↕                                 │
│  ┌──────────────────────────────────────────────────────┐  │
│  │                   Data Models                         │  │
│  │  • Candidato.kt        - Modelo de candidato         │  │
│  │  • Denuncia.kt         - Modelo de denuncia          │  │
│  │  • Propuesta.kt        - Modelo de propuesta         │  │
│  │  • GravedadDenuncia    - Enum (ALTA, MEDIA, BAJA)    │  │
│  └──────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
```

### Flujo de Datos (Unidireccional)

```
┌────────────────────────────────────────────────────────────┐
│  1. User Interaction (Compose UI)                          │
│     • Click en candidato                                   │
│     • Búsqueda de texto                                    │
│     • Selección de filtro                                  │
└────────────────────────────────────────────────────────────┘
                          ↓
┌────────────────────────────────────────────────────────────┐
│  2. ViewModel recibe evento                                │
│     • viewModelScope.launch { ... }                        │
│     • _uiState.value = UiState.Loading                     │
└────────────────────────────────────────────────────────────┘
                          ↓
┌────────────────────────────────────────────────────────────┐
│  3. Repository procesa petición                            │
│     • Accede a DataSource                                  │
│     • Aplica lógica de negocio                             │
│     • Retorna datos                                        │
└────────────────────────────────────────────────────────────┘
                          ↓
┌────────────────────────────────────────────────────────────┐
│  4. ViewModel actualiza estado                             │
│     • _uiState.value = UiState.Success(data)               │
│     • StateFlow emite nuevo estado                         │
└────────────────────────────────────────────────────────────┘
                          ↓
┌────────────────────────────────────────────────────────────┐
│  5. Compose observa y recompone                            │
│     • collectAsState() detecta cambio                      │
│     • Recomposición automática de UI                       │
│     • Usuario ve resultado actualizado                     │
└────────────────────────────────────────────────────────────┘
```

### Ventajas de esta Arquitectura

1. **Separación de Responsabilidades**
   - Cada capa tiene un propósito único y definido
   - Facilita mantenimiento y debugging
   - Código más limpio y organizado

2. **Testabilidad**
   - ViewModels sin dependencias de Android
   - Repository interface permite mocking fácil
   - UI testing independiente con Compose Test

3. **Escalabilidad**
   - Fácil agregar nuevas features sin afectar código existente
   - Repository pattern permite cambiar fuentes de datos sin cambiar ViewModels
   - Compose permite reutilización de componentes

4. **Reactividad**
   - StateFlow proporciona updates automáticos
   - UI siempre sincronizada con el estado
   - Menos bugs relacionados con estados inconsistentes

5. **Supervivencia a Cambios de Configuración**
   - ViewModel retiene estado durante rotaciones
   - No se pierden datos en cambios de orientación
   - Mejor experiencia de usuario

## 🛠️ Stack Tecnológico

### Lenguaje y Versiones
- **Kotlin:** 1.9.0
- **JVM Target:** 11
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 36 (Android 14)
- **Compile SDK:** 36

### UI Framework
- **Jetpack Compose:** 1.5.4
- **Material Design 3:** Última versión
- **Compose BOM:** Gestión de versiones

### Arquitectura y Navegación
- **Navigation Compose:** 2.7.7
- **Safe Args:** Navegación type-safe
- **ViewModel Compose:** 2.7.0

### Gestión de Estado
- **StateFlow:** Manejo reactivo de estado
- **Kotlin Coroutines:** 1.7.3
- **DataStore Preferences:** 1.0.0

### Networking (Preparado para integración)
- **Retrofit:** 2.9.0
- **Gson Converter:** 2.9.0
- **OkHttp:** 4.12.0
- **Logging Interceptor:** 4.12.0

### Recursos Visuales
- **Coil:** 2.5.0 (carga de imágenes)
- **Lottie:** 6.1.0 (animaciones)
- **Material Icons Extended:** 1.5.4
- **Accompanist SwipeRefresh:** 0.32.0

## 👥 Equipo de Desarrollo

**Juan Aguirre** - Líder Técnico & Backend
- Arquitectura MVVM y ViewModels
- Repositorios y gestión de estado
- Modelos de datos

**Yair Araujo** - UI/UX & Frontend
- Diseño en Figma
- Implementación UI en Compose
- Sistema de navegación

**Samir Alfonso** - QA & Features
- Funcionalidad de comparación
- Búsqueda y filtros
- Testing y documentación

## 📅 Cronograma de Desarrollo (6 Días)

### Día 1: Configuración
- Setup del proyecto y repositorio
- Investigación de fuentes de datos
- Diseño inicial en Figma
- Definición de arquitectura

### Día 2: Fundamentos
- Modelos de datos
- MockDataSource
- Sistema de navegación
- Theme y colores

### Día 3: Home Screen
- HomeViewModel
- HomeScreen UI
- Búsqueda y filtros
- Componentes reutilizables

### Día 4: Detail Screen
- DetailViewModel
- DetailScreen con tabs
- DenunciaDetailScreen
- Navegación integrada

### Día 5: Features Avanzadas
- CompareViewModel/Screen
- Modo selección múltiple
- Gráficos comparativos
- Pull to refresh

### Día 6: Refinamiento
- SplashScreen con Lottie
- Optimización UI/UX
- Testing integral
- Documentación final

## 🔐 Fuentes de Datos

Datos basados en fuentes oficiales:
- **JNE**: Información de candidatos
- **Congreso**: Proyectos de ley
- **Poder Judicial**: Denuncias
- **ONPE**: Hojas de vida
- **SUNAT**: Información tributaria

*Versión actual usa MockDataSource con datos simulados*

## 🚀 Instalación

```bash
git clone https://github.com/tu-usuario/candidatoinfo.git
cd candidatoinfo
./gradlew build
```

Abrir en Android Studio y ejecutar en dispositivo/emulador

## 📄 Licencia

Proyecto educativo - Tecsup

---

**CandidatoInfo** - Vota informado 🗳️ Perú 2026

## 📁 Estructura Completa del Proyecto

```
com.tecsup.candidatoinfo/
│
├── 📱 MainActivity.kt                 # Actividad principal (punto de entrada)
│
├── 🎨 presentation/                   # Capa de presentación
│   │
│   ├── splash/
│   │   └── SplashScreen.kt           # Pantalla de bienvenida animada (4s)
│   │
│   ├── ui/
│   │   ├── screens/                  # Pantallas principales
│   │   │   ├── home/
│   │   │   │   └── HomeScreen.kt     # Lista de candidatos con búsqueda/filtros
│   │   │   │
│   │   │   ├── detail/
│   │   │   │   ├── DetailScreen.kt          # Perfil del candidato con tabs
│   │   │   │   └── DenunciaDetailScreen.kt  # Detalle completo de una denuncia
│   │   │   │
│   │   │   └── compare/
│   │   │       └── CompareScreen.kt         # Comparador de 2-3 candidatos
│   │   │
│   │   ├── components/               # Componentes reutilizables
│   │   │   ├── CandidatoCard.kt     # Card de candidato (usado en lista)
│   │   │   ├── LoadingIndicator.kt  # Indicador de carga
│   │   │   ├── EmptyState.kt        # Estado vacío
│   │   │   ├── ErrorState.kt        # Estado de error
│   │   │   ├── FilterChip.kt        # Chips para filtros
│   │   │   ├── StatCard.kt          # Card de estadística
│   │   │   └── HelpDialog.kt        # Diálogo de ayuda
│   │   │
│   │   └── theme/                    # Sistema de diseño
│   │       ├── Color.kt             # Paleta de colores
│   │       ├── Theme.kt             # Configuración de tema M3
│   │       └── Type.kt              # Tipografía
│   │
│   └── viewmodel/                    # ViewModels (lógica de presentación)
│       ├── HomeViewModel.kt         # VM para pantalla principal
│       ├── DetailViewModel.kt       # VM para detalle de candidato
│       └── CompareViewModel.kt      # VM para comparador
│
├── 💾 data/                          # Capa de datos
│   │
│   ├── model/                        # Modelos de dominio
│   │   ├── Candidato.kt             # Data class inmutable
│   │   ├── Denuncia.kt              # Data class + enum GravedadDenuncia
│   │   └── Propuesta.kt             # Data class
│   │
│   ├── repository/                   # Patrón Repository
│   │   ├── CandidatoRepository.kt      # Interface (contrato)
│   │   └── CandidatoRepositoryImpl.kt  # Implementación
│   │
│   ├── datasource/                   # Fuentes de datos
│   │   └── MockDataSource.kt        # Datos simulados (MVP)
│   │
│   └── local/                        # Persistencia local
│       └── FavoritesManager.kt      # DataStore Preferences
│
└── 🔧 core/                          # Utilidades y configuración
    ├── navigation/
    │   └── NavigationHost.kt        # Configuración de Navigation Compose
    │
    └── util/
        ├── UiState.kt               # Sealed class para estados
        └── IntentHelper.kt          # Helper para intents externos

```

### Descripción de Módulos

#### 📱 MainActivity
- **Propósito**: Punto de entrada de la aplicación
- **Responsabilidad**: Configurar Compose y tema
- **Líneas**: ~15

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CandidatoInfoTheme {
                NavigationHost()
            }
        }
    }
}
```

#### 🎨 Presentation Layer

**SplashScreen.kt** (~80 líneas)
- Animación Lottie de bandera peruana
- Transición automática a Home (4 segundos)
- Animación de fade-in para logo

**HomeScreen.kt** (~250 líneas)
- Lista scrollable con LazyColumn
- Barra de búsqueda con debouncing
- Chips de filtrado (Cargo + Región)
- Pull to refresh
- Estados: Loading, Success, Empty, Error
- FAB para comparador (cuando hay 2+ seleccionados)

**DetailScreen.kt** (~300 líneas)
- TabRow con 3 tabs (Info, Proyectos, Denuncias)
- Header con foto y datos personales
- Cards de estadísticas (proyectos/denuncias)
- LazyColumn para tabs de contenido

**DenunciaDetailScreen.kt** (~180 líneas)
- Header con icono de gravedad
- Información completa de la denuncia
- Botón de enlace a fuente oficial
- Warning banner informativo

**CompareScreen.kt** (~400 líneas)
- Tabla comparativa responsive
- Gráficos de barras con LinearProgressIndicator
- Resumen de denuncias
- Botón de compartir en toolbar

**Componentes Reutilizables** (~600 líneas totales)
- CandidatoCard: Card reutilizable en Home y Compare
- LoadingIndicator: Spinner con mensaje
- EmptyState: Ilustración + mensaje + botón de acción
- ErrorState: Error con retry
- StatCard: Card de estadística con icono y número

#### 💾 Data Layer

**Modelos** (~150 líneas)
```kotlin
// Inmutables, con valores por defecto donde tiene sentido
data class Candidato(
    val id: String,
    val nombreCompleto: String,
    val partidoPolitico: String,
    val cargo: String,
    val fotoUrl: String,
    val edad: Int,
    val lugarNacimiento: String,
    val profesion: String,
    val numeroDenuncias: Int,
    val numeroProyectos: Int
)

data class Denuncia(
    val id: String,
    val candidatoId: String,
    val titulo: String,
    val descripcion: String,
    val tipo: String,
    val estado: String,
    val fechaDenuncia: String,
    val fechaResolucion: String?,
    val entidadInvestigadora: String,
    val linkFuenteOficial: String,
    val gravedad: GravedadDenuncia
)

enum class GravedadDenuncia { ALTA, MEDIA, BAJA }

data class Propuesta(
    val id: String,
    val candidatoId: String,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val fechaPresentacion: String,
    val estado: String,
    val linkFuenteOficial: String
)
```

**Repository** (~80 líneas)
- Interface define contrato (testeable)
- Implementación delega a DataSource
- Métodos: get, search, filter, etc.

**MockDataSource** (~1500 líneas)
- Datos simulados de 10+ candidatos
- 30+ denuncias con información real
- 40+ propuestas legislativas
- Datos basados en estructura real de APIs

#### 🔧 Core Utilities

**NavigationHost.kt** (~60 líneas)
- Define rutas y navegación
- Maneja argumentos entre pantallas
- Singleton de CompareViewModel

**UiState.kt** (~15 líneas)
- Sealed class con 5 estados
- Type-safe state management

**IntentHelper.kt** (~30 líneas)
- Helper para abrir URLs externas
- Manejo de intents de compartir

### Estadísticas del Código

| Categoría | Líneas | Archivos |
|-----------|--------|----------|
| **ViewModels** | ~450 | 3 |
| **Screens** | ~1,200 | 5 |
| **Components** | ~600 | 8 |
| **Models** | ~150 | 3 |
| **Repository** | ~100 | 2 |
| **DataSource** | ~1,500 | 1 |
| **Navigation** | ~60 | 1 |
| **Utils** | ~80 | 3 |
| **Theme** | ~120 | 3 |
| **MainActivity** | ~15 | 1 |
| **TOTAL** | **~4,275** | **30** |

---

## 🔧 Instalación y Configuración

### Requisitos Previos

```bash
✅ Android Studio Hedgehog (2023.1.1) o superior
✅ JDK 11 o superior
✅ Android SDK 24+
✅ Gradle 8.0+
✅ Git
```

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/usuario/candidatoinfo.git
cd candidatoinfo
```

### Paso 2: Abrir en Android Studio

1. Abrir Android Studio
2. File → Open
3. Seleccionar la carpeta del proyecto
4. Esperar sincronización de Gradle (~2-3 minutos)

### Paso 3: Configurar Emulador o Dispositivo

**Opción A: Emulador**
```bash
# Crear AVD con Android 13 (API 33)
Tools → Device Manager → Create Virtual Device
Seleccionar: Pixel 6 Pro
System Image: API 33 (Android 13.0)
```

**Opción B: Dispositivo Físico**
```bash
# Habilitar Developer Options
Settings → About Phone → Tap Build Number 7 times
Settings → Developer Options → Enable USB Debugging
Conectar vía USB
```

### Paso 4: Build y Run

```bash
# Vía Android Studio
Shift + F10 (Run)

# Vía Terminal
./gradlew assembleDebug
./gradlew installDebug
```

### Paso 5: Verificar Instalación

✅ Splash screen con animación de bandera  
✅ Lista de candidatos cargada  
✅ Búsqueda funcional  
✅ Navegación entre pantallas  

### Troubleshooting

**Error: "SDK location not found"**
```bash
# Crear local.properties
echo "sdk.dir=/Users/TU_USUARIO/Library/Android/sdk" > local.properties
```

**Error: "Minimum supported Gradle version is 8.0"**
```bash
# Actualizar en gradle/wrapper/gradle-wrapper.properties
distributionUrl=https\://services.gradle.org/distributions/gradle-8.0-bin.zip
```

**Error: "Compose Compiler version mismatch"**
```bash
# Verificar en build.gradle.kts (app)
composeOptions {
    kotlinCompilerExtensionVersion = "1.5.4"
}
```

---


## 🎯 Funcionalidades Implementadas (Detalladas)

### 1. 🔍 Búsqueda Inteligente

**Implementación Técnica:**
```kotlin
// HomeViewModel.kt
fun updateSearchQuery(query: String) {
    _searchQuery.value = query
    searchCandidatos(query)
}

private fun searchCandidatos(query: String) {
    viewModelScope.launch {
        _uiState.value = UiState.Loading
        delay(300) // Debouncing
        
        val results = if (query.isBlank()) {
            repository.getCandidatos()
        } else {
            repository.searchCandidatos(query)
        }
        
        _uiState.value = if (results.isEmpty()) {
            UiState.Empty
        } else {
            UiState.Success(results)
        }
    }
}
```

**Características:**
- ✅ Búsqueda en tiempo real mientras el usuario escribe
- ✅ Debouncing de 300ms para evitar consultas excesivas
- ✅ Búsqueda por nombre completo, partido político o región
- ✅ Case-insensitive
- ✅ Combina con filtros activos

**UI/UX:**
- TextField con Material 3
- Icono de búsqueda (lupa)
- Placeholder descriptivo
- Clear button (X) cuando hay texto

### 2. 🎛️ Sistema de Filtros

**Filtros por Cargo:**
- `Todos` (default)
- `Congreso` (Congresistas)
- `Presidencia` (Candidatos presidenciales)

**Filtros por Región:**
- `Todas` (default)
- `Lima`, `Cusco`, `Arequipa`, `Trujillo`, etc.

**Implementación:**
```kotlin
// Aplica filtros de forma combinada
private fun applyAllFilters() {
    viewModelScope.launch {
        var filtered = repository.getCandidatos()
        
        // Filtro por cargo
        if (_selectedFilter.value != "Todos") {
            filtered = filtered.filter {
                it.cargo.contains(_selectedFilter.value, ignoreCase = true)
            }
        }
        
        // Filtro por región
        if (_selectedRegion.value != "Todas") {
            filtered = filtered.filter {
                it.lugarNacimiento.contains(_selectedRegion.value, ignoreCase = true)
            }
        }
        
        // Filtro por búsqueda
        if (_searchQuery.value.isNotBlank()) {
            filtered = filtered.filter {
                it.nombreCompleto.contains(_searchQuery.value, ignoreCase = true) ||
                it.partidoPolitico.contains(_searchQuery.value, ignoreCase = true)
            }
        }
        
        _uiState.value = if (filtered.isEmpty()) UiState.Empty else UiState.Success(filtered)
    }
}
```

**UI:**
- FilterChips con Material 3
- Selected state visual
- Scroll horizontal para regiones
- Botón "Limpiar filtros"

### 3. 📊 Comparador de Candidatos

**Selección Múltiple:**
```kotlin
// CompareViewModel.kt
private val _selectedCandidatos = mutableStateOf<List<Candidato>>(emptyList())

fun toggleCandidato(candidato: Candidato) {
    val current = _selectedCandidatos.value.toMutableList()
    
    if (current.any { it.id == candidato.id }) {
        // Deseleccionar
        current.removeAll { it.id == candidato.id }
    } else {
        // Seleccionar (máximo 3)
        if (current.size < 3) {
            current.add(candidato)
        }
    }
    
    _selectedCandidatos.value = current
}

fun canCompare(): Boolean = _selectedCandidatos.value.size >= 2
```

**Tabla Comparativa:**
- Nombre (truncado a 2 palabras)
- Partido político (truncado a 20 caracteres)
- Edad
- Profesión (solo primer título)
- **Proyectos** (destacado en verde al mejor)
- **Denuncias** (destacado en verde al más limpio)

**Gráficos:**
```kotlin
// LinearProgressIndicator para visualizar
val progress = proyectos.toFloat() / maxProyectos

LinearProgressIndicator(
    progress = progress,
    modifier = Modifier.height(24.dp),
    color = Green600,
    trackColor = Green50
)
```

**Compartir:**
```kotlin
fun buildShareText(candidatos: List<Candidato>): String {
    val sb = StringBuilder()
    sb.append("📊 Comparación de Candidatos - CandidatoInfo\n\n")
    
    candidatos.forEach { candidato ->
        sb.append("👤 ${candidato.nombreCompleto}\n")
        sb.append("   ${candidato.partidoPolitico}\n")
        sb.append("   📝 ${candidato.numeroProyectos} proyectos\n")
        sb.append("   ⚖️ ${candidato.numeroDenuncias} denuncias\n\n")
    }
    
    sb.append("🗳️ Elecciones 2026 - Vota informado")
    return sb.toString()
}

// Intent de compartir
val intent = Intent(Intent.ACTION_SEND).apply {
    type = "text/plain"
    putExtra(Intent.EXTRA_TEXT, shareText)
}
context.startActivity(Intent.createChooser(intent, "Compartir comparación"))
```

### 4. 📋 Detalle del Candidato (Tabs)

**Tab 1: Información Personal**
- Foto (Coil con placeholder)
- Nombre completo
- Partido político
- Cargo al que postula
- Edad
- Lugar de nacimiento
- Profesión completa
- Cards de estadísticas:
  - 📝 Proyectos presentados (verde)
  - ⚖️ Denuncias registradas (rojo si > 0)

**Tab 2: Proyectos Legislativos**
```kotlin
// DetailViewModel.kt
private fun loadPropuestas(candidatoId: String) {
    viewModelScope.launch {
        _propuestasState.value = UiState.Loading
        delay(350)
        
        val propuestas = repository.getPropuestasByCandidato(candidatoId)
        
        _propuestasState.value = if (propuestas.isEmpty()) {
            UiState.Empty
        } else {
            UiState.Success(propuestas)
        }
    }
}
```

Cada propuesta muestra:
- 📝 Título completo
- 📂 Categoría (con badge de color)
- 📅 Fecha de presentación
- 🔖 Estado (Presentado, En debate, etc.)
- 🔗 Botón "Ver fuente →" (abre Congreso.gob.pe)

**Tab 3: Denuncias**
Similar a propuestas pero con:
- ⚖️ Título de la denuncia
- 🎯 Gravedad (badge con color: rojo/amarillo/gris)
- 📅 Fecha
- 🔖 Estado procesal
- 👆 Click para ver detalle completo

### 5. ⚖️ Detalle de Denuncia

**Información Completa:**
- Header con icono de gravedad
- Título completo
- Descripción detallada (múltiples párrafos)
- Tipo de denuncia
- Estado actual con badge de color
- Fechas (denuncia y resolución)
- Entidad investigadora
- Botón de enlace a fuente oficial
- Banner informativo (amarillo)

**Código de Colores por Estado:**
```kotlin
val estadoColor = when (denuncia.estado) {
    "Archivada", "Desestimada" -> Gray500
    "Sentenciada" -> Red600
    else -> Yellow600  // En investigación
}
```

### 6. 🔄 Pull to Refresh

```kotlin
// HomeScreen.kt
SwipeRefresh(
    state = rememberSwipeRefreshState(isRefreshing),
    onRefresh = { viewModel.refresh() }
) {
    LazyColumn { /* content */ }
}

// HomeViewModel.kt
fun refresh() {
    viewModelScope.launch {
        _isRefreshing.value = true
        delay(1000)  // Simular latencia
        loadCandidatos()
        _isRefreshing.value = false
    }
}
```

### 7. 🎨 SplashScreen Animado

```kotlin
@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )
    
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        // Bandera animada con Lottie
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(650.dp)
        )
        
        // Logo con fade-in
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .alpha(alphaAnim.value)
        )
    }
}
```

---

## 🔄 Gestión de Estado con UiState

### Sealed Class Pattern

```kotlin
sealed class UiState<out T> {
    object Idle : UiState<Nothing>()           // Estado inicial
    object Loading : UiState<Nothing>()        // Cargando datos
    data class Success<T>(val data: T) : UiState<T>()  // Datos cargados
    data class Error(val message: String) : UiState<Nothing>()  // Error
    object Empty : UiState<Nothing>()          // Sin resultados
}
```

### ¿Por qué UiState?

**Ventajas:**

1. **Type-Safety Completo**
```kotlin
// El compilador obliga a manejar TODOS los casos
when (uiState) {
    is UiState.Idle -> { /* inicial */ }
    is UiState.Loading -> LoadingIndicator()
    is UiState.Success -> Content(uiState.data)  // data es type-safe
    is UiState.Error -> ErrorState(uiState.message)
    is UiState.Empty -> EmptyState()
}
// Si falta un caso, no compila ✅
```

2. **Flujo Unidireccional**
```
User Action → ViewModel → UiState update → UI recompose
```

3. **Testeable**
```kotlin
@Test
fun `when loadCandidatos success, uiState is Success`() = runTest {
    // Given
    val viewModel = HomeViewModel()
    
    // When
    viewModel.loadCandidatos()
    
    // Then
    val state = viewModel.uiState.value
    assertTrue(state is UiState.Success)
    assertFalse((state as UiState.Success).data.isEmpty())
}
```

### Uso en ViewModels

**Patrón Estándar:**
```kotlin
class HomeViewModel : ViewModel() {
    // Privado y mutable
    private val _uiState = MutableStateFlow<UiState<List<Candidato>>>(UiState.Idle)
    
    // Público e inmutable
    val uiState: StateFlow<UiState<List<Candidato>>> = _uiState.asStateFlow()
    
    fun loadCandidatos() {
        viewModelScope.launch {
            // 1. Set loading
            _uiState.value = UiState.Loading
            
            try {
                // 2. Fetch data
                val candidatos = repository.getCandidatos()
                
                // 3. Set success or empty
                _uiState.value = if (candidatos.isEmpty()) {
                    UiState.Empty
                } else {
                    UiState.Success(candidatos)
                }
            } catch (e: Exception) {
                // 4. Set error
                _uiState.value = UiState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}
```

### Uso en Compose

```kotlin
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    // Recompone automáticamente cuando cambia el estado
    val uiState by viewModel.uiState.collectAsState()
    
    when (uiState) {
        is UiState.Idle -> {
            // Primera carga
            LaunchedEffect(Unit) {
                viewModel.loadCandidatos()
            }
        }
        
        is UiState.Loading -> {
            LoadingIndicator(message = "Cargando candidatos...")
        }
        
        is UiState.Success -> {
            val candidatos = (uiState as UiState.Success).data
            CandidatesList(candidatos)
        }
        
        is UiState.Error -> {
            val errorMessage = (uiState as UiState.Error).message
            ErrorState(
                message = errorMessage,
                onRetry = { viewModel.loadCandidatos() }
            )
        }
        
        is UiState.Empty -> {
            EmptyState(
                icon = "🔍",
                title = "No hay resultados",
                message = "Intenta con otros filtros"
            )
        }
    }
}
```

---
