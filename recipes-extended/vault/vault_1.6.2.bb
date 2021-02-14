DESCRIPTION = "HashiCorp Vault - A tool for managing secrets"
HOMEPAGE = "https://www.vaultproject.io/"

LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MPL-2.0;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = " \
    https://releases.hashicorp.com/vault/${PV}/vault_${PV}_linux_arm64.zip \
"

SRC_URI[sha256sum] = "fd3c160ba961fedabc527c61c6b4573e9407e51a68cb8c4c26868c34d441ad44"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/${PN} ${D}${bindir}/vault
}

FILES_${PN} = "${bindir}"
