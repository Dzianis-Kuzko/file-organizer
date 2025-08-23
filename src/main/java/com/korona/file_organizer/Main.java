package com.korona.file_organizer;

import com.korona.file_organizer.controller.AppController;
import com.korona.file_organizer.exception.FileOperationException;
import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.writer.OutputWriter;
import com.korona.file_organizer.writer.impl.ConsoleWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting application with args: {}", Arrays.toString(args));

        try (OutputWriter writer = new ConsoleWriter()) {
            try {
                AppController appController = AppFactory.createAppController(args);
                appController.process();

            } catch (IllegalArgumentException | FileOperationException | ValidationException e) {
                writer.writeLine(e.getMessage());
                logger.error("Known error occurred: ", e);
            } catch (Exception e) {
                writer.writeLine(e.getMessage());
                logger.error("Unexpected error", e);
            }
        } catch (Exception e) {
            logger.fatal("Failed to initialize output writer", e);
        }
    }
}
