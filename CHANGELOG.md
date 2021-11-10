
# Change Log
All notable changes to this project will be documented in this file.

Basically, the upgrades are made by adjusting in the POM at the version of the toolkit.
If additional steps are necessary, this is noted under "Upgrade Steps"

## [1.3.25] - 2021-11-10

Here we would have the update steps for 1.3.25 for people to follow.

### Upgrade Steps
`-`


### Added
- Webdriver Autodownload: We have extended the toolkit with a dependency, so that now via the configuration auto-download, the Driver.exe to the browsers will be downloaded automatically. If this leads to errors or no internet access is available, this can of course still be switched off.
- License-Server: Now the license can be pulled via a SeleniumToolkit license server. Licenses are bound to the projects. So first the project must be registered on the server. The toolkit then connects to the server defined in the config to get the license.
- Networktraffic-Capturing Mode: If the mode is enabled, the test will automatically start a proxy which captures the Networktraffic. A HAR file is attached to the report.
- Saucelabs-Gridvendor: We added Sazcekabs functions, Saucelabs as a Gridvendor and SaucelabsOptions to allow an easy handling of Saucelabs specifics.


### Changed
- We have added multiple configurations samples in this sample project so that all methods are now overwritten and described. So it should be even easier to see all configurations and their effects.

### Fixed
`-`

## [1.3.24] - 2021-09-27

Here we would have the update steps for 1.3.24 for people to follow.

### Upgrade Steps
`-`


### Added
`-`

### Changed
#### Logging-Area:
- Logging to the console and also to the log file (at log level debug) has been redesigned. Log messages are now more structured and more detailed.

### Fixed
#### Mobile-Area:
- The capability "app" was classified as not W3C compliant and therefore filtered out in our W3C filter. The W3C filtering for mobile has been removed.
#### SettingClass-Area:
- If a target.env is set, but a corresponding setting class did not exist, an error was thrown.
  This has been fixed so that the setting class without target.env is used in that case.