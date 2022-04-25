RPIFW_DATE = "20220422"
SRCREV = "6b787e7c77df9bf5c6c8dfe45013857dfaf7aa3e"
SRC_URI[md5sum] = "1a1502093a52b3b45781b95b44cfaad1"
SRC_URI[sha256sum] = "672822ff95a17f2dceec38797c0f3536f94f1bf9b68ff5d99c8db4b75d55241a"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"

RPIFW_SRC_URI = "https://codeload.github.com/raspberrypi/firmware/tar.gz/${SRCREV}"
RPIFW_S = "${WORKDIR}/firmware-${SRCREV}"

do_unpack() {
    tar -C ${WORKDIR} -xzf ${DL_DIR}/${SRCREV}
}
