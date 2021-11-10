
# Change Log
All notable changes to this project will be documented in this file.

Basically, the upgrades are made by adjusting in the POM at the version of the toolkit.
If additional steps are necessary, this is noted under "Upgrade Steps

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