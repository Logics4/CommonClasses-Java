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
import java.nio.file.Path;

import ninja.leaping.configurate.ConfigurationNode;

public interface ConfigType {
    public ConfigurationNode load() throws IOException;
    public void save() throws IOException;
    public Path getPath();
}
