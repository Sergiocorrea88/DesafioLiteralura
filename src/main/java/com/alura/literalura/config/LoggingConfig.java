package com.alura.literalura.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class LoggingConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggingConfig.class);

    @PostConstruct // Se ejecuta después de la inyección de dependencias
    public void init() {
        logger.info("Configuración de Logging inicializada.");
        logger.debug("Nivel de depuración activado (solo en desarrollo)."); // Útil para desarrollo
        logger.warn("Ejemplo de mensaje de advertencia.");
        logger.error("Ejemplo de mensaje de error.");
    }

    // Métodos para loggear en diferentes niveles dentro de otras clases:
    public static void logInfo(Class<?> clase, String mensaje) {
        LoggerFactory.getLogger(clase).info(mensaje);
    }

    public static void logDebug(Class<?> clase, String mensaje) {
        LoggerFactory.getLogger(clase).debug(mensaje);
    }

    public static void logWarn(Class<?> clase, String mensaje) {
        LoggerFactory.getLogger(clase).warn(mensaje);
    }

    public static void logError(Class<?> clase, String mensaje, Throwable excepcion) {
        LoggerFactory.getLogger(clase).error(mensaje, excepcion); // Incluye la excepción
    }

    public static void logError(Class<?> clase, String mensaje) {
        LoggerFactory.getLogger(clase).error(mensaje); // Incluye la excepción
    }
}