SUMMARY = "A console development image customized for the rpi"
HOMEPAGE = "http://www.jumpnowtek.com"

require images/basic-dev-image.bb

DEPENDS += "bootfiles"

WIFI = " \
    crda \
    iw \
    linux-firmware-rpidistro-bcm43455 \
    wpa-supplicant \
"

RPI_STUFF = " \
    userland \
"

SYSTEMD_STUFF = " \
    systemd-analyze \
    systemd-bash-completion \
    systemd-container \
"

IMAGE_INSTALL += " \
    firewall \
    vault \
    ${RPI_STUFF} \
    ${SYSTEMD_STUFF} \
    ${WIFI} \
"

export IMAGE_BASENAME = "console-image"
