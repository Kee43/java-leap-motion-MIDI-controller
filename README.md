# Gesture-Based-MIDI-Controller
This project was created for my final year project at Cardiff University, UK. 

This project allows the user to map gestures to a CC command that can be used to control a piece of music within an audio workstation.

This software acts as a MIDI receiver so it needs to be set up with a virtual bridge to the audio workstation. I recommend using a tool 
called loopMIDI to achieve this.

# Key Features
* Customize control of 16 tracks with 7 actions each - making for a possible 112 custom commands
* Control global variables such as tap tempo and master volume
* Add min and max values to each command to restrict some values

# Pre-requisites
* Java (JRE) 1.8
* Leap Motion Controller
* Digital Audio Workstation Software (DAW) - I tested this project with Reaper
