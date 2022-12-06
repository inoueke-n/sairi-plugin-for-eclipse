# sairi-plugin-for-eclipse README

This repository is a eclupse plugin for the fine-grained edit history collection platform.
For overview, please see the repository: [inoueke-n/sairi-common](https://github.com/inoueke-n/sairi-common).

## Features

*THIS PLUGIN SENDS EDIT HISTORY TO THE SERVER*. (default: localhost)

Please use this plugin *ONLY IN* the experimental environment.

## Requirement
- Node.js  &nbsp; (This pulugin starts a language server as a process using Node.js)

## Settings

### PluginConfigration.java
Edit PluginConfigration.java file. &nbsp; (sairi-plugin-for-eclipse/src/eclipselanguageclient/pluginconfigration/PluginConfigration.java)

* `uid`: username
* `apiEndpoint`: API endpoint of [sairi-backend](https://github.com/inoueke-n/sairi-backend)
* `publicKey`: public key for API endpoint
* `automaticSendPeriod`: automatic send period (millisecond)

\* `uid` can be edited even after the plugin is started form the `"Sairi User Id Configration"` window

### plugin.xml
Edit plugin.xml file &nbsp; (sairi-plugin-for-eclipse/plugin.xml)
* `file-extensions` (line 85):file extensions of the files for history collection

## Usage
1. Open this project in Eclipse
1. From plugin.xml, start a new Eclipse with this plugin 
1. From `SairiAid` in the menu bar, Sendindg edit hisotyr to the server
    * `send manually`
    * `start automatic send` 
    * `stop automatic send` 

## Known Issues

*THIS PLUGIN SENDS EDIT HISTORY TO THE SERVER*. (default: localhost)

Please use this plugin *ONLY IN* the experimental environment.