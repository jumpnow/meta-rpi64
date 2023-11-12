FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LINUX_VERSION = "6.1.61"

SRCREV_machine = ""
SRCREV_kmeta = ""

SRCREV = "f364e0eb8f973e1aa24a3c451d18e84247a8efcd"

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
