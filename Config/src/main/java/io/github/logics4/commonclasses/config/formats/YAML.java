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

package io.github.logics4.commonclasses.config.formats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.yaml.YAMLConfigurationLoader;

import org.yaml.snakeyaml.DumperOptions.FlowStyle;

public class YAML implements UncommentedConfigType {

    private Path dataFolderPath; // The folder where the config file will be located
    private Path configFilePath;
    private ConfigurationLoader<ConfigurationNode> loader;
    private ConfigurationNode config;

    public YAML(Path dataFolderPath, String configFileName) {
        this.dataFolderPath = dataFolderPath;
        this.configFilePath = Paths.get(this.dataFolderPath.toString(), configFileName);

        loader = YAMLConfigurationLoader.builder()
            .setFlowStyle(FlowStyle.BLOCK)
            .setPath(this.configFilePath)
            .build();
    }

    @Override
    public Path getPath() {
        return configFilePath;
    }

    @Override
    public ConfigurationNode load() throws IOException {
        if (Files.notExists(this.dataFolderPath)) {
            Files.createDirectories(this.dataFolderPath);
        }
        if (Files.notExists(this.configFilePath)) {
            Files.createFile(this.configFilePath);
        }

        this.config = loader.load();
        return this.config;
    }

    @Override
    public void save() throws IOException {
        loader.save(this.config);
    }
}
