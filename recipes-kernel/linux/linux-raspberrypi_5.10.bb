FILESEXTRAPATHS_prepend := "${THISDIR}/linux-raspberrypi-5.10:"

DESCRIPTION = "Linux Kernel for Raspberry Pi"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

COMPATIBLE_MACHINE = "^rpi$"

LINUX_VERSION = "5.10.36"
LINUX_RPI_BRANCH = "rpi-5.10.y"
LINUX_VERSION_EXTENSION = "-jumpnow"

KBUILD_DEFCONFIG_raspberrypi64-64 = "defconfig"

SRCREV_machine = ""
SRCREV_kmeta = ""

KERNEL_DTC_FLAGS += "-@ -H epapr"

KERNEL_EXTRA_ARGS += "LOADADDR=0x00008000"

PV = "${LINUX_VERSION}"
SRCREV = "b657cd2f27d9171b75c846f21e7b4bb581b3ed29"

SRC_URI = "\
    git://github.com/raspberrypi/linux.git;branch=${LINUX_RPI_BRANCH} \
    file://defconfig \
"

inherit siteinfo
require recipes-kernel/linux/linux-yocto.inc

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
