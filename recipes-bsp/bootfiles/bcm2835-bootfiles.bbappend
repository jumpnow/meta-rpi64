RPIFW_DATE = "20200228"
SRCREV = "bf83b506b4a6f9e592e711d02871a278fad5bd1e"
SRC_URI[md5sum] = "2e2490ce8b4cd8809979daeef904b2b3"
SRC_URI[sha256sum] = "32ef9f8dadbc05f3a1da3e9819f261e911f52cd05c4830a34361d989660f23b5"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"

RPIFW_SRC_URI = "https://codeload.github.com/raspberrypi/firmware/tar.gz/${SRCREV}"
RPIFW_S = "${WORKDIR}/firmware-${SRCREV}"

do_unpack() {
    tar -C ${WORKDIR} -xzf ${DL_DIR}/${SRCREV}
}
