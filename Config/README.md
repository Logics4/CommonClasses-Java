## CommonClasses-Config module

In this module I mostly include methods for configuration files (think YAML, JSON, HOCON, XML...), made around [Configurate](https://github.com/SpongePowered/Configurate), a configuration library that deals with these. Each configuration file is basically an instance of a \[TYPE]Config class provided here.</br>

Configurate is licensed under Apache License 2.0. You can find a copy in this directory, and in the `META-INF/LICENSES/Apache_v2.0` directory of the compiled JAR file.</br></br>

## How to use this module?
Copy the class(es) you need to your source code's folders, to a package of your own.</br>
You will also need to declare Configurate as a dependency (which you probably want to shade and relocate, unless your runtime already includes it - SpongePowered server? - in which case you just have to change the `<scope>` to `provided`):</br>
```xml
<!-- In case you use HOCONConfig.java -->
<dependency>
    <groupId>org.spongepowered</groupId>
    <artifactId>configurate-hocon</artifactId>
    <version>3.7.1</version>
    <scope>compile</scope> <!-- can be changed to "provided" if you don't need to shade it -->
</dependency>

<!-- In case you use YAMLConfig.java -->
<dependency>
    <groupId>org.spongepowered</groupId>
    <artifactId>configurate-yaml</artifactId>
    <version>3.7.1</version>
    <scope>compile</scope> <!-- can be changed to "provided" if you don't need to shade it -->
</dependency>
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
