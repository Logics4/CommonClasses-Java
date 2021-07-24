/*
 * This file is part of the "CommonClasses-Java" project, "Config" module.
 * You can find it here: https://github.com/Logics4/CommonClasses-Java/tree/main/Config
 *
 * Copyright (C) 2020-2021 Logics4
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *limitations under the License.
 */

package io.github.logics4.commonclasses.config;

import io.github.logics4.commonclasses.config.exceptions.*;
import io.github.logics4.commonclasses.config.formats.UncommentedConfigType;
import io.github.logics4.commonclasses.config.formats.YAML;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import ninja.leaping.configurate.ConfigurationNode;

public class ConfigFile {

    private UncommentedConfigType configFile;
    private ConfigurationNode config;
    private Path dataFolderPath;
    private String configFileName;
    private Path configFilePath;

    public ConfigFile(ConfigFileFormat format, Path dataFolderPath, String configFileName) {
        this.dataFolderPath = dataFolderPath;
        this.configFileName = configFileName;
        this.configFilePath = Paths.get(this.dataFolderPath.toString(), this.configFileName);

        switch (format) {
            case YAML: {
                configFile = new YAML(dataFolderPath, configFileName);
                break;
            }
            default: {
                throw new InvalidConfigFormatException();
                //break;
            }
        }
    }

    public void extractFromJar(String pathInJar, boolean replace) {
        try {
            if (Files.notExists(this.dataFolderPath)) {
                Files.createDirectories(this.dataFolderPath);
            }
            if (Files.notExists(this.configFilePath) || replace) {
                InputStream in = getClass().getResourceAsStream(pathInJar + configFileName);
                Files.copy(in, this.configFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new ConfigExtractionFailureException();
        }
    }

    public ConfigFile loadConfig() {
        try {
            if (Files.notExists(this.dataFolderPath)) {
                Files.createDirectories(this.dataFolderPath);
            }
            if (Files.notExists(this.configFilePath)) {
                Files.createFile(this.configFilePath);
            }
            config = configFile.load();
        } catch (IOException e) {
            throw new ConfigLoadFailureException();
        }
        return this;
    }

    public ConfigurationNode getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            if (Files.notExists(this.dataFolderPath)) {
                Files.createDirectories(this.dataFolderPath);
            }
            configFile.save();
        } catch (IOException e) {
            throw new ConfigSaveFailureException();
        }
    }
}
