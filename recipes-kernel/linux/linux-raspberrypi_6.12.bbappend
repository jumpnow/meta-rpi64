FILESEXTRAPATHS:prepend := "${THISDIR}/linux-raspberrypi-6.12:"

LINUX_RPI_BRANCH = "rpi-6.12.y"
LINUX_VERSION = "6.12.61"

SRCREV_machine = ""
SRCREV_kmeta = ""

unset KBUILD_DEFCONFIG

SRCREV = "21b410140c47ffab5668399f6f143c7d7b935c8b"

SRC_URI = "\
    git://github.com/raspberrypi/linux.git;branch=${LINUX_RPI_BRANCH};protocol=https \
    file://defconfig \
"

KERNEL_DEVICETREE = " \
    ${RPI_KERNEL_DEVICETREE} \
    ${RPI_KERNEL_DEVICETREE_OVERLAYS} \
"

RPI_KERNEL_DEVICETREE = " \
    broadcom/bcm2710-rpi-zero-2.dtb \
    broadcom/bcm2710-rpi-zero-2-w.dtb \
    broadcom/bcm2711-rpi-400.dtb \
    broadcom/bcm2711-rpi-4-b.dtb \
    broadcom/bcm2711-rpi-cm4.dtb \
"

# RPI_KERNEL_DEVICETREE_OVERLAYS = ""
