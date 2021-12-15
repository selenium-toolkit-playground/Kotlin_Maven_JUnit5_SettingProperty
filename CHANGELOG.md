
# Change Log
All notable changes to this project will be documented in this file.

Basically, the upgrades are made by adjusting in the POM at the version of the toolkit.
If additional steps are necessary, this is noted under "Upgrade Steps"

## [1.3.26] - 2021-12-15

Here we would have the update steps for 1.3.26 for people to follow.

### Upgrade Steps
- If you are Using the Neoload-Addon pleyse change in all seleniumTest-Annotations the Argument named "nlPurePath" to "performanceRecordingName"

### Added
- SauceLabs GridVendor: It is now possible to define the grid in the Setting-Class via an enum, in which all SauceLabs-Grid-Destinations are stored.
- Gatling Recording Modul: A Gatling Recording module has been added. With this module, the running tests are additionally recorded automatically in Gatling and finally provided as Scala Gatling scripts

### Changed
- The SeleniumTest-Annotation Argument "nlPurePath" was renamed to "performanceRecordingName"

### Fixed
- SauceLabs GridVendor: The Har download with activated performance analysis did not work depending on the SauceLabs grid destination and has now been fixed
- Errors when starting the tests, e.g. wrong license code or wrong configurations, are displayed in the log again and no longer end up in Surefire dump files
- The exception handling has been improved so that there are no more additional exceptions if there is a crash and you don't have an Allure step open. Previously, the toolkit always tried to close the current step, even if none was open.


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