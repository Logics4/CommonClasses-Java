## CommonClasses-Config module

This module is a bit of abstraction over [Configurate](https://github.com/SpongePowered/Configurate), a library that deals with configuration files (think YAML, JSON, HOCON, XML...).</br>

Configurate is licensed under Apache License 2.0. You can find a copy in this directory, and in the `META-INF/LICENSES/Apache_v2.0/` directory of the compiled JAR file.</br></br>

## How to use this module?
You can use [jitpack.io](https://jitpack.io/):</br>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Logics4.CommonClasses-Java</groupId>
        <artifactId>commonclasses-config</artifactId>
        <version>[VERSION]</version> <!-- Check Releases for a stable version. This can be replaced with either a GitHub Releases tag, commit hash or "<branchname>-SNAPSHOT". Read more at https://jitpack.io/docs/#building-with-jitpack -->
        <scope>compile</scope> <!-- We recommend shading this, unless your runtime's classpath already has this library. -->
    </dependency>

    <!-- In case you make use of HOCON support, you'll need to shade Configurate-HOCON by yourself. -->
    <dependency>
        <groupId>org.spongepowered</groupId>
        <artifactId>configurate-hocon</artifactId>
        <version>3.7.1</version>
        <scope>compile</scope> <!-- can be changed to "provided" if you don't need to shade it -->
    </dependency>

    <!-- In case you make use of YAML support, you'll need to shade Configurate-YAML by yourself. -->
    <dependency>
        <groupId>org.spongepowered</groupId>
        <artifactId>configurate-yaml</artifactId>
        <version>3.7.1</version>
        <scope>compile</scope> <!-- can be changed to "provided" if you don't need to shade it -->
    </dependency>

    <!-- Note that doing this is no different from CommonClasses-Config already shading them by default, so there should be no concern about bigger filesizes. -->
</dependencies>

<!-- Don't forget to relocate if needed! -->
```

## License for CommonClasses-Config
Copyright (C) 2020 Logics4</br></br>
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.</bR>
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
