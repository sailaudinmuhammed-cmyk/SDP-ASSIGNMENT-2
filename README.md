so the final read/me as a plain text?

Logistics Factory Demo

Purpose
Console Java app combining Factory Method (transport creation) and Abstract Factory (platform-specific UI components) for a logistics delivery scenario.

Note: all classes are in the default (unnamed) package for simplicity, no package structure. All files sit directly under src.

Files
Transport, Truck, Ship, Logistics, RoadLogistics, SeaLogistics, Button, Checkbox, WindowsButton, WindowsCheckbox, MacOSButton, MacOSCheckbox, GUIFactory, WindowsFactory, MacOSFactory, DeliveryApplication, Main

Prerequisites
JDK 17

Build and run
javac -d out src/*.java
java -cp out Main ROAD WINDOWS

Or run without args and answer the two prompts (ROAD/SEA, WINDOWS/MACOS).
In IntelliJ: right-click Main.java and choose Run.

Supported inputs
Delivery mode: ROAD, SEA
UI platform: WINDOWS, MACOS
Any other value, or missing input, prints a clear error and stops. No default is used and nothing crashes.

Sample run
java -cp out Main ROAD WINDOWS
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road
