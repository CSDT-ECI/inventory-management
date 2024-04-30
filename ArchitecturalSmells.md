# ArchitecturalSmells

> [!NOTE]
> Para obtener más información sobre el proyecto y los cambios realizados, consulte los archivos md: semlls, TestingDebt, CSDT-2024.md.

Un "Architectural Smell" es un término utilizado en ingeniería de software para referirse a problemas estructurales en la arquitectura de un sistema que pueden afectar su calidad y mantenibilidad. Estos problemas pueden surgir debido a decisiones de diseño inapropiadas o a la evolución del sistema a lo largo del tiempo, lo que puede llevar a dificultades en el desarrollo, mantenimiento y escalabilidad del software.

## Smells

> [!PACKAGE]
> com.systelab.inventory.controller

### UserController 


**Unstable Dependency:** El UserController depende de UserRepository, AuthenticationManager, TokenProvider y BCryptPasswordEncoder. Si estas clases o interfaces cambian frecuentemente, esto podría ser un problema. 

### Item

**Ambiguous Interface:** El método clearQuarantineInfo podría ser confuso si no se entiende el contexto de cuarentena. Un nombre más descriptivo podría ser resetQuarantineInfo.

```java
    private void clearQuarantineInfo() {
    }
    
    ==>

    private void resetQuarantineInfo() {
    }
```

### Product

**Insufficient Modularization:** Product parece tener muchas responsabilidades, ya que maneja una gran cantidad de atributos. Podría ser útil dividir esta clase en varias clases más pequeñas, cada una con su propia responsabilidad.

```java
    private Integer minimumExpiry;
    private Integer consumptionPurchaseRatio;
    private Integer minStock;
    private Integer maxStock;
    ...
    private Integer totalRemainingUnitsInQuarantine;
    private String quarantineControl;
    private boolean mandatoryExpiry;
    private Integer minDaysToExpire;
```

**Ambiguous Interface:** Los atributos productField1, productField2, productField3, y productField4 podrían ser confusos si no se entiende su propósito. Un nombre más descriptivo podría ser útil.

```java
    private String productField2;
    private String productField3;
    private String productField4;
```