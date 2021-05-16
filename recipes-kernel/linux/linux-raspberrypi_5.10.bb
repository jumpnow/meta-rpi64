FILESEXTRAPATHS_prepend := "${THISDIR}/linux-raspberrypi-5.10:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.10.36"
LINUX_VERSION_EXTENSION = "-jumpnow"

PV = "${LINUX_VERSION}"
SRCREV = "b657cd2f27d9171b75c846f21e7b4bb581b3ed29"
SRC_URI = "\
    git://github.com/raspberrypi/linux.git;branch=rpi-5.10.y \
    file://defconfig \
"

require linux-rpi.inc

KERNEL_EXTRA_ARGS_append_rpi = " DTC_FLAGS='-@ -H epapr'"

KERNEL_DEVICETREE = " \
    ${RPI_KERNEL_DEVICETREE} \
    ${RPI_KERNEL_DEVICETREE_OVERLAYS} \
"

RPI_KERNEL_DEVICETREE = " \
    broadcom/bcm2711-rpi-400.dtb \
    broadcom/bcm2711-rpi-4-b.dtb \
    broadcom/bcm2711-rpi-cm4.dtb \
"

RPI_KERNEL_DEVICETREE_OVERLAYS = " \
"
