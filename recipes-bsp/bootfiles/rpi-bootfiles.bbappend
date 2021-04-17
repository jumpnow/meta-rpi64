RPIFW_DATE = "20210412"
SRCREV = "1df55790fb191704c0ce630d4d0713a8beb43a7d"
SRC_URI[md5sum] = "42d7d14c5988592e5b13444eefb6ac5c"
SRC_URI[sha256sum] = "3e16d576378ec78a705dd447fd21e1e83f4b102566367759b10998de8596613d"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"

RPIFW_SRC_URI = "https://codeload.github.com/raspberrypi/firmware/tar.gz/${SRCREV}"
RPIFW_S = "${WORKDIR}/firmware-${SRCREV}"

do_unpack() {
    tar -C ${WORKDIR} -xzf ${DL_DIR}/${SRCREV}
}
