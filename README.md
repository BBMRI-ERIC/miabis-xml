# README #

Supplementary data to the article "Towards European Biobank Integration by Community Review and Implementation of the Minimum Information About Biobank data Sharing (MIABIS)"

### What is this repository for? ###

This repository contains the XML schema for [MIABIS 2.0](https://github.com/MIABIS/miabis/wiki).

### How do I get set up? ###
This repository contains a [Maven](http://maven.apache.org) project that can generate classes for the XML schema of MIABIS. 

1. If you need the schema for validating MIABIS XML output you can [download the schema](src/main/resources/miabis.xsd) In due time the schema will also be published on the [BBMRI ERIC website](http://www.bbmri-eric.eu).
2. If you need ready to use Java classes you can include the MIABIS classes by including the following artifact in your Maven project.

```
#!xml

<dependency>
    <groupId>eu.bbmri-eric.miabis</groupId>
    <artifactId>MIABIS</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Contribution guidelines ###

Contributions to the MIABIS standard can be proposed through the MIABIS working group, read the article for more information.

XML experts are welcome to contribute to the development of the schema definition. All changes should be backwards compatible within MIABIS 2.0.

### Who do I talk to? ###

Please contact us through the MIABIS working group.
