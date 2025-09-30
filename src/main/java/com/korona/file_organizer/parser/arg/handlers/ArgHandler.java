package com.korona.file_organizer.parser.arg.handlers;

import com.korona.file_organizer.config.Config;

/**
 * Handles processing command-line arguments.
 */

public interface ArgHandler {

    /**
     * @param key    the argument name or flag (e.g., "--output", "-o")
     * @param value  the argument value; may be null
     * @param config the configuration object to populate
     * @param index  the position in command line
     * @throws IllegalArgumentException if the argument value is invalid,
     *                                  missing when required, or otherwise malformed.
     */
    void handle(String key, String value, Config config, int index);

}
