#!/bin/sh
#
# https://doc.qt.io/qt-6/inputs-linux-device.html
#

export PATH=${PATH}:/usr/bin/qt6

export LC_COLLATE="C"
export LANG="en_US.UTF-8"

# use eglfs if we have a GPU, the other option is linuxfb (deprecated?)
export QT_QPA_PLATFORM=eglfs

# export QT_QPA_EGLFS_TSLIB=1

# for the STM32MP157F-DK2 dev board display
#export QT_QPA_EGLFS_PHYSICAL_WIDTH=480
#export QT_QPA_EGLFS_PHYSICAL_HEIGHT=800

# for the STM32MP157F-EV1 dev board display
#export QT_QPA_EGLFS_PHYSICAL_WIDTH=720
#export QT_QPA_EGLFS_PHYSICAL_HEIGHT=1280

# For finer touchscreen resolution you can specify physical dimensions in mm
#export QT_QPA_EGLFS_PHYSICAL_WIDTH=78
#export QT_QPA_EGLFS_PHYSICAL_HEIGHT=50

# set a rotate value
#export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/touchscreen0:rotate=90
