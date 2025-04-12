FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LINUX_RPI_BRANCH = "rpi-6.6.y"
LINUX_VERSION = "6.6.74"

SRCREV_machine = ""
SRCREV_kmeta = ""

SRCREV = "6d16e47ca139ba64c5daedf06e72f2774adbdc48"

SRC_URI = "\
    git://github.com/raspberrypi/linux.git;branch=${LINUX_RPI_BRANCH};protocol=https \
    file://ikconfig.cfg \
"

KERNEL_DEVICETREE = " \
    ${RPI_KERNEL_DEVICETREE} \
    ${RPI_KERNEL_DEVICETREE_OVERLAYS} \
"

RPI_KERNEL_DEVICETREE = " \
    broadcom/bcm2711-rpi-400.dtb \
    broadcom/bcm2711-rpi-4-b.dtb \
    broadcom/bcm2711-rpi-cm4.dtb \
"

# RPI_KERNEL_DEVICETREE_OVERLAYS = ""
