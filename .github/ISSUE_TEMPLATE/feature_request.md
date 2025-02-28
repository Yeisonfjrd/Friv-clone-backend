---
name: ✨ Feature request
about: Sugerir una nueva funcionalidad para el backend
title: '[FEATURE] '
labels: enhancement, backend
assignees: ''

---

**🎯 Objetivo**
Una descripción clara y concisa de qué quieres lograr.

**📝 Descripción técnica**
Explica en detalle cómo debería implementarse esta característica.

**🔌 API Propuesta**
```
POST /api/example
Request:
{
    "field1": "type",
    "field2": "type"
}

Response:
{
    "field1": "type",
    "field2": "type"
}
```

**📊 Modelo de datos**
Describe los cambios necesarios en el modelo de datos:
```java
@Entity
class Example {
    // Campos propuestos
}
```

**🔒 Seguridad**
- [ ] Requiere autenticación
- [ ] Requiere roles específicos
- [ ] Validación de datos
- [ ] Rate limiting

**📈 Escalabilidad**
- Estimación de carga
- Consideraciones de caché
- Optimizaciones necesarias
- Índices de base de datos

**🔄 Integración**
- Servicios afectados
- Dependencias externas
- Cambios en la configuración
- Migraciones necesarias

**✅ Criterios de aceptación**
- [ ] Tests unitarios
- [ ] Tests de integración
- [ ] Documentación de API
- [ ] Métricas de monitoreo

**📝 Tareas técnicas**
1. [ ] Crear entidades
2. [ ] Implementar repositorios
3. [ ] Desarrollar servicios
4. [ ] Crear endpoints
5. [ ] Agregar tests
6. [ ] Documentar API

**🎯 Métricas de éxito**
- Tiempo de respuesta esperado
- Throughput objetivo
- SLA propuesto
- Métricas de monitoreo

**📚 Documentación**
- Swagger/OpenAPI
- Postman Collection
- Diagramas necesarios
- Guías de migración 