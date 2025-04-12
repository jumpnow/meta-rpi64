SUMMARY = "Add qt6 bin dir to PATH"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://qt6-env.sh"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 qt6-env.sh ${D}${sysconfdir}/profile.d
}

FILES_${PN} = "${sysconfdir}"
