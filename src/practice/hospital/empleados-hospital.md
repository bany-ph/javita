
**Empleados de Hospital**

**Tu tarea**: Modelar diferentes tipos de empleados de un hospital.

**Requisitos**:
- Clase base `Empleado`: nombre, salarioBase, turno
- Subclases: `Medico`, `Enfermero`, `Administrativo`
- Cada uno calcula su salario total diferente:
    - Médico: salarioBase + bono por especialidad + horas extra
    - Enfermero: salarioBase + bono nocturno si trabaja de noche
    - Administrativo: solo salarioBase
- Método `obtenerResponsabilidades()` específico para cada tipo
